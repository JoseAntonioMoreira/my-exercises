package io.codeforall.bootcamp.cars;

public class Opel extends Car {


    public Opel(int col, int row) {
        super(col, row);
        setSpeed(1);
    }
    @Override
    public String toString () {
        return "O";
    }
}
