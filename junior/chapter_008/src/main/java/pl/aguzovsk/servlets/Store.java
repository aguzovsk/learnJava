package pl.aguzovsk.servlets;

import java.time.LocalDateTime;
import java.util.Collection;

interface Store<T> {
    boolean add(String name, String login, String email, LocalDateTime ld);
    boolean update(int id, String newName, String newLogin, String newEmail);
    boolean delete(int id);
    Collection<T> findAll();
    T findById(int id);
}
