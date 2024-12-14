package Beginner;
import java.util.Random;

public class MagicalArena {
	static class Player {
        private String name;
        private int health;
        private int strength;
        private int attack;

        public Player(String name, int health, int strength, int attack) {
            this.name = name;
            this.health = health;
            this.strength = strength;
            this.attack = attack;
        }

        public boolean isAlive() {
            return health > 0;
        }

        public void attackOpponent(Player opponent, Die attackDie, Die defendDie) {
            int attackRoll = attackDie.roll();
            int defenseRoll = defendDie.roll();

            int attackDamage = attackRoll * this.attack;
            int defenseStrength = defenseRoll * opponent.strength;

            int damageInflicted = Math.max(0, attackDamage - defenseStrength);
            opponent.health = Math.max(0, opponent.health - damageInflicted);

            System.out.println(this.name + " attacks! Attack Roll: " + attackRoll + ", Damage: " + attackDamage);
            System.out.println(opponent.name + " defends! Defense Roll: " + defenseRoll + ", Defense: " + defenseStrength);
            System.out.println(opponent.name + " takes " + damageInflicted + " damage. Remaining Health: " + opponent.health + "\n");
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }
    }

    // Die class representing a dice
    static class Die {
        private final int sides;
        private final Random random;

        public Die(int sides) {
            this.sides = sides;
            this.random = new Random();
        }

        public int roll() {
            return random.nextInt(sides) + 1; // Random number between 1 and sides
        }
    }

    // Arena class for managing the battle
    static class Arena {
        private final Player player1;
        private final Player player2;
        private final Die attackDie;
        private final Die defendDie;

        public Arena(Player player1, Player player2) {
            this.player1 = player1;
            this.player2 = player2;
            this.attackDie = new Die(6); // 6-sided attack die
            this.defendDie = new Die(6); // 6-sided defense die
        }

        public void startMatch() {
            System.out.println("Match Start! " + player1.getName() + " vs " + player2.getName() + "\n");

            while (player1.isAlive() && player2.isAlive()) {
                if (player1.getHealth() <= player2.getHealth()) {
                    player1.attackOpponent(player2, attackDie, defendDie);
                } else {
                    player2.attackOpponent(player1, attackDie, defendDie);
                }
            }

            Player winner = player1.isAlive() ? player1 : player2;
            System.out.println("Game Over! Winner: " + winner.getName());
        }
    }

    // Main method for executing the game
    public static void main(String[] args) {
        // Create players
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        // Create the arena and start the match
        Arena arena = new Arena(playerA, playerB);
        arena.startMatch();
    }
}



