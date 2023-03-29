package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import service.SetOverview;

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class ScoreOverviewJFrame extends JFrame{
	public ScoreOverviewJFrame scoreOverviewJFrame;
	
	public JTextField textFieldNumber;
	public JTextField textFieldAveScore;
	public JTextField textFieldMaxScore;
	public JTextField textFieldMinScore;
	public JTextField textFieldPassRate;
	public JTextField textFieldNumber2;
	public JTextField textFieldAveScore2;
	public JTextField textFieldMax2;
	public JTextField textFieldMin2;
	public JTextField textFieldPassRate2;
	public JTextPane textPaneGrade;
	public JTextPane textPaneGrade2; 
	public ScoreOverviewJFrame() {
		scoreOverviewJFrame = this;
		
		getContentPane().setForeground(SystemColor.textInactiveText);
		setTitle("成绩概览");
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setBounds(200,200,893,610);
		JPanel panelClassOne = new JPanel();
		panelClassOne.setBackground(new Color(216, 191, 216));
		panelClassOne.setForeground(new Color(153, 204, 204));
		panelClassOne.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelClassOne.setBounds(60, 45, 541, 181);
		getContentPane().add(panelClassOne);
		panelClassOne.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学生人数");
		lblNewLabel.setBounds(10, 39, 58, 15);
		panelClassOne.add(lblNewLabel);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setBackground(new Color(245, 245, 220));
		textFieldNumber.setEditable(false);
		textFieldNumber.setBounds(63, 36, 66, 21);
		panelClassOne.add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("课程平均分");
		lblNewLabel_1.setBounds(175, 39, 79, 15);
		panelClassOne.add(lblNewLabel_1);
		
		textFieldAveScore = new JTextField();
		textFieldAveScore.setBackground(new Color(245, 245, 220));
		textFieldAveScore.setEditable(false);
		textFieldAveScore.setColumns(10);
		textFieldAveScore.setBounds(251, 36, 66, 21);
		panelClassOne.add(textFieldAveScore);
		
		JLabel lblNewLabel_2 = new JLabel("最高分");
		lblNewLabel_2.setBounds(175, 74, 58, 15);
		panelClassOne.add(lblNewLabel_2);
		
		textFieldMaxScore = new JTextField();
		textFieldMaxScore.setBackground(new Color(245, 245, 220));
		textFieldMaxScore.setEditable(false);
		textFieldMaxScore.setColumns(10);
		textFieldMaxScore.setBounds(251, 71, 66, 21);
		panelClassOne.add(textFieldMaxScore);
		
		JLabel lblNewLabel_2_1 = new JLabel("最低分");
		lblNewLabel_2_1.setBounds(175, 113, 58, 15);
		panelClassOne.add(lblNewLabel_2_1);
		
		textFieldMinScore = new JTextField();
		textFieldMinScore.setBackground(new Color(245, 245, 220));
		textFieldMinScore.setEditable(false);
		textFieldMinScore.setColumns(10);
		textFieldMinScore.setBounds(251, 110, 66, 21);
		panelClassOne.add(textFieldMinScore);
		
		JLabel lblNewLabel_1_1 = new JLabel("课程及格率");
		lblNewLabel_1_1.setBounds(363, 39, 79, 15);
		panelClassOne.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("课程成绩分布情况");
		lblNewLabel_1_1_1.setBounds(363, 74, 136, 15);
		panelClassOne.add(lblNewLabel_1_1_1);
		
		textFieldPassRate = new JTextField();
		textFieldPassRate.setBackground(new Color(245, 245, 220));
		textFieldPassRate.setEditable(false);
		textFieldPassRate.setColumns(10);
		textFieldPassRate.setBounds(433, 36, 66, 21);
		panelClassOne.add(textFieldPassRate);
		
		textPaneGrade = new JTextPane();
		textPaneGrade.setBackground(new Color(245, 245, 245));
		textPaneGrade.setEditable(false);
		textPaneGrade.setBounds(363, 99, 136, 72);
		panelClassOne.add(textPaneGrade);
		
		JLabel lblNewLabelTieleOne = new JLabel("课程1");
		lblNewLabelTieleOne.setBackground(new Color(0, 250, 154));
		lblNewLabelTieleOne.setBounds(284, 10, 97, 25);
		getContentPane().add(lblNewLabelTieleOne);
		lblNewLabelTieleOne.setFont(new Font("等线", Font.BOLD, 24));
		
		JPanel panelClassOne_1 = new JPanel();
		panelClassOne_1.setBackground(new Color(216, 191, 216));
		panelClassOne_1.setForeground(new Color(216, 191, 216));
		panelClassOne_1.setLayout(null);
		panelClassOne_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelClassOne_1.setBounds(60, 273, 541, 181);
		getContentPane().add(panelClassOne_1);
		
		JLabel lblNewLabel_3 = new JLabel("学生人数");
		lblNewLabel_3.setBackground(new Color(245, 245, 220));
		lblNewLabel_3.setBounds(10, 39, 58, 15);
		panelClassOne_1.add(lblNewLabel_3);
		
		textFieldNumber2 = new JTextField();
		textFieldNumber2.setBackground(new Color(245, 245, 220));
		textFieldNumber2.setEditable(false);
		textFieldNumber2.setColumns(10);
		textFieldNumber2.setBounds(63, 36, 66, 21);
		panelClassOne_1.add(textFieldNumber2);
		
		JLabel lblNewLabel_1_2 = new JLabel("课程平均分");
		lblNewLabel_1_2.setBounds(178, 39, 79, 15);
		panelClassOne_1.add(lblNewLabel_1_2);
		
		textFieldAveScore2 = new JTextField();
		textFieldAveScore2.setBackground(new Color(245, 245, 220));
		textFieldAveScore2.setEditable(false);
		textFieldAveScore2.setColumns(10);
		textFieldAveScore2.setBounds(251, 36, 66, 21);
		panelClassOne_1.add(textFieldAveScore2);
		
		JLabel lblNewLabel_2_2 = new JLabel("最高分");
		lblNewLabel_2_2.setBounds(178, 74, 58, 15);
		panelClassOne_1.add(lblNewLabel_2_2);
		
		textFieldMax2 = new JTextField();
		textFieldMax2.setBackground(new Color(245, 245, 220));
		textFieldMax2.setEditable(false);
		textFieldMax2.setColumns(10);
		textFieldMax2.setBounds(251, 71, 66, 21);
		panelClassOne_1.add(textFieldMax2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("最低分");
		lblNewLabel_2_1_1.setBounds(178, 113, 58, 15);
		panelClassOne_1.add(lblNewLabel_2_1_1);
		
		textFieldMin2 = new JTextField();
		textFieldMin2.setBackground(new Color(245, 245, 220));
		textFieldMin2.setEditable(false);
		textFieldMin2.setColumns(10);
		textFieldMin2.setBounds(251, 110, 66, 21);
		panelClassOne_1.add(textFieldMin2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("课程及格率");
		lblNewLabel_1_1_2.setBounds(363, 39, 79, 15);
		panelClassOne_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("课程成绩分布情况");
		lblNewLabel_1_1_1_1.setBounds(363, 74, 136, 15);
		panelClassOne_1.add(lblNewLabel_1_1_1_1);
		
		textFieldPassRate2 = new JTextField();
		textFieldPassRate2.setBackground(new Color(245, 245, 220));
		textFieldPassRate2.setEditable(false);
		textFieldPassRate2.setColumns(10);
		textFieldPassRate2.setBounds(433, 36, 66, 21);
		panelClassOne_1.add(textFieldPassRate2);
		
		textPaneGrade2 = new JTextPane();
		textPaneGrade2.setBackground(new Color(248, 248, 255));
		textPaneGrade2.setEditable(false);
		textPaneGrade2.setBounds(363, 99, 136, 72);
		panelClassOne_1.add(textPaneGrade2);
		
		JLabel lblNewLabelTieleOne_1 = new JLabel("课程2");
		lblNewLabelTieleOne_1.setForeground(new Color(0, 0, 0));
		lblNewLabelTieleOne_1.setFont(new Font("等线", Font.BOLD, 24));
		lblNewLabelTieleOne_1.setBounds(284, 238, 82, 25);
		getContentPane().add(lblNewLabelTieleOne_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(664, 45, 163, 408);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setForeground(SystemColor.menuText);
		textPane_2.setBackground(new Color(220, 220, 220));
		textPane_2.setEditable(false);
		textPane_2.setFont(new Font("宋体", Font.PLAIN, 14));
		textPane_2.setText("等级划分规则\r\n优：90-100\r\n良：80-89\r\n中：70-79");
		textPane_2.setBounds(23, 61, 118, 323);
		panel.add(textPane_2);
		
		JLabel lblNewLabelTieleOne_2 = new JLabel("说明");
		lblNewLabelTieleOne_2.setForeground(UIManager.getColor("Button.disabledForeground"));
		lblNewLabelTieleOne_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabelTieleOne_2.setBounds(55, 10, 58, 25);
		panel.add(lblNewLabelTieleOne_2);
		
		SetOverview setOverview = new SetOverview(scoreOverviewJFrame);
		setOverview.setInfo();
		
		ImageIcon bkg=new ImageIcon("C:\\Users\\86158\\eclipse-workspace\\stuGradeManage\\src\\image\\overviewbkg.jpg");
		//使用这个方法调整照片的大小
		//bkg.setImage(bkg.getImage().getScaledInstance(1540,824,Image.SCALE_DEFAULT));
		JLabel label=new JLabel(bkg);//用图片构造一个JLabel标签
		label.setBounds(0, 0, 879, 573);
		this.getContentPane().add(label);
		
	}
	
//	public static void main(String args[]) {
//		new ScoreOverviewJFrame();
//	}
}
