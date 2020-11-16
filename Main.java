package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {
    AnimationTimer timer;
    MyStage background = new MyStage();
    Animal animal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(background, 590, 800);
        backgroundINIT();
        primaryStage.setScene(scene);
        primaryStage.show();
        start();
    }


    public void backgroundINIT() {
        BackgroundImage froggerback = new BackgroundImage("file:E:\\Programming\\Intellij\\TryFrog1\\src\\p4_group_8_repo\\FBackground1.jpg");
        background.add(froggerback);

        /* Implementing log obstacles */
        background.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 0, 166, 0.75));
        background.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 220, 166, 0.75));
        background.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 440, 166, 0.75));
        background.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 50, 329, 0.75));
        background.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 270, 329, 0.75));
        background.add(new Log("file:src/p4_group_8_repo/log3.png", 120, 490, 329, 0.75));
        background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 0, 276, -2));
        background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 400, 276, -2));


        /* Implementing Turtle Obstacles */
        background.add(new Turtle(500, 370, -1, 80, 80));
        background.add(new Turtle(300, 370, -1, 80, 80));

        /* Implementing Wet Turtle Obstacles */
        background.add(new WetTurtle(700, 370, -1, 80, 80));
        background.add(new WetTurtle(600, 217, -1, 100, 100));
        background.add(new WetTurtle(400, 217, -1, 100, 100));
        background.add(new WetTurtle(200, 217, -1, 100, 100));


        /* Implementing Truck -> Right Obstacles */
        background.add(new obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 0, 649, 1, 120, 120));
        background.add(new obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 300, 649, 1, 120, 120));
        background.add(new obstacle("file:src/p4_group_8_repo/truck1" + "Right.png", 600, 649, 1, 120, 120));
        //background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
        background.add(new obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 540, 1, 200, 200));
        background.add(new obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 540, 1, 200, 200));

        /* Implementing Car <- Left Obastacles */
        background.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 597, -1, 50, 50));
        background.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 597, -1, 50, 50));
        background.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 597, -1, 50, 50));
        background.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 597, -1, 50, 50));
        background.add(new obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 490, -5, 50, 50));


        /* Implementing End goals */
        int x = 13;
        int x1 = 140;
        int y = 90;
        background.add(new End(x, y));
        background.add(new End(x1, y));
        background.add(new End(x1 * 2 - x, y));
        background.add(new End(x1 * 3 - x * 2, y));
        background.add(new End(x1 * 4 - x * 3, y));

        /* Initialising ScoreBoard */
        background.add(new Digit(0, 30, 360, 25));

        /* Initialising Frogger start position */
        animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
        background.add(animal);

        background.start();
    }


    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    background.stopMusic();
                    stop();
                    background.stop();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }

    public void start() {
        //background.playMusic();
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            background.add(new Digit(k, 30, 360 - shift, 25));
            shift += 30;
        }
    }
}
