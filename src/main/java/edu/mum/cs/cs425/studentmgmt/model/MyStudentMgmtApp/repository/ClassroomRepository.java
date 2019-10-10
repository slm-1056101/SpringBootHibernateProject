package edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.repository;

import edu.mum.cs.cs425.studentmgmt.model.MyStudentMgmtApp.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
