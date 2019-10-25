package wwi.fallstudie.gui.admin;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import backend.Logik;
import backend_exceptions.FalscheAdmPwdAendernMethodeException;
import backend_exceptions.UsrNichtGefundenException;
import wwi.fallstudie.gui.popupAllgemein.MessagePopup;
import wwi.fallstudie.gui.utilities.Comparator;
import wwi.fallstudie.gui.utilities.Window;

public class AdminOberflaechePopUpPasswortUserNeuSetzen extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField wdhPasswordField;
	private JButton passwortAendern;
	private JButton abbrechen;

	public AdminOberflaechePopUpPasswortUserNeuSetzen() {
		super("Passwort neu setzen");

		setLayout(new GridBagLayout()); // set Layout Manager

		// initialise variables
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		wdhPasswordField = new JPasswordField();
		passwortAendern = new JButton("Passwort ändern");
		abbrechen = new JButton("Abbrechen");

		// edit usernameField
		usernameField.setForeground(Color.LIGHT_GRAY);
		usernameField.setText("Nutzername");
		usernameField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				JTextField source = (JTextField) e.getComponent();
				source.setText("");
				source.setForeground(Color.BLACK);
				source.removeFocusListener(this);
			}
		});

		// edit passwordField
		passwordField.setEchoChar((char) 0);
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setText("Passwort");
		passwordField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				JPasswordField source = (JPasswordField) e.getComponent();
				source.setText("");
				source.setEchoChar('\u25CF');
				source.setForeground(Color.BLACK);
				source.removeFocusListener(this);
			}
		});

		// edit wdhPasswordField
		wdhPasswordField.setEchoChar((char) 0);
		wdhPasswordField.setForeground(Color.LIGHT_GRAY);
		wdhPasswordField.setText("Passwort wiederholen");
		System.out.println(wdhPasswordField.getEchoChar());
		wdhPasswordField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				JPasswordField source = (JPasswordField) e.getComponent();
				source.setText("");
				source.setEchoChar('\u25CF');
				source.setForeground(Color.BLACK);
				source.removeFocusListener(this);
			}
		});

		// set buttons on clicklistener
		passwortAendern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if (Comparator.compatePasswords(passwordField.getPassword(), wdhPasswordField.getPassword())) {
					try {
						System.out.println("gui -> User: " + usernameField.getText() + " Neues Pwd: "
								+ new String(passwordField.getPassword()));
						Logik.pwdAendern(usernameField.getText(), new String(passwordField.getPassword()));
						System.out.println("gui -> pwd geändert");
						dispose(); // fenster schließen
					} catch (FalscheAdmPwdAendernMethodeException e) {
						e.printStackTrace();
						new MessagePopup("Als Admin bitte das eigene Passwort über \"Passwort ändern\" bearbeiten!");
					} catch (UsrNichtGefundenException e) {
						e.printStackTrace();
						new MessagePopup("Der Nutzer konnte nicht gefunden werden!");
					} catch (InvalidKeyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeySpecException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidAlgorithmParameterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalBlockSizeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BadPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					new MessagePopup("Passwörter stimmen nicht überein!");
				}

			}
		});

		abbrechen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();// fenster schließen
			}
		});

		/*
		 * setting variables to Layout
		 */
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;

		////////////////////// reihe 1 ///////////////////////

		// usernameField
		gc.ipady = 20;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		add(usernameField, gc);

		////////////////////// reihe 2 ///////////////////////

		// passwordField
		gc.ipady = 20;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		add(passwordField, gc);

		////////////////////// reihe 3 ///////////////////////

		// wdhPasswordField
		gc.ipady = 20;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 2;
		add(wdhPasswordField, gc);

		////////////////////// reihe 4 ///////////////////////

		gc.gridwidth = 1;
		gc.ipady = 0;

		// hinzufuegen
		gc.gridx = 0;
		gc.gridy = 3;
		add(passwortAendern, gc);

		// abbrechen
		gc.gridx = 1;
		gc.gridy = 3;
		add(abbrechen, gc);

		// setze JFrame
		setSize(320, 200);
		Window.centerFrame(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
