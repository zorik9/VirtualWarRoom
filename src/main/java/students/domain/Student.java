package students.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	String id;
	@Column(name = "fullName")
	String fullName;
	@Column(name = "gender")
	Gender gender;
	@Column(name = "avgGrade")
	float avgGrade;

	public Student(){

	}
	
	public Student(String id) {
		this.id = id;
		this.avgGrade = 0;
		this.fullName = "DefaultFullName";
		this.gender = Gender.FEMALE;
	}
	
	
	public Student(String id, String fullName, Gender gender, float avgGrade) {
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.avgGrade = avgGrade;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", fullName='" + fullName + '\'' +
				", gender=" + gender +
				", avgGrade=" + avgGrade +
				'}';
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public float getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}
}
