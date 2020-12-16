
package com.lemon.admin.cofjus.repositories;

import com.lemon.admin.cofjus.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LabelRepository extends JpaRepository<Label,Integer> {

}