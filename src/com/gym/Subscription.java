package com.gym;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subscription {
    private int id;//same id of customer
    public int assigned_coach_id;
    public Membership_plan member_plan;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean hasSubscriptionForCoach(int coachId) {
        return this.assigned_coach_id == coachId;
    }

    public Subscription() {
    }

    public Subscription(int id, int assigned_coach_id, Membership_plan member_plan) {
        this.id = id;
        this.assigned_coach_id = assigned_coach_id;
        this.member_plan = member_plan;
    }

    public boolean hasSubscriptionOnDate(LocalDate inputLocalDate) {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        return isDateInRange(inputLocalDate, startDate, endDate);
    }

    private boolean isDateInRange(LocalDate dateToCheck, LocalDate startDate, LocalDate endDate) {
        return !dateToCheck.isBefore(startDate) && !dateToCheck.isAfter(endDate);
    }

    public LocalDate getStartDate() {
        return LocalDate.of(2023, 1, 1);
    }

    public static void showSubscriptionHistory(ArrayList<Customer> customers, ArrayList<Membership_plan> membershipPlans) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a customer to display subscription history:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }

        try {
            int customerIndex = scanner.nextInt();
            if (customerIndex >= 1 && customerIndex <= customers.size()) {
                Customer selectedCustomer = customers.get(customerIndex - 1);
                System.out.println("Subscription history for " + selectedCustomer.getName() + ":");
                for (Membership_plan plan : membershipPlans) {
                    if (plan.getCustomer().equals(selectedCustomer)) {
                        System.out.println("Start Date: " + plan.getStartDate() +
                                ", Payment: " + plan.getPay());
                    }
                }

            } else {
                System.out.println("Invalid customer selection.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid customer number.");
            scanner.nextLine();
        }
    }
}