import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class showPatientInfo {
private JPanel showPanel = new JPanel();
	
	showPatientInfo()
	{
		showPatient();
	}
	
	private void showPatient()
	{
		
		
		userLogin.logInFrame.setTitle("Patient Information");
		
		//showPanel.setLayout(null);
	    JButton backButton = new JButton("Back");
		
		backButton.setBounds(10, 10, 68, 20);
		
		/*JLabel idLabel = new JLabel();
		idLabel.setText("Patient ID");
		idLabel.setBounds(170, 50, 150, 50);
		
		JTextField idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(250, 60, 250, 30);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Name");
		nameLabel.setBounds(170, 90, 150, 50);
		
		
		JTextField firstNameField = new JTextField();
		firstNameField.setEditable(false);
		firstNameField.setBounds(250, 100, 250, 30);
	
		JLabel genderLabel = new JLabel();
		genderLabel.setText("Gender");
		genderLabel.setBounds(170, 130, 150, 50);
		
		
		JTextField genderField = new JTextField();
		
		genderField.setEditable(false);
		genderField.setBounds(250, 140, 250, 30);
		
		JLabel birthLabel = new JLabel();
		birthLabel.setText("Birthdate");
		birthLabel.setBounds(170, 170, 150, 50);
		
		JTextField dayField = new JTextField();
		dayField.setEditable(false);
		dayField.setBounds(250, 180, 250, 30);
		
		JLabel phoneLable = new JLabel();
		phoneLable.setText("Number");
		phoneLable.setBounds(170, 210, 150, 50);
		
		JTextField phoneField = new JTextField();
		phoneField.setEditable(false);
		phoneField.setBounds(250, 220, 250, 30);
		
		JLabel addressLabel = new JLabel();
		addressLabel.setText("Address");
		addressLabel.setBounds(170, 250, 150, 50);
		
		JTextField addressField = new JTextField();
		
		addressField.setEditable(false);
		addressField.setBounds(250, 260, 250, 30);*/
		
		JLabel historyLabel = new JLabel();
		historyLabel.setText("History");
		historyLabel.setBounds(170, 290, 150, 50);
		
		JTextArea historyField = new JTextArea();
		historyField.setEditable(true);

		historyField.setLineWrap(true);
		historyField.setWrapStyleWord(true);
		
		
		

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/doctor's_appointment","root","");  
			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery("Select * from patient");
            while(rs.next()) {
            	
				historyField.setText(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6)+rs.getString(7));
	
            }
con.close();
		
		}catch(Exception exception) {
			new JOptionPane().showMessageDialog(null, exception.getMessage());

		}
		

			
		
		
	
		//backButton.setFont(new Font("Serif", Font.PLAIN, 16));
		
		backButton.addActionListener(new ActionListener()
		{  
			@Override
			public void actionPerformed(ActionEvent e)
			{
				showPanel.setVisible(false);
				new Doctor_Screen();
			}  
		}); 
		showPanel.add(backButton);
		showPanel.add(historyLabel);
        showPanel.add(historyField);
		
		
		

	
		
		userLogin.logInFrame.add(showPanel);
		
	}

}
