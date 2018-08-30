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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FifthFrame {
	
	static Connection mycon=null;
	static String url="jdbc:mysql://localhost:3306";
	static String dbname="/airline";
	static String driver="com.mysql.jdbc.Driver";
	static String userName="root";
	static String password="manju";

	private JFrame frmPaymentdetails;
	private JTextField textField;
	private JTable table;
	private JLabel lblSector;
	
	PreparedStatement pst=null;
	private JLabel lblFlightCode;
	private JLabel lblCapacity;
	private JLabel lblClasscode;
	private JLabel lblClassname;
	private JLabel label;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FifthFrame window = new FifthFrame();
					window.frmPaymentdetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public FifthFrame() throws ClassNotFoundException, SQLException {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmPaymentdetails = new JFrame("SECTOR_DETAILS");
		frmPaymentdetails.setTitle("PAYMENT_DETAILS");
		frmPaymentdetails.getContentPane().setBackground(new Color(255, 153, 204));
		frmPaymentdetails.getContentPane().setForeground(new Color(100, 149, 237));
		frmPaymentdetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaymentdetails.setSize(860,486);
		frmPaymentdetails.getContentPane().setLayout(null);
		
		JLabel lblFcode = new JLabel("PNR_NO");
		lblFcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFcode.setBounds(51, 169, 141, 26);
		frmPaymentdetails.getContentPane().add(lblFcode);
		
		textField = new JTextField();
		textField.setBounds(203, 169, 148, 26);
		frmPaymentdetails.getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(38, 329, 766, 87);
		frmPaymentdetails.getContentPane().add(table);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShow.setBounds(143, 228, 132, 24);
		frmPaymentdetails.getContentPane().add(btnShow);
		
		lblSector = new JLabel("PAYMENT _DETAILS");
		lblSector.setForeground(new Color(100, 149, 237));
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblSector.setBounds(51, 17, 300, 39);
		frmPaymentdetails.getContentPane().add(lblSector);
		
		lblFlightCode = new JLabel("PNR_NO");
		lblFlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFlightCode.setBounds(84, 292, 108, 26);
		frmPaymentdetails.getContentPane().add(lblFlightCode);
		
		lblCapacity = new JLabel("PAID_AMOUNT");
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCapacity.setBounds(183, 298, 92, 14);
		frmPaymentdetails.getContentPane().add(lblCapacity);
		
		lblClasscode = new JLabel("PAY_DATE");
		lblClasscode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClasscode.setBounds(322, 294, 101, 24);
		frmPaymentdetails.getContentPane().add(lblClasscode);
		
		lblClassname = new JLabel("CHEQUE_NO");
		lblClassname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClassname.setBounds(455, 298, 114, 14);
		frmPaymentdetails.getContentPane().add(lblClassname);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Mithun\\Downloads\\download.jpg"));
		label.setBounds(425, 15, 239, 272);
		frmPaymentdetails.getContentPane().add(label);
		
		JLabel lblCardno = new JLabel("CARD_NO");
		lblCardno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCardno.setBounds(602, 299, 101, 19);
		frmPaymentdetails.getContentPane().add(lblCardno);
		
		JLabel lblPhoneno = new JLabel("PHONE_NO");
		lblPhoneno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneno.setBounds(712, 294, 86, 24);
		frmPaymentdetails.getContentPane().add(lblPhoneno);
		frmPaymentdetails.setVisible(true);
		
		Class.forName(driver);
		 mycon=DriverManager.getConnection(url+dbname,userName,password); 
		 Statement stmt=mycon.createStatement(); 
		
		frmPaymentdetails.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		
		btnShow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				
				try {
					 String code =textField.getText();
					ResultSet myrs;
					pst=mycon.prepareStatement("select pnr_no,paid_amt,pay_date,cheque_no,card_no,ph_no from airline.payment where pnr_no=?");
					pst.setString(1, code);
					myrs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(myrs));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		
		frmPaymentdetails.setSize(960,590);
		frmPaymentdetails.setVisible(true);
		
	
			
		
	}
}
