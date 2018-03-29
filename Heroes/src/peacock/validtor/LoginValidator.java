package peacock.validtor;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import peacock.dto.CreateNewUserDto;
import peacock.dto.ViewBasicUserDto;
import peacock.entity.User;
import peacock.formatter.LocalDateFormat;
import peacock.util.StringUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginValidator implements Validator<ViewBasicUserDto> {

    private static final LoginValidator INSTANCE = new LoginValidator();

    @Override
    public List<String> validate(ViewBasicUserDto object) {
        List<String> errors = new ArrayList<>();
        if (StringUtil.isEmpty(object.getLogin()) || StringUtil.isEmpty(object.getPassword())) {
            errors.add("Не все поля заполнены!");
        }
        if (object.getPassword().length()<4) {
            errors.add("Пароль слишком короткий. Попробуйте еще раз.");
        }
        else{
            errors.add("Вы ввели неверные данные. Попробуйте еще раз.");
        }
        return errors;
    }

    public static LoginValidator getInstance() {
        return INSTANCE;
    }
}
