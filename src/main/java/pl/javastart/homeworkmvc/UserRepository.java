package pl.javastart.homeworkmvc;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("Karolina", "Kowalska", 22));
        users.add(new User("Adam", "Nowak", 33));
        users.add(new User("Bartek", "Koc", 44));
    }

    public List<User> getAll() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }
}
