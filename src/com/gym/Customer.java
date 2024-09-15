        package com.gym;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Customer extends person implements Serializable {
    protected int id;
    public int pay;
    public static ArrayList<Customer> customerlist = new ArrayList<Customer>();

    private int assignedCoachId;

    public ArrayList<Inbody> inbody;
    public ArrayList<Subscription> subscriptionlist;


    public static int count = 0;


    public Customer(int id, String name, String gender, String address, String phone_no, String email, String password, int pay, int assignedCoachId) {
        super(id, name, gender, address, phone_no, email, password);
        this.id = id;
        this.assignedCoachId = assignedCoachId;
        this.inbody = new ArrayList<>();
        this.subscriptionlist = new ArrayList<>();
        this.pay = pay;
        count++;

    }

    public Customer(int id, String name, String gender, String address, String phone_no, String email, String password, int assignedCoachId) {
        super(name, gender, address, phone_no, email, password);
        this.id = id;
        this.assignedCoachId = assignedCoachId;
        //this.inbody = new ArrayList<>();
        // this.subscriptionlist = new ArrayList<>();
    }


    public Customer(int id, String name, String gender, String address, String phone, String mail, String password) {
        super(id, name, gender, address, phone, mail, password);
    }



    public Customer(String name, String gender, String address, String phone, String mail, String password) {
        super( name, gender, address, phone, mail, password);
    }
    private static Coaches findCoachById(ArrayList<Coaches> coaches, int coachId) {
        for (Coaches coach : coaches) {
            if (coach.getId() == coachId) {
                return coach;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public ArrayList<Inbody> getInbody() {
        return inbody;
    }

    public void setInbody(ArrayList<Inbody> inbody) {
        this.inbody = inbody;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAssignedCoachId() {
        return assignedCoachId;
    }

    public boolean hasSubscriptionOnDate(LocalDate inputLocalDate) {
        for (Subscription subscription : subscriptionlist) {
            if (subscription.hasSubscriptionOnDate(inputLocalDate)) {
                return true;
            }
        }
        return false;
    }

    public void displaySubscriptionHistory() {
        for (Subscription subscription : subscriptionlist) {
            System.out.println("Subscription ID: " + subscription.getId());
            System.out.println("Start Date: " + subscription.getStartDate());
        }
    }



    public void displaySubscriptionHistory(ArrayList <Subscription> sub)
    {
        for (Subscription x :sub)
        {
            if (this.id == x.getId())
            {
                System.out.println("the subscription of customer :"+this.name);
                System.out.println(x.toString());
                break;
            }
        }

    }

    @Override
    public String toString()
    {
        return id+","+name+","+gender+","+address+","+phone_no+","+email+","+getPassword()+","+pay+","+assignedCoachId+",";
    }
    //    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", inbody=" + inbody +
//                ", count=" + count +
//                ", name='" + name + '\'' +
//                ", gender='" + gender + '\'' +
//                ", address='" + address + '\'' +
//                ", phone_no='" + phone_no + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
    public String showinfo() {
        return "Customer{" +
                " name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void show_customers(ArrayList<Customer> c,String n) {

        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i).toString());

        }

    }
    public static void show_sex(ArrayList<Customer> cust, String gend) {

        {
            System.out.println("customers of this gender are:");
            for (int i = 0; i < cust.size(); i++) {
                if (cust.get(i).gender.equals(gend))
                    System.out.println(cust.get(i).name);
            }


        }
    }
    public static void search_customer_by_name(ArrayList <Customer>c, String n) {
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).name.equals(n) ){
                System.out.println(c.get(i).toString());
            }
        }
    }
    public static void displayCustomers(Coaches coach) {
        System.out.println("Customers of Coach " + coach.getName() + ":");
        coach.displayCustomers();
    }
    public static void displayCustomersInGivenDate(ArrayList<Membership_plan> m) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the date (yyyy-MM-dd) to display customers: ");
            String dateString = scanner.next();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate givenDate = LocalDate.parse(dateString, formatter);

            System.out.println("Customers registered on or before " + givenDate + ":");
            boolean customersFound = false;

            for (Membership_plan membership : m) {
                LocalDate membershipStartDate = LocalDate.parse(membership.getStartDate(), formatter);

                if (membershipStartDate.isEqual(givenDate) || membershipStartDate.isBefore(givenDate)) {
                    Customer customer = membership.getCustomer();
                    System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName());
                    customersFound = true;
                }
            }

            if (!customersFound) {
                System.out.println("No customers found on or before " + givenDate);
            }

        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
        }
    }
    public static Customer findCustomerByName(String customerName) {

        for (Customer r : customerlist) {
            if (r.name.equalsIgnoreCase(customerName)) {
                return r;
            }

        }
        return null;


    }
    public static void inbody_history(ArrayList<Customer> cust, int your_id) {
        boolean isbool = false;
        for (int i = 0; i < cust.size(); i++) {
            if (cust.get(i).getId() == (your_id))
                isbool = true;
            System.out.println("here is your inbody history");
            for (int j = 0; j < cust.get(i).inbody.size(); j++) {
                System.out.println(cust.get(i).inbody.get(j).toString());

            }
            break;
        }
        if (isbool == false)
            System.out.println("not found");


    }

    public static void write_to_file(ArrayList<Customer> m1) {
        try (FileWriter writer = new FileWriter("Customer.txt")) {
            for(int i=0;i<m1.size();i++)
            {
                writer.write(m1.get(i) + System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Customer> read_from_file() {
        ArrayList<Customer> customer=new ArrayList<>();
        try{
            File file =new File("Customer.txt");
            Scanner readFlie =new Scanner(file);
            StringTokenizer token =null;

            while (readFlie.hasNextLine()) {
                token = new StringTokenizer(readFlie.nextLine(),",");

                int id= Integer.parseInt(token.nextToken());
                String name= token.nextToken();
                String gander= token.nextToken();
                String address= token.nextToken();
                String phone_no= token.nextToken();
                String email= token.nextToken();
                String password= token.nextToken();
                int pay = Integer.parseInt(token.nextToken());
                int assignedCoachId= Integer.parseInt(token.nextToken());
                Customer custo = new Customer(id,name,gander,address,phone_no,email,password,pay,assignedCoachId);

                customer.add(custo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;

    }
    public static void writereq_to_file(ArrayList<Customer> m1) {
        try (FileWriter writer = new FileWriter("customerrequastmessage.txt")) {
            for(int i=0;i<m1.size();i++)
            {
                writer.write(m1.get(i) + System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Customer> readreq_from_file() {
        ArrayList<Customer> customer=new ArrayList<>();
        try{
            File file =new File("customerrequastmessage.txt");
            Scanner readFlie =new Scanner(file);
            StringTokenizer token =null;

            while (readFlie.hasNextLine()) {
                token = new StringTokenizer(readFlie.nextLine(),",");

                int id= Integer.parseInt(token.nextToken());
                String name= token.nextToken();
                String gander= token.nextToken();
                String address= token.nextToken();
                String phone_no= token.nextToken();
                String email= token.nextToken();
                String password= token.nextToken();
                int pay = Integer.parseInt(token.nextToken());
                int assignedCoachId= Integer.parseInt(token.nextToken());
                Customer custo = new Customer(id,name,gander,address,phone_no,email,password,pay,assignedCoachId);

                customer.add(custo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;

    }

}