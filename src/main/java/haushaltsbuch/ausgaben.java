package haushaltsbuch;

import java.sql.*;

public class ausgaben {
    public Integer expID;
    public String expLabel;
    public Integer user;
    public Integer category;
    public Float amount;
    public Date date;
    
    ausgaben() {
    }
    
    ausgaben(String expLabel, Integer user, Integer category, Float amount, Date date) {
        this.expLabel = expLabel;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    
    ausgaben(Integer expID, String expLabel, Integer user, Integer category, Float amount, Date date) {
        this.expID = expID;
    	this.expLabel = expLabel;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.date = date;
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
    
}