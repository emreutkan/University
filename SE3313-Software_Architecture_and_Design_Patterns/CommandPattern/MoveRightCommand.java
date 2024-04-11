public class MoveRightCommand implements Command {
    private GameCharacter character;

    public MoveRightCommand(GameCharacter character) {
        this.character = character;
    }
    @Override
    public void execute() {
        character.moveRight();
    }
}
