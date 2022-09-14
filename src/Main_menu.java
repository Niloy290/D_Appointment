
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main_menu {
	Main_menu()
	{	
		menu_panel();
	}
	

	public void menu_panel() {
		
userLogin.logInFrame.setTitle("Docotrs Care Menu");
	
		JPanel mainMenuPanel = new JPanel();
		mainMenuPanel.setLayout(null);
		mainMenuPanel.setBackground(Color.WHITE);
		
		JTabbedPane tabPanel = new JTabbedPane();
		tabPanel.setBounds(0, 0, 700, 455);
		
		JPanel appointPanel = new JPanel();
		JPanel patientPanel = new JPanel();
		JPanel doctorPanel = new JPanel();
		//JPanel endPage = new JPanel();
		
		appointPanel.setBackground(Color.GRAY);
		patientPanel.setBackground(Color.GRAY);
		patientPanel.setLayout(null);
		doctorPanel.setBackground(Color.GRAY);
		patientPanel.setLayout(null);

		JLabel label=new JLabel();
		appointPanel.add(label);
		JButton takeAppointButton = new JButton("Take Appointment");
		JButton cancelAppointButton = new JButton("Cancel Appointment");
		appointPanel.add(takeAppointButton);
		appointPanel.add(cancelAppointButton);

		
		takeAppointButton.addActionListener(new ActionListener()
		{  
			@Override
			public void actionPerformed(ActionEvent e)
			{

				mainMenuPanel.setVisible(false);
				userLogin.logInFrame.setTitle("Appointment Form");
				new Appointment();	
			}  
		}); 
		
		
		cancelAppointButton.addActionListener(new ActionListener()
		{  
			@Override
			public void actionPerformed(ActionEvent e)
			{

				mainMenuPanel.setVisible(false);
				userLogin.logInFrame.setTitle("Cancel Appointment");
				new cancelAppointment();	
			}  
		}); 
		
		

		//doctor screen
		JLabel doctorlabel = new JLabel();
		JButton doctorButton = new JButton("Patients View");
		//doctorButton.setFont(new Font("Serif", Font.PLAIN, 20));
		
		doctorPanel.add(doctorButton);

		doctorButton.setBounds(250, 160, 195, 50);
		//doctorlabel.add(doctorButton);
		
		doctorButton.addActionListener(new ActionListener()
		{  
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{  
					Class.forName("com.mysql.cj.jdbc.Driver");  
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/doctor's_appointment","root","");  
						
					Statement stmt = con.createStatement();  
					ResultSet rs = stmt.executeQuery("Select * from patient");
						
					if(rs.next())
					{
						con.close();
						mainMenuPanel.setVisible(false);
						userLogin.logInFrame.setTitle("Patient List");
						new Doctor_Screen();
					}
					else
					{
						con.close();
						new JOptionPane().showMessageDialog(null, "No patient has registered yet!");
					}
				}
				catch(Exception exception)
				{
					new JOptionPane().showMessageDialog(null, exception.getMessage());
				} 		
			}  
		});
		
		doctorPanel.add(doctorlabel);
		//search

		JLabel phoneLabelC = new JLabel();
		phoneLabelC.setText("Number");
		phoneLabelC.setBounds(30, 20, 150, 50);
		
		JTextField phoneFieldC = new JTextField(15);
		phoneFieldC.setBounds(90, 30, 250, 30);
		
		JLabel idLabel = new JLabel();
		idLabel.setText("Patient ID");
		idLabel.setBounds(170, 100, 150, 50);
		
		JTextField idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(250, 100, 250, 30);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Name");
		nameLabel.setBounds(170, 130, 250, 50);
		
		
		JTextField firstNameField = new JTextField();
		firstNameField.setEditable(false);
		firstNameField.setBounds(250, 140, 250, 30);
	
		JLabel genderLabel = new JLabel();
		genderLabel.setText("Gender");
		genderLabel.setBounds(170, 170, 150, 50);
		
		
		JTextField genderField = new JTextField();
		
		genderField.setEditable(false);
		genderField.setBounds(250, 180, 250, 30);
		
		JLabel birthLabel = new JLabel();
		birthLabel.setText("Birthdate");
		birthLabel.setBounds(170, 210, 150, 50);
		
		JTextField dayField = new JTextField();
		dayField.setEditable(false);
		dayField.setBounds(250, 220, 250, 30);
		
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
		addressField.setBounds(250, 260, 250, 30);
		
		JLabel historyLabel = new JLabel();
		historyLabel.setText("History");
		historyLabel.setBounds(170, 290, 150, 50);
		
		JTextArea historyField = new JTextArea();
		historyField.setEditable(false);
		
		JButton findButton = new JButton("Find");
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
						ResultSet rs = stmt.executeQuery("Select * from patient where Phone_Number='"+checkPhone+"';");
			            while(rs.next()) {
			            	idField.setText(rs.getString(1));
			            	firstNameField.setText(rs.getString(2));
			            	genderField.setText(rs.getString(3));
			            	dayField.setText(rs.getString(4));
			            	addressField.setText(rs.getString(6));
			            	
							//historyField.setText(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6)+rs.getString(7));
				
			            }
			con.close();
					
					}catch(Exception exception) {
						new JOptionPane().showMessageDialog(null, exception.getMessage());

					}
					
				}
			}
				
		});
		
		patientPanel.add(phoneLabelC);
		patientPanel.add(phoneFieldC);
		
		patientPanel.add(findButton);
		patientPanel.add(idLabel);
		patientPanel.add(idField);
		patientPanel.add(nameLabel);
		patientPanel.add(firstNameField);
		patientPanel.add(genderLabel);
		patientPanel.add(genderField);
		patientPanel.add(birthLabel);
		patientPanel.add(dayField);
		patientPanel.add(addressLabel);
		patientPanel.add(addressField);
	


		tabPanel.add("Appointment", appointPanel);
		tabPanel.add("Search", patientPanel);
		tabPanel.add("Doctors Screen", doctorPanel);
		

		mainMenuPanel.add(tabPanel);
		mainMenuPanel.setVisible(true);
		userLogin.logInFrame.add(mainMenuPanel);

		
	}
}
