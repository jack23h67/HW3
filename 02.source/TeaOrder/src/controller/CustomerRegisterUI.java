package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer;
import service.Impl.CustomerServiceImpl;
import util.Cal1;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class CustomerRegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField customerregisterusername;
	private JPasswordField customerregisterpassword;
	private JTextField customerregistername;
	private JTextField customerregisterphone;
	private static Cal1 cal = new Cal1();
	private JTextField customerregisteraddress;
	private CustomerServiceImpl csi = new CustomerServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegisterUI frame = new CustomerRegisterUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerRegisterUI() {
		setTitle("會員註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 407);
		setLocation(750, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 46, 180, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("電話");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 108, 40, 31);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("姓名");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 80, 40, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("密碼");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 39, 40, 31);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("帳號");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 4, 32, 31);
		panel.add(lblNewLabel_2);
		
		customerregisterusername = new JTextField();
		customerregisterusername.setColumns(10);
		customerregisterusername.setBounds(51, 8, 96, 21);
		panel.add(customerregisterusername);
		
		customerregisterpassword = new JPasswordField();
		customerregisterpassword.setBounds(51, 45, 96, 23);
		panel.add(customerregisterpassword);
		
		customerregistername = new JTextField();
		customerregistername.setColumns(10);
		customerregistername.setBackground(Color.WHITE);
		customerregistername.setBounds(51, 80, 96, 21);
		panel.add(customerregistername);
		
		customerregisterphone = new JTextField();
		customerregisterphone.setColumns(10);
		customerregisterphone.setBounds(51, 115, 96, 21);
		panel.add(customerregisterphone);
		
		JLabel lblNewLabel_5_1 = new JLabel("地址");
		lblNewLabel_5_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(10, 141, 40, 31);
		panel.add(lblNewLabel_5_1);
		
		customerregisteraddress = new JTextField();
		customerregisteraddress.setColumns(10);
		customerregisteraddress.setBounds(51, 148, 96, 21);
		panel.add(customerregisteraddress);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		comboBox.setBounds(10, 182, 145, 25);
		comboBox.addItem("非會員");
		comboBox.addItem("一般會員100");
		comboBox.addItem("銀卡會員300");	
		comboBox.addItem("金卡會員500");
		
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(34, 10, 202, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員註冊");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 22));
		lblNewLabel.setBounds(56, 0, 126, 36);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 297, 243, 61);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JButton customerregisterexit = new JButton("離開");
		customerregisterexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object				
			}
		});
		customerregisterexit.setForeground(new Color(255, 250, 250));
		customerregisterexit.setBackground(new Color(255, 0, 0));
		customerregisterexit.setBounds(125, 0, 87, 23);
		panel_2.add(customerregisterexit);
		
		JLabel registerwarning = new JLabel("");
		registerwarning.setForeground(new Color(227, 57, 15));
		registerwarning.setFont(new Font("微軟正黑體", Font.PLAIN, 11));
		registerwarning.setBounds(0, 23, 243, 34);
		panel_2.add(registerwarning);
		
		JButton customerregisterregister = new JButton("註冊");
		customerregisterregister.setBackground(Color.LIGHT_GRAY);
		customerregisterregister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cInputusername = customerregisterusername.getText().trim();
				String cInputPassword = String.valueOf(customerregisterpassword.getPassword()).trim();
				String cInputname = customerregistername.getText().trim();
				String cInputAddress = customerregistername.getText().trim();
				String cInputPhone = customerregisterphone.getText().trim();
				String level = (String)comboBox.getSelectedItem();
				int lv =  0;
				if(level.equals("非會員")) lv=0;
				else if(level.equals("一般會員100")) lv=1;
				else if(level.equals("銀卡會員300")) lv=2;
				else if(level.equals("金卡會員500")) lv=3;
				System.out.println(cInputusername.isEmpty());
				if(cInputusername.isEmpty()||cInputPassword.isEmpty()||cInputAddress.isEmpty()||cInputPhone.isEmpty()||cInputname.isEmpty())
				{
					registerwarning.setText("帳號、密碼、姓名。地址、電話必須輸入");
				}
				else
				{
					if(csi.findByUsername(cInputusername))
					{
						registerwarning.setText("此帳號已有人使用");
						customerregisterusername.setBackground(Color.ORANGE);
					}
					else 
					{
						
						Customer c = new Customer();
						c.setCustomerusername(cInputusername);
						c.setCustomerpassword(cInputPassword);
						c.setCustomername(cInputname);
						c.setCustomerphone(cInputPhone);
						c.setCustomeraddress(cInputAddress);
						
						c.setCustomerlevel(lv);
						csi.addCustomer(c);
						setVisible(false);
						dispose();
						cal.gotoCustomerLogin();
					}
				}
			}
		});
		customerregisterregister.setBounds(29, 0, 87, 23);
		panel_2.add(customerregisterregister);
		
	}
}
