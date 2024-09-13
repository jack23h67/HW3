package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import controller.CustomerLoginUI;
import controller.CustomerOrderUI;
import controller.CustomerRegisterUI;
import model.Customer;


public class Cal1 {
	
	// 切換到客戶註冊頁
	public static void gotoAddCustomer()
	{
		CustomerRegisterUI customerRegisterUI = new CustomerRegisterUI();
		customerRegisterUI.setVisible(true);
	}
	
	// 切換到客戶登入頁
	public static void gotoCustomerLogin()
	{
		CustomerLoginUI customerLoginUI = new CustomerLoginUI();
		customerLoginUI.setVisible(true);
	}
	// 切換到訂單的頁面
	public static void gotoCustomerOrdere()
	{
		CustomerOrderUI customerOrderUI = new CustomerOrderUI();
		customerOrderUI.setVisible(true);
	}
	
	public void setCustomer(Customer c) throws IOException
	{
		String filePath = "record.txt";
		FileOutputStream fos = new FileOutputStream(filePath);
//		FileOutputStream fos = new FileOutputStream("c:/ABC/exam2.txt");
		
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		String name  = c.getCustomername();
		String no    = c.getCustomerno();
		String level = String.valueOf(c.getCustomerlevel());
		bw.write(name+","+no+","+level);
		bw.close();	
	}
	
	public String getCustomer() throws IOException
	{
		String filePath = "record.txt";
		FileInputStream fis=new FileInputStream(filePath);	
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		
		String info = "";
		
		int i=0;
		
		while((i=br.read())!=-1)
		{
			info += (char)i;
			System.out.print((char)i);
		}
		br.close();
		return info;
	}
}
