package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ScoreData;
import model.StudentScore;
import service.SelectAny;

//实现对学生数据的查询
public class ScoreSelectListener implements ActionListener{
	private ScoreTableFrame scoreTableFrame;
	private Object[][] tableContent = new Object[ScoreData.STUDENTSCORES.size()][5];//表的内容
	
	//设置以改变表的显示
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
            String select = scoreTableFrame.comboBoxSelect.getSelectedItem().toString();//获取查询条件
            String info = scoreTableFrame.textField.getText();//获取信息
            System.out.println("内容："+select+" "+info);//测试
            System.out.println("长度："+ScoreData.STUDENTSCORES.size());//测试
            //选择查询操作
            for(int i=0; i<ScoreData.STUDENTSCORES.size();i++){
            	SelectAny selectAny = new SelectAny();
            	if(select.equals("姓名")) {
            		//如果是姓名的话，设置查询字段
            		selectAny.setNameOrId(ScoreData.STUDENTSCORES.get(i).getName());
            	}
            	else{
            		//学号
            		selectAny.setNameOrId(ScoreData.STUDENTSCORES.get(i).getId());
            	}	
            	//若查询成功，则输出对应内容，若失败则不管。
            	if(selectAny.select(info)) {
            		tableContent[i][0] = ScoreData.STUDENTSCORES.get(i).getId();
	            	tableContent[i][1] = ScoreData.STUDENTSCORES.get(i).getName();
	            	tableContent[i][2] = ScoreData.STUDENTSCORES.get(i).getScoreOne();
	            	tableContent[i][3] = ScoreData.STUDENTSCORES.get(i).getScoreTwo();
	            	tableContent[i][4] = ScoreData.STUDENTSCORES.get(i).getScoreTotal();
	            	scoreTableFrame.tableModel.addRow(tableContent[i]);
            	}
            	
            }
        } catch (Exception e1) {
            System.out.println(e1);
        }
	}
	
}
