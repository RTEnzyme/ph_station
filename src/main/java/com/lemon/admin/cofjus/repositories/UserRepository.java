package com.lemon.admin.cofjus.repositories;

import com.lemon.admin.cofjus.entity.User;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByKolNameContaining(String name);

    List<User> findByUniqueIdContaining(String name);

    List<User> findUsersByKolName(String name);

    List<User> findUsersByUniqueId(String uid);

    List<User> findByLastLabelId(int lid);

    // ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("",GenericPropertyMatchers.)
    // @Query("select * from User u where  u.last_label_id != null")
    // public List<User> cascadeQuery();

    @Query(value ="select * from user u where  u.last_label_id is null", nativeQuery = true)
    List<User> findUsersByLastLabelId();

    @Query(value ="select count(*) from user u where  u.last_label_id is null", nativeQuery = true)
    long count();


}
