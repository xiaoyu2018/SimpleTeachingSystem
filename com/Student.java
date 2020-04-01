package com;

public class Student implements Comparable<Student>
{
    public String no;
    public String name;
    public String IDKey;
    public int score;
    public String home_add;
    public String native_place;
    public String major;
    public String _class;

    Student() {
    }

    Student(String no,String IDKey,String name,String major,
    String _class,String native_place,String home_add,int score)
    {
        this.no = no;
        this.name = name;
        this.IDKey = IDKey;
        this.score = score;
        this.home_add = home_add;
        this.native_place = native_place;
        this.major = major;
        this._class = _class;
    }
    
    @Override
    public int compareTo(Student o) 
    {
         return this.score>o.score?-1:1;
    }
}