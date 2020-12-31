package com.lemon.admin.cofjus.service.impl;


import com.lemon.admin.cofjus.entity.Operator;
import com.lemon.admin.cofjus.entity.User;
import com.lemon.admin.cofjus.repositories.OperatorRepository;
import com.lemon.admin.cofjus.repositories.UserRepository;
import com.lemon.admin.cofjus.service.DistributeLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributeLabelServiceImpl implements DistributeLabelService {

    @Autowired
    OperatorRepository operatorRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void workoutLastDayLabel() {
        List<Operator> operators = operatorRepository.findAll();
        for(Operator operator:operators){
            List<User> users = userRepository.findByOperatorId(operator.getId());
            for(User user:users){
                user.setOperatorId(null); //清空前一天的分配信息
            }
            userRepository.saveAll(users);
        }
    }

    @Override
    public void distributeTodayLabel() {
        List<Operator> operators = operatorRepository.findAll();
        List<User> todos = userRepository.findUsersByLastLabelId();
        int start = 0;
        for(Operator operator:operators){
            for(int i = 0; i < 200; i++){
                if(start < todos.size()){
                    todos.get(start).setOperatorId(operator.getId());
                    start++;
                }else {
                    break;
                }
            }
        }
        userRepository.saveAll(todos.subList(0, start));
    }
}
