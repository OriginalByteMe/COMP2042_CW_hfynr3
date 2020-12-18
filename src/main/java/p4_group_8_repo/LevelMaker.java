package p4_group_8_repo;

public class LevelMaker {
    private final MyStage stage;
    private final ActorGroupToWindow obstacleFactory = new ActorGroupToWindow("ObstacleFactory");
    private final ActorGroupToWindow staticActorFactory = new ActorGroupToWindow("StaticActorFactory");
    private final int sizeCar = 50,sizeTruckSmall = 120,sizeTruckBig = 200, sizeLogSmall = 140, sizeLogBig = 180, sizeLogLong = 300, sizeDryTurtle = 80, sizeWetTurtle = 80;

    /**
     * Allows for a levelmaker object to be created to easily add obstacles to scene's
     * @param game The game stage which actors will be added to
     */
    public LevelMaker(MyStage game) {
        this.stage = game;
        addStatic();
    }

    /**
     * <h1>Adding vehicles to level</h1>
     * <h2>Adding car</h2>
     * @param amount Amount of vehicles to be added
     * @param lane Which lane on the road the vehicle will be added to
     * @param speed Speed at which obstacle will move
     * @param direction Direction of obstacle
     */
    public void addCar(int amount, int lane, int speed,char direction){
        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(amount * sizeCar);

        vehicleDirectionAssign("file:src/main/resources/car1Left.png","file:src/main/resources/car1Right.png",direction,speed);
        carLaneAssign(lane);
        carToWindow();
    }
    public void addTruckSmall(int amount, int lane, double speed, char direction) {
        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(amount * sizeTruckSmall); // Shift of 300
        vehicleDirectionAssign("file:src/main/resources/truck1Left.png","file:src/main/resources/truck1Right.png",direction,speed);
        carLaneAssign(lane);
        truckSmallToWindow();
    }
    public void addTruckBig(int amount, int lane, double speed, char direction) {
        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(amount); // shift 500
        vehicleDirectionAssign("file:src/main/resources/truck2Left.png","file:src/main/resources/truck2Right.png",direction,speed);
        carLaneAssign(lane);
        truckBigToWindow();
    }

    /**
     *<h1>Adding water obstacles</h1>
     * @param amount Amount of vehicles to be added
     * @param lane Which lane on the road the vehicle will be added to
     * @param direction Direction of obstacle
     * @param speed Speed of obstacle
     */
    public void addLogSmall(int amount, int lane, char direction,int speed) {
        obstacleFactory.setActorType("Log");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(amount); // Shift 200
        waterLaneAssign(lane);
        waterDirectionAssign(direction,speed);
        logSmallToWindow();
    }
    public void addLogBig(int amount, int lane, char direction,int speed) {
        obstacleFactory.setActorType("Log");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(amount); // Shift 200
        waterDirectionAssign(direction,speed);
        waterLaneAssign(lane);
        logBigToWindow();
    }
    public void addLogLong(int amount, int lane, char direction,int speed) {
        obstacleFactory.setActorType("Log");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(amount); // Shift 300
        waterLaneAssign(lane);
        waterDirectionAssign(direction,speed);
        logLongToWindow();

    }

    public void addDryTurtle(int amount, int lane, char direction,int speed) {
        obstacleFactory.setActorType("Turtle");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(amount * sizeDryTurtle); // Shift of 200
        waterDirectionAssign(direction,speed);
        waterLaneAssign(lane);
        turtleToWindow();
    }
    public void addWetTurtle(int amount,int lane, char direction,int speed){
        obstacleFactory.setActorType("WetTurtle");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(amount * sizeWetTurtle); // Shift of 200
        waterDirectionAssign(direction,speed);
        waterLaneAssign(lane);
        turtleWetToWindow();
    }

    /**
     * <h1>Water Lane assignment</h1>
     * <p>Has set Y-Positions for each lane in the water</p>
     * @param lane Lane for water object to be put in
     */
    public void waterLaneAssign(int lane){
        switch (lane){
            case 5:
                obstacleFactory.setYPos(166);
                break;
            case 4:
                obstacleFactory.setYPos(217);
                break;
            case 3:
                obstacleFactory.setYPos(276);
                break;
            case 2:
                obstacleFactory.setYPos(329);
                break;
            case 1:
                obstacleFactory.setYPos(370);
                break;
            default:
                obstacleFactory.setYPos(166);
                break;
        }
    }
    /**
     * <h1>Direction and Speed assignment - Water</h1>
     * <p>Allows for direction choice along with which speed it will go at, from 3 different presets</p>
     * @param direction Direction of movement
     * @param speed Speed of movement
     */
    public void waterDirectionAssign(char direction, int speed){
        switch (direction) {
            case 'L':
                if (speed == 1) {
                    obstacleFactory.setSpeed(-0.75);
                } else if (speed == 2) {
                    obstacleFactory.setSpeed(-1);
                } else if (speed == 3) {
                    obstacleFactory.setSpeed(-3);
                } else {
                    obstacleFactory.setSpeed(-1);
                }
                break;
            case 'R':
                if (speed == 1) {
                    obstacleFactory.setSpeed(0.75);
                } else if (speed == 2) {
                    obstacleFactory.setSpeed(1);
                } else if (speed == 3) {
                    obstacleFactory.setSpeed(3);
                } else {
                    obstacleFactory.setSpeed(1.5);
                }
                break;
            default:
                if (speed == 1) {
                    obstacleFactory.setSpeed(-1);
                } else if (speed == 2) {
                    obstacleFactory.setSpeed(-3);
                } else {
                    obstacleFactory.setSpeed(-1);
                }
                break;
        }
    }


