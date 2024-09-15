
package com.gym;

public abstract class person {
    private int id;
    public String name ;

    public String gender;
    protected String address ;
    public String phone_no;
    public String email;
    private String password;

    public person(int id, String name, String gender, String address, String phone_no, String email, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone_no = phone_no;
        this.email = email;
        this.password = password;
    }

    public person(String name, String gender, String address, String phone_no, String email, String password) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone_no = phone_no;
        this.email = email;
        this.password = password;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

public abstract String showinfo();

}