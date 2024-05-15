package org.example;

public class Warrior extends Character {
    /**
     * Constructs a warrior with the specified name, health, and attack power.
     * @param name The name of the warrior
     * @param health The health points of the warrior
     * @param attackPower The attack power of the warrior
     */
    public Warrior(final String name, final int health, final int attackPower) {
        super(name, health, attackPower);
    }

    /**
     * Performs a special attack on the opponent.
     * @param opponent The character being attacked
     */
    @Override
    public final void specialAttack(final Character opponent) {
        opponent.takeDamage(getAttackPower() * 2);
    }
}
