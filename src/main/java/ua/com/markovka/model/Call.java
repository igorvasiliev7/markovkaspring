package ua.com.markovka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "calls")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "date")
    private String date;
    @Column(name = "comment")
    private String comment;

    public Call(long clientId, String date, String comment) {
        this.clientId = clientId;
        this.date = date;
        this.comment = comment;
    }
}
