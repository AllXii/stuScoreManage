package service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.Address;
import dao.ScoreData;
import dao.ScoreReader;
import model.StudentScore;

public class ScoreService {
	ScoreReader scoreReader;
	List<StudentScore> studentScores;
	int NUMBER = 0;//学生数量
	
	
	//构造函数 将String数据放入StudentGrade容器当中，并且放到ScoreData中的静态变量中
	public ScoreService(String scoreAddress) {
		scoreReader = new ScoreReader(scoreAddress);
		studentScores = new ArrayList<StudentScore>();
		String data = scoreReader.toString(); //传递进来数据
		String temp = data.replaceAll("\r\n", " "); //替换回车
//		System.out.print(temp);
		String scoreData[] = temp.split(" ");
		//开始对容器进行赋值
		int tempCount = -1; //设置标志变量
		//当赋值的次数与字符串数组长度相同的时候，内容就被转换完了
		while(scoreData.length > ++tempCount && scoreData[0]!=null) {
			StudentScore studentScore = new StudentScore();
			studentScore.setId(scoreData[tempCount]);
			studentScore.setName(scoreData[++tempCount]);
			studentScore.setScoreOne(Double.valueOf(scoreData[++tempCount]));
			studentScore.setScoreTwo(Double.valueOf(scoreData[++tempCount]));
			studentScore.setScoreTotal(studentScore.getScoreOne()+studentScore.getScoreTwo());
			studentScores.add(studentScore);
		}
		NUMBER = tempCount/4;
		//System.out.print(tempCount);
//		for(StudentGrade i: studentGrades) {
//			System.out.println(i);
//		}
		ScoreData.STUDENTSCORES = studentScores;
		ScoreData.SCORESERVICE = this;
	}
	
	//获取文件中的成绩顺序
	public List<StudentScore> getScore(){
		return ScoreData.STUDENTSCORES;
	}
	
	//使用Collections集合工具类中的方法进行排序
	public List<StudentScore> getSortScoreTotal() {
		 //通过重写接口唯一的compara的方法，来实现升序还是降序
        Collections.sort(studentScores, new Comparator<StudentScore>() {
            @Override
            public int compare(StudentScore o1, StudentScore o2) {
                // 升序
            	//return o1.getScoreTotal().compareTo(o2.getScoreTotal());
                // 降序
                return o2.getScoreTotal().compareTo(o1.getScoreTotal());
            }
        });
		return studentScores;
	}
	
	//使用Collections集合工具类中的方法进行排序
		public List<StudentScore> getSortScoreOne() {
			 //通过重写接口唯一的compara的方法，来实现升序还是降序
	        Collections.sort(studentScores, new Comparator<StudentScore>() {
	            @Override
	            public int compare(StudentScore o1, StudentScore o2) {
	                // 升序
	            	//return o1.getScoreTotal().compareTo(o2.getScoreTotal());
	                // 降序
	                return o2.getScoreOne().compareTo(o1.getScoreOne());
	            }
	        });
			return studentScores;
		}
		
		//使用Collections集合工具类中的方法进行排序
		public List<StudentScore> getSortScoreTwo() {
			 //通过重写接口唯一的compara的方法，来实现升序还是降序
	        Collections.sort(studentScores, new Comparator<StudentScore>() {
	            @Override
	            public int compare(StudentScore o1, StudentScore o2) {
	                // 升序
	            	//return o1.getScoreTotal().compareTo(o2.getScoreTotal());
	                // 降序
	                return o2.getScoreTwo().compareTo(o1.getScoreTwo());
	            }
	        });
			return studentScores;
		}
	
	//返回所有学生的全部分数的平均分数
	public double getAverageScoreTotal() {
		double averageScore = 0;
		double totalScore = 0;
		for(StudentScore i: studentScores) {
			totalScore += i.getScoreTotal();
		}
		averageScore = totalScore/NUMBER;
		return averageScore;
	}
	
	//返回所有学生的课程1的平均分数
	public double getAverageScoreOne() {
		double averageScore = 0;
		double totalScore = 0;
		for(StudentScore i: studentScores) {
			totalScore += i.getScoreOne();
		}
		averageScore = totalScore/NUMBER;
		return averageScore;
	}
	
	//返回所有学生的课程2的平均分数
	public double getAverageScoreTwo() {
		double averageScore = 0;
		double totalScore = 0;
		for(StudentScore i: studentScores) {
			totalScore += i.getScoreTwo();
		}
		averageScore = totalScore/NUMBER;
		return averageScore;
	}
	
	//返回课程1的通过率
	public String getPassRateOne() {
		int passNum = 0;
		for(StudentScore i: studentScores) {
			if(i.getScoreOne()>=60) {
				passNum++;
			}
		}
		double passRate = (double)passNum/NUMBER;
		DecimalFormat df = new DecimalFormat("0.00");//格式化输出
		return (df.format(passRate*100))+"%";
	}
	
	public String getNotPassRateOne() {
		int notPassNum = 0;
		for(StudentScore i: studentScores) {
			if(i.getScoreOne()<60) {
				notPassNum++;
			}
		}
		DecimalFormat df = new DecimalFormat("0.00");//格式化输出
		double notPassRate = (double)notPassNum/NUMBER;
		return (df.format(notPassRate*100))+"%";
	}
	
	//返回课程2的通过率
	public String getPassRateTwo() {
		int passNum = 0;
		for(StudentScore i: studentScores) {
			if(i.getScoreTwo()>=60) {
				passNum++;
			}
		}
		DecimalFormat df = new DecimalFormat("0.00");//格式化输出
		double passRate = (double)passNum/NUMBER;
		return (df.format(passRate*100))+"%";
	}
	
