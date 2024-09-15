

        package Main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;




import com.gym.*;

import java.util.Scanner;

public class main {
    //for calling methods

    public static Gym gym=new Gym();
    public static Customer customer=new Customer("","","","","","");
    public static Coaches coach=new Coaches("","","","","","");
    public static Membership_plan mem=new Membership_plan();
    public static equipements equipments=new equipements();
    public static     Inbody n =new Inbody();
    public static Subscription subscription=new Subscription();
    //////////
    public static ArrayList<Customer> customerlist = new ArrayList<Customer>();
    public static ArrayList<Coaches> coachlist = new ArrayList<Coaches>();
    static ArrayList<equipements> eq = new ArrayList<>();
    static ArrayList<Membership_plan> m = new ArrayList<>();
    public static ArrayList<Inbody> nbody=new ArrayList<>();
    public static Receptionist admin ;
    public static ArrayList<Customer> customerrequastmessage = new ArrayList<Customer>();
    public static ArrayList<Coaches> coachrquastmessage = new ArrayList<Coaches>();
    static String[] args = {};
    public static void main(String[] args) {
       /* customerlist=Customer.read_from_file();
        coachlist=Coaches.read_from_file();
        admin=Receptionist.read_from_file();
        eq=equipements.read_from_file();
        m=Membership_plan.read_from_file();
        nbody=Inbody.read_from_file();
        customerrequastmessage=Customer.readreq_from_file();
        coachrquastmessage=Coaches.readreq_from_file();*/

        admin= new Receptionist(1, "admin", "female", "cairo", "012225", "admin@gym", "admin1");

        nbody.add(0,new Inbody(12,"1/10/2023",151,59.5f,0.3f,0.2f,0.6f,0.3f));
        nbody.add(1,new Inbody(12,"1/11/2023",161,69.5f,0.3f,0.2f,0.6f,0.3f));

        nbody.add(2, new Inbody(151, "1/10/2023", 59.5f, 0.3f, 0.2f, 0.6f, 0.3f,0.7f));
        nbody.add(3, new Inbody(161, "1/11/2023", 69.5f, 0.3f, 0.2f, 0.6f, 0.3f,0.7f));

        customerlist.add(0, new Customer(12, "mo", "male", "cairo", "maadi", "010110", "@", 700, 0));
       customerlist.get(0).inbody=nbody;
         customerlist.add(1, new Customer(13, "mazen", "male", "cairo", "maadi", "010110", "@", 1400, 0));
         customerlist.add(2, new Customer(14, "malak", "female", "cairo", "maadi", "010110", "@", 2100, 0));

        m.add(0,new Membership_plan(12,"2023-02-01","2","",1,700,customerlist.get(0)));
        m.add(1,new Membership_plan(13,"2023-04-03","4","",2,1400,customerlist.get(1)));
        m.add(2,new Membership_plan(14,"2023-05-15","5","",3,2100,customerlist.get(2)));


       coachlist.add(0, new Coaches("ahmed", "male", "helwan", "0155", "@yahoo", "415", 0,8));
        coachlist.add(1, new Coaches("Ayman", "male", "helwan", "0155", "@yahoo", "415", 1,7));
        coachlist.add(2, new Coaches("Mirna", "female", "cairo", "01288", "@gmail", "567", 2,12));
       coachlist.add(3, new Coaches("yassmina", "female", "first settlement", "018878", "@gmail55", "456", 3,6));
       coachlist.add(4, new Coaches("mohamed", "male", "helwan", "011111", "@yahoo44", "678", 4,4));

        ArrayList<Coaches> coachesList = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            Customer customer1 = new Customer(100, "Mirna", "Giza", "female", "mirna1@gmail.com", "0109955221", "1234");
            Customer customer2 = new Customer(101, "Sama", "Cairo", "female", "sama@gmail.com", "0118866551", "3344");

            coachlist.get(i).addCustomer(customer1);
            coachlist.get(i).addCustomer(customer2);
            coachesList.add(coachlist.get(i));
        }

coachesList.get(0).addCustomer(customerlist.get(0) );

        eq.add(0, new equipements("bench press", 234, 5));
        eq.add(1, new equipements("calf machine", 235, 4));
        eq.add(2, new equipements("treadmill", 354, 7));
        eq.add(3, new equipements("excersise bike", 234, 8));
        eq.add(4, new equipements("squat rack", 521, 9));
        eq.add(5, new equipements("inversion table", 234, 6));
        eq.add(6, new equipements("power tower", 239, 7));
        eq.add(7, new equipements("stability ball", 2341, 3));
        eq.add(8, new equipements("smith machine", 237, 3));
        eq.add(9, new equipements("vertical climber machine", 247, 8));

