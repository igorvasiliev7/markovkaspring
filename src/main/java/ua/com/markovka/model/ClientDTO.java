package ua.com.markovka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ClientDTO {
    private long clientId;
    private String clientName;
    private String clientPhone;
    private String clientStatus;
    private int card;
    private String lastCallDate;
    private String comment;
    private String visitDate;
    private int visitsSum;

    public ClientDTO(long clientId, String clientName, String clientPhone, String clientStatus, int card, String lastCallDate, String comment, String visitDate, int visitsSum) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientStatus = clientStatus;
        this.card = card;
        this.lastCallDate = lastCallDate;
        this.comment = comment;
        this.visitDate = visitDate;
        this.visitsSum = visitsSum;
    }

    @Override
    public String toString() {
        return  clientName +";"+
                clientPhone + ";"+
                clientStatus + ";"+
                card +";"+
                visitDate +";"+
                visitsSum +";"+
                lastCallDate +";"+
                comment;
    }
}
