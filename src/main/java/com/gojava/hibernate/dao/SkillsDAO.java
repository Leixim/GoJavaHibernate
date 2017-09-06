package com.gojava.hibernate.dao;

import com.gojava.hibernate.CRUD;
import com.gojava.hibernate.Connector;
import com.gojava.hibernate.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class SkillsDAO implements CRUD {
    Scanner scanner = new Scanner(System.in);
    private Skill skill;

    @Override
    public Object getByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter skill ID to find into database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            skill = session.get(Skill.class, ID);
            transaction.commit();
            if (skill != null) {
                System.out.println(skill);
                return skill;
            } else {
                System.out.println("Skill with this id is missing");
                return skill;
            }

        } finally {
            session.close();
        }
    }


    @Override
    public List<Skill> getAll() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Skill> skills = session.createQuery("FROM  Skill").list();
            transaction.commit();
            for (Skill skill1 : skills) {
                System.out.println(skill1);
            }
            return skills;
        } finally {
            session.close();
        }
    }

    @Override
    public void create() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter skill ID");
        int skillID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter skill name");
        String skillName = scanner.nextLine();
        try {
            transaction = session.beginTransaction();
            skill = new Skill();
            skill.setSkillID(skillID);
            skill.setSkillName(skillName);
            session.save(skill);
            transaction.commit();

        } finally {
            session.close();
        }


    }

    @Override
    public void deleteByID() {
        final Session session = Connector.getSession();
        Transaction transaction = null;
        System.out.println("Enter skill ID to delete from database");
        int ID = scanner.nextInt();
        try {
            transaction = session.beginTransaction();
            skill = session.get(Skill.class, ID);
            session.delete(skill);
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
            Query query = session.createQuery("DELETE FROM Skill ");
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
        System.out.println("Enter skill ID to update");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter skill ID");
        int skillID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter skill name");
        String skillName = scanner.nextLine();
        try {
            transaction = session.beginTransaction();
            skill.setSkillID(skillID);
            skill.setSkillName(skillName);
            session.save(skill);
            transaction.commit();

        } finally {
            session.close();
        }
    }
}
