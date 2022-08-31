package model;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
    private int id;

    @NotBlank(message = "Tên không được để trống!")
    @Size(min = 2,max = 100,message = "Can nhap ten tu 2 den 100 ky tu")
    private String name;
    @Range(min = 1,max = 150,message = "Tuoi phai tu 1 den 150")
    private int age;
    public Student(){
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

