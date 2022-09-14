

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Doctor_Screen {
	
	

	Doctor_Screen(){
		
		showPatient();
	}
	
	
public void showPatient() {
	userLogin.logInFrame.setTitle("Patient List");
	JPanel dcpanel=new JPanel();
	
	

	JButton selectButton = new JButton("Show");
	selectButton.setBounds(470, 200, 100, 30);
	
	
	selectButton.addActionListener(new ActionListener()
	{  
		@Override
		public void actionPerformed(ActionEvent e)
		{
			dcpanel.setVisible(false);
			
            new showPatientInfo();
		}  
	});
	
	JButton backButton = new JButton("Back");
	backButton.setBounds(10, 10, 68, 20);

	
	backButton.addActionListener(new ActionListener()
	{  
		@Override
		public void actionPerformed(ActionEvent e)
		{
			dcpanel.setVisible(false);
			
			new Main_menu();
		}  
	}); 

	
	dcpanel.add(selectButton);
	dcpanel.add(backButton);
	dcpanel.setVisible(true);
	userLogin.logInFrame.add(dcpanel);

}


}