package com.gym;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gym  {
    public String name;
    public String address ;
    private int phone_no ;
    public String sport_equipement ;
    public Coaches[] coaches ;
    public Subscription subscription ;

    public int getPrivate_no() {
        return phone_no;
    }

    public void setPrivate_no(int private_no) {
        this.phone_no = private_no;
    }

    public Gym(String name, String address, int phone_no, String sport_equipement, Coaches[] coaches, Subscription subscription) {
        this.name = name;
        this.address = address;
        this.phone_no = phone_no;
        this.sport_equipement = sport_equipement;
        this.coaches = coaches;
        this.subscription = subscription;
    }

    public Gym() {
    }

    public static void weight_loss_calculator(double weight, double height, String gender) {
        double x, w;


        if (gender.toLowerCase().equals("male")) {
            x = 48 + 1.1 * (height - 150);
            w = weight - x;
        } else {
            x = 48 + 0.9 * (height - 150);
            w = weight - x;
        }
        if (w > 0)
            System.out.println("amount of kilos you should lose is: " + w + " kilos");
        else if (w < 0)
            System.out.println("amount of kilos you should gain is: " + w + " kilos");
        else
            System.out.println("you're on the ideal weight");

    }
    public static void displayGymIncome(ArrayList<Customer> cust, ArrayList<Membership_plan> m) {
        double sum = 0;
        double sumMonth = 0;

        for (Customer c : cust) {
            sum += c.pay;
        }

        Scanner in = new Scanner(System.in);

        String month = null;

        // Handle invalid input with try-catch
        boolean isValidInput = false;
        do {
            try {
                System.out.println("What is the month you would like to display? \n");
                month = in.next();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid month.");
                in.next(); // consume the invalid input to prevent an infinite loop
            }
        } while (!isValidInput);

        for (Membership_plan m_p : m) {
            if (month.equals(m_p.month_date)) {
                sumMonth += m_p.pay;
            }
        }

        System.out.println("The income in this month is: " + sumMonth);
    }
    public static int calcpayment(int months) {
        int payment;
        if (months <= 3) {
            payment = months * 700;
        } else {
            payment = months * 400;
        }
        System.out.println("You have to pay: " + payment);
        return payment;
    }
}