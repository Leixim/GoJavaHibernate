package com.gojava.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private int developerID;

    @Column(name = "dev_name")
    private String developerName;

    @Column(name = "dev_salary")
    private int developerSalary;

    @Column(name = "company_id")
    private int companyID;

    public int getDeveloperID() {
        return developerID;
    }

    public void setDeveloperID(int developerID) {
        this.developerID = developerID;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public int getDeveloperSalary() {
        return developerSalary;
    }

    public void setDeveloperSalary(int developerSalary) {
        this.developerSalary = developerSalary;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    @Override
    public String toString() {
        return developerID + " " + developerName + " " + developerSalary + " " + companyID;
    }
}
