package peacock.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    private long id;
    private int stars;
    private LocalDate date;
    private String comment;
    private User user;
    private Film film;
}
