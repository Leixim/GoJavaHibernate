package com.gojava.hibernate.dao;

import com.gojava.hibernate.CRUD;
import com.gojava.hibernate.Connector;
import com.gojava.hibernate.entity.Project;
import com.gojava.hibernate.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class ProjectDAO implements CRUD {
    Scanner scanner = new Scanner(System.in);
    private Project project;

    @Override
    public Object getByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter project ID to find into database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            project = session.get(Project.class, ID);
            transaction.commit();
            if (project != null) {
                System.out.println(project);
                return project;
            } else {
                System.out.println("Project with this id is missing");
                return project;
            }

        } finally {
            session.close();
        }
    }


    @Override
    public List<Project> getAll() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Project> projects = session.createQuery("FROM  Project ").list();
            transaction.commit();
            for (Project prj : projects) {
                System.out.println(prj);
            }
            return projects;
        } finally {
            session.close();
        }
    }

    @Override
    public void create() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter project ID");
        int projectID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter project name");
        String projectName = scanner.nextLine();
        System.out.println("Enter project cost");
        int projectCost = scanner.nextInt();
        System.out.println("Enter company ID");
        int companyID = scanner.nextInt();
        System.out.println("Enter customer ID");
        int customerID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            project = new Project();
            project.setProjectID(projectID);
            project.setProjectName(projectName);
            project.setProjectCost(projectCost);
            project.setCompanyID(companyID);
            project.setCustomerID(customerID);
            session.save(project);
            transaction.commit();

        } finally {
            session.close();
        }


    }

    @Override
    public void deleteByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter project ID to delete from database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            project = session.get(Project.class, ID);
            session.delete(project);
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
            Query query = session.createQuery("DELETE FROM Project");
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
        System.out.println("Enter project ID to update");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new project ID");
        int projectID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter project name");
        String projectName = scanner.nextLine();
        System.out.println("Enter project cost");
        int projectCost = scanner.nextInt();
        System.out.println("Enter company ID");
        int companyID = scanner.nextInt();
        System.out.println("Enter customer ID");
        int customerID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            project.setProjectID(projectID);
            project.setProjectName(projectName);
            project.setProjectCost(projectCost);
            project.setCompanyID(companyID);
            project.setCustomerID(customerID);
            session.save(project);
            transaction.commit();

        } finally {
            session.close();
        }
    }
}
