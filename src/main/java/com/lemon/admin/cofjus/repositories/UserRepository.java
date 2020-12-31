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

    List<User> findByOperatorId(Integer operator_id);

    // ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("",GenericPropertyMatchers.)
    // @Query("select * from User u where  u.last_label_id != null")
    // public List<User> cascadeQuery();
    
    
    /**
     * @// TODO: 2020/12/31 改进这个query,每次都遍历所有的数据很浪费资源 
     * */
    @Query(value ="select * from user u where  u.last_label_id is null", nativeQuery = true)
    List<User> findUsersByLastLabelId();

    @Query(value ="select count(*) from user u where  u.last_label_id is null", nativeQuery = true)
    long count();


}
