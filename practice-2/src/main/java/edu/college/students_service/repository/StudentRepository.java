package edu.college.students_service.repository;

import edu.college.students_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Дополнительные методы поиска
    Student findByEmail(String email);
    List<Student> findByGroupName(String groupName);
}
