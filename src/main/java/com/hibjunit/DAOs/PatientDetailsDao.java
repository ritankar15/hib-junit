package com.hibjunit.DAOs;

import com.hibjunit.entities.PatientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PatientDetailsDao {
    @Autowired
    private HibernateTemplate ht;

    @Transactional
    public void savePatientDetails(PatientDetails pd){
        this.ht.save(pd);
    }

    public PatientDetails getPatientDetails(int id){
        PatientDetails pd = this.ht.get(PatientDetails.class, id);
        return pd;
    }


    public List<PatientDetails> getAllPatientDetails(){
        List<PatientDetails> pd = this.ht.loadAll(PatientDetails.class);
        return pd;
    }
}
