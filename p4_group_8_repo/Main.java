package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
// https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
public class Main extends Application {
    private AnimationTimer timer;
    private MyStage game;
//    private MyStage menu;
    private List<Actor> players;
    private List<Actor> score;
    private int level = 1;
    private LevelMaker level1,level2,level3,level4;
    Scene menuScene, infoScene, levelChoiceScene;
    Scene gameScene, level1Scene,level2Scene,level3Scene,level4Scene,level5Scene,level6Scene,level7Scene,level8Scene,level9Scene,level10Scene;

    private Stage primaryStage;


//    private AnchorPane content;
    private AnchorPane menu;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        createInfo(primaryStage);
//        menuController control = new menuController();

        //Game Scene
//        gameRoot = (AnchorPane)FXMLLoader.load(getClass().getResource("game.fxml"));
        BackgroundImage backgroundImage = new BackgroundImage("file:src/Resources/FBackground1.jpg");

        game = new MyStage();

        gameScene = new Scene(game, 590, 800);
        game.add(backgroundImage);


        level1 = new LevelMaker(game,score);
        level1.addCar(4,100,597,-1);
        level1.addCar(4,500,475,-1);
//        level1.addStatic();
//        level1.endToWindow(2);
//        addObstacle();
        addPlayer();
        addStatic();

        level1.addStatic();
//        level1.addPlayer();


//        gameRoot.getChildren().add(game);
//        Scene gamer = new Scene(gameRoot, 590, 800);


//        menu = createMenu(primaryStage);

        createMenu(primaryStage);
//        menuScene = new Scene(menu,553,415);

//        menuScene = new Scene(root);


