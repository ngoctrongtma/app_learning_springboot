package com.first_app.app_learning_springboot.sale_app.service.implement;

import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.repository.ProductRepository;
import com.first_app.app_learning_springboot.sale_app.repository.TimeRepository;
import com.first_app.app_learning_springboot.sale_app.service.TimeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class TimeService implements TimeServiceInterface {
    private final TimeRepository timeRepository;

    @Autowired
    public TimeService(TimeRepository timeRepository){
        this.timeRepository = timeRepository;
    }

    @Override
    // get all time
    public List<Time> getAllTime(){
        return timeRepository.findAll();
    }

    @Override
    // get time by id
    public Time getTimeById(Integer timeId){
        return timeRepository.findById(timeId).get();
    }

    @Override
    // create product
    public void createTime(Time time){
        timeRepository.save(time);
    }

    @Override
    // update product
    @Transactional
    public void updateTime(Integer timeId, Integer month, Integer year, Integer quarter){
        Time time = timeRepository.findById(timeId).orElseThrow(() -> new IllegalStateException("Time is not exists!"));
        if(month != null && !Objects.equals(time.getMonth(), month)){
            time.setMonth(month);
        }
        if(year != null && !Objects.equals(time.getYear(), year)){
            time.setYear(year);
        }
        if(quarter != null && !Objects.equals(time.getQuarter(), quarter)){
            time.setQuarter(quarter);
        }
    }

    @Override
    // delete product
    public void deleteTime(Integer timeId){
        boolean exists = timeRepository.existsById(timeId);
        if(!exists){
            throw new IllegalStateException("Id is not exists!");
        }
        timeRepository.findById(timeId);
        timeRepository.deleteById(timeId);
    }
}
