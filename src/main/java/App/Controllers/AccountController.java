package App.Controllers;

import App.Entities.Account;
import App.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/accounts")
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultJ() {
        return "It works";
    }

    @RequestMapping(value = "/accounts/{id}")
    public Optional<Account> getAccount(@PathVariable long id) {
        return accountRepository.findById(id);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateAccount(@PathVariable long id) {
        return null;
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAccount(@PathVariable long id) {
        accountRepository.deleteById(id);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    @ResponseBody
    public void createAccount(String firstName, String lastName, int accountBalance) {
        Account account = new Account(firstName, lastName, accountBalance);
        accountRepository.save(account);
    }

}
