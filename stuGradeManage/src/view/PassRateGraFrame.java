package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JFrame;

import dao.ScoreData;
import javax.swing.JComboBox;


public class PassRateGraFrame extends JFrame{
	double passRateOne;
	double notPassRateOne;
	double passRateTwo;
	double notPassRateTwo;
	
	public PassRateGraFrame() {
		setTitle("及格信息");
		
		this.setBounds(200,100,600,520);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		//处理数据
		String passRateOne = ScoreData.SCORESERVICE.getPassRateOne();
		String notPassRateOne = ScoreData.SCORESERVICE.getNotPassRateOne();
		String passRateTwo = ScoreData.SCORESERVICE.getPassRateTwo();
		String notPassRateTwo = ScoreData.SCORESERVICE.getNotPassRateTwo();
		
		System.out.println(passRateOne + passRateTwo);
		
		this.setInfo(getDouble(passRateOne), getDouble(notPassRateOne), getDouble(passRateTwo), getDouble(notPassRateTwo));
	}//直接在窗体中绘图
	
	double getDouble(String passRate) {
		String []t = passRate.split("%");
		double passRateDouble = Double.valueOf(t[0]);
		return passRateDouble;
	}
	
	public void setInfo(double passRateOne, double notPassRateOne, double passRateTwo, double notPassRateTwo) {
		this.passRateOne = passRateOne;
		this.notPassRateOne = notPassRateOne;
		this.passRateTwo = passRateTwo;
		this.notPassRateTwo = notPassRateTwo;
	}
	public void paint(Graphics g) {
		g.drawString("课程1及格率图表", 100, 100);
		g.drawString("课程2及格率图表", 400, 100);
		
		g.drawLine(20, 40, 20, 500);
		g.drawLine(20, 500, 570, 500);
		g.drawLine(570, 500, 570, 40);
		g.drawLine(570, 40, 20, 40);
		
		Graphics2D g2d = (Graphics2D)g;
		//用Arc2D.Float或Arc2D.Double创建。接收7个参数，
		//前面4个参数对应圆弧所属椭圆的信息，后面3个参数分别是弧的起始角度、弧环绕的角度、闭合方式。弧的闭合方式:
		Arc2D.Double arcPass = new Arc2D.Double(50,150,200,200,0,passRateOne/100*360,Arc2D.PIE);
		g2d.setPaint(Color.GREEN);
		g2d.fill(arcPass);
		g2d.draw(arcPass);
		
		Arc2D.Double arcNotPass = new Arc2D.Double(50,150,200,200,passRateOne/100*360,notPassRateOne/100*360,Arc2D.PIE);
		g2d.setPaint(Color.red);
		g2d.fill(arcNotPass);
		g2d.draw(arcNotPass);
		
		Arc2D.Double arcPassTwo = new Arc2D.Double(350,150,200,200,0,passRateTwo/100*360,Arc2D.PIE);
		g2d.setPaint(Color.GREEN);
		g2d.fill(arcPassTwo);
		g2d.draw(arcPassTwo);
		
		Arc2D.Double arcNotPassTwo = new Arc2D.Double(350,150,200,200,passRateTwo/100*360,notPassRateTwo/100*360,Arc2D.PIE);
		g2d.setPaint(Color.red);
		g2d.fill(arcNotPassTwo);
		g2d.draw(arcNotPassTwo);
		
	}
	
// public static void main(String arg[]){
//	 
//	
//
//	PassRateGraFrame x = new PassRateGraFrame();
//	x.setSize(800, 800);
//	x.setVisible(true);
//  }
}
