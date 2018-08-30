package mini_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.ImageIcon;

public class Mainframe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe window = new Mainframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("AIRLINE RESERVATION MANAGEMENT SYSTEM");
		frame.getContentPane().setBackground(new Color(255, 153, 204));
		frame.getContentPane().setForeground(Color.MAGENTA);
		frame.setBounds(100, 100,866,452);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAirlineManagementSystem = new JLabel("AIR INDIA");
		lblAirlineManagementSystem.setForeground(new Color(100, 149, 237));
		lblAirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblAirlineManagementSystem.setBounds(297, 48, 512, 35);
		frame.getContentPane().add(lblAirlineManagementSystem);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Mithun\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\DPSUX22M\\20171104125839[2].jpg"));
		lblNewLabel.setBounds(197, 110, 478, 294);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAirlineSystem = new JMenu("AIRLINE SYSTEM");
		menuBar.add(mnAirlineSystem);
		
		JMenuItem mntmFlightDetails = new JMenuItem("FLIGHT_INFO");
		mnAirlineSystem.add(mntmFlightDetails);
		
		JMenuItem mntmReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
		mnAirlineSystem.add(mntmReservationDetails);
		
		JMenuItem mntmPassengerDetails = new JMenuItem("JOURNEY_DETAILS");
		mnAirlineSystem.add(mntmPassengerDetails);
		
		JMenuItem mntmSectorDetails_1 = new JMenuItem("PAYMENT_DETAILS");
		mnAirlineSystem.add(mntmSectorDetails_1);
		
		JMenuItem mntmCancellation = new JMenuItem("CANCELLATION");
		mnAirlineSystem.add(mntmCancellation);
		
		JMenu mnTicket = new JMenu("TICKET");
		menuBar.add(mnTicket);
		
		JMenu mnList = new JMenu("LIST");
		menuBar.add(mnList);
		
		JMenu mnMisc = new JMenu("MISC");
		menuBar.add(mnMisc);
		
		mntmFlightDetails.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				new SecondFrame();
			}
		});
	
		
		mntmReservationDetails.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try {
					new ThirdFrame();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		mntmPassengerDetails.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try {
					new FourthFrame();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		mntmSectorDetails_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try {
					new FifthFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	});
		
		mntmCancellation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) 
			{
				new SixthFrame();
			}
	});
		
		frame.setSize(960,590);
		frame.setVisible(true);
	}
}
