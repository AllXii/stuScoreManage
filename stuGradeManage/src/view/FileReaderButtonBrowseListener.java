package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.Address;
import dao.ScoreData;
import service.ScoreService;

public class FileReaderButtonBrowseListener implements ActionListener{
	private FileReaderFrame fileReaderFrame;
	
	public void setData(FileReaderFrame fileReaderFrame) {
		this.fileReaderFrame = fileReaderFrame;
	}
	@Override
	public void  actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();//获取选择的文件
		chooser.showOpenDialog(fileReaderFrame);//打开文件选择的窗口
		try {
			fileReaderFrame.openFile = chooser.getSelectedFile();//获取选择的文件
			if(fileReaderFrame.openFile != null)
				fileReaderFrame.textPath.setText(fileReaderFrame.openFile.getPath());	//获取选择文件的路径
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,"读取文件错误","警告",JOptionPane.ERROR_MESSAGE);
		}
		Address.FILE_READER_ADDRESS = fileReaderFrame.openFile.getPath();//设置路径
		//测试
		System.out.print(Address.FILE_READER_ADDRESS);
	}

}
