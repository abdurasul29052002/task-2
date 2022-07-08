package com.example.task2.repository;

import com.example.task2.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByNameIsLikeIgnoreCase(String name);

    @Query("select new Student(s.id,s.name,m.ball) from Mark m join Student s on m.student.id=s.id join groups g on g.id=s.group.id where g.id=:groupId order by m.ball desc")
    List<Student> findAllByGroupId(Long groupId);
}
