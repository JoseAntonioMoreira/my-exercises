package io.codeforall.bootcamp.car;

import io.codeforall.bootcamp.grid.GridDirection;
import io.codeforall.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyCar extends Car implements KeyboardHandler {
    public final int SPEED = 1;

    private Keyboard keyboard;
    /**
     * Constructs a new car
     *
     * @param pos     the initial car position
     * @param carType the car type
     */
    public MyCar(GridPosition pos, CarType carType) {
        super(pos, carType);
        keyboardInit();
    }

    @Override
    public void move() {

    }

    private void keyboardInit(){
        this.keyboard = new Keyboard(this);
        keyboard.addEventListener(setUpKey(KeyboardEvent.KEY_RIGHT,KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setUpKey(KeyboardEvent.KEY_LEFT,KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setUpKey(KeyboardEvent.KEY_UP,KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setUpKey(KeyboardEvent.KEY_DOWN,KeyboardEventType.KEY_PRESSED));
    }

    private KeyboardEvent setUpKey(int keyEvent,KeyboardEventType typeOfPress){
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(keyEvent);
        keyboardEvent.setKeyboardEventType(typeOfPress);
        return keyboardEvent;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
       switch (keyboardEvent.getKey()){
           case KeyboardEvent.KEY_RIGHT -> accelerate(GridDirection.RIGHT,SPEED);
           case KeyboardEvent.KEY_LEFT -> accelerate(GridDirection.LEFT,SPEED);
           case KeyboardEvent.KEY_UP -> accelerate(GridDirection.UP,SPEED);
           case KeyboardEvent.KEY_DOWN -> accelerate(GridDirection.DOWN,SPEED);
       }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void accelerate(GridDirection direction,int speed){
        if(isCrashed())
        {
            return;
        }
        getPos().moveInDirection(direction, speed);
    }
}
