package App.Controllers;

import App.Entities.Account;
import App.Entities.Transaction;
import App.Repositories.AccountRepository;
import App.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = {"/{customerID}/{accountID}/seeTransactions", "/{accountID}/seeTransactions"})
    public Iterable<Transaction> getAllTransactions(@PathVariable long customerID, @PathVariable long accountID) {
        return transactionRepository.findAll(accountID);
    }

    @RequestMapping(value = {"/{customerID}/{accountID}/{transID}", "/{accountID}/{transID}"})
    public Transaction getATransaction(@PathVariable long customerID, @PathVariable long accountID, @PathVariable long transID) {
        List<Transaction> result = accountRepository.findById(accountID).get().getAccountTransactions().stream().filter(s -> s.getTransactionID() == transID).collect(Collectors.toList());
        return result.get(0);
    }

    @RequestMapping(value = "/{accountID}/addTransaction", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@PathVariable long accountID, long transactionValue, String transactionDate, boolean isIncoming, String transactionAlias) {
        Transaction transaction = new Transaction(transactionValue, transactionDate, isIncoming, transactionAlias);
        Account account = accountRepository.findById(accountID).get();
        List<Transaction> accountTransactions = account.getAccountTransactions();
        accountTransactions.add(accountTransactions.size(), transaction);
        account.setAccountTransactions(accountTransactions);
    }
}
