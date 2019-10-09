package haushaltsbuch;

public class nutzer {
    private Integer userID;
    private Integer userRole;
    private String name;
    private String password;
    
    nutzer() {
    }
    
    nutzer(Integer userRole, String name, String password) {
        this.userRole = userRole;
        this.name = name;
        this.password = password;
    }
    
    nutzer(Integer userID, Integer userRole, String name, String password) {
        this.userID = userID;
        this.userRole = userRole;
        this.name = name;
        this.password = password;
    }
    
    public Integer getUserID() {
        return userID;
    }
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    public Integer getUserRole() {
        return userRole;
    }
    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}