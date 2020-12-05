package p4_group_8_repo;

import java.util.List;

public class LevelMaker {
    private MyStage game;
    private List<Actor> score;
    private List<Actor> players;
    private ActorGroupToWindow obstacleFactory = new ActorGroupToWindow("ObstacleFactory");
    private ActorGroupToWindow playerFactory = new ActorGroupToWindow("PlayerFactory");
    private ActorGroupToWindow staticActorFactory = new ActorGroupToWindow("StaticActorFactory");

    public LevelMaker(MyStage game,List<Actor> score) {
        this.game = game;
        this.score = score;
//        this.players = players;
//        addPlayer();
//        addStatic();
    }



    public void addCar(int amount, int startXPos, int YPos, double speed){
        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); //Shift of 150
        obstacleFactory.setYPos(YPos);
        obstacleFactory.setSpeed(speed);
        carToWindow();
    }
    public void addLogSmall(int amount, int startXPos, int YPos, double speed) {
        obstacleFactory.setActorType("Log");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift 200
        obstacleFactory.setYPos(YPos);
        obstacleFactory.setSpeed(speed);
        logSmallToWindow();

    }
    public void addLogBig(int amount, int startXPos, int YPos, double speed) {
        obstacleFactory.setActorType("Log");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift 200
        obstacleFactory.setYPos(YPos);
        obstacleFactory.setSpeed(speed);
        logBigToWindow();

    }
    public void addTurtles(int amount, int startXPos, int YPos, double speed) {
        obstacleFactory.setActorType("Turtle");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift of 200
        obstacleFactory.setYPos(YPos);
        obstacleFactory.setSpeed(speed);
        turtleToWindow();
        turtleWetToWindow();


    }
    public void addTruckSmall(int amount, int startXPos, int YPos, double speed) {
        // Going to the right -->
        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // Shift of 300
        obstacleFactory.setYPos(YPos);
        obstacleFactory.setSpeed(speed);
        truckSmallToWindow();

    }
    public void addTruckBig(int amount, int startXPos, int YPos, double speed) {
        // Going to the right -->

        obstacleFactory.setActorType("Car");
        obstacleFactory.setAmount(amount);
        obstacleFactory.setStartXPos(startXPos); // shift 500
        obstacleFactory.setYPos(YPos);
        obstacleFactory.setSpeed(speed);
        truckBigToWindow();

    }

    public void setNumber(int n) {
        for (Actor digit : score) {
            final int number = n % 10;

            ((Digit) digit).setDigit(number);

            n /= 10;
        }
    }
//    public void addPlayer() {
//
//        playerFactory.setStartXPos(300);
//        playerFactory.setYPos(706);
//        playerFactory.setAmount(1);
//        playerToWindow();
//    }
//
public void addStatic() {


//    staticActorFactory.setActorType("End");
//    staticActorFactory.setAmount(1);
//    staticActorFactory.setStartXPos(13); // Shift of 140
//    staticActorFactory.setYPos(90);
    endToWindow();

//    staticActorFactory.setActorType("Digit");
//    staticActorFactory.setStartXPos(360);
//    staticActorFactory.setYPos(25);
//    digitToWindow();
}

    public void carToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/car1Left.png");
        obstacleFactory.setSize(50);
        obstacleFactory.setShift(150);


        obstacleFactory.AddToWindow(game);
    }
    public void turtleToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/TurtleAnimation2.png");
        obstacleFactory.setSize(80);
        obstacleFactory.setShift(200);

        obstacleFactory.AddToWindow(game);
    }
    public void turtleWetToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/TurtleAnimation2.png");
        obstacleFactory.setSize(80);
        obstacleFactory.setShift(200);

        obstacleFactory.AddToWindow(game);
    }
    public void truckSmallToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/truck1" + "Right.png");
        obstacleFactory.setSize(120);
        obstacleFactory.setShift(300);
        obstacleFactory.AddToWindow(game);
    }
    public void truckBigToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/truck2Right.png");
        obstacleFactory.setSize(200);
        obstacleFactory.setShift(500);

        obstacleFactory.AddToWindow(game);
    }
    public void logSmallToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/logs.png");
        obstacleFactory.setSize(300);
        obstacleFactory.setShift(1300);

        obstacleFactory.AddToWindow(game);
    }
    public void logBigToWindow() {
        obstacleFactory.setImageLink("file:src/main/resources/log3.png");
        obstacleFactory.setSize(150);
        obstacleFactory.setShift(200);

        obstacleFactory.AddToWindow(game);
    }
    public void digitToWindow() {
//        staticActorFactory.setImageLink("file:src/Resources/0.png");
//        staticActorFactory.setSize(30);
//        staticActorFactory.setShift(-30);
//
        score = staticActorFactory.AddToWindow(game);
        staticActorFactory.setActorType("Digit");
        staticActorFactory.setStartXPos(360);
        staticActorFactory.setYPos(25);
        staticActorFactory.setImageLink("file:src/main/resources/0.png");
        staticActorFactory.setSize(30);
        staticActorFactory.setShift(-30);
//        staticActorFactory.AddToWindow(game);
        score = staticActorFactory.AddToWindow(game);
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

        staticActorFactory.AddToWindow(game);
    }
    public void playerToWindow() {
        playerFactory.setActorType("Animal");
        playerFactory.setImageLink("file:src/Resources/froggerUp.png");
        playerFactory.setShift(160);
        playerFactory.setSize(40);

        players = playerFactory.AddToWindow(game);
    }

}
