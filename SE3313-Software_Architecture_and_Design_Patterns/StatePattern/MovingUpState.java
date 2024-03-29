public class MovingUpState implements ElevatorState{
    ElevatorClass Elevator;


    public MovingUpState(ElevatorClass elevator){
        this.Elevator = elevator;
    }
    @Override
    public void pressButton(int destinationFloor) {
        if (destinationFloor > Elevator.getLevel()){
            Elevator.setLevel(destinationFloor);
            Elevator.setState(Elevator.getMovingUpState());
            System.out.println(Elevator.elevatorGetReadableState + " moving up to " + destinationFloor);

        } else if (destinationFloor < Elevator.getLevel()) {
            Elevator.setLevel(destinationFloor);
            Elevator.setState(Elevator.getMovingDownState());
            System.out.println(Elevator.elevatorGetReadableState + " moving down to " + destinationFloor);

        } else {
            Elevator.setState(Elevator.getStationaryState());
            System.out.println(Elevator.elevatorGetReadableState + " Elevator is already at the level " + destinationFloor);
        }
    }
}
