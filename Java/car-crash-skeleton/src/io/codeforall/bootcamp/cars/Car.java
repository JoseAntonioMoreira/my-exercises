package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.Position;

abstract public class Car {
    private boolean crashed;
    /**
     * The position of the car on the grid
     */
    private Position pos;
    private int speed;

    public Car(int col, int row) {
        pos = new Position(col, row);
        crashed = false;
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return crashed;
    }


    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    /*public void moveCar() {

        int nextPos = (int) (Math.random() * 4);
        if (nextPos == 0) {
            if (getPos().getCol() + getSpeed() < Field.getWidth()) {
                setCol(getPos().getCol() + getSpeed());
            }
        } else if (nextPos == 1) {
            if (getPos().getCol() - getSpeed() > 0) {
                setCol(getPos().getCol() - getSpeed());
            }
        } else if (nextPos == 2) {
            if (getPos().getRow() - getSpeed() > 0) {
                setRow(getPos().getRow() - getSpeed());
            }
        } else if (nextPos == 3) {
            if (getPos().getRow() + getSpeed() > Field.getHeight()) {
                setRow(getPos().getRow() + getSpeed());
            }
        }

    }*/
    public void moveCar() {
        int nextPos1 = (int) (Math.random() * 2);
        int nextPos = (int) (Math.random() * 2);
        if (crashed == false) {
            if (nextPos == 0) {
                if (nextPos1 == 0) {
                    if (getPos().getCol() + getSpeed() < Field.getWidth()) {
                        setCol(getPos().getCol() + getSpeed());
                    }
                } else if (nextPos1 == 1) {
                    if (getPos().getCol() - getSpeed() > 0) {
                        setCol(getPos().getCol() - getSpeed());
                    }
                }
            } else if (nextPos == 1) {
                if (nextPos1 == 1) {
                    if (getPos().getRow() - getSpeed() > 0) {
                        setRow(getPos().getRow() - getSpeed());
                    }
                } else if (nextPos1 == 0) {
                    if (getPos().getRow() + getSpeed() < Field.getHeight()) {
                        setRow(getPos().getRow() + getSpeed());
                    }
                }

            }

        }
    }

    public void setRow(int row) {
        pos.setRow(row);
    }

    public void setCol(int col) {
        pos.setCol(col);
    }

    public void setSpeed(int speed) {
        this.speed = speed;

    }

    public int getSpeed() {
        return speed;
    }
}
