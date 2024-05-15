package org.example;

/**
 * Abstract class representing a character in a game.
 */
public abstract class Character {
    /**
     * The name of the character.
     */
    private String name;

    /**
     * The health points of the character.
     */
    private int health;

    /**
     * The attack power of the character.
     */
    private int attackPower;

    /**
     * Constructor for creating a Character object.
     *
     * @param nameOfCharacter        The name of the character.
     * @param initialHealth      The initial health points of the character.
     * @param initialAttackPower The attack power of the character.
     */
    public Character(final String nameOfCharacter,
                     final int initialHealth,
                     final int initialAttackPower) {
        this.name = nameOfCharacter;
        this.health = initialHealth;
        this.attackPower = initialAttackPower;
    }

    /**
     * Gets the name of the character.
     *
     * @return The name of the character, or "Unknown" if the name is not set.
     */
    public String getName() {
        return name != null ? name : "Unknown";
    }

    /**
     * Sets the name of the character.
     *
     * @param newName The name of the character.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets the health points of the character.
     *
     * @return The health points of the character.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health points of the character.
     *
     * @param newHealth The health points of the character.
     */
    public void setHealth(final int newHealth) {
        this.health = newHealth;
    }

    /**
     * Gets the attack power of the character.
     *
     * @return The attack power of the character.
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Sets the attack power of the character.
     *
     * @param newAttackPower The attack power of the character.
     */
    public void setAttackPower(final int newAttackPower) {
        this.attackPower = newAttackPower;
    }

    /**
     * Inflicts damage on the character.
     *
     * @param damage The amount of damage to inflict.
     */
    public void takeDamage(final int damage) {
        health -= damage;
    }

    /**
     * Performs a special attack on the opponent character.
     *
     * @param opponent The opponent character to attack.
     */
    public abstract void specialAttack(Character opponent);

    /**
     * Checks if the character is defeated.
     *
     * @return True if the character's health <= 0, false otherwise.
     */
    public boolean isDefeated() {
        return health <= 0;
    }
}
