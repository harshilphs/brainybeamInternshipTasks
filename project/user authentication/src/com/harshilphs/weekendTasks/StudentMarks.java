package com.harshilphs.weekendTasks;

public class StudentMarks {
	private int id;
	private String name;
	private int physics;
	private int chemistry;
	private int maths;
	private int computer;
	private int socialScience;
	private int english;
	private int hindi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
	public int getSocialScience() {
		return socialScience;
	}
	public void setSocialScience(int socialScience) {
		this.socialScience = socialScience;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getHindi() {
		return hindi;
	}
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}
	@Override
	public String toString() {
		return "StudentMarks [id=" + id + ", name=" + name + ", physics=" + physics + ", chemistry=" + chemistry
				+ ", maths=" + maths + ", computer=" + computer + ", socialScience=" + socialScience + ", english="
				+ english + ", hindi=" + hindi + "]";
	}
		

}
