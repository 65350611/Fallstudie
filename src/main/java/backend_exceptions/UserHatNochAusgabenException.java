package backend_exceptions;

public class UserHatNochAusgabenException extends Exception{
 
	public UserHatNochAusgabenException() {
		super("Der ausgewählte User hat noch Ausgaben");
	}
}
