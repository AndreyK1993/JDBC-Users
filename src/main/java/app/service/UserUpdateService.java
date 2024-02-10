package app.service;

import app.exceptions.UpdateException;
import app.repository.UserUpdateRepository;
import app.utils.Constants;
import app.utils.IdValidator;
import app.utils.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class UserUpdateService {

    UserUpdateRepository repository;

    public UserUpdateService(UserUpdateRepository UpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для помилок
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (EmailValidator.isEmailValid(data[1]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setEmail(data[1]);
        return user;
    }
}
