public class MoveUpCommand implements Command {
    private GameCharacter character;

    public MoveUpCommand(GameCharacter character) {
        this.character = character;
    }
    @Override
    public void execute() {
        character.moveUp();
    }
}
