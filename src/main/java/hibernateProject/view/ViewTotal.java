package hibernateProject.view;

import hibernateProject.model.*;

import java.util.Scanner;

public class ViewTotal {
    private static final Scanner SCANNER = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);

    public void printMainMenu() {
        System.out.println("===============");
        System.out.println("MAIN MENU");
        System.out.println("---------------");
        System.out.println("1 - company menu");
        System.out.println("2 - customer menu");
        System.out.println("3 - developer menu");
        System.out.println("4 - project menu");
        System.out.println("5 - skill menu");
        System.out.println("0 - exit");
    }

    public static int inputChoice() {
        System.out.println("Input:\n");
        int result;
        try {
            result = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException ex) {
            result = -1;
        }
        return result;
    }

    public void printControllerMenu() {
        System.out.println("1 - add");
        System.out.println("2 - get by id");
        System.out.println("3 - update");
        System.out.println("4 - remove");
        System.out.println("5 - get all");
        System.out.println("0 - in main menu");
    }
    public Developer setDeveloper() {
        Developer developer;
        System.out.println("Write first name of developer: ");
        String firstName = scanner.nextLine();
        System.out.println("Write second name of developer: ");
        String secondName = scanner.nextLine();
        System.out.println("Write salary of developer: ");
        double salary = 0.00;
        try {
            salary = scanner.nextDouble();
            developer = new Developer();
            developer.setFirstName(firstName);
            developer.setSecondName(secondName);
            developer.setSalary(salary);
            return developer;
        } catch (Exception e) {
            System.out.println("You enter incorrect number");
            scanner.next();
            return setDeveloper();
        }
    }

    public int choiceOfSetSkill() {
        return choiceOfSetEntity("developer's skill");
    }

    public int choiceOfSetDeveloper() {
        return choiceOfSetEntity("developer");
    }

    public int choiceOfSetProject() {
        return choiceOfSetEntity("project");
    }

    public int choiceOfSetEntity(String entity) {
        int choice = 0;
        System.out.println("If you want add " + entity + " enter 1");
        System.out.println("If you want stop entering " + entity + " enter 0");
        try {
            choice = scanner.nextInt();
            return choice;
        } catch (Exception e) {
            System.out.println("You enter incorrect number. Try again");
            return choiceOfSetSkill();
        }
    }
    public Skill setSkill() {
        Skill skill = null;
        System.out.println("Write skill of developer: ");
        skill.setSkill(scanner.nextLine());
        return skill;
    }
    public int getId() {
        int id = 0;
        System.out.println("Enter id of entity: ");
        try {
            id = scanner.nextInt();
            return id;
        } catch (Exception e) {
            System.out.println("You enter not correct number. Try again.");
            scanner.next();
            return getId();
        }
    }
    public Project setProject() {
        Project project = null;
        String name;
        double cost;
        System.out.println("Write project's name: ");
        try {
            name = scanner.nextLine();
            project.setProjectName(name);
        } catch (NullPointerException e) {
            scanner.next();
            setProject();
        }
        System.out.println("Write cost of project: ");
        try {
            cost = scanner.nextDouble();
            project.setCost(cost);
        } catch (Exception e) {
            scanner.next();
            setProject();
        }
        return project;
    }
    public Customer setCustomer() {
        Customer customer = null;
        String customerName;
        System.out.println("Write customer: ");
        try {
            customerName = scanner.nextLine();
            customer.setCustomerName(customerName);
        } catch (NullPointerException e) {
            scanner.next();
            setCustomer();
        }
        return customer;
    }
    public Company setCompany() {
        Company company = null;
        String companyName;
        System.out.println("Write company: ");
        try {
            companyName = scanner.nextLine();
            company.setCompanyName(companyName);
        } catch (NullPointerException e) {
            scanner.next();
            setCompany();
        }
        return company;
    }
}
