public class MoveDownCommand implements Command {
    private GameCharacter character;

    public MoveDownCommand(GameCharacter character) {
        this.character = character;
    }
    @Override
    public void execute() {
        character.moveDown();
    }
}
