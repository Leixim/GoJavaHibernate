package com.gojava.hibernate.dao;

import com.gojava.hibernate.CRUD;
import com.gojava.hibernate.Connector;
import com.gojava.hibernate.entity.Developer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class DeveloperDAO implements CRUD {
    Scanner scanner = new Scanner(System.in);
    private Developer developer;

    @Override
    public Object getByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter developer ID to find into database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            developer = session.get(Developer.class, ID);
            transaction.commit();
            if (developer != null) {
                System.out.println(developer);
                return developer;
            } else {
                System.out.println("Developer with this id is missing");
                return developer;
            }

        } finally {
            session.close();
        }
    }


    @Override
    public List<Developer> getAll() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Developer> developers = session.createQuery("FROM  Developer").list();
            transaction.commit();
            for (Developer dev : developers) {
                System.out.println(dev);
            }
            return developers;
        } finally {
            session.close();
        }
    }

    @Override
    public void create() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter developer ID");
        int devID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter developer name");
        String devName = scanner.nextLine();
        System.out.println("Enter developer salary");
        int devSalary = scanner.nextInt();
        System.out.println("Enter developer company ID");
        int devCompany = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            developer = new Developer();
            developer.setDeveloperID(devID);
            developer.setDeveloperName(devName);
            developer.setDeveloperSalary(devSalary);
            developer.setCompanyID(devCompany);
            session.save(developer);
            transaction.commit();

        } finally {
            session.close();
        }


    }

    @Override
    public void deleteByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter developer ID to delete from database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            developer = session.get(Developer.class, ID);
            session.delete(developer);
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
            Query query = session.createQuery("DELETE FROM Developer ");
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
        System.out.println("Enter developer ID to update");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new developer name");
        String devName = scanner.nextLine();
        System.out.println("Enter new developer salary");
        int devSalary = scanner.nextInt();
        System.out.println("Enter new developer company ID");
        int devCompany = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            developer = session.get(Developer.class, ID);
            developer.setDeveloperName(devName);
            developer.setDeveloperSalary(devSalary);
            developer.setCompanyID(devCompany);
            session.save(developer);
            transaction.commit();

        } finally {
            session.close();
        }
    }
}
