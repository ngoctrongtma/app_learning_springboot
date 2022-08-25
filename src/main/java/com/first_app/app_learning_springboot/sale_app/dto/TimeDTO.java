package com.first_app.app_learning_springboot.sale_app.dto;

public class TimeDTO {
    private Integer month;
    private Integer quarter;
    private Integer year;

    public TimeDTO() {}

    public TimeDTO(Integer month, Integer quarter, Integer year) {
        this.month = month;
        this.quarter = quarter;
        this.year = year;
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
}
