import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class cancelAppointment {
	
	cancelAppointment(){
		cancel();
	}
	public void cancel() {
	userLogin.logInFrame.setTitle("Cancel Appointment");
		
	JPanel mainMenuPanel = new JPanel();
	mainMenuPanel.setLayout(null);
	mainMenuPanel.setBackground(Color.WHITE);
	
	JButton backButton = new JButton("Back");
	backButton.setBounds(10, 10, 68, 20);
	
	backButton.addActionListener(new ActionListener()
	{  
		@Override
		public void actionPerformed(ActionEvent e)
		{
			mainMenuPanel.setVisible(false);
			
			new Main_menu();
		}  
	}); 

	
	JLabel phoneLabelC = new JLabel();
	phoneLabelC.setText("Number");
	phoneLabelC.setBounds(30, 20, 150, 50);
	
	JTextField phoneFieldC = new JTextField(15);
	phoneFieldC.setBounds(90, 30, 250, 30);
	
	JButton findButton = new JButton("Cancel");
	findButton.setBounds(400, 30, 110, 35);
	
	
	findButton.addActionListener(new ActionListener()
	{  
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String checkPhone;
			checkPhone = phoneFieldC.getText();
			
		
			
			if(checkPhone.isEmpty())
			{
				new JOptionPane().showMessageDialog(null, "Please enter your phone number!");
			}
			else {
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/doctor's_appointment","root","");  
				Statement stmt = con.createStatement();  
				String SQL = "DELETE FROM patient WHERE Phone_Number = ? ";
				PreparedStatement pstmt = null;

				// get a connection and then in your try catch for executing your delete...

				pstmt = con.prepareStatement(SQL); 
				pstmt.setString(1, checkPhone);
				pstmt.executeUpdate();
				
				con.close();
				phoneLabelC.setText("Number");
				
				new JOptionPane().showMessageDialog(null, "Cancel Confirmed!");
			
			}catch(Exception exception) {
				new JOptionPane().showMessageDialog(null, exception.getMessage());

			}
			
			}
			
		}  
	}); 
	mainMenuPanel.add(backButton);
	mainMenuPanel.add(phoneLabelC);
	mainMenuPanel.add(phoneFieldC);
	
	mainMenuPanel.add(findButton);
	
	mainMenuPanel.setVisible(true);
	userLogin.logInFrame.add(mainMenuPanel);
	}

}
