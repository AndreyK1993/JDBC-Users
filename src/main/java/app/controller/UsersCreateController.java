package app.controller;

import app.service.UserCreateService;
import app.utils.AppStarter;
import app.view.UserCreateView;

public class UsersCreateController {

    UserCreateView view;
    UserCreateService service;

    public UsersCreateController(UserCreateService service, UserCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createUsers() {
        view.getOutput(service.createUser(view.getData()));
        AppStarter.startApp();
    }
}
