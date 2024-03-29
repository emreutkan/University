public class StationaryState implements ElevatorState {
    ElevatorClass Elevator;


    public StationaryState(ElevatorClass elevator){
        this.Elevator = elevator;
    }
    @Override
    public void pressButton(int destinationFloor) {
        if (destinationFloor > Elevator.getLevel() ){
            Elevator.setLevel(destinationFloor);
            Elevator.setState(Elevator.getMovingUpState());
            System.out.println(Elevator.elevatorGetReadableState + " moving up to " + destinationFloor);
        } else if (destinationFloor < Elevator.getLevel()) {
            Elevator.setLevel(destinationFloor);
            Elevator.setState(Elevator.getMovingDownState());
            System.out.println(Elevator.elevatorGetReadableState + " moving down to " + destinationFloor);
        } else {
            System.out.println(Elevator.elevatorGetReadableState + " Elevator is already at the level " + destinationFloor);
        }
    }
}