    /**
     * <h1>Car Lane assignment</h1>
     * <p>Has set Y-Positions for each lane in the water</p>
     * @param lane Lane for Vehicles to be put in
     */
    public void carLaneAssign(int lane){
        switch (lane){
            case 5:
                obstacleFactory.setYPos(470);
                break;
            case 4:
                obstacleFactory.setYPos(520);
                break;
            case 3:
                obstacleFactory.setYPos(565);
                break;
            case 2:
                obstacleFactory.setYPos(620);
                break;
            case 1:
                obstacleFactory.setYPos(660);
                break;
            default:
                obstacleFactory.setYPos(485);
                break;
        }
    }

    /**
     * <h1>Direction and Speed assignment - Vehicle</h1>
     * <p>Allows for direction choice along with which speed it will go at, from 3 different presets</p>
     * @param left Left image
     * @param right Right image
     * @param direction Direction of movement
     * @param speed Speed of movement
     */
    public void vehicleDirectionAssign(String left, String right, char direction, double speed ) {
        switch (direction) {
            case 'L':
                obstacleFactory.setImageLink(left);
                if (speed == 1) {
                    obstacleFactory.setSpeed(-0.75);
                } else if (speed == 2) {
                    obstacleFactory.setSpeed(-1);
                } else if (speed == 3) {
                    obstacleFactory.setSpeed(-3);
                } else {
                    obstacleFactory.setSpeed(-1);
                }
                break;
            case 'R':
                obstacleFactory.setImageLink(right);
                if (speed == 1) {
                    obstacleFactory.setSpeed(0.75);
                } else if (speed == 2) {
                    obstacleFactory.setSpeed(1);
                } else if (speed == 3) {
                    obstacleFactory.setSpeed(3);
                } else {
                    obstacleFactory.setSpeed(1.5);
                }
                break;
            default:
                obstacleFactory.setImageLink(left);
                if (speed == 1) {
                    obstacleFactory.setSpeed(-1);
                } else if (speed == 2) {
                    obstacleFactory.setSpeed(-3);
                } else {
                    obstacleFactory.setSpeed(-1);
                }
                break;
        }
    }

public void addStatic() {
    endToWindow();
}



    /**
     * <h1>Adding obstacle to window</h1>
     * <p>Sets imagelink for each water obstacle here as there is no direction image for them</p>
     * <p>Also sets the shift between obstacles in the same lane.</p>
     * <p>Also sets size of each obstacle</p>
     */
    public void carToWindow() {
        obstacleFactory.setSize(sizeCar);
        obstacleFactory.setShift(sizeCar * 3);
        obstacleFactory.AddToWindow(stage);
    }
    public void turtleToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/TurtleAnimation2.png");
        obstacleFactory.setSize(sizeDryTurtle);
        obstacleFactory.setShift(sizeDryTurtle * 3);
        obstacleFactory.AddToWindow(stage);
    }
    public void turtleWetToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/TurtleAnimation2.png");
        obstacleFactory.setSize(sizeWetTurtle);
        obstacleFactory.setShift(sizeWetTurtle * 3);

        obstacleFactory.AddToWindow(stage);
    }
    public void truckSmallToWindow() {
        obstacleFactory.setSize(sizeTruckSmall);
        obstacleFactory.setShift(sizeLogSmall * 1.5);
        obstacleFactory.AddToWindow(stage);
    }
    public void truckBigToWindow() {
        obstacleFactory.setSize(sizeTruckBig);
        obstacleFactory.setShift(sizeTruckBig * 1.5);

        obstacleFactory.AddToWindow(stage);
    }
    public void logSmallToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/log_small.png");
        obstacleFactory.setSize(sizeLogSmall);
        obstacleFactory.setShift(sizeLogSmall * 1.5);

        obstacleFactory.AddToWindow(stage);
    }
    public void logBigToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/log_big.png");
        obstacleFactory.setSize(sizeLogBig);
        obstacleFactory.setShift(sizeLogBig * 1.5);
        obstacleFactory.AddToWindow(stage);

    }
    public void logLongToWindow(){
        obstacleFactory.setImageLink("file:src/main/resources/log_long.png");
        obstacleFactory.setSize(sizeLogLong);
        obstacleFactory.setShift(sizeLogLong * 1.5);
        obstacleFactory.AddToWindow(stage);
    }

    public void endToWindow() {
        staticActorFactory.setActorType("End");
        staticActorFactory.setAmount(5);
        staticActorFactory.setStartXPos(13); // Shift of 140
        staticActorFactory.setYPos(90);
        staticActorFactory.setImageLink("file:src/main/resources/End.png");
        staticActorFactory.setSize(60);
        staticActorFactory.setShift(128.2);

        staticActorFactory.AddToWindow(stage);
    }


}
