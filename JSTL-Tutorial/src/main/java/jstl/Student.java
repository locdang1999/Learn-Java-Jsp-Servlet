package jstl;

public class Student {
	private int id;
	private String name;
	
	public Student() {
		super();
	}

	public int getRollno() {
		return id;
	}

	public void setRollno(int rollno) {
		this.id = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int rollno, String name) {
		super();
		this.id = rollno;
		this.name = name;
	}
	
	
}
