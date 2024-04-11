public class MoveLeftCommand implements Command {
    private GameCharacter character;

    public MoveLeftCommand(GameCharacter character) {
        this.character = character;
    }
    @Override
    public void execute() {
        character.moveLeft();
    }
}
