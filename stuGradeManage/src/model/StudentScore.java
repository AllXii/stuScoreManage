package model;

import java.io.Serializable;

public class StudentScore implements Serializable{
	private String name;
	private String id;
	private double scoreOne;
	private double scoreTwo;
	private double scoreTotal;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getScoreOne() {
		return scoreOne;
	}
	public void setScoreOne(double scoreOne) {
		this.scoreOne = scoreOne;
	}
	public Double getScoreTwo() {
		return scoreTwo;
	}
	public void setScoreTwo(double scoreTwo) {
		this.scoreTwo = scoreTwo;
	}
	public Double getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(double scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\",\"id\":\"" + id + "\",\"scoreOne\":\"" + scoreOne + "\",\"scoreTwo\":\""
				+ scoreTwo + "\",\"scoreTotal\":\"" + scoreTotal + "\"}";
	}
	
}
