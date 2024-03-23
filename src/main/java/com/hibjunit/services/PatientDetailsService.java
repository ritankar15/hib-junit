package com.hibjunit.services;

import com.hibjunit.DAOs.PatientDetailsDao;
import com.hibjunit.entities.PatientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patientdetailsservice")
public class PatientDetailsService {
    @Autowired
    private PatientDetailsDao pdDao;
    public void savePatient(PatientDetails pd){
        this.pdDao.savePatientDetails(pd);
    }
    public List<PatientDetails> allPatients(){
        return this.pdDao.getAllPatientDetails();
    }
}
