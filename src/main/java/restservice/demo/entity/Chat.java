package restservice.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String text;

    private String fromUser;

    private String toUser;

    public Chat() {
    }
    public Long getId() {
        return id;
    }

    public String getToUser() {
        return toUser;
    }
    public String getFromUser() {
        return fromUser;
    }

    public String getText() {
        return text;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Chat(Long id, Date date, String fromUser, String toUser, String text) {
        this.id = id;
        this.date = date;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = text;

    }

    public void setFromUser(String fromUser) {this.fromUser = fromUser;
    }

    public void setToUser(String toUser) {this.toUser = toUser;
    }
    @PrePersist
    protected void onCreate() {
        date = new Date(); // Set the current date and time before persisting the entity
    }
}
