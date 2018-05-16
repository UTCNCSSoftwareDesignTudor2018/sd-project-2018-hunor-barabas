package stocksim.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "traders")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer traderid;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "trader")
    private List<Wallet> walletList;

    @Override
    public String toString() {
        return "Trader{" +
                "traderid=" + traderid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", walletList=" + walletList +
                '}';
    }

    public Integer getTraderid() {
        return traderid;
    }

    public void setTraderid(Integer traderid) {
        this.traderid = traderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Wallet> getWalletList() {
        return walletList;
    }

    public void setWalletList(List<Wallet> walletList) {
        this.walletList = walletList;
    }
}
