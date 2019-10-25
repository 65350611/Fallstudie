package wwi.fallstudie.gui.login;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import backend.Anmeldung;
import backend.Logik;
import wwi.fallstudie.gui.admin.AdminOberflaeche;
import wwi.fallstudie.gui.popupAllgemein.MessagePopup;
import wwi.fallstudie.gui.user.UserOberflaeche;
import wwi.fallstudie.gui.utilities.Window;

public class Login extends JFrame {

	private ImageIcon logoIcon;
	private JLabel logo;
	private LoginPanel loginPanel;
	private JButton einloggen;

	public Login() {
		super("Login");

		setLayout(new BorderLayout()); // set Layout Manager

		// initialise variables
		logoIcon = new ImageIcon("src/images/IMG_1026.JPG"); // TODO logo ändern <<src/images/BoB_Logo128.png
		logo = new JLabel(logoIcon);
		loginPanel = new LoginPanel();
		einloggen = new JButton("Einloggen");

		// listeners
		einloggen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("Einloggen LoginScreen gedrückt");
				try {
					System.out.println(
							"getName: " + loginPanel.getNameLabel() + " getPasswort: " + loginPanel.getPasswort());
					Anmeldung.anmelden(loginPanel.getNameLabel(), loginPanel.getPasswort());

					if (Logik.istAdmin()) {
						new AdminOberflaeche(); // öffne Admin oberfläche
						dispose(); // loginfenster schließen
					} else {
						new UserOberflaeche(); // öffne User oberfläche
						dispose(); // loginfenster schließen
					}
				} catch (Exception e) {
					e.printStackTrace();
					new MessagePopup("Anmeldung fehlgeschlagen");
				}
			}
		});
		// add to content pane
		add(logo, BorderLayout.NORTH);
		add(loginPanel, BorderLayout.CENTER);
		add(einloggen, BorderLayout.SOUTH);

		/// listener auf Exit Button
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				e.getWindow().dispose(); // schließe fenster
				Logik.exitProgram(); // schliesse DB Connection
			}
		});

		// set Frame
		setSize(320, 380);
		Window.centerFrame(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
