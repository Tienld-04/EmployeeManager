package com.dev.ldt.NewSpring.KienTrucSpring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String phone;
    private String address;

    public Employee(){

    }
    
    public Employee(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public Employee(Long id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public String toString() {
        return "id: "+id +"- name: "+ name +"- age: "+age + "- phone: "+phone + "- address: "+address + " ||";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
