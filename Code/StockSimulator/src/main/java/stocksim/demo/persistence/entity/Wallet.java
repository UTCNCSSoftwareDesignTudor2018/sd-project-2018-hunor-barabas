package stocksim.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer walletid;

    @ManyToOne
    @JoinColumn(name = "traderid")
    private Trader trader;

    @Column
    Integer balance;

    @ManyToOne
    @JoinColumn(name = "stockid")
    private Stock stock;

    @Column
    Integer amount;

    /*@Override
    public String toString() {
        return "Wallet{" +
                "walletid=" + walletid +
                ", trader=" + trader +
                ", balance=" + balance +
                ", stock=" + stockList +
                '}';
    }
    */

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getWalletid() {
        return walletid;
    }

    public void setWalletid(Integer walletid) {
        this.walletid = walletid;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
