package com.gojava.hibernate.dao;

import com.gojava.hibernate.CRUD;
import com.gojava.hibernate.Connector;
import com.gojava.hibernate.entity.Company;
import com.gojava.hibernate.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class CompanyDAO implements CRUD {
    Scanner scanner = new Scanner(System.in);
    private Company company;

    @Override
    public Object getByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter company ID to find into database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            company = session.get(Company.class, ID);
            transaction.commit();
            if (company != null) {
                System.out.println(company);
                return company;
            } else {
                System.out.println("Company with this id is missing");
                return company;
            }

        } finally {
            session.close();
        }
    }


    @Override
    public List<Company> getAll() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Company> companies = session.createQuery("FROM  Company ").list();
            transaction.commit();
            for (Company comp : companies) {
                System.out.println(comp);
            }
            return companies;
        } finally {
            session.close();
        }
    }

    @Override
    public void create() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter company ID");
        int companyID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter company name");
        String companyName = scanner.nextLine();
        try {
            transaction = session.beginTransaction();
            company = new Company();
            company.setCompanyID(companyID);
            company.setCompanyName(companyName);
            session.save(company);
            transaction.commit();

        } finally {
            session.close();
        }


    }

    @Override
    public void deleteByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter company ID to delete from database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            company = session.get(Company.class, ID);
            session.delete(company);
            transaction.commit();

        } finally {
            session.close();
        }
    }

    @Override
    public void deleteAll() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Company ");
            query.executeUpdate();
            transaction.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter company ID to update");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter company ID");
        int companyID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter company name");
        String companyName = scanner.nextLine();
        try {
            transaction = session.beginTransaction();
            company.setCompanyID(companyID);
            company.setCompanyName(companyName);
            session.save(company);
            transaction.commit();

        } finally {
            session.close();
        }
    }
}