        Scanner in = new Scanner(System.in);


        System.out.println("What would you like to do?");
        System.out.println("1-sign up ");
        System.out.println("2-sign in ");
        System.out.println("3-log out ");
        int sign_choice = in.nextInt();
        switch (sign_choice) {
            case 1:
                signup();
                break;
            case 2:
                signin();
                break;
            case 3:
                System.exit(0);
            default:
            {
                System.out.println("Invalid choice");
                main(args);
            }}


     /*   Customer.write_to_file(customerlist);
        Coaches.write_to_file(coachlist);
        Receptionist.write_to_file(admin);
        equipements.write_to_file(eq);
        Membership_plan.write_to_file(m);
        Inbody.write_to_file(nbody);
        Customer.writereq_to_file(customerrequastmessage);
        Coaches.writereq_to_file(coachrquastmessage);*/

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////end main
    public static ArrayList<Subscription> subscriptionlist = new ArrayList<Subscription>();

    static void signup()
    {

        System.out.println("please choose if you want sign up as 1)customer or 2)coach  ");

        Scanner input = new Scanner(System.in);
        char choose = input.next().charAt(0);


        switch (choose) {
            case '1':
                System.out.println("please enter your email , your name and strong password in order ");
                String email = input.next();
                String name = input.next();
                String password = input.next();

                System.out.println(" enter your gender , address , phone in order ");
                String gender = input.next();
                String address = input.next();
                String phone = input.next();

                System.out.println("how many months would you like to reserve?");
                int months = input.nextInt();
                int payment = gym.calcpayment(months);


                System.out.println("back in function");
                Customer customerobject = new Customer(  name, gender, address, phone, email,password);

                customerrequastmessage.add(customerobject);

                System.out.println("please wait the admin to accept you ............");
                System.out.println("press enter to continue");

wait_for_enter();
                main(args);


                break;
            case '2' :
                System.out.println("please enter your email , your name and strong password in order ");
                String coachemail = input.next();
                String coachname = input.next();
                String coachpassword = input.next();

                System.out.println(" enter your gender , address , phone in order ");
                String coachgender = input.next();
                String coachaddress = input.next();
                String coachphone = input.next();

                Coaches coachobject = new Coaches(coachname, coachgender, coachaddress, coachphone, coachemail, coachpassword);

                coachrquastmessage.add(coachobject);
                System.out.println("please wait the admin to accept you ............");
                System.out.println("press enter to continue");
                 wait_for_enter();

                main(args);

                break;

            default:
                System.out.println("invalid choose !! \nPlease choose again ");
                signup();
        }

    }
    public static void signin() {
        // the size in the first time only will be zero after that it will be stored in the file
        System.out.println("please enter your name and password in order");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        String password = input.next();
        boolean found = false;

        if (name.toLowerCase().equals(admin.name)) {
            found = true;
            System.out.println(" admin signing in ...........");
            adminfunctions();
        }

        if (!found)

        {
            if (customerlist.isEmpty())
            {

            }
            else
            {

                for (Customer c : customerlist) {
                    if (c.getPassword().equals(password) && c.name.toLowerCase().equals(name)) {

                        found = true;
                        System.out.println("~found ~*(:");
                        System.out.println(" customer signing in ...........");
                        System.out.println("hey customer: "+name  );
                        customerfunctions();
                        break;
                    }
                }
            }
        }

        if (!found)
        {
            if(coachlist.isEmpty())
            {}
            else
            {
                for (Coaches o : coachlist)
                {
                    if (o.getPassword().equals(password) && o.name.toLowerCase().equals(name))
                    {
                        System.out.println("~found ~*(:");
                        System.out.println(" coach signing in ...........");
                        System.out.println("hey coach: "+name );
                        coachfunctions();
                        found = true;
                        break;
                    }
                }
            }

        }


        if (!found) {
            System.out.println("wronge password or name !!\n_try again ? press 1 \n_create new account ? press 2 ");
            System.out.println("back ? press 3");
            int c = input.nextInt();
            switch (c) {
                case 1:
                    signin();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    main(args);

            }

        }



    }

