package org.example;

/**
 * Represents an Archer character in the game.
 */
public class Archer extends Character {
    /**
     * Constructs a new Archer
     * with the specified name, health, and attack power.
     *
     * @param name        the name of the Archer.
     * @param health      the initial health points of the Archer.
     * @param attackPower the attack power of the Archer.
     */
    public Archer(final String name,
                  final int health,
                  final int attackPower) {
        super(name, health, attackPower);
    }


    /**
     * Performs a special attack on the opponent.
     * Increases the attack power by a fixed bonus value.
     *
     * @param opponent the character to attack.
     */
    @Override
    public void specialAttack(final Character opponent) {
        final int specialAttackBonus = 20;
        opponent.takeDamage(getAttackPower() + specialAttackBonus);
    }
}
