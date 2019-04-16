package App.Controllers;

import App.Entities.Account;
import App.Entities.User;
import App.Repositories.AccountRepository;
import App.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/newAccount", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addAccountNewUser(String firstName, String surname, String emailAddress, long accountBalance) {
        User user = new User(firstName, surname, emailAddress);
        Account account = new Account(user, accountBalance);
        accountRepository.save(account);
    }

    @RequestMapping(value = "users/{customerID}/newAccount")
    public void addAccountExistingUser(@PathVariable long customerID, long accountBalance) {
        User user = userRepository.findById(customerID).get();
        accountRepository.save(new Account(user, accountBalance));
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

    @RequestMapping(value = "/{accountNumber}", method = RequestMethod.PUT)
    public void adjustAccountBalance(@PathVariable long accountNumber, long adjustAmount) {
        Account account = accountRepository.findById(accountNumber).get();
        account.setAccountBalance(account.getAccountBalance() + adjustAmount);
        accountRepository.save(account);
    }

    @RequestMapping(value = "/accounts")
    public Iterable<Account> getAllAccounts() {
       return accountRepository.findAll();
    }
}
