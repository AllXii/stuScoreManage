package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ScoreData;
import model.StudentScore;
import service.SelectAny;

public class ScoreSortListener implements ActionListener{
	
	private List<StudentScore> studentScores;
	private ScoreTableFrame scoreTableFrame;
	private Object[][] tableContent = new Object[ScoreData.STUDENTSCORES.size()][5];//表的内容
	
	//设置表后面以改变表的显示
	public void setTableFrame(ScoreTableFrame scoreTableFrame) {
		this.scoreTableFrame = scoreTableFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
			//清除所有查询界面中的数据 然后就能显示查询的学生数据
			scoreTableFrame.tableModel.setRowCount(0);
		    //查询操作
		    try {
		        //获取输入进文本框的值
		        String select = scoreTableFrame.comboBoxSort.getSelectedItem().toString();//获取排序条件
		        System.out.println("排序："+select);//测试
		        //排序
	            if(select.equals("课程1")) {
	            	//排序
	            	studentScores = ScoreData.SCORESERVICE.getSortScoreOne();
	            }
	            else  if(select.equals("课程2")){
	            	studentScores = ScoreData.SCORESERVICE.getSortScoreTwo();
	            }
	            else {
	            	studentScores = ScoreData.SCORESERVICE.getSortScoreTotal();
	            }
	            //将排序后的表输出
		        for(int i=0; i<ScoreData.STUDENTSCORES.size();i++) {
	            	tableContent[i][0] = ScoreData.STUDENTSCORES.get(i).getId();
		            tableContent[i][1] = ScoreData.STUDENTSCORES.get(i).getName();
		            tableContent[i][2] = ScoreData.STUDENTSCORES.get(i).getScoreOne();
		            tableContent[i][3] = ScoreData.STUDENTSCORES.get(i).getScoreTwo();
		            tableContent[i][4] = ScoreData.STUDENTSCORES.get(i).getScoreTotal();
		            scoreTableFrame.tableModel.addRow(tableContent[i]);
		            }
		    } 
			catch (Exception e1) {
		    	JOptionPane.showMessageDialog(null,"排序出现错误","警告",JOptionPane.WARNING_MESSAGE);
		        System.out.println(e1);
		    }
	}
	
}
