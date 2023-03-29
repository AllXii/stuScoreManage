package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import model.StudentScore;
import service.ScoreService;

public class ScoreWriter {
	File file;
	FileWriter out;
//	List<StudentGrade> studentGrades;
	//初始化
	public ScoreWriter(String writeAddress) {
		file = new File(writeAddress);
		
		try {
			out = new FileWriter(file);
			StringBuffer s = new StringBuffer();
			
			for(StudentScore studentScore: ScoreData.STUDENTSCORES) {
				s.append(studentScore+"\r\n");
			}
//			for(int i=0; i<=10; i++) {
//				s.append("测试"+"\r\n");
//			}
//			
			out.write(new String(s));
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
