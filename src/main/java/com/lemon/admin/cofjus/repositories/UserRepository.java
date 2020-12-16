package com.lemon.admin.cofjus.repositories;

import com.lemon.admin.cofjus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
