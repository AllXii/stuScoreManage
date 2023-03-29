package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.ScoreData;

public class ScoreUpdataSubmitListener implements ActionListener{
	
	ScoreUpdataFrame scoreUpdataFrame;
	
	public void setScoreUpdataFrame(ScoreUpdataFrame scoreUpdataFrame) {
		this.scoreUpdataFrame = scoreUpdataFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Double scoreOne = 0.0;
		Double scoreTwo = 0.0;
		try {
			scoreOne = Double.valueOf(scoreUpdataFrame.textFieldScoreOne.getText());
			scoreTwo = Double.valueOf(scoreUpdataFrame.textFieldScoreTwo.getText());
			if(scoreOne<0||scoreOne>100||scoreTwo<0||scoreTwo>100) {
				throw new Exception();
			}
			//开始修改学生成绩
			ScoreData.SCORESERVICE.updataScore(scoreUpdataFrame.textFieldId.getText(), scoreOne, scoreTwo);
			scoreUpdataFrame.dispose();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,"请输入正确的分数信息","出现异常",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
