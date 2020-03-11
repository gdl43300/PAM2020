package fr.isima.gudaniel1.pam2020;

import java.io.Serializable;

public class Comic implements Serializable {

    private  static  final  long serialVersionUID =  1350092881346723535L;

    public int num;
    public String day;
    public String month;
    public String year;
    public String title;
    public String img;

    public Comic() {
    }

    public Comic(int num, String day, String month, String year, String title, String img) {
        this.num = num;
        this.day = day;
        this.month = month;
        this.year = year;
        this.title = title;
        this.img = img;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "num=" + num +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
