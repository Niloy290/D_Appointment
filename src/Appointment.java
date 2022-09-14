

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Appointment {
	
	Appointment()
	{
		takeAppointment();
	}
	

	
	private void takeAppointment()
	{
		
		userLogin.logInFrame.setTitle("Appointment Form");
		
		JPanel appointFormPanel = new JPanel();
		appointFormPanel.setLayout(null);
		appointFormPanel.setBackground(Color.WHITE);
		
		JButton button=new JButton("Back");
		button.setBounds(10, 10, 68, 20);
		button.addActionListener(new ActionListener()
		{  
			@Override
			public void actionPerformed(ActionEvent e)
			{
				appointFormPanel.setVisible(false);
				
				new Main_menu();
			}  
		}); 
		
		JLabel idLabel = new JLabel();
		idLabel.setText("Patient ID");
		idLabel.setBounds(170, 70, 150, 50);
		//idLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JTextField idField = new JTextField(20);
		idField.setBounds(250, 80, 250, 30);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Name");
		nameLabel.setBounds(170, 105, 150, 50);
		//nameLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JTextField firstNameField = new JTextField(20);
		firstNameField.setBounds(250, 115, 250, 30);
	
		JLabel genderLabel = new JLabel();
		genderLabel.setText("Gender");
		genderLabel.setBounds(170, 138, 150, 50);
		//genderLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		
	     String Gender[] = {"Male", "Female"};
		
		JComboBox genderBox = new JComboBox(Gender);
		genderBox.setBounds(250, 150, 100, 30);
		//genderBox.setFont(new Font("Serif", Font.PLAIN, 16));
		
		JLabel birthLabel = new JLabel();
		birthLabel.setText("Birthdate");
		birthLabel.setBounds(170, 173, 150, 50);
		//birthLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JTextField birthField=new JTextField();
        birthField.setBounds(250, 185, 250, 30);
        

		JLabel phoneLable = new JLabel();
		phoneLable.setText("Number");
		phoneLable.setBounds(170, 208, 150, 50);
		//phoneLable.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JTextField phoneField = new JTextField();
		phoneField.setBounds(250, 220, 250, 30);
		
		JLabel addressLabel = new JLabel();
		addressLabel.setText("Address");
		addressLabel.setBounds(170, 243, 150, 50);
		//addressLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JTextField addressField = new JTextField();
		addressField.setBounds(250, 255, 250, 30);
		
		JLabel historyLabel = new JLabel();
		historyLabel.setText("History");
		historyLabel.setBounds(170, 275, 150, 50);
		//historyLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JTextArea historyField = new JTextArea();

		historyField.setLineWrap(true);
		historyField.setWrapStyleWord(true);
		historyField.setEditable(false);
		
		JScrollPane scrollfield = new JScrollPane(historyField);
		scrollfield.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollfield.setBounds(250, 290, 250, 90);

		
		JButton bookButton = new JButton("Book");
		bookButton.setBounds(295, 400, 100, 30);
		
		bookButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String  P_Id = null, P_Name = null, Gender = null, Date_of_Birth = null, Address = null, History = null,Phone_Number=null;
				
				 patient_info Object = new patient_info();
				 P_Id = idField.getText();
					P_Name = firstNameField.getText();
					Gender = genderBox.getSelectedItem().toString();
					Date_of_Birth= birthField.getText();
					Phone_Number = phoneField.getText();
					Address = addressField.getText();
					History = historyField.getText();
					patient_info.patientList.add(Object);
					
						try
						{  
							Class.forName("com.mysql.jdbc.Driver");  
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost/doctor's_appointment","root","");  
							
							String query = "insert into patient values('" + P_Id + "','" + P_Name + "','" + Gender + "','" + Date_of_Birth + "','" + Phone_Number + "','" + Address + "','" + History + "');";
							
							Statement stmt=con.createStatement();  
							stmt.executeUpdate(query);
							
							con.close();
							
							new JOptionPane().showMessageDialog(null, "Appointment Confirmed!");
							
							appointFormPanel.setVisible(false);
							
							new Main_menu();
						}
						catch(Exception exception)
						{
							new JOptionPane().showMessageDialog(null, exception.getMessage());
							
						}  

							
			}
						
					
				 
		});
		
appointFormPanel.add(button);
appointFormPanel.add(idLabel);
appointFormPanel.add(nameLabel);
appointFormPanel.add(genderLabel);
appointFormPanel.add(birthLabel);

appointFormPanel.add(idField);
appointFormPanel.add(firstNameField);
appointFormPanel.add(genderBox);
appointFormPanel.add(birthField);
appointFormPanel.add(phoneLable);
appointFormPanel.add(phoneField);
appointFormPanel.add(addressLabel);
appointFormPanel.add(addressField);
appointFormPanel.add(historyLabel);
appointFormPanel.add(historyField);
appointFormPanel.add(scrollfield);

appointFormPanel.add(bookButton);


		
		appointFormPanel.setVisible(true);
		userLogin.logInFrame.add(appointFormPanel);
		
	}

}
