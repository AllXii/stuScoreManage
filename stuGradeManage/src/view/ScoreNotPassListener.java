package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


import dao.ScoreData;
import service.SelectAny;

//要实现标记出不及格的行数，那么就要对tablemodel进行操作
public class ScoreNotPassListener implements ActionListener{
	private ScoreTableFrame scoreTableFrame;
	private Object[][] tableContent = new Object[ScoreData.STUDENTSCORES.size()][5];//表的内容
	private List<Integer> notPass;
	private List<String> Id;
	//设置以改变表的显示
	public void setTableFrame(ScoreTableFrame scoreTableFrame) {
		this.scoreTableFrame = scoreTableFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//点击该按钮后改变其中违规的行数，让他变红。重写表的渲染器来实现这个功能
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
        	//重写该方法
        		public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column) {
//        			System.out.print("行数："+violations.size());
        			//如果某一行是在这个不及格里面的，那么就将单元格的颜色换掉
        			if(notPass.contains(row)) {
        				setBackground(Color.orange);
        			}
        			else {
    					setBackground(Color.white);
    				}
					return super.getTableCellRendererComponent(table, value,
							isSelected, hasFocus, row, column);
        		}
		};

		
		notPass = new ArrayList<Integer>();
		Id = new ArrayList<String>();
		for(int i=0; i<scoreTableFrame.table.getRowCount(); i++) {
			//遍历显示界面的表
			if((Double.valueOf(scoreTableFrame.table.getValueAt(i, 2).toString()) < 60 
				|| Double.valueOf(scoreTableFrame.table.getValueAt(i, 3).toString()) < 60)) {
				//将不及格宿舍规则的行数标记出来
				notPass.add(i);
			}
			//保存显示界面中学号信息
			Id.add(scoreTableFrame.table.getValueAt(i, 0).toString());
			
		}
		//保存出显示表中的学号信息，方便再次添加表
		System.out.print("不及格" + notPass);//测试
		//复制一个表
		JTable tableCopy = new JTable();
		tableCopy = scoreTableFrame.table;
		tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        scoreTableFrame.table.setDefaultRenderer(Object.class, tcr);//设置渲染器
        scoreTableFrame.tableModel.setRowCount(0);//清除原有表行
        
        //输出信息
        for(String id: Id) {
        	for(int i=0; i<ScoreData.STUDENTSCORES.size(); i++) {
        		if(ScoreData.STUDENTSCORES.get(i).getId().equals(id)) {
        			tableContent[i][0] = ScoreData.STUDENTSCORES.get(i).getId();
        			tableContent[i][1] = ScoreData.STUDENTSCORES.get(i).getName();
        			tableContent[i][2] = ScoreData.STUDENTSCORES.get(i).getScoreOne();
        			tableContent[i][3] = ScoreData.STUDENTSCORES.get(i).getScoreTwo();
        			tableContent[i][4] = ScoreData.STUDENTSCORES.get(i).getScoreTotal();
        			scoreTableFrame.tableModel.addRow(tableContent[i]);
        		}
        	}
        }
        
        
//		for(int i=0; i<scoreTableFrame.table.getRowCount() ;i++){
//			//打印出原有的显示的表
//			tableContent[i][0] = tableCopy.getValueAt(i, 0);
//			tableContent[i][1] = tableCopy.getValueAt(i, 1);
//			tableContent[i][2] = tableCopy.getValueAt(i, 2);
//			tableContent[i][3] = tableCopy.getValueAt(i, 3);
//			tableContent[i][4] = tableCopy.getValueAt(i, 4);
//			scoreTableFrame.tableModel.addRow(tableContent[i]);
//		}
	}

}
