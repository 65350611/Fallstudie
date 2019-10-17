package haushaltsbuch;

import java.sql.*;

public class ausgaben {
    public int expID;
    public String expLabel;
    public String name;
    public int category;
    public float amount;
    public Date date;
    
    public ausgaben() {
    }
    
    ausgaben(String expLabel, String name, int category, float amount, Date date) {
        this.expLabel = expLabel;
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    
    ausgaben(int expID, String expLabel, String name, int category, float amount, Date date) {
        this.expID = expID;
    	this.expLabel = expLabel;
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    
    public int getExpID() {
        return expID;
    }
    
    public void setExpID(int expID) {
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
    
    public int getCategory() {
        return category;
    }
    
    public void setCategory(int category) {
        this.category = category;
    }
    
    public float getAmount() {
        return amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDatet(Date date) {
        this.date = date;
    }
    
}