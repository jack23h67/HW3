package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Order;
import model.Product;
import service.Impl.OrderServiceImpl;
import service.Impl.ProductServiceImpl;
import util.Cal1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class CustomerOrderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bubbleTeaNum;
	private JTextField blackTeaNum;
	private JTextField pekoeNum;
	private JTextField fourSeasonOolongTeaNum;
	private JTextField greenMilkTeaNum;
	private JTextField kumquatLemonadeNum;
	private JTextField payMoney;
	private int sum = 0;
	private double discount = 1.0;
	String changeMoneyInfo = "";
	private static Cal1 cal = new Cal1();
	private String customerinfo = "";

	private static OrderServiceImpl os1 = new OrderServiceImpl();
	private static ProductServiceImpl ps1 = new ProductServiceImpl();  
	List<Product>  pl1 = ps1.findAll();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeaOrderUI frame = new TeaOrderUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/*
	 * @input 找零金額 
	 * @return 找零訊息
	 * */
	public String makeChange(Integer payMoneyInt)
	{
		int tmp1=0,tmp2=0,tmp3=0, makeChange=payMoneyInt,
			oneThousand=0,fiveHundred=0,oneHundred=0,
			fiftyCoin=0,tenCoin=0,fiveCoin=0,oneCoin=0;
		
		String changeMoneyInfo = "需要找您:\t"+makeChange+
				"\n-----------------------------------------------------------------------";
		
		tmp1 = makeChange/1000;
		tmp2 = makeChange%1000;
		oneThousand = tmp1;
		if(oneThousand>0) {
			changeMoneyInfo +="\n1000元鈔票:"+oneThousand;
		}
		tmp3 = tmp2;

		tmp1 = tmp3/500;
		tmp2 = tmp3%500;
		fiveHundred = tmp1;
		if(fiveHundred>0) {
			changeMoneyInfo +="\n500元鈔票:"+fiveHundred;
		}
		tmp3 = tmp2;

		tmp1 = tmp3/100;
		tmp2 = tmp3%100;
		oneHundred= tmp1;
		if(oneHundred>0) {
			changeMoneyInfo +="\n100元鈔票:"+oneHundred;
		}
		tmp3 = tmp2;

		tmp1 = tmp3/50;
		tmp2 = tmp3%50;
		fiftyCoin= tmp1;
		if(fiftyCoin>0) {
			changeMoneyInfo +="\n50元硬幣:"+fiftyCoin;
		}
		tmp3 = tmp2;

		tmp1 = tmp3/10;
		tmp2 = tmp3%10;
		tenCoin= tmp1;
		if(tenCoin>0) {
			changeMoneyInfo +="\n10元硬幣:"+tenCoin;
		}
		tmp3 = tmp2;

		tmp1 = tmp3/5;
		tmp2 = tmp3%5;
		fiveCoin= tmp1;
		if(fiveCoin>0) {
			changeMoneyInfo +="\n5元硬幣:"+fiveCoin;
		}
		tmp3 = tmp2;

		tmp1 = tmp3/1;
		tmp2 = tmp3%1;
		oneCoin= tmp1;
		if(oneCoin>0) {
			changeMoneyInfo +="\n1元硬幣:"+oneCoin;
		}
		tmp3 = tmp2;
								
		return changeMoneyInfo;
	}
	
	/**
	 * Create the frame.
	 */

	public CustomerOrderUI() {
		try {
			customerinfo = cal.getCustomer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] words = customerinfo.split(",");
		String cName = words[0];
		String no	 = words[1];
		String level = words[2];
		int ilevel = Integer.parseInt(level);
		
		int pl1len = pl1.size();
		int[] teanum = new int[pl1len];
		String[] teaname  = new String[pl1len];
		double[] teaprice = new double[pl1len];
		String[] teaInfo  = new String[pl1len];
		
		String[] teaMenu = new String[pl1len];
		
		
		String tmp = "";
		int tmp2=0;
		for(int j=0;j<pl1len;j++)
		{
			tmp = "";
			teanum[j] = 0;
			teaname[j]  = pl1.get(j).getProductname();
			teaprice[j] = pl1.get(j).getProductprice();
			@SuppressWarnings("deprecation")
			Double newData = new Double(pl1.get(j).getProductprice());
			tmp2 = newData.intValue();
			tmp = tmp.concat(pl1.get(j).getProductname()).concat("/一杯")
					.concat(String.valueOf(tmp2));
			teaMenu[j] = tmp ;
		}
		
		setTitle("先喝道台北誠品站前店點餐系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 472);
		setLocation(680,345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 256, 274);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("客戶姓名:");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 10, 130, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(teaMenu[0]);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 40, 130, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(teaMenu[2]);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 100, 130, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(teaMenu[4]);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 160, 130, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(teaMenu[5]);
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(20, 190, 130, 30);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(teaMenu[3]);
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(20, 130, 130, 30);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(teaMenu[1]);
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(20, 70, 130, 30);
		panel_1.add(lblNewLabel_6);
		
		bubbleTeaNum = new JTextField();
		bubbleTeaNum.setBounds(140, 48, 79, 21);
		panel_1.add(bubbleTeaNum);
		bubbleTeaNum.setColumns(10);
		
		blackTeaNum = new JTextField();
		blackTeaNum.setBounds(140, 78, 79, 21);
		panel_1.add(blackTeaNum);
		blackTeaNum.setColumns(10);
		
		pekoeNum = new JTextField();
		pekoeNum.setBounds(140, 108, 79, 21);
		panel_1.add(pekoeNum);
		pekoeNum.setColumns(10);
		
		fourSeasonOolongTeaNum = new JTextField();
		fourSeasonOolongTeaNum.setBounds(140, 140, 79, 21);
		panel_1.add(fourSeasonOolongTeaNum);
		fourSeasonOolongTeaNum.setColumns(10);
		
		greenMilkTeaNum = new JTextField();
		greenMilkTeaNum.setBounds(140, 168, 79, 21);
		panel_1.add(greenMilkTeaNum);
		greenMilkTeaNum.setColumns(10);
		
		kumquatLemonadeNum = new JTextField();
		kumquatLemonadeNum.setBounds(140, 198, 79, 21);
		panel_1.add(kumquatLemonadeNum);
		kumquatLemonadeNum.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		if(ilevel==1) {
			comboBox.addItem("一般會員");
		}else if(ilevel==2) {
			comboBox.addItem("銀卡會員");	
		}else if(ilevel==3) {
			comboBox.addItem("金卡會員");
		}else {
			comboBox.addItem("非會員");
		}
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboBox.setBounds(103, 230, 116, 30);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("會員等級");
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(20, 230, 112, 30);
		panel_1.add(lblNewLabel_8);
		
		JLabel lbname = new JLabel(cName);
		lbname.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lbname.setBounds(140, 13, 79, 30);
		panel_1.add(lbname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(276, 10, 336, 415);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea output_01 = new JTextArea();
		output_01.setBounds(10, 10, 319, 215);
		panel_2.add(output_01);
		
		JLabel lblNewLabel_7 = new JLabel("請輸入您付款的金額");
		lblNewLabel_7.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 235, 141, 31);
		panel_2.add(lblNewLabel_7);
		
		payMoney = new JTextField();
		payMoney.setText("0");
		payMoney.setBounds(145, 235, 80, 29);
		panel_2.add(payMoney);
		payMoney.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("結帳");
		btnNewButton_1.setBounds(235, 235, 87, 31);
		panel_2.add(btnNewButton_1);
		
		JTextArea output_02 = new JTextArea();
		output_02.setBounds(10, 276, 319, 129);
		panel_2.add(output_02);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 294, 256, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton customerloginexit = new JButton("離開");
		customerloginexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		customerloginexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		customerloginexit.setForeground(new Color(255, 250, 250));
		customerloginexit.setBackground(Color.RED);
		customerloginexit.setBounds(93, 48, 73, 23);
		panel.add(customerloginexit);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.setBounds(10, 46, 73, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.setBounds(93, 10, 73, 23);
		panel.add(btnNewButton);
		
		JButton clear = new JButton("清空");
		clear.setBounds(10, 10, 73, 23);
		panel.add(clear);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 385, 256, 40);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel txttime = new JLabel("");
		txttime.setForeground(new Color(0, 128, 192));
		txttime.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		txttime.setBounds(25, 0, 225, 40);
		panel_3.add(txttime);
		
		Timer timer = new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
				txttime.setText(timeStamp);
			}
			
		});
		timer.start();
		
		
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bubbleTeaNum.setText("0");
				blackTeaNum.setText("0");
				pekoeNum.setText("0");
				fourSeasonOolongTeaNum.setText("0");
				greenMilkTeaNum.setText("0");
				kumquatLemonadeNum.setText("0");
				comboBox.setSelectedIndex(0);
				payMoney.setText("0");
				output_02.setText("");
				output_01.setText("");	
				sum=0;
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 接 input String
//				String CustomerName = customerName.getText();
				String BubbleTeaNum = bubbleTeaNum.getText();
				String BlackTeaNum = blackTeaNum.getText();
				String PekoeNum = pekoeNum.getText();
				String FourSeasonOolongTeaNum = fourSeasonOolongTeaNum.getText();
				String GreenMilkTeaNum = greenMilkTeaNum.getText();
				String KumquatLemonadeNum = kumquatLemonadeNum.getText();
				Double originalPrice = 0.0;
				/*
				 * 轉型檢查 begin
				 * */
				try {
					teanum[0] = Integer.parseInt(BubbleTeaNum);
					if(teanum[0]<=0) {teanum[0]=0; bubbleTeaNum.setText("0");}
				}catch(NumberFormatException e1)
				{teanum[0] = 0;bubbleTeaNum.setText("0");}
				
				try {
					teanum[1] = Integer.parseInt(BlackTeaNum);
					if(teanum[1]<=0) {teanum[1]=0;blackTeaNum.setText("0");}
				}catch(NumberFormatException e2)
				{teanum[1] = 0;blackTeaNum.setText("0");}
				
				try {
					teanum[2] = Integer.parseInt(PekoeNum);
					if(teanum[2]<=0) {teanum[2]=0;pekoeNum.setText("0");}
				}catch(NumberFormatException e3)
				{teanum[2] = 0;pekoeNum.setText("0");}
				
				try {
					teanum[3] = Integer.parseInt(FourSeasonOolongTeaNum);
					if(teanum[3]<=0) {teanum[0]=0;fourSeasonOolongTeaNum.setText("0");}
				}catch(NumberFormatException e4)
				{teanum[3] = 0;fourSeasonOolongTeaNum.setText("0");}
				
				try {
					teanum[4] = Integer.parseInt(GreenMilkTeaNum);
					if(teanum[4]<=0) {teanum[0]=0;greenMilkTeaNum.setText("0");}
				}catch(NumberFormatException e5)
				{teanum[4] = 0;greenMilkTeaNum.setText("0");}
				
				try {
					teanum[5] = Integer.parseInt(KumquatLemonadeNum);
					if(teanum[5]<=0) {teanum[5]=0;kumquatLemonadeNum.setText("0");}
				}catch(NumberFormatException e6)
				{teanum[5] = 0;kumquatLemonadeNum.setText("0");}
				/*
				 * 轉型檢查 END
				 * */
				
				
				String showInfoString = "";
				showInfoString += cName + " 客戶，您好,您的購買清單如下\n品項:\t數量:\t小計:\n";
				
				for(int k=0;k<pl1len;k++)
				{
					if(teanum[k]<=0)  			
						{teaInfo[k]="";}
					else
						{teaInfo[k]=teaname[k]+"\t"+teanum[k]+"\t"+(teanum[k]*teaprice[k])+"\n";}
					showInfoString+=teaInfo[k];
					originalPrice =originalPrice+(teanum[k]*teaprice[k]);
				}
				
				
				showInfoString+="-----------------------------------------------------------------------\n"
				+"原價:$"+originalPrice;
								
				String genderSel = (String) comboBox.getSelectedItem();//get the selected item
                switch (genderSel) {
                	case "非會員":
                		discount=1.0;
                		break;
                	case "一般會員":
                		discount=0.9;
                		break;
                	case "銀卡會員":
                		discount=0.7;
                		break;
                	case "金卡會員":
                		discount=0.5;
                		break;
                }
                double osum = Math.floor(originalPrice*discount);
                if(osum>0) osum+=39.0;
                else osum=0.0;
				showInfoString += "\t折扣:"+(discount*100)+"%";	
				showInfoString += "\t折扣後:$"+(Math.floor(originalPrice*discount));
				showInfoString += "\n運費:$39\t總計:$"+osum;
				
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
				showInfoString +="\n訂單日期與時間:"+timeStamp;
				
				sum = (int)osum;
                if(sum!=0)
                {
	                // Order 建構式
	                Order o1 = new Order();
	                o1.setCustomerno(no);
	                o1.setAmount(originalPrice);
	                o1.setDiscount(discount);
	                o1.setFreight(39.0);
	                o1.setOsum(osum);
	                o1.setOrdertime(timeStamp);
	                o1.setInfo(showInfoString);
	                os1.addOrder(o1);
	                	
					output_01.setText(showInfoString);
					payMoney.setText("0");
                }
                output_02.setText("");		
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean complete = output_01.print();
					if(complete)
						{JOptionPane.showMessageDialog(null,"列印完成","Information",
								JOptionPane.INFORMATION_MESSAGE);}
					else {
						JOptionPane.showMessageDialog(null,"列印...","Printer",JOptionPane.ERROR_MESSAGE);
					}
				}catch(PrinterException ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
				
			}
		});
		
		/*
		 * pay btn
		 * 計算找零 輸出output02
		 * */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String payMoneyStr = payMoney.getText();
				output_02.setText("");
				int payMoneyInt = 0;
				
				try {
					payMoneyInt= Integer.parseInt(payMoneyStr);
					if(payMoneyInt<=0) {payMoneyInt=0;payMoney.setText("0");}
				}catch(NumberFormatException e7)
				{payMoneyInt=0;payMoney.setText("0");}
				
				if(payMoneyInt<sum)
				{
					String warningMessage = "客官，付的錢不夠啊~";
					output_02.setText(warningMessage);
				}
				else
				{
					payMoneyInt -= sum;
					changeMoneyInfo = makeChange(payMoneyInt);
					output_02.setText(changeMoneyInfo);
				}
			}
		});

		/*
		 * clear btn
		 * 清空input output
		 * */
		
		/*
		 * confirm btn
		 * 計算及輸出output_01
		 * */
	}
}
