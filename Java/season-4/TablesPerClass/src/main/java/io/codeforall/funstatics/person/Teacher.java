package io.codeforall.funstatics.person;

import javax.persistence.Entity;

@Entity
public class Teacher extends PersonDetails {

    private String patent;

    public String getPatent() {
        return patent;
    }

    public void setPatent(String rank) {
        this.patent = rank;
    }
}
