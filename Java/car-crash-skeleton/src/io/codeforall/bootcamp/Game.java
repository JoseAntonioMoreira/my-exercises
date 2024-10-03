package io.codeforall.bootcamp;

import io.codeforall.bootcamp.cars.Car;
import io.codeforall.bootcamp.cars.CarFactory;
import io.codeforall.bootcamp.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /** Container of Cars */
    private Car[] cars;

    /** Animation delay */
    private int delay;
    private int cols;
    private int rows;
    public Game(int cols, int rows, int delay) {
        this.cols = cols;
        this.rows =rows;
        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }


        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {
        for (int i = 0; i < cars.length; i++) {
            cars[i].moveCar();
        }
        for (int i = 0; i < cars.length; i++) {
            if(i + 1 >= cars.length){
                return;
            }
            for (int j = i +1  ; j < cars.length ; j++) {
                if (cars[i].getPos().getRow() == cars[j].getPos().getRow() && cars[i].getPos().getCol() == cars[j].getPos().getCol()) {
                    cars[i].setCrashed(true);
                    cars[j].setCrashed(true);
                }

            }


        }
    }

}
