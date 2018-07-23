package pl.aguzovsk.servlets;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * class MemoryStore
 * created 20.07.18
 */
public class MemoryStore implements Store {
    private static final MemoryStore instance = new MemoryStore();
    private MemoryStore() { };
    public static MemoryStore instance() {
        return instance;
    }
    private Map<Integer, User> users = new ConcurrentHashMap<>();
    private AtomicInteger sequence = new AtomicInteger(0);

    public boolean add(String name, String login, String email, LocalDateTime ld) {
        int id = sequence.getAndIncrement();
        users.put(id, new User(id, name, login, email, ld));
        return true;
    }

    public boolean updateName(int id, String newName) {
        User user = users.get(id);
        if (user == null) {
            return false;
        }
        user.updateName(newName);
        return true;
    }

    public boolean deleteUser(int id) {
        return users.remove(id) != null;
    }

    public Collection<User> findAll() {
        return users.values();
    }

    public User findById(int id) {
        return users.get(id);
    }

    public boolean update(int id, String name, String login, String email) {
        User user = users.get(id);
        if (user == null) {
            return false;
        }
        user.update(name, login, email);
        return true;
    }
}
