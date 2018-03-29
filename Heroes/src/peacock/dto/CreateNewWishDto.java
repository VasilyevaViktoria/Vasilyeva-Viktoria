package peacock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateNewWishDto {

    private Long filmId;
    private Long userId;
    private Boolean wish;
}
