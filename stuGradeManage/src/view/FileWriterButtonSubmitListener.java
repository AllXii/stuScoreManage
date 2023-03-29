package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.Address;
import dao.ScoreData;
import dao.ScoreWriter;
import service.ScoreService;

public class FileWriterButtonSubmitListener implements ActionListener{
	private FileWriterFrame fileWriterFrame;
	
	public void setFileWriter(FileWriterFrame fileWriterFrame) {
		this.fileWriterFrame = fileWriterFrame;
	}
	@Override
	public void  actionPerformed(ActionEvent e) {
		try {
			new ScoreWriter(Address.FILE_READER_ADDRESS);//写操作
			fileWriterFrame.dispose();
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,"保存失败","警告",JOptionPane.WARNING_MESSAGE);
		}
	}
}
