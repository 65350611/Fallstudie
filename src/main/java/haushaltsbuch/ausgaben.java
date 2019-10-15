package haushaltsbuch;

import java.sql.*;

public class ausgaben {
    public Integer expID;
    public String expLabel;
    public String name;
    public Integer category;
    public Float amount;
    public Date date;
    
    ausgaben() {
    }
    
    ausgaben(String expLabel, String name, Integer category, Float amount, Date date) {
        this.expLabel = expLabel;
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    
    ausgaben(Integer expID, String expLabel, String name, Integer category, Float amount, Date date) {
        this.expID = expID;
    	this.expLabel = expLabel;
        this.name = name;
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
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