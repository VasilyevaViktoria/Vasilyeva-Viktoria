package peacock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewReviewFullInfoDto {

    private Long id;
    private Integer stars;
    private String comment;
    private String userName;
    private String filmName;
}
