package com.example.firstservice;

public class Customer {
    String ID;
    String name;
    boolean sex;
    int age;

    public Customer(String ID, String n, String s, int a){
        this.ID = ID;
        this.name = n;
        if(s.equals("male") || s.equals("Male")){
            this.sex = true;
        }
        else if(s.equals("female") || s.equals("Female")){
            this.sex = false;
        }
        this.age = a;
    }

    public Customer(){
        this("",null,"female",0);
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSex(boolean sex){
        this.sex = sex;
    }
    public void setAge(int age){
            this.age = age;
    }
    public String getID(){
        return ID;
    }
    public String getName(){
        return name;
   }
   public boolean getSex(){
        return sex;
   }
   public int getAge(){
        return age;
   }
}