	public String getNotPassRateTwo() {
		int notPassNum = 0;
		for(StudentScore i: studentScores) {
			if(i.getScoreTwo()<60) {
				notPassNum++;
			}
		}
		DecimalFormat df = new DecimalFormat("0.00");//格式化输出
		double notPassRate = (double)notPassNum/NUMBER;
		return (df.format(notPassRate*100))+"%";
	}
	
	// 课程1等级的分布
	public String getGradeOne(){
		int excellenceOne = 0;
		int goodMarksOne = 0;
		int mediumLevelOne = 0;
		double excellenceOneRate = 0;
		double goodMarksOneRate = 0;
		double mediumLevelOneRate = 0;
		for(StudentScore i: studentScores) {
			//
			if(i.getScoreOne()>=90) {
				excellenceOne++;
			}
			else if(i.getScoreOne()>=80 && i.getScoreOne()<90) {
				goodMarksOne++;
			}
			else if(i.getScoreOne()>=70 && i.getScoreOne()<80) {
				mediumLevelOne++;
			}
		}
		excellenceOneRate = (double)excellenceOne/NUMBER;
		goodMarksOneRate = (double)goodMarksOne/NUMBER;
		mediumLevelOneRate = (double)mediumLevelOne/NUMBER;
		
		DecimalFormat df = new DecimalFormat("0.00");//格式化输出
		
		return "优 " + df.format(excellenceOneRate*100)+"% :"+excellenceOne+
			   "人\s\n良 " + df.format(goodMarksOneRate*100)+"% :"+goodMarksOne+
			   "人\s\n中 " + df.format(mediumLevelOneRate*100)+"% :"+mediumLevelOne+"人";
	}
	
	public String getGradeTwo(){
		int excellenceTwo = 0;
		int goodMarksTwo = 0;
		int mediumLevelTwo = 0;
		double excellenceTwoRate = 0;
		double goodMarksTwoRate = 0;
		double mediumLevelTwoRate = 0;
		for(StudentScore i: studentScores) {
			//
			
			if(i.getScoreTwo()>=90) {
				excellenceTwo++;
			}
			else if(i.getScoreTwo()>=80 && i.getScoreTwo()<90) {
				goodMarksTwo++;
			}
			else if(i.getScoreTwo()>=70 && i.getScoreTwo()<80) {
				mediumLevelTwo++;
			}
		}
		excellenceTwoRate = (double)excellenceTwo/NUMBER;
		goodMarksTwoRate = (double)goodMarksTwo/NUMBER;
		mediumLevelTwoRate = (double)mediumLevelTwo/NUMBER;
		
		DecimalFormat df = new DecimalFormat("0.00");//格式化输出
		
		return "优 " + df.format(excellenceTwoRate*100)+"% :"+excellenceTwo+
			   "人\s\n良 " + df.format(goodMarksTwoRate*100)+"% :"+goodMarksTwo+
			   "人\s\n中 " + df.format(mediumLevelTwoRate*100)+"% :"+mediumLevelTwo+"人";
	}
	
	//获取课程1的最大成绩
	public double getMaxScoreOne() {
		double max = -1;
		for(StudentScore i: ScoreData.STUDENTSCORES) {
			if(i.getScoreOne() > max) {
				max = i.getScoreOne();
			}
		}
		return max;
	}
	//获取课程1的最小成绩
	public double getMinScoreOne() {
		double min = 101;
		for(StudentScore i: ScoreData.STUDENTSCORES) {
			if(i.getScoreOne() < min ) {
				min = i.getScoreOne();
			}
		}
		return min;
	}
	//获取课程2的最大成绩
	public double getMaxScoreTwo() {
		double max = -1;
		for(StudentScore i: ScoreData.STUDENTSCORES) {
			if(i.getScoreTwo() > max) {
				max = i.getScoreTwo();
			}
		}
		return max;
	}
	//获取课程2的最小成绩
	public double getMinScoreTwo() {
		double min = 101;
		for(StudentScore i: ScoreData.STUDENTSCORES) {
			if(i.getScoreTwo() < min ) {
				min = i.getScoreTwo();
			}
		}
		return min;
	}
	
	//修改学生的数据
	public boolean updataScore(String Id, Double scoreOne, Double scoreTwo) {
		SelectAny selectAny = new SelectAny();
		selectAny.setNameOrId(Id);//设置所要查找的学号
		for(int i = 0; i<ScoreData.STUDENTSCORES.size(); i++) {
			//找到对应的容器位置
			if(selectAny.select(ScoreData.STUDENTSCORES.get(i).getId())) {
				ScoreData.STUDENTSCORES.get(i).setScoreOne(scoreOne);
				ScoreData.STUDENTSCORES.get(i).setScoreTwo(scoreTwo);
				ScoreData.STUDENTSCORES.get(i).setScoreTotal(scoreOne+scoreTwo);
				return true;
			}
		}
		return false;
	}
	
	
	//测试
//	public static void main(String args[]) {
//		Address.FILE_READER_ADDRESS = "src\\\\score.txt";
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getScore());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getSortScoreTotal());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getAverageScoreTotal());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getAverageScoreOne());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getAverageScoreTwo());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getPassRateOne());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getPassRateTwo());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getNotPassRateOne());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getNotPassRateTwo());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getGradeOne());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getGradeTwo());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getMinScoreOne());
//		System.out.println(new ScoreService(Address.FILE_READER_ADDRESS).getMinScoreTwo());
//	}
}
