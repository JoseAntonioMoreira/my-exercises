package io.codeforall.funstatics.Person;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends PersonDetails {
    private String patent;

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }
}
