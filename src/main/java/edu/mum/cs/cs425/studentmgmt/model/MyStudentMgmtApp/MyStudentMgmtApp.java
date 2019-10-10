package edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp;

import edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {


	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TranscriptRepository transcriptRepository;

	@Autowired
	private ClassroomRepository classroomRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		studentRepository.deleteAllInBatch();
		transcriptRepository.deleteAllInBatch();
		classroomRepository.deleteAllInBatch();

		Student student = getStudent();
		Transcript transcript=getTranscript();
		Classroom classroom1=getClassroom();
		Classroom classroom2=getClassroom2();
		student.setTranscript(transcript);
		transcript.setStudent(student);

		// Add classroom references in the student
		student.getClassRoom().add(classroom1);
		student.getClassRoom().add(classroom2);

		// Add student reference in the classroom
		classroom1.getStudents().add(student);
		classroom2.getStudents().add(student);

		studentRepository.save(student);

	}
	private Student getStudent() {
		Student student= new Student();
		student.setStudentId(3);
		student.setStudentNumber("000-61-0111");
		student.setFirstName("pogo");
		student.setMiddleName("logo");
		student.setLastName("romelu");
		student.setCgpa(3.45);
		student.setDateOfEnrollment(LocalDate.of(2019,5,24));
		return student;
	}
	private Transcript getTranscript() {
		Transcript transcript= new Transcript();
		transcript.setTranscriptId(1);
		transcript.setDegreeTitle("Computer Science");
		return transcript;
	}

	private Classroom getClassroom() {
		Classroom classroom= new Classroom();
		classroom.setClassroomId(1);
		classroom.setBuildingName("McLaughlin building");
		classroom.setRoomNumber("M105");
		return classroom;
	}
	private Classroom getClassroom2() {
		Classroom classroom= new Classroom();
		classroom.setClassroomId(2);
		classroom.setBuildingName("Library building");
		classroom.setRoomNumber("M209");
		return classroom;
	}

}
