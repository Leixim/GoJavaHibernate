package com.gojava.hibernate.dao;

import com.gojava.hibernate.CRUD;
import com.gojava.hibernate.Connector;
import com.gojava.hibernate.entity.Customer;
import com.gojava.hibernate.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class CustomerDAO implements CRUD {
    Scanner scanner = new Scanner(System.in);
    private Customer customer;

    @Override
    public Object getByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter customer ID to find into database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            customer = session.get(Customer.class, ID);
            transaction.commit();
            if (customer != null) {
                System.out.println(customer);
                return customer;
            } else {
                System.out.println("Customer with this id is missing");
                return customer;
            }

        } finally {
            session.close();
        }
    }


    @Override
    public List<Customer> getAll() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Customer> customers = session.createQuery("FROM  Customer").list();
            transaction.commit();
            for (Customer cust : customers) {
                System.out.println(cust);
            }
            return customers;
        } finally {
            session.close();
        }
    }

    @Override
    public void create() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter customer ID");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter customer name");
        String customerName = scanner.nextLine();
        try {
            transaction = session.beginTransaction();
            customer = new Customer();
            customer.setCustomerID(customerID);
            customer.setCustomerName(customerName);
            session.save(customer);
            transaction.commit();

        } finally {
            session.close();
        }


    }

    @Override
    public void deleteByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter customer ID to delete from database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            customer = session.get(Customer.class, ID);
            session.delete(customer);
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
            Query query = session.createQuery("DELETE FROM Customer");
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
        System.out.println("Enter customer ID to update");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter customer ID");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter customer name");
        String customerName = scanner.nextLine();
        try {
            transaction = session.beginTransaction();
            customer.setCustomerID(customerID);
            customer.setCustomerName(customerName);
            session.save(customer);
            transaction.commit();

        } finally {
            session.close();
        }
    }
}
