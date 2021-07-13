package pl.javastart.homeworkmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/add")
    public String add(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));

        if (name.isEmpty()) {
            return "err.html";
        } else {
            User user = new User(name, surname, age);
            userRepository.add(user);
            return "success.html";
        }
    }
}
