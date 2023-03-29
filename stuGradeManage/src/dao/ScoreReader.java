package dao;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;


public class ScoreReader {
	private File file;
	private FileReader in;
	private StringBuffer scoreInfo;
	
	//初始化对象，并完成数据读取
	 public ScoreReader(String fileAddress) {
		 try {
			 file = new File(fileAddress);
			 in = new FileReader(file);
			 scoreInfo = new StringBuffer(); //创建变长字符串
			 char t[] = new char[10000]; //创建一个暂存字符空间以存放读取的数据
			 int n = -1;
			 //将in这个字符流的数据输入至暂存t中，从t的0位置放入数据，从文件中读取10000个字符直至结束
			 //返回值n是读取的字符数
			 while((n=in.read(t, 0, 10000)) != -1) {
				 //
				 String temp = new String(t, 0, n);//通过t字符数据，从0开始读入n个数据
				 scoreInfo.append(temp);
			 }
			 in.close();
//			 System.out.print(scoreInfo);
		 }
		 catch(Exception e) {
			 System.out.print(e);
		 }
	 }
	 //返回字符串以进行进一步处理
	 public String toString() {
		 return new String(scoreInfo);
	 }
}
