package com.pro.timon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.timon.entity.Tasks;

@Repository
public interface TaskRepository extends JpaRepository< Tasks, Long> {

}
