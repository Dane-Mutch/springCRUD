package App.Entities;

import java.util.List;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_number")
    private long accountNumber;

    private List<Transaction> accountTransactions;

    public Account() {}

    public Account(User user, List<Transaction> accountTransactions) {
        this.user = user;
        this.accountTransactions = accountTransactions;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "cust_id", referencedColumnName = "customer_id"),
            @JoinColumn(name = "cust_first_name", referencedColumnName = "first_name"),
            @JoinColumn(name = "cust_surname", referencedColumnName = "surname")
    })
    private User user;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Transaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<Transaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
