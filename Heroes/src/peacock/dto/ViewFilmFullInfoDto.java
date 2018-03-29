package peacock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewFilmFullInfoDto {

    private Long id;
    private String name;
    private String premiere;
    private Integer duration;
    private Integer ageLimit;
    private String countryName;
    private String description;
}
