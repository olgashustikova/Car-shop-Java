package restservice.demo.dto;

import restservice.demo.entity.User;

import java.util.Date;

public class ChatDto {
    private Long id;
    private Date date;
    private String fromUser;
    private String toUser;
    private String text;

    public ChatDto(String toUser, String fromUser, String text, Date currentDate) {
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

    public ChatDto( Long id, String fromUser, String toUser,  String text ) {
        this.id= id;
        this.date =  new Date();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = text;
    }
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ChatDto() {
    }

    public void setFromUser(User fromUser) {
    }

    public void setToUser(User toUser) {
    }
}
