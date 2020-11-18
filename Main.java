package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {
    private AnimationTimer timer;
    private MyStage area;
    private List<Actor> players;
    private List<Actor> score;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundImage backgroundImage = new BackgroundImage("file:src/p4_group_8_repo/FBackground1.jpg");

        area = new MyStage();
        Scene scene = new Scene(area, 590, 800);

        area.add(backgroundImage);


        addObstacle();
        addPlayer();
        addStatic();

        area.start();
        primaryStage.setTitle("Frogger Game!");
        primaryStage.setScene(scene);
        primaryStage.show();
        start();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for(Actor Player:players) {
                    if (( (Animal) Player).changeScore()) {
                        setNumber(( (Animal) Player).getPoints());
                    }
                    if (( (Animal) Player).getStop()) {
                        System.out.print("STOPP:");
                        area.stopMusic();
                        stop();
                        area.stop();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("You Have Won The Game!");
                        alert.setHeaderText("Your High Score: "+( (Animal) Player).getPoints()+"!");
                        alert.setContentText("Highest Possible Score: 800");
                        alert.show();
                    }
                }
            }
        };
    }

    public void start() {
//        area.playMusic();
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        for (Actor digit : score) {
            final int number = n % 10;

            ((Digit) digit).setDigit(number);

            n /= 10;
        }
    }


    public void addObstacle() {
        ActorGroupToWindow grouper = new ActorGroupToWindow("ObstacleFactory");

        addCar(grouper);
        addLog(grouper);
        addTurtles(grouper);
        addTruck(grouper);

    }

    public void addPlayer() {
        ActorGroupToWindow grouper = new ActorGroupToWindow("PlayerFactory");
        grouper.setStartXPos(300);
        grouper.setyPos(706);
        grouper.setAmount(1);
        playerToWindow(grouper);
    }

    public void addStatic() {
        ActorGroupToWindow grouper = new ActorGroupToWindow("StaticActorFactory");

        grouper.setActorType("End");
        grouper.setAmount(5);
        grouper.setStartXPos(13); // Shift of 140
        grouper.setyPos(90);
        endToWindow(grouper);

        grouper.setActorType("Digit");
        grouper.setStartXPos(360);
        grouper.setyPos(25);
        digitToWindow(grouper);
    }

    /* Add Obstacles */
    public void addCar(ActorGroupToWindow grouper) {
        grouper.setActorType("Car");
        grouper.setAmount(4);
        grouper.setStartXPos(100); //Shift of 150
        grouper.setyPos(597);
        grouper.setSpeed(-1);
        carToWindow(grouper);

        grouper.setActorType("Car");
        grouper.setAmount(1);
        grouper.setStartXPos(500); //Shift of 150
        grouper.setyPos(490);
        grouper.setSpeed(-5);
        carToWindow(grouper);

    }

    public void addLog(ActorGroupToWindow grouper) {
        grouper.setActorType("Log");
        grouper.setAmount(3);
        grouper.setStartXPos(0); // Shift 200
        grouper.setyPos(166);
        grouper.setSpeed(0.75);
        logBigToWindow(grouper);

        grouper.setActorType("Log");
        grouper.setAmount(3);
        grouper.setStartXPos(50);
        grouper.setyPos(329);
        grouper.setSpeed(0.75);
        logBigToWindow(grouper);

        grouper.setActorType("Log");
        grouper.setAmount(2);
        grouper.setStartXPos(0); // Shift by 400
        grouper.setyPos(276);
        grouper.setSpeed(-2);
        logSmallToWindow(grouper);
    }

    public void addTurtles(ActorGroupToWindow grouper) {
        grouper.setActorType("Turtle");
        grouper.setAmount(2);
        grouper.setStartXPos(300); // Shift of 200
        grouper.setyPos(370);
        grouper.setSpeed(-1);
        turtleToWindow(grouper);

        grouper.setActorType("WetTurtle");
        grouper.setAmount(1);
        grouper.setStartXPos(700); // Shift of 200
        grouper.setyPos(370);
        grouper.setSpeed(-1);
        turtleWetToWindow(grouper);

        grouper.setActorType("WetTurtle");
        grouper.setAmount(3);
        grouper.setStartXPos(200); // Shift of 200
        grouper.setyPos(217);
        grouper.setSpeed(-1);
        turtleWetToWindow(grouper);
    }

    public void addTruck(ActorGroupToWindow grouper) {
        // Going to the right -->
        grouper.setActorType("Car");
        grouper.setAmount(3);
        grouper.setStartXPos(0); // Shift of 300
        grouper.setyPos(649);
        grouper.setSpeed(1);
        truckSmallToWindow(grouper);

        grouper.setActorType("Car");
        grouper.setAmount(2);
        grouper.setStartXPos(0); // shift 500
        grouper.setyPos(540);
        grouper.setSpeed(1);
        truckBigToWindow(grouper);

    }


    /* Adding to window */
    public void carToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/car1Left.png");
        grouper.setSize(50);
        grouper.setShift(150);

        grouper.AddToWindow(area);
    }

    public void turtleToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/TurtleAnimation2.png");
        grouper.setSize(80);
        grouper.setShift(200);

        grouper.AddToWindow(area);
    }

    public void turtleWetToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/TurtleAnimation2.png");
        grouper.setSize(80);
        grouper.setShift(200);

        grouper.AddToWindow(area);
    }

    public void truckSmallToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/truck1" + "Right.png");
        grouper.setSize(120);
        grouper.setShift(300);

        grouper.AddToWindow(area);
    }

    public void truckBigToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/truck2Right.png");
        grouper.setSize(200);
        grouper.setShift(500);

        grouper.AddToWindow(area);
    }

    public void logSmallToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/logs.png");
        grouper.setSize(200);
        grouper.setShift(400);

        grouper.AddToWindow(area);
    }

    public void logBigToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/log3.png");
        grouper.setSize(120);
        grouper.setShift(200);

        grouper.AddToWindow(area);
    }

    public void digitToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/0.png");
        grouper.setSize(30);
        grouper.setShift(-30);

        score = grouper.AddToWindow(area);
    }

    public void endToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/p4_group_8_repo/End.png");
        grouper.setSize(60);
        grouper.setShift(128.2);

        grouper.AddToWindow(area);
    }

    public void playerToWindow(ActorGroupToWindow grouper) {
        grouper.setActorType("Animal");

        grouper.setImageLink("file:src/p4_group_8_repo/froggerUp.png");

        grouper.setShift(160);

        grouper.setSize(40);


        players = grouper.AddToWindow(area);
    }
}
/*
    public void backgroundINIT() {
        BackgroundImage background = new BackgroundImage("file:E:\\Programming\\Intellij\\TryFrog1\\src\\p4_group_8_repo\\FBackground1.jpg");
        area.add(background);

        // Implementing log obstacles
        area.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 0, 166, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 220, 166, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 440, 166, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 50, 329, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 270, 329, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 490, 329, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 0, 276, -2));
        area.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 400, 276, -2));


        // Implementing Turtle Obstacles
        area.add(new Turtle(500, 370, -1, 80, 80));
        area.add(new Turtle(300, 370, -1, 80, 80));

       // Implementing Wet Turtle Obstacles
        area.add(new WetTurtle(700, 370, -1, 80, 80));
        area.add(new WetTurtle(600, 217, -1, 100, 100));
        area.add(new WetTurtle(400, 217, -1, 100, 100));
        area.add(new WetTurtle(200, 217, -1, 100, 100));


        // Implementing Truck -> Right Obstacles
        area.add(new obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 0, 649, 1, 120, 120));
        area.add(new obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 300, 649, 1, 120, 120));
        area.add(new obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 600, 649, 1, 120, 120));
        //background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
        area.add(new obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 540, 1, 200, 200));
        area.add(new obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 540, 1, 200, 200));

        // Implementing Car <- Left Obastacles
        area.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 597, -1, 50, 50));
        area.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 597, -1, 50, 50));
        area.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 597, -1, 50, 50));
        area.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 597, -1, 50, 50));
        area.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 490, -5, 50, 50));


        // Implementing End goals
        int x = 13;
        int x1 = 140;
        int y = 90;
        area.add(new End(x, y));
        area.add(new End(x1, y));
        area.add(new End(x1 * 2 - x, y));
        area.add(new End(x1 * 3 - x * 2, y));
        area.add(new End(x1 * 4 - x * 3, y));

        // Initialising ScoreBoard
        area.add(new Digit(0, 30, 360, 25));

        // Initialising Frogger start position
        animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
        area.add(animal);

        area.start();
    }
 */


