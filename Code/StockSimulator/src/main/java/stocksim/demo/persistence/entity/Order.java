package stocksim.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderid;

    @ManyToOne
    @JoinColumn(name = "walletid")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "stockid")
    private Stock stock;

    @Column
    Integer amount;

    @Column
    Date orderDate;

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", wallet=" + wallet +
                ", stock=" + stock +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                '}';
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
