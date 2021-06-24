package com.example.HospitalApp.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @Column(name="did")
    private int did;
    @Column(name="availability")
    private int availability;
    @Column(name="dname")
    private String dname;
    @Column(name="emailid")
    private String emailid;
    @Column(name="password")
    private String password;
    @Column(name="specialization")
    private String specialization;
    @Column(name="slot")
    private String slot;

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }



    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
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
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public int getAvailability() {
        return availability;
    }
    public void setAvailability(int availability) {
        this.availability = availability;
    }

}
