package service;

import dao.LoginAccount;

public class LoginService {
	private String username;
	private String password;
	
	public LoginService(String username, String password) {
		// TODO Auto-generated constructor stub
		this.password = password;
		this.username = username;
	}
	
	public boolean isLogin() {
		int usernameCount = 0;//查找账户序号
		LoginAccount loginAccount = new LoginAccount();
		//System.out.print(loginAccount.getUsername());
		for(String un: loginAccount.getUsername()) {
			if(un.equals(username)) {
				if(password.equals(loginAccount.getPassword().get(usernameCount))){
					return true;
				}
			}
			usernameCount++;
		}
		return false;
	}
	
//	public static void main(String args[]) {
//		LoginAccount loginCount = new LoginAccount();
//		System.out.print(loginCount.getUsername());
//		
//		LoginService loginService = new LoginService("2020211700", "111111");
//		System.out.print(loginService.isLogin());
//	}
}
