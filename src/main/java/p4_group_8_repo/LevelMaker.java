package p4_group_8_repo;

import java.util.List;

public class LevelMaker {
    private MyStage stage;
    private List<Actor> score;
    private List<Actor> players;
    private List<Actor> obstacles;
    private ActorGroupToWindow obstacleFactory = new ActorGroupToWindow("ObstacleFactory");
    private ActorGroupToWindow playerFactory = new ActorGroupToWindow("PlayerFactory");
    private ActorGroupToWindow staticActorFactory = new ActorGroupToWindow("StaticActorFactory");

    public LevelMaker(MyStage game,List<Actor> score) {
        this.stage = game;
        this.score = score;
        addStatic();
    }



    public void addCar(int amount, int startXPos, int lane, int speed,char direction){
        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); //Shift of 150
        switch(direction){
            case 'L':
                obstacleFactory.setImageLink("file:src/main/resources/car1Left.png");
                if(speed == 1){
                    obstacleFactory.setSpeed(-0.75);
                } else if(speed == 2) {
                    obstacleFactory.setSpeed(-1);
                }else if(speed == 3){
                    obstacleFactory.setSpeed(-3);
                }else{
                    obstacleFactory.setSpeed(-1);
                }
                break;
            case 'R':
                obstacleFactory.setImageLink("file:src/main/resources/car1Right.png");
                if(speed == 1){
                    obstacleFactory.setSpeed(0.75);
                } else if(speed == 2) {
                    obstacleFactory.setSpeed(1);
                }else if (speed == 3){
                    obstacleFactory.setSpeed(3);
                }else{
                    obstacleFactory.setSpeed(1.5);
                }
                break;
            default:
                obstacleFactory.setImageLink("file:src/main/resources/car1Left.png");
                if(speed == 1){
                    obstacleFactory.setSpeed(-1);
                } else if(speed == 2){
                    obstacleFactory.setSpeed(-3);
                }else{
                    obstacleFactory.setSpeed(-1);
                }
                break;

        }
        switch (lane){
            case 1:
                obstacleFactory.setYPos(485);
                break;
            case 2:
                obstacleFactory.setYPos(525);
                break;
            case 3:
                obstacleFactory.setYPos(565);
                break;
            case 4:
                obstacleFactory.setYPos(620);
                break;
            case 5:
                obstacleFactory.setYPos(660);
                break;
            default:
                obstacleFactory.setYPos(485);
                break;
        }


