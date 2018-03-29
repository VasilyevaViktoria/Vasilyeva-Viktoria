package peacock.service;

import peacock.dao.CareerDao;
import peacock.dao.ParticipantDao;
import peacock.dto.CreateNewParticipantDto;
import peacock.dto.ViewParticipantBasicInfoDto;
import peacock.dto.ViewParticipantFullInfoDto;
import peacock.entity.Participant;
import peacock.formatter.LocalDateFormat;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantService {

    private static final ParticipantService INSTANCE = new ParticipantService();

    public ViewParticipantBasicInfoDto saveParticipant(CreateNewParticipantDto dto) {
        Participant savedParticipant = ParticipantDao.getInstance().save(
                Participant.builder()
                        .name(dto.getName())
                        .dateOfBirth(LocalDateFormat.format(dto.getDateOfBirth()))
                        .build());

        return new ViewParticipantBasicInfoDto(savedParticipant.getId(), savedParticipant.getName());
    }

    public List<ViewParticipantBasicInfoDto> findAll() {
        return ParticipantDao.getInstance().findAll().stream()
                .map(it -> new ViewParticipantBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public ViewParticipantFullInfoDto findById(Long participantId) {
        return ParticipantDao.getInstance().findById(participantId)
                .map(it -> ViewParticipantFullInfoDto.builder()
                        .name(it.getName())
                        .dateOfBirth(LocalDateFormat.format(it.getDateOfBirth()))
                        .build())
                .orElse(null);
    }

    public long addRole(String career){
        if ( CareerDao.getInstance().getRoleIdByName(career) == 0) {
            CareerDao.getInstance().addRole(career.trim().toLowerCase());
        }
        return CareerDao.getInstance().getRoleIdByName(career);
    }

    public List<Participant> getParticipantsByFilmId(long filmId){
        return ParticipantDao.getInstance().getParticipantsByFilmId(filmId);
    }

    public boolean addParticipantToFilm(String[] participantId, long filmId, String career){
        boolean isAdd = false;
        if (participantId.length != 0){
            for (String strParticipantId : participantId){
                ParticipantDao.getInstance().addParticipantToFilm(Long.valueOf(strParticipantId), filmId, addRole(career));
            }
            isAdd = true;
        }
        return isAdd;
    }

    public static ParticipantService getInstance() {
        return INSTANCE;
    }
}
