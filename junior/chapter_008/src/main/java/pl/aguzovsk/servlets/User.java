package pl.aguzovsk.servlets;

import java.time.LocalDateTime;

/***
 * class User
 * created 22.07.18
 */
public class User {
    int id;
    String name;
    String login;
    String email;
    LocalDateTime creationTime;
    User(int id, String name, String login, String email, LocalDateTime ld) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.creationTime = ld;
    }

    public synchronized void updateName(String newName) {
        this.name = newName;
    }

    public synchronized void update(String newName, String newLogin, String newEmail) {
        this.name = newName;
        this.login = newLogin;
        this.email = newEmail;
    }

    public String getName() {
        return this.name;
    }

    public String getLogin() {
        return this.login;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }
}
