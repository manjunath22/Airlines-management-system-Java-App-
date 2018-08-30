package mini_project;

import java.awt.EventQueue;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class ThirdFrame {
	static Connection mycon=null;
	static String url="jdbc:mysql://localhost:3306";
	static String dbname="/airline";
	static String driver="com.mysql.jdbc.Driver";
	static String userName="root";
	static String password="manju";
	Connection con=null;
	
	private JFrame f1=new JFrame("ADD_PASSENGERS");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThirdFrame window =new ThirdFrame();
					window.f1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	PreparedStatement pst=null;
	private JTextField textField_6;
	
	public ThirdFrame() throws ClassNotFoundException, SQLException
	{
			f1.getContentPane().setForeground(new Color(100, 149, 237));
			f1.getContentPane().setBackground(new Color(255, 153, 204));
			f1.setTitle("ADD_CUSTOMER_DETAILS");
		 
			f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			f1.setSize(778,486);
			f1.getContentPane().setLayout(null);
			
			JLabel lblPassportno = new JLabel("PASSPORT_NO");
			lblPassportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPassportno.setBounds(60, 63, 121, 27);
			f1.getContentPane().add(lblPassportno);
			
			textField = new JTextField();
			textField.setBounds(191, 64, 139, 24);
			f1.getContentPane().add(textField);
			textField.setColumns(10);
			
			JButton btnNext = new JButton("SAVE");
			btnNext.setBounds(206, 388, 139, 27);
			f1.getContentPane().add(btnNext);
			
			JLabel lblPnrno = new JLabel("PNR_NO");
			lblPnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPnrno.setBounds(70, 109, 83, 24);
			f1.getContentPane().add(lblPnrno);
			
			textField_1 = new JTextField();
			textField_1.setBounds(190, 111, 140, 22);
			f1.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblAddress = new JLabel("ADDRESS");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblAddress.setBounds(70, 159, 83, 24);
			f1.getContentPane().add(lblAddress);
			
			textField_2 = new JTextField();
			textField_2.setBounds(192, 161, 138, 22);
			f1.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNationality = new JLabel("NATIONALITY");
			lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNationality.setBounds(44, 209, 121, 22);
			f1.getContentPane().add(lblNationality);
			
			textField_3 = new JTextField();
			textField_3.setBounds(191, 213, 139, 21);
			f1.getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblName = new JLabel("NAME");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblName.setBounds(82, 254, 83, 24);
			f1.getContentPane().add(lblName);
			
			textField_4 = new JTextField();
			textField_4.setBounds(191, 256, 139, 22);
			f1.getContentPane().add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblGender = new JLabel("GENDER");
			lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblGender.setBounds(77, 299, 88, 24);
			f1.getContentPane().add(lblGender);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("MALE");
			rdbtnNewRadioButton.setBounds(193, 300, 109, 23);
			f1.getContentPane().add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
			rdbtnFemale.setBounds(309, 300, 114, 22);
			f1.getContentPane().add(rdbtnFemale);
			
			JLabel lblPhno = new JLabel("PH_NO");
			lblPhno.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblPhno.setBounds(82, 343, 83, 21);
			f1.getContentPane().add(lblPhno);
			
			textField_5 = new JTextField();
			textField_5.setBounds(191, 343, 140, 21);
			f1.getContentPane().add(textField_5);
			textField_5.setColumns(10);
			f1.setVisible(true);
			
			
			JLabel lblAddPassengers = new JLabel("ADD_CUSTOMER_DETAILS");
			lblAddPassengers.setForeground(new Color(100, 149, 237));
			lblAddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
			lblAddPassengers.setBounds(402, 24, 442, 27);
			f1.getContentPane().add(lblAddPassengers);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Mithun\\Downloads\\20171109191019.png"));
			lblNewLabel.setBounds(456, 63, 342, 311);
			f1.getContentPane().add(lblNewLabel);
			
			JLabel lblFlightcode = new JLabel("FLIGHT_CODE");
			lblFlightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblFlightcode.setBounds(56, 22, 109, 41);
			f1.getContentPane().add(lblFlightcode);
			
			textField_6 = new JTextField();
			textField_6.setBounds(189, 24, 141, 24);
			f1.getContentPane().add(textField_6);
			textField_6.setColumns(10);
			
			Class.forName(driver);
			 mycon=DriverManager.getConnection(url+dbname,userName,password); 
			 Statement stmt=mycon.createStatement(); 
				
			 
					
			btnNext.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					String passport_No=(String)textField.getText();
					String pnr_no=(String)textField_1.getText();
					String address=(String)textField_2.getText();
					String nationality=(String)textField_3.getText();
					String name=(String)textField_4.getText();
					String fl_code=(String)textField_6.getText();
					
					String g = null;
					String ph_no=(String)textField_5.getText();
						if(rdbtnNewRadioButton.isSelected())
						{
							g="male";
						}
						else if(rdbtnFemale.isSelected())
						{
							g="female";
						}
					
					try {
						Class.forName(driver);
						
						
						 con=DriverManager.getConnection(url+dbname,userName,password);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					try {						
						pst=con.prepareStatement("INSERT INTO `airline`.`passenger` ( `pnr_no`, `address`, `nationality`,`name`, `gender`, `ph_no`,`passport_no`, `fl_code`) VALUES (?,?,?,?,?,?,?,?)");
						pst.setString(1,pnr_no);
						pst.setString(2, address);
						pst.setString(3,nationality);
						pst.setString(4,name);
						pst.setString(5,g);
						pst.setString(6, ph_no);
						pst.setString(7, passport_No);
						pst.setString(8,fl_code);
						
						pst.executeUpdate();
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				
				}
			});
			
			
			f1.setSize(860,486);
			f1.setVisible(true);
			
			
	}
}
