package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.ScoreData;
import model.StudentScore;
import service.ScoreService;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreTableFrame extends JFrame{
	JTable table;
	ScoreTableFrame scoreTableFrame;
    Object[]  tableColumn;//表格的表头
    Object[][] tableContent;//表头的内容
    public static DefaultTableModel tableModel; //表的渲染模型
    
    JPanel panelSelect;//查询容器
    JComboBox comboBoxSelect;// 选择的查询条件 
    JTextField textField;// 输入的信息
    
    JComboBox comboBoxSort;//排序选择
	public ScoreTableFrame() {
		scoreTableFrame = this;
		ScoreData.NOTPASS = new ArrayList<Integer>();
		//this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setBounds(300,200,800,575);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenuSelect = new JMenu("查询学生成绩");
		menuBar.add(mnNewMenuSelect);
		
		
		//查询出所有的信息，打印在表格

		tableContent = new Object[ScoreData.STUDENTSCORES.size()][5];
		tableColumn = new Object[]{"学号", "姓名", "课程1成绩", "课程2成绩", "总成绩"};
		
		//将表内容初始化
		for(int i=0; i<ScoreData.STUDENTSCORES.size();i++){
			tableContent[i][0] = ScoreData.STUDENTSCORES.get(i).getId();
            tableContent[i][1] = ScoreData.STUDENTSCORES.get(i).getName();
            tableContent[i][2] = ScoreData.STUDENTSCORES.get(i).getScoreOne();
            tableContent[i][3] = ScoreData.STUDENTSCORES.get(i).getScoreTwo();
            tableContent[i][4] = ScoreData.STUDENTSCORES.get(i).getScoreTotal();
		}
		
		
		//添加滚轮
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 155, 600, 288);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//默认的表格格式
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        table.setDefaultRenderer(Object.class, tcr);//设置渲染器
        //这种方法可以添加一些控制Jtable行列和单元格的一些属性 后面选学生会使用
        tableModel = new DefaultTableModel(tableContent,tableColumn);
        table.setModel(tableModel);
        
		scrollPane.setViewportView(table);
		
		panelSelect = new JPanel();
		panelSelect.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSelect.setBounds(98, 10, 146, 128);
		getContentPane().add(panelSelect);
		panelSelect.setLayout(null);
		
		comboBoxSelect = new JComboBox();
		comboBoxSelect.setModel(new DefaultComboBoxModel(new String[] {"学号", "姓名"}));
		comboBoxSelect.setBounds(10, 10, 122, 23);
		panelSelect.add(comboBoxSelect);
		
		textField = new JTextField();
		textField.setBounds(10, 43, 122, 23);
		panelSelect.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		ScoreSelectListener scoreSelectListener = new ScoreSelectListener();
		scoreSelectListener.setTableFrame(this);
		btnNewButton.addActionListener(scoreSelectListener);
		btnNewButton.setBounds(24, 95, 97, 23);
		panelSelect.add(btnNewButton);
		
		JPanel panelSelect_1 = new JPanel();
		panelSelect_1.setLayout(null);
		panelSelect_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSelect_1.setBounds(268, 10, 146, 128);
		getContentPane().add(panelSelect_1);
		
		comboBoxSort = new JComboBox();
		comboBoxSort.setModel(new DefaultComboBoxModel(new String[] {"课程1", "课程2", "总分"}));
		comboBoxSort.setBounds(10, 10, 122, 23);
		panelSelect_1.add(comboBoxSort);
		
		JButton btnNewButtonSort = new JButton("排序");
		ScoreSortListener scoreSortListener = new ScoreSortListener();
		scoreSortListener.setTableFrame(this);
		btnNewButtonSort.addActionListener(scoreSortListener);
		btnNewButtonSort.setBounds(24, 95, 97, 23);
		panelSelect_1.add(btnNewButtonSort);
		
		JPanel panelSelect_1_1 = new JPanel();
		panelSelect_1_1.setLayout(null);
		panelSelect_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSelect_1_1.setBounds(581, 10, 117, 42);
		getContentPane().add(panelSelect_1_1);
		
		JButton btnNewButtonRefresh = new JButton("刷新");
		ScoreRefreshListener scoreRefreshListener = new ScoreRefreshListener();
		scoreRefreshListener.setTableFrame(this);
		btnNewButtonRefresh.addActionListener(scoreRefreshListener);
		btnNewButtonRefresh.setBounds(10, 10, 97, 23);
		panelSelect_1_1.add(btnNewButtonRefresh);
		
		JPanel panelSelect_1_1_1 = new JPanel();
		panelSelect_1_1_1.setLayout(null);
		panelSelect_1_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSelect_1_1_1.setBounds(581, 96, 117, 42);
		getContentPane().add(panelSelect_1_1_1);
		
		JButton btnNewButtonNotPass = new JButton("不及格");
		ScoreNotPassListener scoreNotPassListener = new ScoreNotPassListener();
		scoreNotPassListener.setTableFrame(this);
		btnNewButtonNotPass.addActionListener(scoreNotPassListener);
		btnNewButtonNotPass.setBounds(10, 10, 97, 23);
		panelSelect_1_1_1.add(btnNewButtonNotPass);
		
		JPanel panelSelect_1_1_2 = new JPanel();
		panelSelect_1_1_2.setLayout(null);
		panelSelect_1_1_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSelect_1_1_2.setBounds(581, 51, 117, 47);
		getContentPane().add(panelSelect_1_1_2);
		
		JButton btnNewButtonUpdata = new JButton("修改");
		btnNewButtonUpdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(scoreTableFrame.table.getSelectedRow() != -1){
	                    //修改界面
					 new ScoreUpdataFrame(scoreTableFrame);
	             }
				 else {
					 JOptionPane.showMessageDialog(null,"未选择学生信息","出现异常",JOptionPane.ERROR_MESSAGE);
	            }
			}
		});
		btnNewButtonUpdata.setBounds(10, 10, 97, 23);
		panelSelect_1_1_2.add(btnNewButtonUpdata);
		
		

	}
}
