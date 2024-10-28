package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

public class Ford extends Car {

    public Ford(int col, int row) {
        super(col, row);
        setSpeed(2);
    }

    @Override
    public String toString() {
        return "F";
    }
}
