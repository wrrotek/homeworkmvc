package pl.javastart.homeworkmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @GetMapping("/users")
    public String users() {
        List<User> all = userRepository.getAll();
        String result = "";
        for (User user : all) {
            result += user.toString() + "<br/>";
        }
        return result;
    }

    @PostMapping("/add")
    public String add(@RequestParam String imie, @RequestParam String nazwisko, @RequestParam int wiek) {

        if (imie.isEmpty()) {
            return "redirect:/err.html";
        } else {
            User user = new User(imie, nazwisko, wiek);
            userRepository.add(user);
            return "redirect:/success.html";
        }
    }
}
