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
    public User(int id, String name, String login, String email, LocalDateTime ld) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.creationTime = ld;
    }

    public User() {
        this.id = -1;
        this.name = "Undefined";
        this.login = "Such user do not exists.";
        this.email = "Undefined";
        this.creationTime = LocalDateTime.now();
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
