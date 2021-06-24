package com.example.HospitalApp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="patient")
public class Patient {


    @Id
    @Column(name="pid")
    private int pid;
    @Column(name="pname")
    private String pname;
    @Column(name="emailid")
    private String emailid;
    @Column(name="password")
    private String password;
    @Column(name="symptoms")
    private String symptoms;

    @Column(name="slot1")
    private int slot1;
    @Column(name="slot2")
    private int slot2;
    @Column(name="age")
    private int age;

    @Column(name="prescription")
    private String prescription;

    public int getSlot1() {
        return slot1;
    }
    public void setSlot1(int slot1) {
        this.slot1 = slot1;
    }
    public int getSlot2() {
        return slot2;
    }
    public void setSlot2(int slot2) {
        this.slot2 = slot2;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getEmailid() {
        return emailid;
    }
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

}