package pl.aguzovsk.servlets;

import java.time.LocalDateTime;
import java.util.Collection;

interface Store {
    boolean add(String name, String login, String email, LocalDateTime ld);
    boolean updateName(int id, String newName);
    boolean deleteUser(int id);
    Collection<User> findAll();
}
