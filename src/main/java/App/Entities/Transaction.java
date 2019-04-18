package App.Entities;

import javax.persistence.*;

@Entity
public class Transaction {

    public enum TransactionType {
        COFFEE, EATING_OUT, TRANSFERS, DRINKS, GROCERIES, HOUSING, BILLS, INCOME, EXPENSES, HOLIDAYS, TRANSPORT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transactionID;

    @Column(name = "trans_value")
    private long transactionValue;

    @Column(name = "trans_date")
    private String transactionDate;

    @Column(name = "trans_type")
    private TransactionType transactionType;

    @Column(name = "trans_alias")
    private String transactionAlias;

    @Column(name = "is_incoming")
    private boolean isIncoming;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "cust_id", referencedColumnName = "customer_id"),
            @JoinColumn(name = "cust_first_name", referencedColumnName = "first_name"),
            @JoinColumn(name = "cust_surname", referencedColumnName = "surname")
    })
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_no", referencedColumnName = "account_number")
    private Account account;

    public Transaction() {}

    public Transaction(long transactionValue, String transactionDate, boolean isIncoming, String transactionAlias) {
        this.transactionValue = transactionValue;
        this.transactionDate = transactionDate;
        this.transactionAlias = transactionAlias;
        this.isIncoming = isIncoming;
    }

    public Transaction(long transactionValue, String transactionDate, String transactionAlias, TransactionType transactionType, boolean isIncoming) {
        this.transactionValue = transactionValue;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionAlias = transactionAlias;
        this.isIncoming = isIncoming;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public long getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(long transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionAlias() {
        return transactionAlias;
    }

    public void setTransactionAlias(String transactionAlias) {
        this.transactionAlias = transactionAlias;
    }

    public boolean isIncoming() {
        return isIncoming;
    }

    public void setIncoming(boolean incoming) {
        isIncoming = incoming;
    }
}