    ///////////////////////////////////////////////////////////////////////////////admin function
    public static void adminfunctions(){
        Scanner in = new Scanner(System.in);

        System.out.println("~");
        boolean check;
        do{
            check =false;
            System.out.println("~ Welcome Admin ~");
            System.out.println("What would you like to do?");
            System.out.println("1 - Manage Coaches");
            System.out.println("2 - Manage Equipments");
            System.out.println("3 - Manage Customers");
            System.out.println("4 - Show Subscription History for a Customer");
            System.out.println("5 - Display Customers in a Given Month/Day");
            System.out.println("6 - Display Customers of a Specific Coach");
            System.out.println("7 - Display Gym Income in a Given Month");
            System.out.println("8 - Display Coaches Sorted by Assigned Customers");

            int adminChoice = in.nextInt();
            switch (adminChoice) {
                case 1:
                    manageCoaches(coachlist);
                    check=logout();
                    break;
                case 2:
                    manageEquipments(eq);check=logout();
                    break;
                case 3:
                    manageCustomers(customerlist);

                    check=logout();
                    break;
                case 4:
                    subscription.showSubscriptionHistory(customerlist,m);
                    check=logout();
                    break;
                case 5:
                    customer.displayCustomersInGivenDate(m);
                    check=logout();
                    break;
                case 6:

                    displayCustomersOfSpecificCoach(coachlist);
                    check=logout();
                    break;
                case 7:
                    gym.displayGymIncome(customerlist, m);
                    check=logout();
                    break;
                case 8:
                    displayCoachesSortedByAssignedCustomers(coachlist  );
                    check=logout();
                    break;
                default:
                    System.out.println("Invalid choice");
                    check=true;
            }}while(check);
main(args);
    }

