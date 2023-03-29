package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.Address;
import dao.ScoreData;
import service.ScoreService;

public class FileReaderButtonSubmitListener implements ActionListener{
	private FileReaderFrame fileReaderFrame;
	
	public void setFileReaderFrame(FileReaderFrame fileReaderFrame) {
		this.fileReaderFrame = fileReaderFrame;
	}

	@Override
	public void  actionPerformed(ActionEvent e) {
		try {
			//用于检测文件是否读正确
			if(Address.FILE_READER_ADDRESS != null) {
				ScoreService scoreService = new ScoreService(Address.FILE_READER_ADDRESS);
				//测试
				System.out.println(scoreService.getAverageScoreOne());
				System.out.println(ScoreData.STUDENTSCORES.get(0));
				fileReaderFrame.dispose();
			}
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,"未选择文件或者选择文件错误","警告",JOptionPane.OK_OPTION);
		}
	}
}
