package ticketserver.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AddOffense extends JPanel
{
	public AddOffense() {
		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.pnlAddOffenseFields = new JPanel();
		add(this.pnlAddOffenseFields);
		this.pnlAddOffenseFields.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(109dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		this.lblOffenseName = new JLabel("Offense Name:");
		this.pnlAddOffenseFields.add(this.lblOffenseName, "4, 4, right, center");
		
		this.txtOffenseName = new JTextField();
		this.pnlAddOffenseFields.add(this.txtOffenseName, "6, 4, fill, default");
		this.txtOffenseName.setColumns(10);
		
		this.lblDescription = new JLabel("Description:");
		this.pnlAddOffenseFields.add(this.lblDescription, "4, 6, right, center");
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.pnlAddOffenseFields.add(this.scrollPane, "6, 6, fill, fill");
		
		this.txtOffenseDescription = new JTextArea();
		this.txtOffenseDescription.setRows(4);
		this.txtOffenseDescription.setLineWrap(true);
		this.scrollPane.setViewportView(this.txtOffenseDescription);
		
		this.pnlAddOffenseControls = new JPanel();
		add(this.pnlAddOffenseControls);
		this.pnlAddOffenseControls.setLayout(new BoxLayout(this.pnlAddOffenseControls, BoxLayout.Y_AXIS));
		
		this.pnllAddOffenseButtons = new JPanel();
		this.pnlAddOffenseControls.add(this.pnllAddOffenseButtons);
		
		this.btnSaveOffense = new JButton("Save Offense");
		this.pnllAddOffenseButtons.add(this.btnSaveOffense);
		
		this.btnResetFields = new JButton("Reset Fields");
		this.pnllAddOffenseButtons.add(this.btnResetFields);
		
		this.pnlAddoffenseStatus = new JPanel();
		this.pnlAddOffenseControls.add(this.pnlAddoffenseStatus);
		
		this.lblAddOffenseStatus = new JLabel("");
		this.lblAddOffenseStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		this.lblAddOffenseStatus.setHorizontalAlignment(SwingConstants.TRAILING);
		this.pnlAddoffenseStatus.add(this.lblAddOffenseStatus);
	}

	public JPanel getPnlAddOffenseControls() {
		return pnlAddOffenseControls;
	}
	public void setPnlAddOffenseControls(JPanel pnlAddOffenseControls) {
		this.pnlAddOffenseControls = pnlAddOffenseControls;
	}
	public JPanel getPnlAddOffenseFields() {
		return pnlAddOffenseFields;
	}
	public void setPnlAddOffenseFields(JPanel pnlAddOffenseFields) {
		this.pnlAddOffenseFields = pnlAddOffenseFields;
	}
	public JPanel getPnllAddOffenseButtons() {
		return pnllAddOffenseButtons;
	}
	public void setPnllAddOffenseButtons(JPanel pnllAddOffenseButtons) {
		this.pnllAddOffenseButtons = pnllAddOffenseButtons;
	}
	public JPanel getPnlAddoffenseStatus() {
		return pnlAddoffenseStatus;
	}
	public void setPnlAddoffenseStatus(JPanel pnlAddoffenseStatus) {
		this.pnlAddoffenseStatus = pnlAddoffenseStatus;
	}
	public JLabel getLblOffenseName() {
		return lblOffenseName;
	}
	public void setLblOffenseName(JLabel lblOffenseName) {
		this.lblOffenseName = lblOffenseName;
	}
	public JLabel getLblDescription() {
		return lblDescription;
	}
	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}
	public JTextField getTxtOffenseName() {
		return txtOffenseName;
	}
	public void setTxtOffenseName(JTextField txtOffenseName) {
		this.txtOffenseName = txtOffenseName;
	}
	public JTextArea getTxtOffenseDescription() {
		return txtOffenseDescription;
	}
	public void setTxtOffenseDescription(JTextArea txtOffenseDescription) {
		this.txtOffenseDescription = txtOffenseDescription;
	}
	public JButton getBtnSaveOffense() {
		return btnSaveOffense;
	}
	public void setBtnSaveOffense(JButton btnSaveOffense) {
		this.btnSaveOffense = btnSaveOffense;
	}
	public JButton getBtnResetFields() {
		return btnResetFields;
	}
	public void setBtnResetFields(JButton btnResetFields) {
		this.btnResetFields = btnResetFields;
	}
	public JLabel getLblAddOffenseStatus() {
		return lblAddOffenseStatus;
	}
	public void setLblAddOffenseStatus(JLabel lblAddOffenseStatus) {
		this.lblAddOffenseStatus = lblAddOffenseStatus;
	}

	private static final long serialVersionUID = 1L;
	private JPanel pnlAddOffenseControls;
	private JPanel pnlAddOffenseFields;
	private JPanel pnllAddOffenseButtons;
	private JPanel pnlAddoffenseStatus;
	private JLabel lblOffenseName;
	private JLabel lblDescription;
	private JTextField txtOffenseName;
	private JScrollPane scrollPane;
	private JTextArea txtOffenseDescription;
	private JButton btnSaveOffense;
	private JButton btnResetFields;
	private JLabel lblAddOffenseStatus;
	
}