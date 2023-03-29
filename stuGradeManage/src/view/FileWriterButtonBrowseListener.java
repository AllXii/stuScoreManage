package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import dao.Address;
import dao.ScoreWriter;

public class FileWriterButtonBrowseListener implements ActionListener{
	private FileWriterFrame fileWriterFrame;
	
	//初始化操作界面
	public void setData(FileWriterFrame fileWriterFrame) {
		this.fileWriterFrame = fileWriterFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();//获取选择的文件
		try {
			if(chooser.showSaveDialog(chooser) == JFileChooser.APPROVE_OPTION){//打开文件保存的窗口
				fileWriterFrame.chooseFile = chooser.getSelectedFile();//获取选择的文件
				fileWriterFrame.textPath.setText(fileWriterFrame.chooseFile.getPath());	//获取选择文件的路径
				Address.FILE_READER_ADDRESS = fileWriterFrame.chooseFile.getPath();//设置路径

			}
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,"保存文件错误","警告",JOptionPane.WARNING_MESSAGE);
		}
		
		//测试
		System.out.print(Address.FILE_READER_ADDRESS);
	}
	
}
