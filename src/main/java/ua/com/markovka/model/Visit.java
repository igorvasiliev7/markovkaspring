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
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "date")
    private String date;
    @Column(name = "amount")
    private int amount;
    @Column (name = "master")
    private String master;

    public Visit(long clientId, String date, int amount, String master) {
        this.clientId = clientId;
        this.date = date;
        this.amount = amount;
        this.master = master;
    }
}
