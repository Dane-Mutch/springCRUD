package App.Controllers;

import java.util.List;
import App.Entities.Account;
import App.Entities.Transaction;
import App.Entities.User;
import App.Repositories.AccountRepository;
import App.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/newAccount", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addAccountNewUser(String firstName, String surname, String emailAddress, List<Transaction> accountTransactions) {
        User user = new User(firstName, surname, emailAddress);
        Account account = new Account(user, accountTransactions);
        accountRepository.save(account);
    }

    @RequestMapping(value = "users/{customerID}/newAccount")
    public void addAccountExistingUser(@PathVariable long customerID, List<Transaction> accountTransactions) {
        User user = userRepository.findById(customerID).get();
        accountRepository.save(new Account(user, accountTransactions));
    }

    @RequestMapping(value = "/{accountNumber}")
    public Account retrieveAccount(
            @PathVariable long accountNumber) {
        return accountRepository.findById(accountNumber).get();
    }

    @RequestMapping(value = "/{accountNumber}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable long accountNumber) {
        accountRepository.deleteById(accountNumber);
    }

    @RequestMapping(value = "/accounts")
    public Iterable<Account> getAllAccounts() {
       return accountRepository.findAll();
    }
}
