package com.example.demo.repository;

import com.example.demo.domain.Raid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaidRepository extends JpaRepository<Raid, Long> {
    Raid findByName(String name);
}
