package haushaltsbuch;

import java.sql.*;

public class ausgaben {
    private Integer expID;
    private String expLabel;
    private Integer user;
    private Integer category;
    private Float amount;
    private Date date;
    private Timestamp time;
    private String description;
    
    ausgaben() {
    }
    
    ausgaben(String expLabel, Integer user, Integer category, Float amount, Date date, Timestamp time, String description) {
        this.expLabel = expLabel;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.description = description;
    }
    
    ausgaben(Integer expID, String expLabel, Integer user, Integer category, Float amount, Date date, Timestamp time, String description) {
        this.expID = expID;
    	this.expLabel = expLabel;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.description = description;
    }
    
    public Integer getExpID() {
        return expID;
    }
    
    public void setExpID(Integer expID) {
        this.expID = expID;
    }
    
    public String getExpLabel() {
        return expLabel;
    }
    
    public void setExpLabel(String expLabel) {
        this.expLabel = expLabel;
    }
    
    public Integer getUser() {
        return user;
    }
    
    public void setUser(Integer user) {
        this.user = user;
    }
    
    public Integer getCategory() {
        return category;
    }
    
    public void setCategory(Integer category) {
        this.category = category;
    }
    
    public Float getAmount() {
        return amount;
    }
    
    public void setAmount(Float amount) {
        this.amount = amount;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDatet(Date date) {
        this.date = date;
    }
    
    public Timestamp getTime() {
        return time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}