package com.lemon.chen.RT_Enzyme.dao.Dto;

import lombok.Data;

@Data
public class Table<T> {

    private String message = "成功";

    private Integer code = 0;

    private Integer count = 0;

    private T data;

    public Table(){
        super();
    }

    public Table(T data){
        this.data = data;
    }

}
