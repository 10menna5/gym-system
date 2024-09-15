package com.gym;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Membership_plan {
    int id;
    public String start_date ;
    public String month_date;
    public String monthly_plan ;
    public int no_of_months ;
    public int pay;
    private Customer customer;

    public Membership_plan(int id,String start_date,String month_date, String monthly_plan, int no_of_months,int pay) {
        this.id=id;
        this.start_date = start_date;
        this.month_date = month_date;
        this.monthly_plan = monthly_plan;
        this.no_of_months = no_of_months;
        this.pay=pay;

    }



    public Membership_plan(int id, String start_date, String monthly_plan, int no_of_months)
    {
        this.id=id;
        this.start_date = start_date;
        this.monthly_plan = monthly_plan;
        this.no_of_months = no_of_months;
    }



    public Membership_plan(int id,String start_date,String month_date, String monthly_plan, int no_of_months,int pay, Customer customer) {
        this.id=id;
        this.start_date = start_date;
        this.month_date = month_date;
        this.monthly_plan = monthly_plan;
        this.no_of_months = no_of_months;
        this.pay=pay;
        this.customer= customer;

    }
    public String getStartDate() {
        return start_date;
    }
    public int getPay() {
        return pay;
    }
    public Customer getCustomer() {
        return customer;
    }

    public Membership_plan() {
    }

    // @Override
//    public String toString() {
//        return "Membership_plan{" +
//                "id='"+ id+ '\'' +
//                ", start_date='" + start_date + '\'' +
//                ", month_date='" + month_date + '\'' +
//                ", monthly_plan='" + monthly_plan + '\'' +
//                ", no_of_months=" + no_of_months +
//                '}';
//    }
    public static void membership_plan_details(ArrayList<Membership_plan> m) {
        System.out.println("enter your id");
        Scanner X=new Scanner(System.in);
        int memb= X.nextInt();
        for (int i = 0; i < m.size(); i++) {

            if (memb== m.get(i).id) {

                System.out.println(m.get(i).toString());
            }
        }

    }    public String toString() {
        return id+"," +start_date+","+month_date+","+monthly_plan+","+no_of_months+","+pay ;

    }
    public static void write_to_file(ArrayList<Membership_plan> m1) {
        try (FileWriter writer = new FileWriter("Member_Plan.txt")) {
            for(int i=0;i<m1.size();i++)
            {
                writer.write(m1.get(i) + System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Membership_plan> read_from_file() {
        ArrayList<Membership_plan> Mem=new ArrayList<>();
        try{
            File file =new File("Member_Plan.txt");
            Scanner readFlie =new Scanner(file);
            StringTokenizer token =null;

            while (readFlie.hasNextLine()) {
                token = new StringTokenizer(readFlie.nextLine(),",");
                int id= Integer.parseInt(token.nextToken());

                String start_date= token.nextToken();
                String month_date= token.nextToken();
                String monthly_plan= token.nextToken();


                int no_of_months= Integer.parseInt(token.nextToken());
                int pay= Integer.parseInt(token.nextToken());
                Membership_plan me = new Membership_plan(id,start_date,month_date,monthly_plan,no_of_months,pay);

                Mem.add(me);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Mem;

    }


}