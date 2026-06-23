/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.entity;

/**
 *
 * @author olwet
 */
public class Member {
    private String name;
    private String surname;
    private String gender;
    private String idno;
    private String contractsType;
    private Boolean trainer;

    public Member() {
    }

    public Member(String name, String surname, String gender, String idno, String contractsType, Boolean trainer) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.idno = idno;
        this.contractsType = contractsType;
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getContractsType() {
        return contractsType;
    }

    public void setContractsType(String contractsType) {
        this.contractsType = contractsType;
    }

    public Boolean getTrainer() {
        return trainer;
    }

    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }
    
    
    
    
}
