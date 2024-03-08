package org.doctorapp.service;

import org.doctorapp.exceptions.DoctorNotFoundException;
import org.doctorapp.model.Doctor;
import org.doctorapp.repository.DoctorRepositoryImpl;
import org.doctorapp.repository.IDoctorRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class DoctorServiceImpl implements IDoctorService {

    private IDoctorRepository doctorRepository = new DoctorRepositoryImpl();

    @Override
    public void addDoctor(Doctor doctor) {
        //doctorRepository.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(int doctorId, double fees) {
        doctorRepository.updateDoctor(doctorId,fees);


    }

    @Override
    public void deleteDoctor(int doctorId) {

    }

    @Override
    public Doctor getById(int doctorId) {
        return null;
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialist(String speciality) throws DoctorNotFoundException, SQLException {
        List<Doctor> doctorList = doctorRepository.findBySpecialist(speciality);
        if (doctorList.isEmpty())
            throw new DoctorNotFoundException("Docto with this specialist not found");
        Collections.sort(doctorList, (d1, d2) -> d1.getDoctorName().compareTo(d2.getDoctorName()));

        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.findBySpecialityAndExp(speciality, experience);
        if (doctorList.isEmpty())
            throw new DoctorNotFoundException("Doctor with this specialist and experience not found");
        Collections.sort(doctorList, (d1, d2) -> d2.getDoctorName().compareTo(d1.getDoctorName()));

        return doctorList;

    }

    @Override
    public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) {
        return null;
    }

    @Override
    public List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName) throws DoctorNotFoundException {
        List<Doctor> doctorList= doctorRepository.findBySpecialityAndNameContains(speciality,doctorName);
        if (doctorList.isEmpty())
            throw new DoctorNotFoundException("Doctor with this specialist and Name Contains Not Found");
        Collections.sort(doctorList,(d1,d2)->d2.getDoctorName().compareTo(d1.getDoctorName()));
        return null;
    }
    @Override
    public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository.findBySpecialityAndFees(speciality, fees);
        if (doctorList.isEmpty())
            throw new DoctorNotFoundException("Docto with this specialist and fees not found");
        Collections.sort(doctorList, (d1, d2)-> d2.getDoctorName().compareTo(d1.getDoctorName()));

        return doctorList;
    }


}