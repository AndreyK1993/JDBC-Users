package app.controller;

import app.service.UserUpdateService;
import app.utils.AppStarter;
import app.view.UserUpdateView;

public class UsersUpdateController {

    UserUpdateService service;
    UserUpdateView view;

    public UsersUpdateController(UserUpdateService service, UserUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateUsers() {
        view.getOutput(service.updateUser(view.getData()));
        AppStarter.startApp();
    }
}
