package org.doctorapp.service;

import org.doctorapp.exceptions.DoctorNotFoundException;
import org.doctorapp.model.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface IDoctorService {
    void addDoctor(Doctor doctor);
    void updateDoctor(int doctorId,double fees);
    void deleteDoctor(int doctorId) throws DoctorNotFoundException;


    Doctor getById(int doctorId) throws DoctorNotFoundException;
    List<Doctor> getAll();
    List<Doctor> getBySpecialist(String speciality) throws DoctorNotFoundException, SQLException;
    List<Doctor> getBySpecialityAndExp(String speciality,int experience) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndRatings(String speciality,int ratings) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndNameContains(String speciality,String doctorName) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndFees(String speciality,double fees) throws DoctorNotFoundException;


}
