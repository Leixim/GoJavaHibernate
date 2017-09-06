package com.gojava.hibernate;

import com.gojava.hibernate.dao.*;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuDataBase() {
        System.out.println();
        System.out.println("***********************************");
        System.out.println("Enter table from InitDB DATABASE");
        System.out.println("-----------------------------------");
        System.out.println(" 1. DEVELOPERS");
        System.out.println(" 2. SKILLS");
        System.out.println(" 3. PROJECTS");
        System.out.println(" 4. COMPANIES");
        System.out.println(" 5. CUSTOMERS");
        System.out.println(" 0. Exit");
        System.out.println("***********************************");
        int menuTable = 0;
        try {
            menuTable = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
        switch (menuTable) {
            case 1:
                DeveloperDAO developers = new DeveloperDAO();
                queryMenu(developers);
                break;
            case 2:
                SkillsDAO skills = new SkillsDAO();
                queryMenu(skills);
                break;
            case 3:
                ProjectDAO projects = new ProjectDAO();
                queryMenu(projects);
                break;
            case 4:
                CompanyDAO companies = new CompanyDAO();
                queryMenu(companies);
                break;
            case 5:
                CustomerDAO customers = new CustomerDAO();
                queryMenu(customers);
                break;
            case (0): {
                System.exit(0);
            }
            default:
                System.out.println("Wrong choice");
                menuDataBase();
        }

    }

    private static void queryMenu(CRUD table) {
        System.out.println("***********************************");
        System.out.println(" 1. Select record by ID");
        System.out.println(" 2. Select all records ");
        System.out.println(" 3. Create record");
        System.out.println(" 4. Update record by ID");
        System.out.println(" 5. Delete record by ID");
        System.out.println(" 6. Delete all records");
        System.out.println(" 8. Previous menu");
        System.out.println(" 0. Exit");
        System.out.println("***********************************");
        int queryMenu = 0;
        try {
            queryMenu = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
        switch (queryMenu) {
            case 1:
                table.getByID();
                menuDataBase();
                break;
            case 2:
                table.getAll();
                menuDataBase();
                break;
            case 3:
                table.create();
                menuDataBase();
                break;
            case 4:
                table.updateByID();
                menuDataBase();
                break;
            case 5:
                table.deleteByID();
                menuDataBase();
                break;
            case 6:
                table.deleteAll();
                menuDataBase();
                break;
            case 8:
                menuDataBase();
                break;
            case (0): {
                System.exit(0);
            }
            default:
                System.out.println("Wrong choice");
                menuDataBase();
        }
    }
}
