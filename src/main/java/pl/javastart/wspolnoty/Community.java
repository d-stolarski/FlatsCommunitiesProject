package pl.javastart.wspolnoty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Community {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String adress;

    @OneToMany(mappedBy = "community")
    private List<Flat> flats;

    public Community() {
    }

    public Community(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", flats=" + flats +
                '}';
    }
}
