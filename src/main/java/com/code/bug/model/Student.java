package com.code.bug.model;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student implements Serializable {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getRollno() {
			return rollno;
		}
		public void setRollno(int rollno) {
			this.rollno = rollno;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public int getLecture() {
			return lecture;
		}
		public void setLecture(int lecture) {
			this.lecture = lecture;
		}
		public int getAttend() {
			return attend;
		}
		public void setAttend(int attend) {
			this.attend = attend;
		}
		@Column(name = "rollno")
	    private int rollno;	 
	    @Column(name = "student_name")
	    private String studentName;
	    @Column(name = "lecture")
	    private int lecture;
	    @Column(name = "attend")
	    private int attend;
}

