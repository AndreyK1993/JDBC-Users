package app.controller;

import app.service.UserReadService;
import app.utils.AppStarter;
import app.view.UserReadView;

public class UsersReadController {

    UserReadService service;
    UserReadView view;

    public UsersReadController(UserReadService service, UserReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readUsers() {
        view.getOutput(service.readUsers());
        AppStarter.startApp();
    }
}
