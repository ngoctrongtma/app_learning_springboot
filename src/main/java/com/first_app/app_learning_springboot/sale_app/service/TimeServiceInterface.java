package com.first_app.app_learning_springboot.sale_app.service;

import com.first_app.app_learning_springboot.sale_app.model.Time;

import java.util.List;

public interface TimeServiceInterface {
    List<Time> getAllTime();
    Time getTimeById(Integer timeId);
    void createTime(Time time);
    void updateTime(Integer timeId, Integer month, Integer year, Integer quarter);
    void deleteTime(Integer timeId);
}