    public static void manageCoaches(ArrayList<Coaches> c) {
        Scanner in = new Scanner(System.in);
        System.out.println("What would you like to do with coaches?");
        System.out.println("1 - Add Coach");
        System.out.println("2 - Edit Coach");
        System.out.println("3 - Delete Coach");
        System.out.println("4 - back to admin functions");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                addCoach();
                break;
            case 2:
                editCoach();
                break;
            case 3:
                deleteCoach(c);
                break;
            case 4 : adminfunctions();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void addCoach() {

        int ID;
        if (coachrquastmessage.isEmpty()) {
            System.out.println("there is no coaches to add ");
        }
        else
        {

            for (Coaches c : coachrquastmessage) {
                System.out.println(c.showinfo());
                System.out.println(" enter y to add the coach above \n" +
                        " any thing else  to delete/ unaccepted  the coach above ");
                Scanner in = new Scanner(System.in);
                String choose = in.next();
                switch (choose) {
                    case "y":
                    case "Y":
                        ID=calc_id_for_coach(coachlist);
                        System.out.println("the current id is "+ ID);
                        c.setId(ID);
                        coachlist.add(c);
                        System.out.println("the coach id is "+coachlist.get(ID-1).getId() );

                        System.out.println("Coach added successfully!");
                        wait_for_enter();
                }
            }

            coachrquastmessage .clear();


        }


    }

    public static void editCoach() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Coach Name to Edit:");
            String coachName = in.nextLine();
            Coaches coachToEdit = coach.findCoachByName(coachName);

            if (coachToEdit != null) {
                System.out.println("Enter New Coach Name:");
                String newCoachName = in.nextLine();
                coachToEdit.name = newCoachName;
                System.out.println("Coach edited successfully!");
            } else {
                System.out.println("Coach not found!");
            }
            manageCoaches(coachlist);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid coach name.");
            in.nextLine(); // Consume the invalid input

        }
    }
    public static void deleteCoach(ArrayList<Coaches> coach) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Coach Name to Delete:");
            String coachName = in.nextLine();
            boolean isDeleted = false;

            for (int i = 0; i < coach.size(); i++) {
                if (coach.get(i).name.equals(coachName)) {
                    coach.remove(i);
                    isDeleted = true;
                    System.out.println("Coach deleted successfully!");
                    break;
                }
            }

            if (!isDeleted) {
                System.out.println("Coach not found!");
            }


        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid coach name.");
            in.nextLine();

        }
    }
    public static void manageCustomers(ArrayList<Customer> c) {
        Scanner in = new Scanner(System.in);
        System.out.println("What would you like to do with customers?");
        System.out.println("1 - Add Customer");
        System.out.println("2 - Edit Customer");
        System.out.println("3 - Delete Customer");
        System.out.println("4 - back to admin function");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                addCustomer(c);
                break;
            case 2:
                editCustomer();
                break;
            case 3:
                deleteCustomer(c);
                break;
            case 4 :
                adminfunctions();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void editCustomer() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Customer Name to Edit:");
            String customerName = in.nextLine();
            Customer customerToEdit = customer.findCustomerByName(customerName);

            if (customerToEdit != null) {
                System.out.println("Enter New Customer Name:");
                String newCustomerName = in.nextLine();
                customerToEdit.name = newCustomerName;
                System.out.println("Customer edited successfully!");
            } else {
                System.out.println("Customer not found!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid customer name.");
            in.nextLine();
        }
    }
    public static void addCustomer(ArrayList<Customer> customer) {
        int currentid;

        if (customerrequastmessage.isEmpty()) {
            System.out.println("there is no customer to add ");
        } else {

            for (Customer c : customerrequastmessage) {
                System.out.println(c.showinfo());
                System.out.println(" enter y to add the customer above \n any thing alse  to delete/ unaccepted  the customer above ");
                Scanner in = new Scanner(System.in);
                String choose = in.next();
                switch (choose) {
                    case "y":
                    case "Y":
                        currentid=calc_id_for_customer(customerlist);

                        c.setId(currentid);

                        customerlist.add(c);
                      //  System.out.println("customer id ="+customerlist.get(currentid-1 ).getId() );
                     //   displayCoachesSortedByAssignedCustomers(coachlist);
                        System.out.println("Enter assigned coach id:");

                        int coach_id = in.nextInt();
                        Objects.requireNonNull(Coaches.findCoachById(coachlist, coach_id)).addCustomer(c);
                        System.out.println("enter the membership_plan : start date , monthly plan , number of month in order");
                        Membership_plan mum_plan = new Membership_plan(c.getId() , in.next(), in.next(), in.nextInt());
                        m.add(mum_plan);
                      //  subscriptionlist.add(new Subscription(c.getId(), coach_id, mum_plan));
                        System.out.println("Customer added successfully!");
                        System.out.println("press enter to continue");

                        wait_for_enter();

                }
            }

            customerrequastmessage .clear();
        }

    }

    public static boolean deleteCustomer(ArrayList<Customer> c) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Customer Name to Delete:");
            String customerName = in.nextLine();

            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).name.equals(customerName)) {
                    c.remove(i);
                    System.out.println("Customer deleted successfully.");
                    return true;
                }
            }

            System.out.println("Customer not found!");
            return false;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid customer name.");
            in.nextLine();
            return false;
        }
    }


    public static void manageEquipments(ArrayList<equipements> q) {
        Scanner in = new Scanner(System.in);
        System.out.println("What would you like to do with equipments?");
        System.out.println("1 - Add Equipment");
        System.out.println("2 - Edit Equipment");
        System.out.println("3 - Delete Equipment");
        System.out.println("4 - back to admin function");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                addEquipment(q);
                break;
            case 2:
                editEquipment();
                break;
            case 3:
                deleteEquipment(q);
                break;
            case 4:
                adminfunctions();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void addEquipment(ArrayList<equipements> q) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Equipment Name:");
            String equipmentName = in.nextLine();

            System.out.println("Enter Equipment Code:");
            int equipmentCode = in.nextInt();

            System.out.println("Enter Equipment Quantity:");
            int equipmentQuantity = in.nextInt();

            equipements newEquipment = new equipements(equipmentName, equipmentCode, equipmentQuantity);
            q.add(newEquipment);
            System.out.println("Equipment added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data for equipment.");
            in.nextLine();

        }
    }
    public static void editEquipment() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Equipment Name to Edit:");
            String equipmentName = in.nextLine();
            ArrayList<equipements> eq = new ArrayList<>();
            equipements equipmentToEdit = equipments.findEquipmentByName(eq, equipmentName);

            if (equipmentToEdit != null) {
                System.out.println("Enter New Equipment Name:");
                String newEquipmentName = in.nextLine();

                System.out.println("Enter New Equipment Quantity:");
                int newEquipmentQ = in.nextInt();

                equipmentToEdit.name = newEquipmentName;
                equipmentToEdit.quantity = newEquipmentQ;
                System.out.println("Equipment edited successfully!");
            } else {
                System.out.println("Equipment not found!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data for equipment.");
            in.nextLine();
        }
    }
    public static boolean deleteEquipment(ArrayList<equipements> eq) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Equipment Name to Delete:");
            String equipmentName = in.nextLine();

            boolean isDeleted = false;

            for (int i = 0; i < eq.size(); i++) {
                if (eq.get(i).name.equals(equipmentName)) {
                    eq.remove(i);
                    System.out.println("Equipment deleted successfully.");
                    return true;
                }
            }

            System.out.println("Equipment not found!");
            return false;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid equipment name.");
            in.nextLine(); // Consume the invalid input
            return false;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////admin functions above
    //////////////////////////////////////////////////////////////////////////////////////////////////coach  functions under

    public static void coachfunctions()
    {
        Scanner in = new Scanner(System.in);
        boolean check ;
        check=false ;
        do {
            System.out.println("do you want to \n 1-show a list of your customers \n 2-get inbody history of any customer " +
                    "\n 3-get details of customer by name \n 4-show a list of male/female customers");
            System.out.println("~~");
            int y = in.nextInt();
            if (y == 1) {
                displayCustomersOfSpecificCoach(coachlist);
                check=logout();
            }
            else if (y == 2)
            {
                System.out.println("please enter your id");
                y = in.nextInt();
                customer.inbody_history(customerlist, y);
                check=logout();
            } else if (y == 3)
            {
                System.out.println("enter customer name");
                String z = in.next();
                customer.search_customer_by_name(customerlist,z);
                check=logout();

            }
            else if (y == 4)
            {
                System.out.println("do you want to show male or female");
                String z = in.next();
                customer.show_sex(customerlist, z);
                check=logout();

            } else {
                check =true;
                System.out.println("invalid choice");
            }
        }
        while (check);

main(args);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////coach functions above
    //////////////////////////////////////////////////////////////////////////////////////////////////customer  functions under
    public static void customerfunctions()
    {
        Scanner in = new Scanner(System.in);

        boolean check =false;
        do {

            System.out.println("do you want to \n 1- get your coach info \n 2-display gym equipments \n " +
                    "3-display membership plan details \n 4-display inbody info at specific date " +
                    "\n 5- display how many kilos need to be reduced or gained accoding to your body weight");
            System.out.println("~~");
            int y = in.nextInt();
            if (y == 1){
                coach.get_coach_info(coachlist.get(0));
                check=logout();}
            else if (y == 2) {
                equipments.display_equipements(eq);
                check = logout();
            }
            else if (y == 3) {
                mem.membership_plan_details(m);
                check=logout();
            } else if (y == 4) {
                n.inbody_by_date(nbody,"1/10/2023");
                check = logout();
            } else if (y == 5) {
                System.out.println("enter your weight");
                double z = in.nextDouble();
                System.out.println("enter your height");
                double n = in.nextDouble();
                System.out.println("enter your gender");
                String g = in.next();
                gym.weight_loss_calculator(z, n, g);
                check=logout();
            } else{
                System.out.println("invalid choice");
                check=true;
            }

        } while (check);
        main(args);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////customer  functions above

    public static void displayCustomersOfSpecificCoach(ArrayList<Coaches> coachesList) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the ID of the coach: ");
            int coachId = scanner.nextInt();

            Coaches selectedCoach = coach.findCoachById(coachesList, coachId);

            if (selectedCoach != null) {
                customer.displayCustomers(selectedCoach);
            } else {
                System.out.println("Coach not found with the given ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid coach ID.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    public static void displayCoachesSortedByAssignedCustomers( ArrayList<Coaches> coach ) {

        System.out.println("List of Coashes sorted by numOFcustomer :");
        Collections.sort(coach);
        for (Coaches coaches:coach) {
            System.out.println("id: "+ coaches.getId());
            System.out.println("Name: " + coaches.name);
            System.out.println("Number of Customer: " + coaches.numOfCustomer);
        }

    }


    public static boolean logout () {
        boolean check=true;
        System.out.println("do you want  ?\n 1-main menu\n 2-log out");
        Scanner INPUT = new Scanner(System.in);
        int x = INPUT.nextInt();
        if (x == 1) {
            check=true;
        } else if (x == 2) {
            check=false;

        } else {
            System.out.println("invalid choice");
        }
        return check;
    }

    public static int calc_id_for_coach(ArrayList<Coaches> ARRAY ){

        if(ARRAY.isEmpty())
        {
            return 1;
        }else {
            return ARRAY.size()+1;
        }
    }
    public static int calc_id_for_customer(ArrayList<Customer> ARRAY ){

        if(ARRAY.isEmpty())
        {
            return 1;
        }else {
            return ARRAY.size()+1;
        }
    }
    public static void wait_for_enter(){
        Scanner in =new Scanner(System.in);
        in.nextLine();


    }


}
