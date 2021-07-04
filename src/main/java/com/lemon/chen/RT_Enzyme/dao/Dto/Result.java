package com.lemon.chen.RT_Enzyme.dao.Dto;

import lombok.Data;

@Data
public class Result<T> {

    private String message = "成功";

    private Integer code = 0;

    private Integer count = 0;

    private T data;

    public Result(){
        super();
    }

    public Result(T data){
        this.data = data;
    }

}
