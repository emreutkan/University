package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game with characters and their interactions.
 */
public class Game {

    /**
     *  List of characters.
     */
    private final List<Character> characters = new ArrayList<>();

    /**
     * Adds a character to the game.
     * @param character The character to be added.
     */
    public void addCharacter(final Character character) {
        characters.add(character);
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        int turn = 0;
        boolean gameOver = false;

        while (!gameOver) {
            final Character attacker
                    = characters.get(turn % characters.size());
            final Character defender
                    = characters.get(turn % characters.size());
            attacker.specialAttack(defender);
            System.out.println(
                    attacker.getName() + " attacks " + defender.getName());

            if (defender.isDefeated()) {
                System.out.println(defender.getName() + " is defeated!");
                gameOver = true;
            }

            turn++;
        }
    }

    /**
     * Checks if the game is over.
     * @return True if the game is over, otherwise false.
     */
    private boolean isGameOver() {
        for (final Character character : characters) {
            if (character.isDefeated()) {
                return true;
            }
        }
        return false;
    }
}
