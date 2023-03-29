package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;

//@SuppressWarnings("serial")
public class FileReaderFrame extends JFrame{
	JTextField textPath;
	File openFile;//打开的文件
	FileReaderFrame fileReaderFrame;
	
	public FileReaderFrame() {
		System.out.print(1);
		
		openFile = null;
		fileReaderFrame = this;
		this.setBounds(400,100,636,185);
		this.setVisible(true);
		//this.setAlwaysOnTop(true);
		setFont(null);
		setTitle("请选择学生成绩文件");
		getContentPane().setLayout(null);
		
		textPath = new JTextField();
		textPath.setBounds(78, 37, 402, 29);
		getContentPane().add(textPath);
		textPath.setColumns(10);
		
		JLabel lblNewLabelFileAddress = new JLabel("文件");
		lblNewLabelFileAddress.setFont(new Font("等线", Font.PLAIN, 16));
		lblNewLabelFileAddress.setBounds(23, 43, 58, 15);
		getContentPane().add(lblNewLabelFileAddress);
	
		//这个主要是实现文件地址的读取
		JButton btnNewButtonBrowse = new JButton("浏览");
		FileReaderButtonBrowseListener fileReaderButtonBrowseListener = new FileReaderButtonBrowseListener();
		fileReaderButtonBrowseListener.setData(fileReaderFrame);
		btnNewButtonBrowse.addActionListener(fileReaderButtonBrowseListener);
		
		btnNewButtonBrowse.setBounds(499, 37, 81, 29);
		getContentPane().add(btnNewButtonBrowse);
		
		
		JButton btnNewButtonSubmit = new JButton("确认");
		//这里的功能是实现对文件地址的赋值，将数据导入进来
		FileReaderButtonSubmitListener fileReaderButtonSubmitListener = new FileReaderButtonSubmitListener();
		fileReaderButtonSubmitListener.setFileReaderFrame(fileReaderFrame);
		btnNewButtonSubmit.addActionListener(fileReaderButtonSubmitListener);
		btnNewButtonSubmit.setBackground(new Color(240, 248, 255));
		btnNewButtonSubmit.setBounds(366, 103, 114, 29);
		getContentPane().add(btnNewButtonSubmit);
		
		JButton btnNewButtonCancel = new JButton("取消");
		btnNewButtonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fileReaderFrame.dispose();
			}
		});
		btnNewButtonCancel.setBackground(new Color(240, 248, 255));
		btnNewButtonCancel.setBounds(499, 103, 114, 29);
		getContentPane().add(btnNewButtonCancel);
		
	}
	
//	public static void main(String []args) {
//		new FileReaderFrame();
//	}
	
}
