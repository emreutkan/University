package org.example;

/**
 * Entry point for the game application.
 */
public final class App {
    /** Health points for the warrior. */
    private static final int WARRIOR_HEALTH = 100;
    /** Damage points for the warrior. */
    private static final int WARRIOR_DAMAGE = 15;
    /** Health points for the mage. */
    private static final int MAGE_HEALTH = 80;
    /** Damage points for the mage. */
    private static final int MAGE_DAMAGE = 20;
    /** Health points for the archer. */
    private static final int ARCHER_HEALTH = 90;
    /** Damage points for the archer. */
    private static final int ARCHER_DAMAGE = 18;

    private App() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    /**
     * Main method to start the game.
     *
     * @param args command-line arguments.
     */
    public static void main(final String[] args) {
        runGame();
    }

    private static void runGame() {
        final Game game = new Game();
        game.addCharacter(new Warrior("Conan", WARRIOR_HEALTH, WARRIOR_DAMAGE));
        game.addCharacter(new Mage("Merlin", MAGE_HEALTH, MAGE_DAMAGE));
        game.addCharacter(new Archer("Legolas", ARCHER_HEALTH, ARCHER_DAMAGE));

        game.startGame();
    }
}
