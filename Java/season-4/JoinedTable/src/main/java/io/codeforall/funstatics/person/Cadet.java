package io.codeforall.funstatics.person;

import javax.persistence.Entity;

@Entity
public class Cadet extends PersonDetails {
    private Integer age;


    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}
