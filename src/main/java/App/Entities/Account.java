package App.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountNumber;

    @Column(name = "balance")
    private long accountBalance;

    public Account() {}

    public Account(String firstName, String surname, String emailAddress, int accountBalance) {
        this.user = new User(firstName, surname, emailAddress);
        this.accountBalance = accountBalance;
    }

    public Account(User user, long accountBalance) {
        this.user = user;
        this.accountBalance = accountBalance;
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

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
