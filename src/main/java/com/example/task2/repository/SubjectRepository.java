package com.example.task2.repository;

import com.example.task2.entity.Student;
import com.example.task2.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findAllByGroup_StudentsId(Long group_students_id);
}
