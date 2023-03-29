package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FileWriterFrame extends JFrame{
	JTextField textPath;
	File chooseFile;//打开的文件
	FileWriterFrame fileWriterFrame;
	
	public FileWriterFrame() {
		System.out.print("打开保存页面");
		chooseFile = null;
		fileWriterFrame = this;
		this.setBounds(400,100,636,185);
		this.setVisible(true);
		setFont(null);
		setTitle("请选择保存的学生文件地址");
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
		FileWriterButtonBrowseListener fileWriterButtonBrowseListener = new FileWriterButtonBrowseListener();
		fileWriterButtonBrowseListener.setData(fileWriterFrame);
		btnNewButtonBrowse.addActionListener(fileWriterButtonBrowseListener);
		btnNewButtonBrowse.setBounds(499, 37, 81, 29);
		getContentPane().add(btnNewButtonBrowse);
		
		
		JButton btnNewButtonSubmit = new JButton("确认");
		FileWriterButtonSubmitListener fileWriterButtonSubmitListener = new FileWriterButtonSubmitListener();
		fileWriterButtonSubmitListener.setFileWriter(fileWriterFrame);
		btnNewButtonSubmit.addActionListener(fileWriterButtonSubmitListener);
		btnNewButtonSubmit.setBackground(new Color(240, 248, 255));
		btnNewButtonSubmit.setBounds(366, 103, 114, 29);
		getContentPane().add(btnNewButtonSubmit);
		
		JButton btnNewButtonCancel = new JButton("取消");
		btnNewButtonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fileWriterFrame.dispose();
			}
		});
		btnNewButtonCancel.setBackground(new Color(240, 248, 255));
		btnNewButtonCancel.setBounds(499, 103, 114, 29);
		getContentPane().add(btnNewButtonCancel);
	}
}
