package pl.javastart.wspolnoty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Flat {

    @Id
    @GeneratedValue
    private long id;

    private Integer number;
    private Double area;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @OneToMany
    private List<Dweller> dwellers;

    public List<Dweller> getDwellers() {
        return dwellers;
    }

    public void setDwellers(List<Dweller> dwellers) {
        this.dwellers = dwellers;
    }

    public Flat() {
    }

    public Flat(Integer number, Double area, Community community) {
        this.number = number;
        this.area = area;
        this.community = community;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", number=" + number +
                ", area=" + area +
                ", community=" + community +
                '}';
    }
}
