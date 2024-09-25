package io.codeforall.bootcamp;

public class Pokedex {

    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", "Normal", "Rat", "Ground", new Ability[]{new Ability("Tail Whip", 10, "Normal"), new Ability("Spark", 20, "Electric")}, 2, 60);

        System.out.println(pikachu.getName());
    }

}
