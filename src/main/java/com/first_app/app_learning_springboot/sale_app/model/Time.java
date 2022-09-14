package com.first_app.app_learning_springboot.sale_app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Time {
    @Id // primary key
    @GeneratedValue // auto generate id increase
    private Integer id;

    @Column(name = "month")
    private Integer month;

    @Column(name = "quarter")
    private Integer quarter;

    @Column(name = "year")
    private Integer year;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)  // MappedBy point to time variable in Sales.
    private Collection<Sale> sales;

    public Time(Integer time_Id, Integer month, Integer quarter, Integer year) {
        id = time_Id;
        this.month = month;
        this.quarter = quarter;
        this.year = year;
    }

    public Time() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Time{" +
                "Time_Id=" + id +
                ", Month=" + month +
                ", Quarter=" + quarter +
                ", Year=" + year +
                '}';
    }
}
