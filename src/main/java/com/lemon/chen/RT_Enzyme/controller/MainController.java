package com.lemon.chen.RT_Enzyme.controller;

import com.lemon.chen.RT_Enzyme.dao.Dto.LocationDto;
import com.lemon.chen.RT_Enzyme.entity.ProjInfo;
import com.lemon.chen.RT_Enzyme.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class MainController {
    @Autowired
    MainPageService mainPageService;



    @GetMapping("/locations/{proj_id}/list")
    public List<LocationDto> locations_list(@PathVariable("proj_id")Integer proj_id){
        return mainPageService.locations_list(proj_id);
    }

    @GetMapping("/project/{uid}/info")
    public List<ProjInfo> projInfoList(@PathVariable("uid")Integer uid){
        return mainPageService.projInfoList(uid);
    }

}

