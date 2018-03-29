package peacock.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {

    private Long id;
    private String name;
    private Integer population;
    private Integer countOfCinemas;
}
