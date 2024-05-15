package org.example;


public class Mage extends Character {

    /**
     *  Special Attack Bonus for Mage.
     */
    private static final int SPECIAL_ATTACK_BONUS = 50;
    /**
     * Constructs a new Mage with the given name, health, and attack power.
     *
     * @param name        The name of the Mage.
     * @param health      The health points of the Mage.
     * @param attackPower The attack power of the Mage.
     */
    public Mage(final String name, final int health, final int attackPower) {
        super(name, health, attackPower);
    }

    /**
     * Performs a special attack.
     *
     * @param opponent The character to attack
     */
    @Override
    public void specialAttack(final Character opponent) {
        final int specialAttackPower = getAttackPower() + SPECIAL_ATTACK_BONUS;
        opponent.takeDamage(specialAttackPower);
    }


}
