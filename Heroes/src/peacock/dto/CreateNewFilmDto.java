package peacock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewFilmDto {

    private String name;
    private Integer duration;
    private String premiere;
    private Integer ageLimit;
    private Long countryId;
    private String description;

}
