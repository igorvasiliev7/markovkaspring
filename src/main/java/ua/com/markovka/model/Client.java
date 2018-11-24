package ua.com.markovka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "status")
    private String status;
    @Column(name = "card")
    private int card;
//TODO check constructors list

    public Client(long id, String phone, String name, String status, int card) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.status = status;
        this.card = card;
    }

    public Client(String name, String phone, String status, int card) {
        this.phone = phone;
        this.name = name;
        this.status = status;
        this.card = card;
    }

    public Client(String name, String phone, String status) {
        this.phone = phone;
        this.name = name;
        this.status = status;
    }
}
