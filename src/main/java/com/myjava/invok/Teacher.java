package com.myjava.invok;

/**
 * Created by flyap on 2018/3/26.
 */
public class Teacher {

        //**********字段*************//
        public String name;
        protected int age;
        char sex;
        private String phoneNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Teacher(String name, int age, char sex, String phoneNum) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNum = phoneNum;
    }

    public Teacher() {
    }

    @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                    + ", phoneNum=" + phoneNum + "]";
        }


    }

