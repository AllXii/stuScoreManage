package view;


import javax.swing.*;

import service.LoginService;
import service.VarifyInput;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//完成

public class LoginFrame extends JFrame{
    //组件
    JButton loginbutton = new JButton("登录");
    JButton restorebuton =new JButton("重置");
    public JTextField usernameContext = new JTextField(20);
    public JPasswordField passwordContext = new JPasswordField(20);
    JLabel labelTitle = new JLabel("成绩管理系统");
    JLabel labelUsername = new JLabel("用户名/工作号：");
    JLabel labelPassword = new JLabel("密码:           ");

    //登录背景图片
    //布局容器
    JPanel top = new JPanel();
    JPanel left = new JPanel();
    JPanel center = new JPanel();
    JPanel right = new JPanel();
    JPanel bottom = new JPanel();

    JPanel usernameInput = new JPanel();
    JPanel passwordInput = new JPanel();


    public LoginFrame() throws HeadlessException {
    	//设置窗口的属性
        setTitle("登录");
        setBounds(300,200,400,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        
        labelTitle.setFont(new Font("微软雅黑", Font.BOLD, 22));
        labelTitle.setBounds(120,0,134,76);
        getContentPane().add(labelTitle);
        
        labelUsername.setFont(new Font("宋体", Font.BOLD, 14));
        usernameInput.setBackground(new Color(204, 204, 255));
        usernameInput.setLocation(28, 86);
        usernameInput.setSize(337, 31);
        usernameInput.add(labelUsername);
        labelPassword.setFont(new Font("宋体", Font.BOLD, 14));
        passwordInput.setBackground(new Color(204, 204, 255));
        passwordInput.setLocation(28, 127);
        passwordInput.setSize(337, 31);
        passwordInput.add(labelPassword);
        usernameInput.add(usernameContext);
        passwordInput.add(passwordContext);
        loginbutton.setLocation(28, 183);
        loginbutton.setSize(144, 31);
        loginbutton.setBackground(new Color(51, 204, 51));
        loginbutton.setForeground(new Color(255, 255, 255));
        loginbutton.setFont(new Font("微软雅黑", Font.BOLD, 16));

        getContentPane().add(usernameInput);
        getContentPane().add(passwordInput);
        getContentPane().add(loginbutton);
        restorebuton.setLocation(213, 183);
        restorebuton.setSize(152, 31);

        restorebuton.setBackground(new Color(204, 204, 255));
        restorebuton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        getContentPane().add(restorebuton);

      
        //设置背景图片
		ImageIcon image=new ImageIcon("C:\\Users\\86158\\eclipse-workspace\\stu_dorm_manage_system\\src\\main\\java\\com\\lzx\\image\\home.jpg");
		JLabel label=new JLabel(image);//用图片构造一个JLabel标签
		label.setBounds(0, 0, 386, 263);
		getContentPane().add(label);
      
        //重置功能
        restorebuton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//usernameContext.setText("");
	            passwordContext.setText("");
	            JOptionPane.showMessageDialog(null,"已重置");
        	 }
        });


        //登录功能
        loginbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
        		String username = usernameContext.getText(); //从文本获取用户名
        		String password = new String(passwordContext.getPassword());//获取密码
        		//将账号和密码传进去
        		LoginService loginService = new LoginService(username, password);

        		//处理button传进来的数据，增加鲁棒性
            	if(VarifyInput.isEmpty(username)||VarifyInput.isEmpty(password)){
            		JOptionPane.showMessageDialog(null,"用户名或密码为空!!","error",JOptionPane.ERROR_MESSAGE);
            		return;
            	}
            	try {	
                	if(loginService.isLogin() != true) {
                		 JOptionPane.showMessageDialog(null,"用户名或密码错误","警告",JOptionPane.WARNING_MESSAGE);
                		 return; //退出该方法
                	}
	                dispose();//登录界面消失
	                new Home(); //进入主页
            	} catch (Exception e1) {
                	System.out.println(e1.getMessage());
            	}
			}
        });
        
        
    }
    //测试代码
    public static void main(String args[]){
        new LoginFrame();
    }
}
