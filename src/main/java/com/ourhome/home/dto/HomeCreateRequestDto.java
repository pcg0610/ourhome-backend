package com.ourhome.home.dto;

import com.ourhome.home.util.Coord;
import com.ourhome.home.util.HomeType;

public class HomeCreateRequestDto {

    private String name;

    private HomeType type;

    private String address;

    private int buildYear;

    private int jeonsae;

    private String monthlyDeposit;

    private String monthlyPay;

    private double area;

    private Coord coord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HomeType getType() {
        return type;
    }

    public void setType(HomeType type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public int getJeonsae() {
        return jeonsae;
    }

    public void setJeonsae(int jeonsae) {
        this.jeonsae = jeonsae;
    }

    public String getMonthlyDeposit() {
        return monthlyDeposit;
    }

    public void setMonthlyDeposit(String monthlyDeposit) {
        this.monthlyDeposit = monthlyDeposit;
    }

    public String getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(String monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

}
