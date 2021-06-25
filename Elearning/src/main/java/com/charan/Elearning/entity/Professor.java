package com.charan.Elearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="professor")
public class Professor {

    @Id
    @Column(name="pid")
    private int pid;
    @Column(name="pname")
    private String pname;
    @Column(name="emailid")
    private String emailid;
    @Column(name="password")
    private String password;
    @Column(name="department")
    private String department;
    @Column(name="course")
    private String course;
    @Column(name="resources")
    private String resources;

    public String getClassmssg() {
        return classmssg;
    }

    public void setClassmssg(String classmssg) {
        this.classmssg = classmssg;
    }

    @Column(name="classmssg")
    private String classmssg;


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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

}
