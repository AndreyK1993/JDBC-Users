package app.service;

import app.entity.User;
import app.repository.UsersReadRepository;
import app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadService {

    UsersReadRepository repository;

    public UserReadService(UsersReadRepository repository) {
        this.repository = repository;
    }

    public String readUsers() {

        // Отримуємо дані у колекцію.
        List<User> list = repository.readUsers();

        // Якщо колекція не null, формуємо виведення.
        // Інакше повідомлення про відсутність даних.
        if (list != null) {
            // Якщо колекція не порожня, формуємо виведення.
            // Інакше повідомлення про відсутність даних.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((contact) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(contact.getId())
                                .append(", ")
                                .append(contact.getName())
                                .append(" ")
                                .append(contact.getEmail())
                                .append("\n")
                );
                return "\n______ Users ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
