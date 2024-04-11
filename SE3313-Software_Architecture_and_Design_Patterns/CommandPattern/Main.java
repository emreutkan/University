import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter character = new GameCharacter();
        GameController controller = new GameController();

        while (true) {
            System.out.println(
                    "Select an action " + " \n" +
                    "W - Move Up" +  " \n" +
                    "A - Move Left" + " \n" +
                    "S - Move Down" + " \n" +
                    "D - Move Right" + " \n" +
                    "J - Jump" + " \n" +
                    "S - Attack" + " \n"
            );
            String command = scanner.next();

            switch (command) {
                case "w","W":
                    controller.setCommand(new MoveUpCommand(character));
                    break;
                case "a","A":
                    controller.setCommand(new MoveLeftCommand(character));
                    break;
                case "s","S":
                    controller.setCommand(new MoveDownCommand(character));
                    break;
                case "d","D":
                    controller.setCommand(new MoveRightCommand(character));
                    break;
                case "j","J":
                    controller.setCommand(new JumpCommand(character));
                    break;
                case "k","K":
                    controller.setCommand(new AttackCommand(character));
                    break;
                case "q","Q":
                    System.out.println("Exiting game");
                    return;
                default:
                    System.out.println("wrong input");
            }

            controller.executeCommand();
        }
    }
}