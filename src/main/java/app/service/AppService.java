package app.service;

import app.controller.UsersCreateController;
import app.controller.UsersDeleteController;
import app.controller.UsersReadController;
import app.controller.UsersUpdateController;
import app.exceptions.OptionException;
import app.repository.UserCreateRepository;
import app.repository.UserDeleteRepository;
import app.repository.UsersReadRepository;
import app.repository.UserUpdateRepository;
import app.utils.AppStarter;
import app.utils.Constants;
import app.view.UserCreateView;
import app.view.UserDeleteView;
import app.view.UserReadView;
import app.view.UserUpdateView;

public class AppService {

    public void createUsers() {
        UserCreateRepository repository = new UserCreateRepository();
        UserCreateService service = new UserCreateService(repository);
        UserCreateView view = new UserCreateView();
        UsersCreateController controller = new UsersCreateController(service, view);
        controller.createUsers();
    }

    public void readUsers() {
        UsersReadRepository repository = new UsersReadRepository();
        UserReadService service = new UserReadService(repository);
        UserReadView view = new UserReadView();
        UsersReadController controller = new UsersReadController(service, view);
        controller.readUsers();
    }

    public void updateUsers() {
        UserUpdateRepository repository = new UserUpdateRepository();
        UserUpdateService service = new UserUpdateService(repository);
        UserUpdateView view = new UserUpdateView();
        UsersUpdateController controller = new UsersUpdateController(service, view);
        controller.updateUsers();
    }

    public void deleteUsers() {
        UserDeleteRepository repository = new UserDeleteRepository();
        UserDeleteService service = new UserDeleteService(repository);
        UserDeleteView view = new UserDeleteView();
        UsersDeleteController controller = new UsersDeleteController(service, view);
        controller.deleteUsers();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    // Перевірка наявності опції
    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
