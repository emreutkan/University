public class ElevatorClass {

    ElevatorState MovingUpState;
    ElevatorState MovingDownState;
    ElevatorState StationaryState;

    ElevatorState state;

    String elevatorGetReadableState;

    int level;

    public ElevatorClass(int level){
        MovingUpState = new MovingUpState(this);
        MovingDownState = new MovingDownState(this);
        StationaryState = new StationaryState(this);
        state = getStationaryState(); //
        this.level = level;
    }



    void setLevel(int level){
        this.level = level;
    }

    void pressButton(int level){
        this.state.pressButton(level);
    }

    public ElevatorState getMovingUpState(){
        elevatorGetReadableState = "Moving Up State";
        return MovingUpState;
    }

    public ElevatorState getMovingDownState(){
        elevatorGetReadableState = "Moving Down State";
        return MovingDownState;
    }

    public ElevatorState getStationaryState(){
        elevatorGetReadableState = "Stationary State";
        return StationaryState;
    }

    void setState(ElevatorState state){
        this.state = state;
    }

    int getLevel(){
        return level;
    }

}
