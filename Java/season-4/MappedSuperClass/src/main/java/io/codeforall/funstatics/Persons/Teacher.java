package io.codeforall.funstatics.Persons;

import javax.persistence.*;

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
