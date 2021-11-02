package com.javabuc17.exampleProject.repositories;

import com.javabuc17.exampleProject.models.ClassRoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoomModel, Integer> {
}
