package dao;

import java.util.ArrayList;
import java.util.List;

public class LoginAccount {
	private static List<String> USERNAME;
	private static List<String> PASSWORD;
	
	//初始化账号
	public LoginAccount() {
		// TODO Auto-generated constructor stub
		USERNAME = new ArrayList<String>();
		PASSWORD = new ArrayList<String>();
		USERNAME.add("2020211700");
		PASSWORD.add("111111");
	}
	
	public List<String> getUsername(){
		return USERNAME;
	}
	public List<String> getPassword(){
		return PASSWORD;
	}
	
}
