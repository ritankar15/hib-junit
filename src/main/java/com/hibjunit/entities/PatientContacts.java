package com.hibjunit.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="patient_contacts")
public class PatientContacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String mobile;
    private Boolean deleteflag;
    @OneToOne
    private PatientDetails patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public PatientDetails getPatient() {
        return patient;
    }

    public void setPatient(PatientDetails patient) {
        this.patient = patient;
    }
}
