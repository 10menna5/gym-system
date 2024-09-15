        package com.gym;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Inbody {
    int id;
    public String date ;
    public float height ;
    public float t_weight ;
    public float body_fat_mass ;
    public float minirals ;
    public float body_water ;
    public float protien ;
    public static int  count ;

    public Inbody(int id,String date, float height, float t_weight, float body_fat_mass, float minirals, float body_water, float protien) {
        this.id=id;
        this.date = date;
        this.height = height;
        this.t_weight = t_weight;
        this.body_fat_mass = body_fat_mass;
        this.minirals = minirals;
        this.body_water = body_water;
        this.protien = protien;
    }

    public Inbody() {
    }

    //    @Override
//    public String toString() {
//        return "Inbody{" +
//                "date='" + date + '\'' +
//                ", height=" + height +
//                ", t_weight=" + t_weight +
//                ", body_fat_mass=" + body_fat_mass +
//                ", minirals=" + minirals +
//                ", body_water=" + body_water +
//                ", protien=" + protien +
//                '}';
//    }
    @Override
    public String toString() {
        return id +","+date+","+height+","+t_weight+"," +body_fat_mass+","+minirals+","+ ","+body_water +"," +protien;
    }
    public static void write_to_file(ArrayList<Inbody> m1) {
        try (FileWriter writer = new FileWriter("Inbody.txt")) {
            for(int i=0;i<m1.size();i++)
            {
                writer.write(m1.get(i) + System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Inbody> read_from_file() {
        ArrayList<Inbody> IN=new ArrayList<>();
        try{
            File file =new File("Inbody.txt");
            Scanner readFlie =new Scanner(file);
            StringTokenizer token =null;

            while (readFlie.hasNextLine()) {
                token = new StringTokenizer(readFlie.nextLine(),",");
                int id= Integer.parseInt(token.nextToken());

                String date= token.nextToken();
                float height= Float.parseFloat(token.nextToken());
                float t_weight= Float.parseFloat(token.nextToken());
                float body_fat_mass= Float.parseFloat(token.nextToken());
                float minirals= Float.parseFloat(token.nextToken());
                float body_water = Float.parseFloat(token.nextToken());
                float protien= Float.parseFloat(token.nextToken());



                Inbody in = new Inbody(id,date,height,t_weight,body_fat_mass,minirals,body_water,protien);

                IN.add(in);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return IN;

    }
    public static void inbody_by_date(ArrayList<Inbody> in, String date) {
        boolean c=false;
        for (int i = 0; i < in.size(); i++) {
            if (date.equals(in.get(i).date)){
                System.out.println(in.get(i).toString());
                c=true;}

        }
        if(c==false)
            System.out.println("data not found!");
    }
    public static void addInbody(ArrayList<Customer> c, int id) {
        Scanner s = new Scanner(System.in);
        System.out.println("please enter date");
        String d = s.next();
        System.out.println("please enter height");
        float h = s.nextFloat();
        System.out.println("please enter total weight");
        float w = s.nextFloat();
        System.out.println("please enter body fat mass");
        float b_f_m = s.nextFloat();
        System.out.println("please enter minerals");
        float m = s.nextFloat();
        System.out.println("please enter body water");
        float b_w = s.nextFloat();
        System.out.println("please enter protien");
        float p = s.nextFloat();


        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getId() == id) {

                c.get(i).inbody.add(new Inbody(12,d, h, w, b_f_m, m, b_w, p));
                break;

            }

        }

    }
    public static void display_inbody(String date, ArrayList<Inbody> in) {
        for (int i = 0; i < in.size(); i++) {
            if (in.get(i).date.equals(date)) {
                System.out.println(in.toString());
            }
        }

    }
}