package com.tyss.jspiders.repository;

import com.tyss.jspiders.entity.Role;
import com.tyss.jspiders.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer,String> {

}
