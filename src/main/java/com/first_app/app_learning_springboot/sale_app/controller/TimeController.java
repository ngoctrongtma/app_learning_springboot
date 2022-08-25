package com.first_app.app_learning_springboot.sale_app.controller;

import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.service.TimeServiceInterface;
import com.first_app.app_learning_springboot.sale_app.util.SaleAppUrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = SaleAppUrlUtil.timeUrl)
public class TimeController {

    private final TimeServiceInterface timeService;
    @Autowired
    public TimeController(TimeServiceInterface timeServiceInterface){
        this.timeService = timeServiceInterface;
    }

    Logger logger
            = LoggerFactory.getLogger(TimeController.class);

    @GetMapping
    public List<Time> getAllTime(){
        logger.info("get all time");
        return timeService.getAllTime();
    }

    @GetMapping(path = "{timeId}")
    public  Time getTimeById(@PathVariable("timeId") Integer timeId){
        logger.info("get time by id");
        return timeService.getTimeById(timeId);
    }

    @PostMapping
    public void createTime(@RequestBody Time time){
        logger.info("create time");
        timeService.createTime(time);
    }


    @PutMapping(path = "{timeId}")
    public void updateTime(
            @PathVariable("timeId") Integer timeId,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer quarter
    ){
        logger.info("update time");
        timeService.updateTime(timeId, month, year, quarter);
    }

    @DeleteMapping(path = "{timeId}")
    public void deleteTime(@PathVariable("timeId") Integer timeId){
        logger.info("delete time");
        timeService.deleteTime(timeId);
    }


}
