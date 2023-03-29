package service;

import dao.ScoreData;
import view.ScoreOverviewJFrame;

public class SetOverview {
	ScoreOverviewJFrame scoreOverviewJFrame;
	
	//初始化，页面传递过来
	public SetOverview(ScoreOverviewJFrame scoreOverviewJFrame) {
		this.scoreOverviewJFrame = scoreOverviewJFrame;
	}
	
	public void setInfo(){
		scoreOverviewJFrame.textFieldNumber.setText(ScoreData.STUDENTSCORES.size()+"");//设置人数
		scoreOverviewJFrame.textFieldAveScore.setText(ScoreData.SCORESERVICE.getAverageScoreOne()+"");//平均分
		scoreOverviewJFrame.textFieldMaxScore.setText(ScoreData.SCORESERVICE.getMaxScoreOne()+"");
		scoreOverviewJFrame.textFieldMinScore.setText(ScoreData.SCORESERVICE.getMinScoreOne()+"");
		scoreOverviewJFrame.textPaneGrade.setText(ScoreData.SCORESERVICE.getGradeOne());//分数等级
		scoreOverviewJFrame.textFieldPassRate.setText(ScoreData.SCORESERVICE.getPassRateOne());
		
		scoreOverviewJFrame.textFieldNumber2.setText(ScoreData.STUDENTSCORES.size()+"");
		scoreOverviewJFrame.textFieldAveScore2.setText(ScoreData.SCORESERVICE.getAverageScoreTwo()+"");
		scoreOverviewJFrame.textFieldMax2.setText(ScoreData.SCORESERVICE.getMaxScoreTwo()+"");
		scoreOverviewJFrame.textFieldMin2.setText(ScoreData.SCORESERVICE.getMinScoreTwo()+"");
		scoreOverviewJFrame.textPaneGrade2.setText(ScoreData.SCORESERVICE.getGradeTwo());//分数等级
		scoreOverviewJFrame.textFieldPassRate2.setText(ScoreData.SCORESERVICE.getPassRateTwo());
	}
}
