package backend_exceptions;

public class AdmKannSichNichtSelberLoeschenException extends Exception{
	public AdmKannSichNichtSelberLoeschenException() {
		super("Administratoren können sich nicht selber löschen");
	}
}
