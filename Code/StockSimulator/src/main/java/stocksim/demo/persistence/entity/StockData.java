package stocksim.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "stockdata")
public class StockData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockdataid;

    @ManyToOne
    @JoinColumn(name = "stockid")
    private Stock stock;

    @Column
    private Date date;

    @Column
    private Integer price;

    @Override
    public String toString() {
        return "StockData{" +
                "stock=" + stock +
                ", date=" + date +
                ", price=" + price +
                '}';
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
