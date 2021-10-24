package com.springrestdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "students")
@XmlRootElement
public class Student {
	
	@Id
	private int id;
	
	private String name;
	
	
	private int points;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return name;
	}
	
//	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	
//	@XmlElement
	public int getPoints() {
		return points;
	}
	
//	@XmlAttribute
	public void setPoints(int points) {
		this.points = points;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", points=" + points + "]";
	}

//	@XmlElement
	public int getId() {
		return id;
	}

//	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
