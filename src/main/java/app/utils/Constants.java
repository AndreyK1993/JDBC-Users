package app.utils;

public final class Constants {

    public final static String TABLE_CONTACTS = "contacts";


    // Regex для email
    public final static String EMAIL_RGX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public final static String WRONG_EMAIL_MSG = "Wrong email input.";

    // Regex для id.
    // Регулярний вираз для позитивних цілих чисел без нулів, мінусів або ком на початку.
    // ^ вказує на початок рядка
    // [1-9] відповідає будь-якій цифрі від 1 до 9 і гарантує відсутність нулів на початку.
    // $ вказує на кінець рядка
    public final static String ID_RGX = "^[1-9]$";
    public final static String WRONG_ID_MSG = "Wrong id input.";

    public final static String DATA_ABSENT_MSG = "\n>> No data!";
    public final static String DATA_INSERT_MSG = "\n>> Created.";
    public final static String DATA_UPDATE_MSG = "\n>> Updated.";
    public final static String DATA_DELETE_MSG = "\n>> Deleted.";

    public final static String APP_CLOSE_MSG = "\n>> App closed.";
    public final static String INPUT_REQ_MSG = "Input required.";
    public final static String INCORRECT_VALUE_MSG = ">> Incorrect value! Try again.";
    public final static String ID_NO_EXISTS_MSG = "\n>> There is no such ID.";
}
