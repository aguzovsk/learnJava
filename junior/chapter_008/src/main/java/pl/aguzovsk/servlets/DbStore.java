package pl.aguzovsk.servlets;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/***
 * class DbStrore
 * created 24.07.18
 */
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * create table users (
 *   id serial primary key,
 *   name varchar(30),
 *   login varchar(30),
 *   email varchar(30),
 *   createdTime timestamp)
 */
public class DbStore implements Store<User> {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();

    public DbStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/first");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("123");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean add(String name, String login, String email, LocalDateTime ld) {
        try (Connection connection = SOURCE.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO users(name, login, email, createdTime) "
                            + "VALUES (?, ?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, login);
            statement.setString(3, email);
            statement.setObject(4, ld, Types.TIMESTAMP);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(int id, String newName, String newLogin, String newEmail) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("UPDATE users SET name = ?, login = ?, email = ?  WHERE id = ?")) {
            statement.setString(1, newName);
            statement.setString(2, newLogin);
            statement.setString(3, newEmail);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM users WHERE id = ?;")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Collection<User> findAll() {
        List<User> answer = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users")) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                String login = result.getString(3);
                String email = result.getString(4);
                LocalDateTime ld = result.getObject(5, LocalDateTime.class);
                answer.add(new User(id, name, login, email, ld));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    public User findById(int id) {
        User user = new User();
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            String name = result.getString(2);
            String login = result.getString(3);
            String email = result.getString(4);
            LocalDateTime ld = result.getObject(5, LocalDateTime.class);
            user = new User(id, name, login, email, ld);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
