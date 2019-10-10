package edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Student_table")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer studentId;
	@NotNull
	@Column(name="student_num")
	private String studentNumber;
	@NotNull
	@Column(name="Fname")
	private String firstName;
	@Column(name="Mname")
	private String middleName;
	@NotNull
	@Column(name="Lname")
	private String lastName;
	@Column(name="Gpa")
	private Double cgpa;
	@Column(name="Date")
	private LocalDate dateOfEnrollment;




	@OneToOne(fetch = FetchType.LAZY,
			cascade =  CascadeType.PERSIST,
			mappedBy = "student")
	private Transcript transcript;




	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
//	@NotFound(action = NotFoundAction.IGNORE)
	@JoinTable(name = "student_classroom",
			joinColumns = { @JoinColumn(name = "student_id") },
			inverseJoinColumns = { @JoinColumn(name = "classroom_id") })
	private Set<Classroom> classRoom = new HashSet<>();

	public Set<Classroom> getClassRoom() { return classRoom; }

	public void setClassRoom(Set<Classroom> classRoom) { this.classRoom = classRoom; }

	public Transcript getTranscript() { return transcript; }
	public void setTranscript(Transcript transcript) { this.transcript = transcript; }
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}



}
