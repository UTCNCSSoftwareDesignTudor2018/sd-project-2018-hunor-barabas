package stocksim.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="enrollments")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer walletid;

    @ManyToOne
    @JoinColumn(name = "traderid")
    private Trader trader;

    @Column
    Integer balance;

    @Column
    Stock stock;

    @Override
    public String toString() {
        return "Wallet{" +
                "walletid=" + walletid +
                ", trader=" + trader +
                ", balance=" + balance +
                ", stock=" + stock +
                '}';
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