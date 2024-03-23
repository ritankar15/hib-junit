package com.hibjunit.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="patient_details")
@NamedEntityGraph(name = "PatientDetails.visits",
        attributeNodes = @NamedAttributeNode("visits")
)
public class PatientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private Boolean deleteflag;
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private PatientContacts contacts;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PatientVisitHistory> visits;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public PatientContacts getContacts() {
        return contacts;
    }

    public void setContacts(PatientContacts contacts) {
        this.contacts = contacts;
    }

    public List<PatientVisitHistory> getVisits() {
        return visits;
    }

    public void setVisits(List<PatientVisitHistory> visits) {
        this.visits = visits;
    }
}
