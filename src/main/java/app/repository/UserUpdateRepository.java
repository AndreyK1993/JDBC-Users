package app.repository;

import app.database.DBConn;
import app.entity.User;
import app.utils.Constants;
import app.utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateRepository {

    public String updateUser(User user) {
        // Перевіряємо наявність id в БД.
        // ТАК - працюємо з даними.
        // НІ - повідомлення про відсутність id.
        if (IdChecker.isIdExists(user.getId())) {
            return updateUserById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String updateUserById(User user) {

        String sql = "UPDATE " + Constants.TABLE_CONTACTS + " SET email = ? WHERE id = ?";
        // PreparedStatement - підготовлений вираз, щоб уникнути SQL-ін'єкцій
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getEmail());
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();
            return Constants.DATA_UPDATE_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
