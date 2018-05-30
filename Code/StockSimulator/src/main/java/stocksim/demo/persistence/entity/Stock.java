package stocksim.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockid;

    @Column
    private String symbol;

    @OneToMany(mappedBy = "stock")
    private List<StockData> stockData;

    @OneToMany(mappedBy = "stock")
    private List<Wallet> wallets;

    @Override
    public String toString() {
        return "Stock{" +
                "stockid=" + stockid +
                ", symbol='" + symbol + '\'' +
                ", stockData=" + stockData +
                ", wallets=" + wallets +
                '}';
    }


    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<StockData> getStockData() {
        return stockData;
    }

    public void setStockData(List<StockData> stockData) {
        this.stockData = stockData;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }
}
