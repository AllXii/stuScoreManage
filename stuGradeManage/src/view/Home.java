package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import service.ScoreService;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import dao.ScoreData;
import java.awt.Font;

public class Home extends JFrame{
	private Home home;//用于传递该页面
	
	public Home() {
		setForeground(new Color(250, 250, 210));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		home = this;
		
		getContentPane().setBackground(new Color(211, 211, 211));
		this.setBounds(-10,0,1920,1080);
		this.setVisible(true);
		
		setTitle("学生成绩管理系统");
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("黑体", Font.PLAIN, 22));
		menuBar.setBounds(0, 0, 1540, 23);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenuFile = new JMenu("文件");
		menuBar.add(mnNewMenuFile);
		
		JMenuItem mntmNewMenuItemReader = new JMenuItem("加载文件");
		mntmNewMenuItemReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FileReaderFrame();
			}
		});
		mnNewMenuFile.add(mntmNewMenuItemReader);
		
		JMenuItem mntmNewMenuItemWriter = new JMenuItem("保存文件\r\n");
		mntmNewMenuItemWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ScoreData.STUDENTSCORES == null) {
					JOptionPane.showMessageDialog(home,"还未导入学生信息哦！","出错了！",JOptionPane.ERROR_MESSAGE);
				}
				else {
					new FileWriterFrame();
				}
			}
		});
		mnNewMenuFile.add(mntmNewMenuItemWriter);
		
		JMenu mnNewMenuAnalysis = new JMenu("成绩分析");
		menuBar.add(mnNewMenuAnalysis);
		
		JMenuItem mntmNewMenuItemScoreAnalysis = new JMenuItem("成绩概览");
		mntmNewMenuItemScoreAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ScoreData.STUDENTSCORES == null) {
					JOptionPane.showMessageDialog(home,"还未导入学生信息哦！","出错了！",JOptionPane.ERROR_MESSAGE);
				}
				else {
					new ScoreOverviewJFrame();
				}
			}
		});
		mnNewMenuAnalysis.add(mntmNewMenuItemScoreAnalysis);
		
		JMenuItem mntmNewMenuItemPassRate = new JMenuItem("及格情况");
		mntmNewMenuItemPassRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ScoreData.STUDENTSCORES == null) {
					JOptionPane.showMessageDialog(home,"还未导入学生信息哦！","出错了！",JOptionPane.ERROR_MESSAGE);
				}
				else {
					new PassRateGraFrame();
				}
				
			}
		});
		mnNewMenuAnalysis.add(mntmNewMenuItemPassRate);
		
		JMenu mnNewMenuScoreData = new JMenu("成绩数据");
		menuBar.add(mnNewMenuScoreData);
		
		JMenuItem mntmNewMenuItemPrintScore = new JMenuItem("操作学生成绩表");
		mntmNewMenuItemPrintScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ScoreData.STUDENTSCORES == null) {
					JOptionPane.showMessageDialog(home,"还未导入学生信息哦！","出错了！",JOptionPane.ERROR_MESSAGE);
				}
				else {
					new ScoreTableFrame();
				}
			}
		});
		mnNewMenuScoreData.add(mntmNewMenuItemPrintScore);
		
		//设置背景图片
		ImageIcon bkg=new ImageIcon("C:\\Users\\86158\\eclipse-workspace\\stuGradeManage\\src\\image\\homebkg2.jpg");
		//使用这个方法调整照片的大小
		bkg.setImage(bkg.getImage().getScaledInstance(1540,824,Image.SCALE_DEFAULT));
		JLabel label=new JLabel(bkg);//用图片构造一个JLabel标签
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(0, 21, 1540, 824);
		this.getContentPane().add(label);
	}
	
//	public static void main(String []args) {
//		new Home();
//	}
}
