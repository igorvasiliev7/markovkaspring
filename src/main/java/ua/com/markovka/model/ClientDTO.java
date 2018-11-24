package ua.com.markovka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ClientDTO {
    private int number;
    private long clientId;
    private String clientName;
    private String clientPhone;
    private String clientStatus;
    private int card;
    private String lastCallDate;
    private String comment;
    private String visitDate;
    private int visitsSum;

    public ClientDTO(int number) {
        this.number = number;
    }

    public ClientDTO(int number, String lastCallDate, String comment) {
        this.number = number;
        this.lastCallDate = lastCallDate;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return  number +";"+
                clientName +";"+
                clientPhone + ";"+
                clientStatus + ";"+
                card +";"+
                visitDate +";"+
                visitsSum +";"+
                lastCallDate +";"+
                comment
        ;
    }
}
