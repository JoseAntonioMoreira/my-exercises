package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Field;

import java.awt.*;

public class CarFactory {

    public static  Car getNewCar() {
        int col = (int) (Math.random()* Field.getWidth());
        int row = (int) (Math.random()* Field.getHeight());
        if( (int)(Math.random()* 2) == 0){

            return new Ford(col, row);
        }

        return new Opel(col, row);

    }
}
