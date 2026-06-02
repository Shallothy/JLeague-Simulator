package shall.domain;

import shall.domain.enums.Gender;
import shall.error.InvalidAge;

public abstract class Person {
    private String name;
    private int age;
    private Gender gender;

    public Person(){
        this("Unnamed", 0, null);
    }

    public Person(String name){
        this(name, 0, null);
    }

    public Person(String name, int age) {
        this(name, age, null);
        if(age<0) {
            throw new InvalidAge("Invalid age, can't add negative age.");
        }
    }

    public Person(String name, int age , Gender gender) {
        this.name = name;
        if(age<0) {
            throw new InvalidAge("Invalid age, can't add negative age.");
        } this.age = age;
        this.gender =gender;
    }

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
        if(age<0) {
            throw new InvalidAge("Invalid age, can't add negative age.");
        } this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {

        this.gender = gender;
    }

    public abstract void printData();
}
