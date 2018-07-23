package pl.aguzovsk.servlets;

import java.time.LocalDateTime;
import java.util.Collection;

/***
 * class ValidateService
 * created 20.07.18
 */
public class ValidateService {
    private static final ValidateService instance = new ValidateService();
    private MemoryStore memoryStore;

    private ValidateService(){
        memoryStore = MemoryStore.instance();
    };

    public static ValidateService getInstance() {
        return instance;
    }

    public boolean add(String name, String login, String email, LocalDateTime ld) {
        return memoryStore.add(name, login, email, ld);
    }

    public boolean updateName(int id, String newName) {
        return memoryStore.updateName(id, newName);
    }

    public boolean delete(int id) {
        return memoryStore.deleteUser(id);
    }

    public Collection<User> findAll() {
        return memoryStore.findAll();
    }

    public User findById(int id) { return memoryStore.findById(id); }

    public boolean update(int id, String name, String login, String email) {
        return memoryStore.update(id, name, login, email);
    }
}
