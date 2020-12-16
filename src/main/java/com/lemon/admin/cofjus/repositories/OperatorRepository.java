package com.lemon.admin.cofjus.repositories;

import com.lemon.admin.cofjus.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OperatorRepository extends JpaRepository<Operator,Integer> {
    Operator findByUserName(String name);

    // @Query("select u from operator u where u.user_name = ?1")
    // Operator findByFullUserName(String name);

}

