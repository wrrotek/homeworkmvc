package pl.javastart.homeworkmvc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
    private int age;

    @Override
    public String toString() {
        return name + " " + surname + ", lat " + age;
    }
}
