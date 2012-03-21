package ticketserver.view.login;

//import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ticketserver.controller.login.BtnLoginController;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TicketServerLoginForm extends JPanel {
	private static final long serialVersionUID = 1L;
	private BtnLoginController btnLoginController;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JLabel lblLoginStatus;

	public TicketServerLoginForm() {
		initialize();
	}

	private void initialize() {
		setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("39px"),
				ColumnSpec.decode("65px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("118px:grow"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("28px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(16dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		this.lblUsername = new JLabel("Username:");
		add(this.lblUsername, "2, 4, right, center");

		this.txtUsername = new JTextField();
		add(this.txtUsername, "4, 4, left, center");
		this.txtUsername.setColumns(20);

		this.lblPassword = new JLabel("Password:");
		add(this.lblPassword, "2, 6, right, center");

		this.txtPassword = new JPasswordField();
		this.txtPassword.setColumns(20);
		add(this.txtPassword, "4, 6, left, default");

		this.lblLoginStatus = new JLabel("");
		add(this.lblLoginStatus, "4, 8, left, center");

		this.btnLogin = new JButton("");
		this.btnLogin.setIcon(new ImageIcon(TicketServerLoginForm.class
				.getResource("/ticketserver/resources/LoginIcon.gif")));
		add(this.btnLogin, "4, 10, left, center");
	}

	public void initiateListners() {
		this.btnLoginController = new BtnLoginController(
				(JFrame) this.getTopLevelAncestor());
		this.btnLoginController.setLblControllerStatus(this.lblLoginStatus);
		this.btnLogin.addActionListener(this.btnLoginController);
		// this.btnLogin.addMouseListener(this.btnLoginController);
	}
}