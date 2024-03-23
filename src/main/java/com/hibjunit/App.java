package com.hibjunit;

import com.hibjunit.entities.PatientContacts;
import com.hibjunit.entities.PatientDetails;
import com.hibjunit.entities.PatientVisitHistory;
import com.hibjunit.services.PatientDetailsService;
import com.hibjunit.utilities.AppUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Joi Ma" );
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PatientDetailsService pdService = ctx.getBean("patientdetailsservice", PatientDetailsService.class);
        List<PatientDetails> allPatients = pdService.allPatients();

        for(PatientDetails patient: allPatients){
            System.out.println(patient.getName()+" "+patient.getContacts().getEmail()+" "
                    +patient.getContacts().getMobile());
            for(PatientVisitHistory pv:patient.getVisits()){
                System.out.println(pv.getPatiententry()+" "+pv.getPatientexit());
            }
        }
/*
        PatientDetails pd = new PatientDetails();
        pd.setName("RD");

        PatientContacts pc = new PatientContacts();
        pc.setEmail("rd@sdfs.com");
        pc.setMobile("09867564533");
        pc.setPatient(pd);

        PatientVisitHistory pv1 = new PatientVisitHistory();
        pv1.setPatient(pd);
        pv1.setPatiententry(AppUtils.standardisedDate("22-01-2024 10:15:35 AM"));
        pv1.setPatientexit(AppUtils.standardisedDate("22-01-2024 11:05:59 AM"));

        PatientVisitHistory pv2 = new PatientVisitHistory();
        pv2.setPatient(pd);
        pv2.setPatiententry(AppUtils.standardisedDate("02-01-2024 11:31:12 AM"));
        pv2.setPatientexit(AppUtils.standardisedDate("02-01-2024 11:58:23 AM"));

        List<PatientVisitHistory> visits = new ArrayList<PatientVisitHistory>();
        visits.add(pv1);
        visits.add(pv2);

        pd.setContacts(pc);
        pd.setVisits(visits);
        pdService.savePatient(pd);

 */
    }
}
