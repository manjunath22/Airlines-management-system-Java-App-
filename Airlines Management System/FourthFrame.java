package mini_project;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
public class FourthFrame {

	private JFrame frame = new JFrame("JOURNEY_DETAILS");
	private JTable table;
	private JLabel lblReservationDetails;
	static Connection mycon=null;
	static String url="jdbc:mysql://localhost:3306";
	static String dbname="/airline";
	static String driver="com.mysql.jdbc.Driver";
	static String userName="root";
	static String password="manju";
	private JLabel lblPnrno;
	private JLabel lblTicketid;
	private JLabel lblFcode;
	private JLabel lblJnydate;
	private JLabel lblJnytime;
	private JLabel lblSource_1;
	private JLabel lblDestination_1;
	private JLabel label;
	private JLabel label_1;
	
	

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//FourthFrame f=new FourthFrame();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FourthFrame window = new FourthFrame();
					window.frame.setVisible(true);
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
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public FourthFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		frame.getContentPane().setBackground(new Color(255, 153, 204));
		frame.setBackground(new Color(0, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(860,486);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSource = new JLabel("SOURCE");
		lblSource.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSource.setBounds(68, 147, 94, 21);
		frame.getContentPane().add(lblSource);
		
			 Class.forName(driver);
			 mycon=DriverManager.getConnection(url+dbname,userName,password); 
			 Statement stmt=mycon.createStatement(); 
			  
		JLabel lblDestination = new JLabel("DESTINATION");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDestination.setBounds(230, 148, 156, 18);
		frame.getContentPane().add(lblDestination);
		
		table = new JTable();
		table.setBounds(38, 321, 773, 126);
		frame.getContentPane().add(table);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setBounds(172, 232, 89, 23);
		frame.getContentPane().add(btnShow);
		
		
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(btnShow);
		
		lblReservationDetails = new JLabel("JOURNEY_DETAILS");
		lblReservationDetails.setForeground(new Color(100, 149, 237));
		lblReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblReservationDetails.setBounds(224, 27, 359, 21);
		frame.getContentPane().add(lblReservationDetails);
		
		lblPnrno = new JLabel("PNR_NO");
		lblPnrno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPnrno.setBounds(79, 294, 83, 21);
		frame.getContentPane().add(lblPnrno);
		
		lblTicketid = new JLabel("TICKET_ID");
		lblTicketid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTicketid.setBounds(172, 297, 71, 14);
		frame.getContentPane().add(lblTicketid);
		
		lblFcode = new JLabel("F_CODE");
		lblFcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFcode.setBounds(297, 297, 103, 14);
		frame.getContentPane().add(lblFcode);
		
		lblJnydate = new JLabel("JNY_DATE");
		lblJnydate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJnydate.setBounds(390, 289, 94, 26);
		frame.getContentPane().add(lblJnydate);
		
		lblJnytime = new JLabel("JNY_TIME");
		lblJnytime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJnytime.setBounds(494, 297, 83, 14);
		frame.getContentPane().add(lblJnytime);
		
		lblSource_1 = new JLabel("SOURCE");
		lblSource_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSource_1.setBounds(613, 295, 94, 18);
		frame.getContentPane().add(lblSource_1);
		
		lblDestination_1 = new JLabel("DESTINATION");
		lblDestination_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDestination_1.setBounds(717, 297, 94, 14);
		frame.getContentPane().add(lblDestination_1);
		

		
		String[] items1 =  { "BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD" };
		JComboBox comboBox = new JComboBox(items1);
		comboBox.setBounds(37, 171, 139, 21);
		frame.getContentPane().add(comboBox);
		
		
		
		String[] items2 =  { "BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD" };
		JComboBox comboBox_1 = new JComboBox(items2);
		comboBox_1.setBounds(230, 171, 132, 20);
		frame.getContentPane().add(comboBox_1);
		
		label_1 = new JLabel("");
		label_1.setBounds(498, 87, 293, 164);
		frame.getContentPane().add(label_1);
		
		
		
		btnShow.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent ae)
			{
				try{
					String src =(String) comboBox.getSelectedItem();
					 String dst =(String) comboBox_1.getSelectedItem();
					
					PreparedStatement pst = mycon.prepareStatement("select pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst from airline.reservation where src=? and dst=?");
					pst.setString(1, src);
					pst.setString(2,dst);
					ResultSet myrs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(myrs));
					
					
				
				
			
			}  
			catch(Exception e){
			
			}
			}
		});
		
		frame.setSize(860,486);
		frame.setVisible(true);
		

	}
}
