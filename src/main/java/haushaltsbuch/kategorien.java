package haushaltsbuch;

public class kategorien {
    private Integer catID;
    private String catLabel;
    
    kategorien() {
    }
    
    kategorien(String catLabel) {
        this.catLabel = catLabel;
    }
    
    kategorien(Integer catID, String catLabel) {
        this.catID = catID;
        this.catLabel = catLabel;
    }
    
    public Integer getCatID() {
        return catID;
    }
    
    public void setCatID(Integer catID) {
        this.catID = catID;
    }
    
    public String getCatLabel() {
        return catLabel;
    }
    
    public void setCatLabel(String catLabel) {
        this.catLabel = catLabel;
    }
}