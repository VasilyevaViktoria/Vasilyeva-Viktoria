package peacock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewReviewDto {

    private String comment;
    private String date;
    private Integer stars;
    private Long userId;
    private Long filmId;
}