        carToWindow();
    }
    public void addTruckSmall(int amount, int startXPos, int lane, double speed) {
        // Going to the right -->
        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift of 300
        switch (lane){
            case 1:
                obstacleFactory.setYPos(485);
                break;
            case 2:
                obstacleFactory.setYPos(525);
                break;
            case 3:
                obstacleFactory.setYPos(565);
                break;
            case 4:
                obstacleFactory.setYPos(620);
                break;
            case 5:
                obstacleFactory.setYPos(660);
                break;
            default:
                obstacleFactory.setYPos(485);
                break;
        }
        obstacleFactory.setSpeed(speed);
        truckSmallToWindow();

    }
    public void addTruckBig(int amount, int startXPos, int lane, double speed) {
        // Going to the right -->

        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // shift 500
        switch (lane){
            case 1:
                obstacleFactory.setYPos(485);
                break;
            case 2:
                obstacleFactory.setYPos(525);
                break;
            case 3:
                obstacleFactory.setYPos(565);
                break;
            case 4:
                obstacleFactory.setYPos(620);
                break;
            case 5:
                obstacleFactory.setYPos(660);
                break;
            default:
                obstacleFactory.setYPos(485);
                break;
        }
        obstacleFactory.setSpeed(speed);
        truckBigToWindow();

    }

    public void addLogSmall(int amount, int startXPos, int lane) {
        obstacleFactory.setActorType("Log");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift 200
        switch (lane){
            case 1:
                obstacleFactory.setYPos(166);
                break;
            case 2:
                obstacleFactory.setYPos(217);
                break;
            case 3:
                obstacleFactory.setYPos(276);
                break;
            case 4:
                obstacleFactory.setYPos(329);
                break;
            case 5:
                obstacleFactory.setYPos(370);
                break;
            default:
                obstacleFactory.setYPos(166);
                break;
        }
        obstacleFactory.setSpeed(-2);
        logSmallToWindow();

    }
    public void addLogBig(int amount, int startXPos, int lane) {
        obstacleFactory.setActorType("Log");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift 200
        obstacleFactory.setSpeed(0.75);
        switch (lane){
            case 1:
                obstacleFactory.setYPos(166);
                break;
            case 2:
                obstacleFactory.setYPos(217);
                break;
            case 3:
                obstacleFactory.setYPos(276);
                break;
            case 4:
                obstacleFactory.setYPos(329);
                break;
            case 5:
                obstacleFactory.setYPos(370);
                break;
            default:
                obstacleFactory.setYPos(166);
                break;
        }
        logBigToWindow();

    }
    public void addLogLong(int amount, int startXPos, int lane) {
        obstacleFactory.setActorType("Log");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift 300
        switch (lane){
            case 1:
                obstacleFactory.setYPos(166);
                break;
            case 2:
                obstacleFactory.setYPos(217);
                break;
            case 3:
                obstacleFactory.setYPos(276);
                break;
            case 4:
                obstacleFactory.setYPos(329);
                break;
            case 5:
                obstacleFactory.setYPos(370);
                break;
            default:
                obstacleFactory.setYPos(166);
                break;
        }
        obstacleFactory.setSpeed(-2);
        logLongToWindow();

    }

    public void addDryTurtle(int amount, int startXPos, int lane) {
        obstacleFactory.setActorType("Turtle");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift of 200
        obstacleFactory.setSpeed(-1);
        switch (lane){
            case 1:
                obstacleFactory.setYPos(166);
                break;
            case 2:
                obstacleFactory.setYPos(217);
                break;
            case 3:
                obstacleFactory.setYPos(276);
                break;
            case 4:
                obstacleFactory.setYPos(329);
                break;
            case 5:
                obstacleFactory.setYPos(370);
                break;
            default:
                obstacleFactory.setYPos(166);
                break;
        }
        turtleToWindow();
    }
    public void addWetTurtle(int amount,int startXPos,int lane){
        obstacleFactory.setActorType("WetTurtle");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift of 200
        obstacleFactory.setSpeed(-1);
        switch (lane){
            case 1:
                obstacleFactory.setYPos(166);
                break;
            case 2:
                obstacleFactory.setYPos(217);
                break;
            case 3:
                obstacleFactory.setYPos(276);
                break;
            case 4:
                obstacleFactory.setYPos(329);
                break;
            case 5:
                obstacleFactory.setYPos(370);
                break;
            default:
                obstacleFactory.setYPos(166);
                break;
        }
        turtleWetToWindow();
    }

public void addStatic() {
    endToWindow();
}

//TODO: 'Mathematically automate the XPos and shift of each obstacle'
//FIXME: 'Get the correct sizes for each obstacle'
    public void carToWindow() {
        obstacleFactory.setSize(50);
        obstacleFactory.setShift(150);
        obstacleFactory.AddToWindow(stage);
    }
    public void turtleToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/TurtleAnimation2.png");
        obstacleFactory.setSize(80);
        obstacleFactory.setShift(200);
        obstacleFactory.AddToWindow(stage);
    }
    public void turtleWetToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/TurtleAnimation2.png");
        obstacleFactory.setSize(80);
        obstacleFactory.setShift(200);

        obstacleFactory.AddToWindow(stage);
    }
    public void truckSmallToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/truck1" + "Right.png");
        obstacleFactory.setSize(120);
        obstacleFactory.setShift(300);
        obstacleFactory.AddToWindow(stage);
    }
    public void truckBigToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/truck2Right.png");
        obstacleFactory.setSize(200);
        obstacleFactory.setShift(500);

        obstacleFactory.AddToWindow(stage);
    }
    public void logSmallToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/log_small.png");
        obstacleFactory.setSize(130);
        obstacleFactory.setShift(400);

        obstacleFactory.AddToWindow(stage);
    }
    public void logBigToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/log_big.png");
        obstacleFactory.setSize(180);
        obstacleFactory.setShift(250);
        obstacleFactory.AddToWindow(stage);

    }
    public void logLongToWindow(){
        obstacleFactory.setImageLink("file:src/main/resources/log_long.png");
        obstacleFactory.setSize(170);
        obstacleFactory.setShift(400);
        obstacleFactory.AddToWindow(stage);
    }

    public void endToWindow() {
//        staticActorFactory.setImageLink("file:src/Resources/End.png");
//        staticActorFactory.setSize(60);
//        staticActorFactory.setShift(128.2);
//
//        staticActorFactory.AddToWindow(game);
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
