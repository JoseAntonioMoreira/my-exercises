package io.codeforall.bootcamp;

import io.codeforall.bootcamp.GameObjects.Barrel;
import io.codeforall.bootcamp.GameObjects.Destroyable;
import io.codeforall.bootcamp.GameObjects.GameObject;
import io.codeforall.bootcamp.GameObjects.Tree;
import io.codeforall.bootcamp.GameObjects.Enemies.ArmouredEnemy;
import io.codeforall.bootcamp.GameObjects.Enemies.SoldierEnemy;

public class Game {
    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private int shotsFired;

    public Game() {
        sniperRifle = new SniperRifle();
        shotsFired = 0;
    }

    public void start(int numberofObjects) {
        createObjects(numberofObjects);

        for (int i = 0; i < gameObjects.length; i++) {
            System.out.println(gameObjects[i].getMessage());
            if (gameObjects[i] instanceof Destroyable) {
                while (!((Destroyable) gameObjects[i]).isDestroyed()) {
                    sniperRifle.shoot((Destroyable) gameObjects[i]);
                    shotsFired++;
                }
            }
        }
        System.out.println("Enemies downed in " + shotsFired + " shots");
    }

    private GameObject[] createObjects(int numberofObjects) {

        gameObjects = new GameObject[numberofObjects];

        for (int i = 0; i < gameObjects.length; i++) {
            double randomNumber = Math.random();

            if (randomNumber < 0.1f) {
                gameObjects[i] = new Tree();
            } else if (randomNumber <= 0.5f) {
                gameObjects[i] = new SoldierEnemy();
            } else if(randomNumber <= 0.75f){
                gameObjects[i] = new ArmouredEnemy();
            }else{
                gameObjects[i] = new Barrel();
            }
        }
        return gameObjects;
    }
}
