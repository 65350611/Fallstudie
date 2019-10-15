package haushaltsbuch;

public class kategorien {
    public int catID;
    public String catLabel;
    
    kategorien() {
    }
    
    kategorien(String catLabel) {
        this.catLabel = catLabel;
    }
    
    kategorien(int catID, String catLabel) {
        this.catID = catID;
        this.catLabel = catLabel;
    }
    
    public int getCatID() {
        return catID;
    }
    
    public void setCatID(int catID) {
        this.catID = catID;
    }
    
    public String getCatLabel() {
        return catLabel;
    }
    
    public void setCatLabel(String catLabel) {
        this.catLabel = catLabel;
    }

}