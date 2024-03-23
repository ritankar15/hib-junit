package com.hibjunit.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient_visits")
public class PatientVisitHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date patiententry;
    @Temporal(TemporalType.TIMESTAMP)
    private Date patientexit;
    private Boolean deleteflag;
    @ManyToOne
    private PatientDetails patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPatiententry() {
        return patiententry;
    }

    public void setPatiententry(Date patiententry) {
        this.patiententry = patiententry;
    }

    public Date getPatientexit() {
        return patientexit;
    }

    public void setPatientexit(Date patientexit) {
        this.patientexit = patientexit;
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
