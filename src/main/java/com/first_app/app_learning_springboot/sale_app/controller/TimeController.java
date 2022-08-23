package com.first_app.app_learning_springboot.sale_app.controller;

import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.service.ProductService;
import com.first_app.app_learning_springboot.sale_app.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/time")
public class TimeController {

    private final TimeService timeService;
    @Autowired
    public TimeController(TimeService timeService){
        this.timeService = timeService;
    }

    @GetMapping
    public List<Time> getAllTime(){
        return timeService.getAllTime();
    }

    @GetMapping(path = "{timeId}")
    public  Time getTimeById(@PathVariable("timeId") Integer timeId){
        return timeService.getTimeById(timeId);
    }

    @PostMapping
    public void createTime(@RequestBody Time time){
        timeService.createTime(time);
    }


    @PutMapping(path = "{timeId}")
    public void updateTime(
            @PathVariable("timeId") Integer timeId,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer quarter
    ){
        timeService.updateTime(timeId, month, year, quarter);
    }

    @DeleteMapping(path = "{timeId}")
    public void deleteTime(@PathVariable("timeId") Integer timeId){
        timeService.deleteTime(timeId);
    }


}
