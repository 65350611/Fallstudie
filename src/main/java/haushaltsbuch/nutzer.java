package haushaltsbuch;

public class nutzer {
    private static Integer userRole;
    private static String name;
    private static String password;
    
    nutzer() {
    }
    
    nutzer(Integer userRole, String name, String password) {
        nutzer.userRole = userRole;
        nutzer.password = password;
    }
    
    nutzer(Integer userID, Integer userRole, String name, String password) {
        nutzer.userRole = userRole;
        nutzer.name = name;
        nutzer.password = password;
    }
    
    public static Integer getUserRole() {
        return userRole;
    }
    public void setUserRole(Integer userRole) {
        nutzer.userRole = userRole;
    }
    public static String getName() {
        return name;
    }
    public void setName(String name) {
        nutzer.name = name;
    }
    public static String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        nutzer.password = password;
    }
}