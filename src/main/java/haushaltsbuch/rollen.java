package haushaltsbuch;

public class rollen {
	public Integer roleID;
	public String roleLabel;
    
    rollen() {
    }
    
    rollen(String roleLabel) {
        this.roleLabel = roleLabel;
    }
    
    rollen(Integer roleID, String roleLabel) {
        this.roleID = roleID;
        this.roleLabel = roleLabel;
    }
    
    public Integer getRoleID() {
        return roleID;
    }
    
    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }
    
    public String getRoleLabel() {
        return roleLabel;
    }
    
    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }
}