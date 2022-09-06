package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleUserLogin(
        @RequestParam String name,
        @RequestParam String password,
        ModelMap model
    ) {
        System.out.println("name: " + name + ", password: " + password);
        if (!loginService.validateUser(name, password)) {
            model.put("errorMessage", "invalid credentials");
            return "login";
        }
        model.put("name", name);
        return "welcome";
    }
}
