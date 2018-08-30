package mini_project;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.tools.JavaFileObject;
import javax.swing.JScrollBar;
public class SecondFrame {
	static Connection mycon=null;
	static String url="jdbc:mysql://localhost:3306";
	static String dbname="/airline";
	static String driver="com.mysql.jdbc.Driver";
	static String userName="root";
	static String password="manju";
	
	
	

	PreparedStatement pst=null;
	ResultSet rs=null;
	
	
	
	private JFrame f=new JFrame("FLIGHT_INFO");
	private static Statement stmt;
	private JTable table;
	private JTextField textField;
	public static void main(String[] args) {
		 
					   

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					SecondFrame window = new SecondFrame();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SecondFrame()
	{
		
		
		f.getContentPane().setBackground(new Color(255, 153, 204));
		f.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(860,523);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		
		JLabel lblFcode = new JLabel("F_CODE");
		lblFcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFcode.setBounds(43, 176, 76, 31);
		f.getContentPane().add(lblFcode);
	
		
		JLabel lblFlightDetails = new JLabel("FLIGHT_INFO");
		lblFlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblFlightDetails.setForeground(new Color(100, 149, 237));
		lblFlightDetails.setBounds(47, 11, 270, 31);
		f.getContentPane().add(lblFlightDetails);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				 String code =textField.getText();
				 
				     
					try {
					
						ResultSet myrs;
						pst=mycon.prepareStatement("select A.f_code,A.f_name,A.src,A.dst,B.capacity,B.class_code,B.class_name from airline.flight A,airline.sector B where A.f_code=B.flight_code and f_code=? ");
						pst.setString(1, code);
						myrs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(myrs));
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
			}
		});
		btnShow.setBounds(129, 241, 120, 31);
		f.getContentPane().add(btnShow);
		
		table = new JTable();
		table.setBounds(10, 349, 806, 76);
		f.getContentPane().add(table);
		
		textField = new JTextField();
		textField.setBounds(145, 176, 104, 29);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFlightCode = new JLabel("FLIGHT CODE");
		lblFlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFlightCode.setBounds(23, 318, 126, 20);
		f.getContentPane().add(lblFlightCode);
		
		JLabel lblFlightName = new JLabel("FLIGHT NAME");
		lblFlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFlightName.setBounds(145, 321, 120, 14);
		f.getContentPane().add(lblFlightName);
		
		JLabel lblSource = new JLabel("SOURCE");
		lblSource.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSource.setBounds(275, 321, 104, 14);
		f.getContentPane().add(lblSource);
		
		JLabel lblDestination = new JLabel("DESTINATION");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDestination.setBounds(367, 316, 120, 24);
		f.getContentPane().add(lblDestination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Mithun\\Downloads\\20171109190614.jpg"));
		lblNewLabel.setBounds(327, 11, 463, 269);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblCapacity = new JLabel("CAPACITY");
		lblCapacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCapacity.setBounds(497, 321, 111, 14);
		f.getContentPane().add(lblCapacity);
		
		JLabel lblClassCode = new JLabel("CLASS CODE");
		lblClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClassCode.setBounds(587, 318, 120, 20);
		f.getContentPane().add(lblClassCode);
		
		JLabel lblClassName = new JLabel("CLASS NAME");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClassName.setBounds(700, 321, 111, 14);
		f.getContentPane().add(lblClassName);
		
		
		
	
		
		try{
			 Class.forName(driver); 
			 mycon=DriverManager.getConnection(url+dbname,userName,password); 
			  stmt=mycon.createStatement(); 
			  
			 
				
			  
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
		
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		f.setSize(860,486);
		f.setVisible(true);
		
	}
}
