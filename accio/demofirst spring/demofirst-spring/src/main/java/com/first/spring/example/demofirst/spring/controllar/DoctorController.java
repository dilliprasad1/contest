package com.simpleproject.hospital_management.controller;

import com.simpleproject.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    // spring boot APIs -> takes input in the form of JSON (javascript object notation)

    // here we use hashmap as for storing the data in memory.
    HashMap<Integer, Doctor> doctorDbHashMap = new HashMap<>();

    // 101->{101,"ajay","ajay@gmail.com","9287628111","dentist"}
    // 102->{102,"aowow","ajay@gmail.com","9287628111","dentist"}
    // 103->{103,"aopapap","ajay@gmail.com","9287628111","dentist"}
    // 104->{104,"pepeppepe","ajay@gmail.com","9287628111","dentist"}


    //@RequestBody - it takes the input from postman or ui and assigns it to the doctor object
    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor){
        doctorDbHashMap.put(doctor.getId(),doctor);
        System.out.println(doctorDbHashMap);
        return "Doctor saved successfully";
    }

    @GetMapping("/findAll")
    public HashMap<Integer, Doctor> getAllDoctor(){
        return doctorDbHashMap;
    }

    //@PathVariable - takes the input in the api endpoint/url path
    @GetMapping("/find/{id}")
    public Doctor getDoctorById(@PathVariable int id){
        Doctor doctor = doctorDbHashMap.get(id);
        return doctor;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctorById(@PathVariable int id){
        doctorDbHashMap.remove(id);
        return "Doctor deleted Successfully";
    }

    @PutMapping("/update/{id}")
    public String updateDoctor( @PathVariable int id,@RequestBody Doctor doctor){
        // check if doctor id is present or not
        // if present update
        // else no update

        Doctor doctor1 = doctorDbHashMap.get(id);
        if(doctor1!=null){
            // update details
            doctorDbHashMap.put(id,doctor);
            return "Doctor updated successfully";
        } else{
            return "Doctor not found with that id : "+id ;
        }
    }

}
