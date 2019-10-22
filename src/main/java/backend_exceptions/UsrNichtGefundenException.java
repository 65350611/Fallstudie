package backend_exceptions;

public class UsrNichtGefundenException extends Exception {
	public UsrNichtGefundenException() {
		super("Nuter existiert nicht oder Fehleingabe");
	}

}
