package pl.javastart.wspolnoty.model;

import javax.persistence.*;

@Entity
public class Dweller {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;

    public Dweller() {
    }

    public Dweller(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Dweller{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", flat=" + flat +
                '}';
    }
}
