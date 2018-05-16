package stocksim.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockid;

    @Column
    private String symbol;

    @Column
    private StockData stockData;

    @Override
    public String toString() {
        return "Stock{" +
                "stockid=" + stockid +
                ", symbol='" + symbol + '\'' +
                ", stockData=" + stockData +
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

    public StockData getStockData() {
        return stockData;
    }

    public void setStockData(StockData stockData) {
        this.stockData = stockData;
    }
}
