package com.example.task2.repository;

import com.example.task2.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Long> {
    List<Group> findAllByFacultyId(Long faculty_id);
}
