
package com.gym;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Receptionist extends person  {
    public float working_hours;




    public Receptionist(int id, String name, String gender, String address, String phone_no, String email, String password, float working_hours) {
        super(id, name, gender, address, phone_no, email, password);
        this.working_hours = working_hours;
    }

    public Receptionist(int id, String name, String gender, String address, String phone_no, String email, String password) {
        super(id, name, gender, address, phone_no, email, password);

    }
    public String toString()
    {
        return name+","+gender+","+address+","+phone_no+","+email+","+getPassword()+","+getId()+","+working_hours;
    }



    public static void write_to_file(Receptionist m1) {
        try (FileWriter writer = new FileWriter("Admin.txt")) {


            writer.write(m1 + System.lineSeparator());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Receptionist read_from_file() {
        Receptionist adm=null;
        try{
            File file =new File("Admin.txt");
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

                float working_hours= Float.parseFloat(token.nextToken());
                adm = new Receptionist(id,name,gander,address,phone_no,email,password,working_hours);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return adm;

    }
    public String showinfo() {
        return "admin{" +
                " name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}