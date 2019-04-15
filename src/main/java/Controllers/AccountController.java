package Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @RequestMapping(value = "/accounts/")
    public String getAllAccounts() {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}")
    public String getAccount(@PathVariable long id) {
        return null;
    }

    @RequestMapping(value = "accounts/{id}")
    @ResponseBody
    public String updateAccount(@PathVariable long id) {
        return null;
    }

    @RequestMapping(value = "accounts/{id}")
    @ResponseBody
    public String deleteAccount(@PathVariable long id) {
        return null;
    }

    @RequestMapping(value = "accounts/")
    @ResponseBody
    public String createAccount() {
        return null;
    }

}
