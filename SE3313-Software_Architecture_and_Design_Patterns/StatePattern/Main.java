public class Main {
    public static void main(String[] args) {
        ElevatorClass elevator = new ElevatorClass(0);
        // at initial the elevator as at level 0

        /*

        in this programmes logic elevator on changes to stationary state

            at
                first initialization

            and if

                user presses the button that the elevator is already in

            otherwise it has no implementation of waiting to meet the level to set stationary state...
         */

        elevator.pressButton(1);
        elevator.pressButton(5);
        elevator.pressButton(5);
        elevator.pressButton(-2);
        elevator.pressButton(3);

    }
}