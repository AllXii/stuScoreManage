package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import dao.ScoreData;
import model.StudentScore;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreUpdataFrame extends JFrame{
	
	public ScoreUpdataFrame() {};
	
	private List<StudentScore> studentScores;
	JTextField textFieldId;
	JTextField textFieldName;
	JTextField textFieldScoreOne;
	JTextField textFieldScoreTwo;
	//private Object[][] tableContent = new Object[ScoreData.STUDENTSCORES.size()][5];//表的内容
	
	public ScoreUpdataFrame(ScoreTableFrame scoreTableFrame) {
		setTitle("修改学生成绩");
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setBounds(200,100,500,400);
		//根据行数获取数据
        int count = scoreTableFrame.table.getSelectedRow();
        //得到选中行数的学号和成绩信息
        String Id = scoreTableFrame.table.getValueAt(count,0).toString();
        String name = scoreTableFrame.table.getValueAt(count,1).toString();
        Double scoreOne = Double.valueOf(scoreTableFrame.table.getValueAt(count, 2).toString());
        Double scoreTwo = Double.valueOf(scoreTableFrame.table.getValueAt(count, 3).toString());
        
		System.out.print("选中的信息"+Id+name+scoreOne+scoreTwo);
        
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(45, 45, 344, 212);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setBounds(10, 39, 58, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(10, 75, 58, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("课程1分数");
		lblNewLabel_2.setBounds(10, 113, 58, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("课程2分数");
		lblNewLabel_3.setBounds(10, 150, 58, 15);
		panel.add(lblNewLabel_3);
		
		textFieldId = new JTextField(Id);
		textFieldId.setEditable(false);
		textFieldId.setBounds(82, 37, 224, 18);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField(name);
		textFieldName.setEditable(false);
		textFieldName.setColumns(10);
		textFieldName.setBounds(82, 73, 224, 18);
		panel.add(textFieldName);
		
		textFieldScoreOne = new JTextField(scoreOne + "");
		textFieldScoreOne.setColumns(10);
		textFieldScoreOne.setBounds(82, 111, 224, 18);
		panel.add(textFieldScoreOne);
		
		textFieldScoreTwo = new JTextField(scoreTwo + "");
		textFieldScoreTwo.setColumns(10);
		textFieldScoreTwo.setBounds(82, 148, 224, 18);
		panel.add(textFieldScoreTwo);
		
		JButton btnNewButton = new JButton("提交");
		ScoreUpdataSubmitListener scoreUpdataSubmitListener = new ScoreUpdataSubmitListener();
		scoreUpdataSubmitListener.setScoreUpdataFrame(this); //获取填入文本框的数据
		btnNewButton.addActionListener(scoreUpdataSubmitListener);
		btnNewButton.setBounds(172, 286, 97, 23);
		

		getContentPane().add(btnNewButton);
        
	}
}
