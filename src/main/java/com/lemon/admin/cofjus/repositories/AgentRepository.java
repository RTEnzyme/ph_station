package com.lemon.admin.cofjus.repositories;

import com.lemon.admin.cofjus.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer> {
    Agent findByUserName(String name);
}

