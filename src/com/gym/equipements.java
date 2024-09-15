package com.gym;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class equipements {
    public  String name ;
    private  int code ;

    public equipements() {
    }

    public  int quantity ;

    public  int getCode() {
        return code;
    }

    public  void setCode(int code) {
        this.code = code;
    }

    public equipements(String name ,int code ,int quantity ) {
        this.name=name ;
        this.code=code ;
        this.quantity=quantity ;
    }

    @Override
//    public String toString() {
//        return "equipements{" +
//                "name='" + name + '\'' +
//                ", code=" + code +
//                ", quantity=" + quantity +
//                '}';
//    }
    public String toString() {
        return name+"," +code+","+ +quantity ;

    }
    public static void write_to_file(ArrayList<equipements> m1) {
        try (FileWriter writer = new FileWriter("Equipment.txt")) {
            for(int i=0;i<m1.size();i++)
            {
                writer.write(m1.get(i) + System.lineSeparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<equipements> read_from_file() {
        ArrayList<equipements> equ=new ArrayList<>();
        try{
            File file =new File("Equipment.txt");
            Scanner readFlie =new Scanner(file);
            StringTokenizer token =null;

            while (readFlie.hasNextLine()) {
                token = new StringTokenizer(readFlie.nextLine(),",");


                String name= token.nextToken();


                int code= Integer.parseInt(token.nextToken());
                int quentity= Integer.parseInt(token.nextToken());

                equipements eq = new equipements(name,code,quentity);

                equ.add(eq);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return equ;

    }


    public static void display_equipements(ArrayList<equipements> equ) {
        for (int i = 0; i < equ.size(); i++) {
            System.out.println(equ.get(i).toString());
        }
    }
    public static equipements findEquipmentByName(ArrayList<equipements> eq, String equipmentName) {
        for (int i = 0; i < eq.size(); i++) {
            if (eq.get(i).name.equalsIgnoreCase(equipmentName)) {
                return eq.get(i);
            }
        }
        return null;
    }

}