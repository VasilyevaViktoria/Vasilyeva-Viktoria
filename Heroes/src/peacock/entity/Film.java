package peacock.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {

    private Long id;
    private String name;
    private LocalDate premiere;
    private Integer duration;
    private Integer ageLimit;
    private String description;
//    private Country genre;
    private Country country;
    private List<Participant> filmParticipants;
//    private Set<User> users = new HashSet<>();
//    private Set<Review> reviews = new HashSet<>();

}
