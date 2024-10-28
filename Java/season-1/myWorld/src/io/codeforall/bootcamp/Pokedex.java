package io.codeforall.bootcamp;

public class Pokedex {

    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon("Pikachu", "Electric", "Normal", "Mouse", "Ground", new Ability[]{new Ability("Tail Whip", 10, "Normal"), new Ability("Spark", 20, "Electric")}, 2, 60);
        Pokemon sandshrew = new Pokemon("Sandshrew", "Ground", "Normal", "Mouse", "Water", new Ability[]{new Ability("Double Scratch", 20, "Normal"), new Ability("Sand Tomb", 20, "Ground")}, 1, 60);

        for (int i = 0; i < pikachu.getAbilities().length; i++) {
            pikachu.receiveDamage(sandshrew.getAbility(i).getDamage(), sandshrew.getAbility(i).getType());
            System.out.println(pikachu.getName() + " " + pikachu.getHealth());

            sandshrew.receiveDamage(pikachu.getAbility(i).getDamage(), pikachu.getAbility(i).getType());
            System.out.println(sandshrew.getName() + " " + sandshrew.getHealth());
        }
    }
}
