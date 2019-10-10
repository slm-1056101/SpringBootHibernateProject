package edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transcriptId;
    private String degreeTitle;

    @OneToOne(fetch = FetchType.LAZY,  optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    public void setStudent(Student student) {this.student = student; }

    public Student getStudent() { return student; }

    public Integer getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Integer transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }


}