        primaryStage.setTitle("Frogger Game!");
        game.start();
        primaryStage.setScene(menuScene);
        primaryStage.show();
        start();
    }

    public AnchorPane createLevel1(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        addPlayer();
        addStatic();
        LevelMaker level = new LevelMaker(game,score);
        return contents;
    }
    public AnchorPane createLevel2(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        addPlayer();
        addStatic();
        LevelMaker level = new LevelMaker(game,score);
        return contents;
    }
    public AnchorPane createLevel3(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        LevelMaker level = new LevelMaker(game,score);
        return contents;
    }
    public AnchorPane createLevel4(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        LevelMaker level = new LevelMaker(game,score);
        return contents;
    }
    public AnchorPane createLevel5(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        LevelMaker level = new LevelMaker(game,score);
        return contents;
    }
    public AnchorPane createLevel6(Stage primaryStage){
        AnchorPane contents = new AnchorPane();

        return contents;
    }
    public AnchorPane createLevel7(Stage primaryStage){
        AnchorPane contents = new AnchorPane();

        return contents;
    }
    public AnchorPane createLevel8(Stage primaryStage){
        AnchorPane contents = new AnchorPane();

        return contents;
    }
    public AnchorPane createLevel9(Stage primaryStage){
        AnchorPane contents = new AnchorPane();

        return contents;
    }
    public AnchorPane createLevel10(Stage primaryStage){
        AnchorPane contents = new AnchorPane();

        return contents;
    }

    public void createLvlChooser(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        Label title= new Label("Frogger");
        title.setLayoutX(204.0);
        title.setLayoutY(30);
        title.setTextFill(Paint.valueOf("#0edd34"));
        title.setFont(Font.font("Cambria Bold Italic",50.0));
        Button level1Btn,level2Btn,level3Btn,level4Btn,level5Btn,level6Btn,level8Btn,level9Btn,level10Btn;

        level1Btn = new Button("Level1");
        level1Btn.setLayoutX(14);
        level1Btn.setLayoutY(361);
        level1Btn.prefHeight(25.0);
        level1Btn.prefWidth(57.0);
        level1Btn.setOnAction(e -> primaryStage.setScene(level1Scene));
//        contents.getChildren().addAll(title, txtArea,backBtn);
        levelChoiceScene = new Scene(contents);
    }
    public void createInfo(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        contents.setPrefWidth(600);
        contents.setPrefHeight(400);

        Label title= new Label("Frogger");
        title.setLayoutX(204.0);
        title.setLayoutY(20);
        title.setTextFill(Paint.valueOf("#0edd34"));
        title.setFont(Font.font("Cambria Bold Italic",50.0));

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(14);
        backBtn.setLayoutY(361);
        backBtn.prefHeight(25.0);
        backBtn.prefWidth(57.0);
        backBtn.setOnAction(e -> primaryStage.setScene(menuScene));

        Label text = new Label();
        text.setWrapText(true);
        text.setLayoutX(22);
        text.setLayoutY(88);
        text.setText("Rules:\n - Use W,A,S,D to control the Frog\n - Avoid obstacles such as trucks and cars\n - Use Logs and turtles to move across water (becareful of the turtles that sink!)\n - To score points avoid obstacles and reach the end goals \n");
        text.setFont(Font.font("Arial Black",12.0));


        contents.getChildren().addAll(title, text,backBtn);
        infoScene = new Scene(contents);

    }


    public void createMenu(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        contents.setPrefWidth(600);
        contents.setPrefHeight(400);

        Label title= new Label("Frogger");
        title.setLayoutX(204.0);
        title.setLayoutY(30);
        title.setTextFill(Paint.valueOf("#0edd34"));
        title.setFont(Font.font("Cambria Bold Italic",50.0));

        Image image = new Image("file:src/Resources/smiiling-big-eyed-green-frog-clipart-6926.jpg");
        ImageView coverIMG = new ImageView(image);
        coverIMG.setX(186.0);
        coverIMG.setY(96.0);
        coverIMG.setFitWidth(228.0);
        coverIMG.setFitHeight(175.0);
        coverIMG.setPickOnBounds(true);
        coverIMG.setPreserveRatio(true);

        Button playBtn= new Button("Choose Level");
        playBtn.setLayoutX(242);
        playBtn.setLayoutY(268);
        playBtn.prefHeight(25.0);
        playBtn.prefWidth(57.0);
        Font font = new Font(18.0);
        playBtn.setFont(font);
        playBtn.setOnAction(e -> primaryStage.setScene(gameScene));
//        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        Button infoBtn = new Button("Info");
        infoBtn.setLayoutX(282);
        infoBtn.setLayoutY(322);
        infoBtn.prefHeight(25.0);
        infoBtn.prefWidth(57.0);
        infoBtn.setOnAction(e -> primaryStage.setScene(infoScene));

        contents.getChildren().addAll(title, playBtn,infoBtn,coverIMG);
        menuScene = new Scene(contents);

    }
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for(Actor Player: players) {
                    if (( (Animal) Player).changeScore()) {
                        setNumber(( (Animal) Player).getScore());
                    }
                    if (( (Animal) Player).getStop()) {
                        System.out.print("STOPP:");
                        game.stopMusic();
                        stop();
                        game.stop();
                        Alert winAlert = new Alert(AlertType.INFORMATION);
                        winAlert.setTitle("You Have Won The Game!");
                        winAlert.setHeaderText("Your High Score: "+( (Animal) Player).getScore()+"!");
                        winAlert.setContentText("Highest Possible Score: 800");
                        winAlert.show();

                    }
                }
            }
        };
    }

    public void start() {
        game.playMusic();
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
        grouper.setYPos(706);
        grouper.setAmount(1);
        playerToWindow(grouper);
    }

    public void addStatic() {
        ActorGroupToWindow grouper = new ActorGroupToWindow("StaticActorFactory");

//        grouper.setActorType("End");
//        grouper.setAmount(1);
//        grouper.setStartXPos(13); // Shift of 140
//        grouper.setYPos(90);
//        endToWindow(grouper);

        grouper.setActorType("Digit");
        grouper.setAmount(3);
        grouper.setStartXPos(360);
        grouper.setYPos(25);
        digitToWindow(grouper);
    }

    /* Add Obstacles */
    public void addCar(ActorGroupToWindow grouper) {
        grouper.setActorType("Car");
        grouper.setAmount(4);
        grouper.setStartXPos(100); //Shift of 150
        grouper.setYPos(597);
        grouper.setSpeed(-1);
        carToWindow(grouper);

        grouper.setActorType("Car");
        grouper.setAmount(1);
        grouper.setStartXPos(500); //Shift of 150
        grouper.setYPos(475);
        grouper.setSpeed(-5);
        carToWindow(grouper);

    }

    public void addLog(ActorGroupToWindow grouper) {
        grouper.setActorType("Log");
        grouper.setAmount(3);
        grouper.setStartXPos(0); // Shift 200
        grouper.setYPos(166);
        grouper.setSpeed(0.75);
        logBigToWindow(grouper);

        grouper.setActorType("Log");
        grouper.setAmount(3);
        grouper.setStartXPos(50);
        grouper.setYPos(329);
        grouper.setSpeed(0.75);
        logBigToWindow(grouper);

        grouper.setActorType("Log");
        grouper.setAmount(2);
        grouper.setStartXPos(0); // Shift by 400
        grouper.setYPos(276);
        grouper.setSpeed(-2);
        logSmallToWindow(grouper);
    }

    public void addTurtles(ActorGroupToWindow grouper) {
        grouper.setActorType("Turtle");
        grouper.setAmount(2);
        grouper.setStartXPos(300); // Shift of 200
        grouper.setYPos(370);
        grouper.setSpeed(-1);
        turtleToWindow(grouper);

        grouper.setActorType("WetTurtle");
        grouper.setAmount(1);
        grouper.setStartXPos(700); // Shift of 200
        grouper.setYPos(370);
        grouper.setSpeed(-1);
        turtleWetToWindow(grouper);

        grouper.setActorType("WetTurtle");
        grouper.setAmount(3);
        grouper.setStartXPos(200); // Shift of 200
        grouper.setYPos(217);
        grouper.setSpeed(-1);
        turtleWetToWindow(grouper);
    }

    public void addTruck(ActorGroupToWindow grouper) {
        // Going to the right -->
        grouper.setActorType("Car");
        grouper.setAmount(3);
        grouper.setStartXPos(0); // Shift of 300
        grouper.setYPos(649);
        grouper.setSpeed(1);
        truckSmallToWindow(grouper);

        grouper.setActorType("Car");
        grouper.setAmount(2);
        grouper.setStartXPos(0); // shift 500
        grouper.setYPos(540);
        grouper.setSpeed(1);
        truckBigToWindow(grouper);

    }


    /* Adding to window */
    public void carToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/car1Left.png");
        grouper.setSize(50);
        grouper.setShift(150);

        grouper.AddToWindow(game);
    }

    public void turtleToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/TurtleAnimation2.png");
        grouper.setSize(80);
        grouper.setShift(200);

        grouper.AddToWindow(game);
    }

    public void turtleWetToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/TurtleAnimation2.png");
        grouper.setSize(80);
        grouper.setShift(200);

        grouper.AddToWindow(game);
    }

    public void truckSmallToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/truck1" + "Right.png");
        grouper.setSize(120);
        grouper.setShift(300);

        grouper.AddToWindow(game);
    }

    public void truckBigToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/truck2Right.png");
        grouper.setSize(200);
        grouper.setShift(500);

        grouper.AddToWindow(game);
    }

    public void logSmallToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/logs.png");
        grouper.setSize(300);
        grouper.setShift(1300);

        grouper.AddToWindow(game);
    }

    public void logBigToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/log3.png");
        grouper.setSize(150);
        grouper.setShift(200);

        grouper.AddToWindow(game);
    }

    public void digitToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/0.png");
        grouper.setSize(30);
        grouper.setShift(-30);

        score = grouper.AddToWindow(game);
    }

    public void endToWindow(ActorGroupToWindow grouper) {
        grouper.setImageLink("file:src/Resources/End.png");
        grouper.setSize(60);
        grouper.setShift(128.2);

        grouper.AddToWindow(game);
    }

    public void playerToWindow(ActorGroupToWindow grouper) {
        grouper.setActorType("Animal");

        grouper.setImageLink("file:src/Resources/froggerUp.png");

        grouper.setShift(160);

        grouper.setSize(40);


        players = grouper.AddToWindow(game);
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


