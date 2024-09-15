        package com.gym;

import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class  Coaches extends person implements Serializable , Comparable<Coaches>{
    public static ArrayList<Coaches> coachlist =new ArrayList<>();
    public float working_hours;
    public ArrayList<Customer> customers=new ArrayList<>() ;
    static int count_members;
    public   int numOfCustomer ;
    @Override
    public int compareTo(Coaches c)
    {
        return c.numOfCustomer-this.numOfCustomer;
    }

    public void setId(int id) {
        super.setId(id) ;
    }


    public int getId() {return super.getId();}

    public Coaches(String name, String gender, String address, String phone_no, String email, String password, int id, float working_hours) {
        super(name, gender, address, phone_no, email,password);
        super.setId(id);
        this.working_hours = working_hours;
        // this.customers = new ArrayList<>();
    }

    public Coaches(String name, String gender, String address, String phone_no, String email, String password) {
        super(name, gender, address, phone_no, email,password);


    }

    public Coaches(String name, String gender, String address, String phone_no, String email,String password, int id) {
        super(id,name, gender, address, phone_no, email,password);
    }

    public int count_members(){

        return count_members++;
    }
    public void clients() {
        for (int i = 0; i < 11; i++) {

        }
    }






    public void setNumOfCustomer(int numOfCustomer) {
        this.numOfCustomer = numOfCustomer;
    }

    public void addCustomer(Customer customer) {
        if (customers==null) {
            customers = new ArrayList<>();
        }
        customers.add(customer);
        this.numOfCustomer++;
    }

    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    public String showinfo() {
        return "Coach{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static Coaches findCoachById(ArrayList<Coaches> coaches, int coachId) {
        for (Coaches coach : coaches) {
            if (coach.getId() == coachId) {
                return coach;
            }
        }
        return null;
    }
    public static void get_coach_info(Coaches c) {
        System.out.println("here's your coach info");
        System.out.println("name: " + c.name);
        System.out.println("phone number: " + c.phone_no);
        System.out.println("working hours: " + c.working_hours);
    }

    public static Coaches findCoachByName(String coachName) {


        for (Coaches c : coachlist) {
            if (c.name.equalsIgnoreCase(coachName)) {
                return c;
            }
        }
        return null;

    }
    public String toString()
    {
        return name+","+gender+","+address+","+phone_no+","+email+","+getPassword()+","+getId()+","+working_hours;
    }



    public static void write_to_file(ArrayList<Coaches> m1) {
        try (FileWriter writer = new FileWriter("Coaches.txt")) {
            for(int i=0;i<m1.size();i++)
            {
                writer.write(m1.get(i) + System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Coaches> read_from_file() {
        ArrayList<Coaches> coaches = new ArrayList<>();
        try {
            File file = new File("Coaches.txt");
            Scanner readFlie = new Scanner(file);
            StringTokenizer token = null;

            while (readFlie.hasNextLine()) {
                token = new StringTokenizer(readFlie.nextLine(), ",");

                String name = token.nextToken();
                String gander = token.nextToken();
                String address = token.nextToken();
                String phone_no = token.nextToken();
                String email = token.nextToken();
                String password = token.nextToken();
                int id = Integer.parseInt(token.nextToken());
                float working_hours = Float.parseFloat(token.nextToken());
                Coaches coac = new Coaches(name, gander, address, phone_no, email, password, id, working_hours);

                coaches.add(coac);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return coaches;


    }
    public static void writereq_to_file(ArrayList<Coaches> m1) {
        try (FileWriter writer = new FileWriter("coachrquastmessage.txt")) {
            for(int i=0;i<m1.size();i++)
            {
                writer.write(m1.get(i) + System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Coaches> readreq_from_file() {
        ArrayList<Coaches> coaches = new ArrayList<>();
        try {
            File file = new File("coachrquastmessage.txt");
            Scanner readFlie = new Scanner(file);
            StringTokenizer token = null;

            while (readFlie.hasNextLine()) {
                token = new StringTokenizer(readFlie.nextLine(), ",");


                String name = token.nextToken();
                String gander = token.nextToken();
                String address = token.nextToken();
                String phone_no = token.nextToken();
                String email = token.nextToken();
                String password = token.nextToken();
                int id = Integer.parseInt(token.nextToken());
                float working_hours = Float.parseFloat(token.nextToken());
                Coaches coac = new Coaches(name, gander, address, phone_no, email, password, id, working_hours);

                coaches.add(coac);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return coaches;


    }


}