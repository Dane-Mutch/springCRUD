package App.Controllers;

import App.Entities.User;
import App.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users")
    public Iterable<User> getAllAccounts() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage() {
        return "Hello";
    }

    @RequestMapping(value = "/users/{id}")
    public User getUser(@PathVariable long customerID) {
        return userRepository.findById(customerID).get();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@PathVariable long customerID) {
        return null;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable long customerID) {
        userRepository.deleteById(customerID);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(String firstName, String surname, String emailAddress) {
        userRepository.save(new User(firstName, surname, emailAddress));
    }

}
