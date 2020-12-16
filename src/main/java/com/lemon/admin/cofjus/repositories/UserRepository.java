package com.lemon.admin.cofjus.repositories;

import com.lemon.admin.cofjus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findUsersByKolName(String name);

    List<User> findUsersByUniqueId(String uid);
}
