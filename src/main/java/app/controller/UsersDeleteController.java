package app.controller;

import app.service.UserDeleteService;
import app.utils.AppStarter;
import app.view.UserDeleteView;

public class UsersDeleteController {

    UserDeleteService service;
    UserDeleteView view;

    public UsersDeleteController(UserDeleteService service, UserDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteUsers() {
        view.getOutput(service.deleteUser(view.getData()));
        AppStarter.startApp();
    }
}
