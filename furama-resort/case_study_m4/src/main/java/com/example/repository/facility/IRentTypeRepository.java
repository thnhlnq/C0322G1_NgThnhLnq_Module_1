package com.example.repository.facility;

import com.example.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
