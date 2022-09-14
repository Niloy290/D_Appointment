import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class userLogin extends Frame {
		protected static Frame logInFrame;
	public void user() {
		logInFrame = new Frame();
		logInFrame.setTitle("Welcome to doctors care");
		TitledBorder border1 = new TitledBorder("Login panel");
	    border1.setTitleJustification(TitledBorder.CENTER);
	    border1.setTitlePosition(TitledBorder.TOP);
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    logInFrame.add(panel);
		 panel.setBackground(Color.CYAN);
		 panel.setBorder(border1);
		  JLabel label1 = new JLabel("Id");
		  panel.add(label1);
	      JTextField text = new JTextField(20);
	      label1.setBounds(250, 150, 100, 80);
	      text.setBounds(340, 177, 200, 30);
	      panel.add(text);
	      
	      JLabel label2 = new JLabel("Password");
		  panel.add(label2);
	      JTextField text2 = new JTextField(20);
	      label2.setBounds(250, 200, 100, 80);
	      text2.setBounds(340, 227, 200, 30);
	      panel.add(text2);
	      
	      JButton button = new JButton("Login");
	      button.setBounds(350, 300, 80, 40);
	      panel.add(button);
	      
	      
			;
		    logInFrame.setVisible(true);
		    
		    button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{	
					String user, pass;
					
					user = text.getText();
					pass = text2.getText();
					
					match(user, pass);
				}
				
				private void match(String user,String pass) {
					JOptionPane dial = new JOptionPane();
					if(user.equals("admin") && pass.equals("admin123456"))
					{
						panel.setVisible(false);
						logInFrame.remove(panel);

						new Main_menu();
					}	
					else if(user.equals("admin") && pass != "admin123456")
					{
						dial.showMessageDialog(null, "Invalid password. Try again!");
					}
					else if(user != "admin" && pass.equals("admin123456"))
					{
						dial.showMessageDialog(null, "Invalid username. Try again!");
					}
					else
					{
						dial.showMessageDialog(null, "Invalid username and password. Try again!");
					}	
				}
			});
		    
	}
	}


