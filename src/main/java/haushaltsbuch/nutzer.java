package haushaltsbuch;

public class nutzer {
	public Integer userRole;
	public String name;
	public String password;
    
    nutzer() {
    }
    
    nutzer(Integer userRole, String name, String password) {
        this.userRole = userRole;
        this.password = password;
    }
    
    nutzer(Integer userID, Integer userRole, String name, String password) {
    	this.userRole = userRole;
    	this.name = name;
    	this.password = password;
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