package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

import dao.ScoreData;

public class ScoreRefreshListener implements ActionListener{
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
		//将渲染器更改回去
	    //查询操作
	    try {
	        for(int i=0; i<ScoreData.STUDENTSCORES.size();i++) {
            	tableContent[i][0] = ScoreData.STUDENTSCORES.get(i).getId();
	            tableContent[i][1] = ScoreData.STUDENTSCORES.get(i).getName();
	            tableContent[i][2] = ScoreData.STUDENTSCORES.get(i).getScoreOne();
	            tableContent[i][3] = ScoreData.STUDENTSCORES.get(i).getScoreTwo();
	            tableContent[i][4] = ScoreData.STUDENTSCORES.get(i).getScoreTotal();
	            scoreTableFrame.tableModel.addRow(tableContent[i]);
	            }
	        
	        DefaultTableCellRenderer tcrBack = new DefaultTableCellRenderer();
			tcrBack.setHorizontalAlignment(JLabel.CENTER);
			scoreTableFrame.table.setDefaultRenderer(Object.class, tcrBack);//设置渲染器
	      
	    } 
		catch (Exception e1) {
	    	JOptionPane.showMessageDialog(null,"刷新错误","警告",JOptionPane.WARNING_MESSAGE);
	        System.out.println(e1);
	    }
	}
	
}
