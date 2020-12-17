package p4_group_8_repo;



import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
/**
 * @author Noah Rijkaard 20123697
 */


// https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
public class Main extends Application {

    private AnimationTimer timer;
    private MyStage menu;
    private List<Actor> players;
    private List<Actor> score;
    private Scene menuScene, infoScene, levelChoiceScene, gameScene, scoreboardScene;
    private BackgroundImage backgroundImage;
    private HighscoreManager scoreKeeper = new HighscoreManager("Game");
    private MyStage game;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        game = new MyStage();
        addPlayer(game);
        createHSPage(primaryStage);
        createInfo(primaryStage);
        createMenu(primaryStage);
        createLvlChooser(primaryStage);


        primaryStage.setTitle("Frogger Game!");
        primaryStage.setScene(menuScene);
        primaryStage.show();
        start();
    }
//TODO: 'Find way at end of game to go back to level select screen'

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
                        stop();

                        scoreKeeper.addScore(((Animal) Player).getScore());
                        scoreKeeper.printScore();

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

    //FIXME: 'Game ends music while moving, as well as not ending music after getting all ends'
    public void stop() {
        timer.stop();
        game.stop();
        game.stopMusic();

    }

    public void setNumber(int n) {
        for (Actor digit : score) {
            final int number = n % 10;

            ((Digit) digit).setDigit(number);

            n /= 10;
        }
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

        Image image = new Image("file:src/main/resources/smiiling-big-eyed-green-frog-clipart-6926.jpg");
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
        playBtn.setOnAction(e -> primaryStage.setScene(levelChoiceScene));

        Button scoreboardBtn = new Button("Score Board");
        scoreboardBtn.setLayoutX(242);
        scoreboardBtn.setLayoutY(350);
        scoreboardBtn.prefHeight(25.0);
        scoreboardBtn.prefWidth(57.0);
        scoreboardBtn.setOnAction(e -> primaryStage.setScene(scoreboardScene));

        Button infoBtn = new Button("Info");
        infoBtn.setLayoutX(282);
        infoBtn.setLayoutY(322);
        infoBtn.prefHeight(25.0);
        infoBtn.prefWidth(57.0);
        infoBtn.setOnAction(e -> primaryStage.setScene(infoScene));

        contents.getChildren().addAll(title, playBtn,infoBtn,scoreboardBtn,coverIMG);
        menuScene = new Scene(contents);

    }
    //FIXME:'Fix organisation of buttons'
    public void createLvlChooser(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        Label title= new Label("Frogger");
        title.setLayoutX(204.0);
        title.setLayoutY(30);
        title.setTextFill(Paint.valueOf("#0edd34"));
        title.setFont(Font.font("Cambria Bold Italic",53.0));

        Button level1Btn = getLvlBtn("Level 1", 98,162);
        level1Btn.setOnAction(actionEvent ->  {

            createLevel1();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 1:");

        });
        Button level2Btn = getLvlBtn("Level 2", 180,162);
        level2Btn.setOnAction(actionEvent ->  {
            createLevel2();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 2:");
        });

        Button level3Btn = getLvlBtn("Level 3",253,162);
        level3Btn.setOnAction(actionEvent ->  {
            createLevel3();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 3:");
        });

        Button level4Btn = getLvlBtn("Level 4",331,162);
        level4Btn.setOnAction(actionEvent ->  {
            createLevel4();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 4:");
        });
        Button level5Btn = getLvlBtn("Level 5",404,162);
        level5Btn.setOnAction(actionEvent ->  {
            createLevel5();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 5:");
        });

        Button level6Btn = getLvlBtn("Level 6", 98,214);
        level6Btn.setOnAction(actionEvent ->  {
            createLevel6();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 6:");
        });

        Button level7Btn = getLvlBtn("Level 7",180,214);
        level7Btn.setOnAction(actionEvent ->  {
            createLevel7();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 7:");
        });

        Button level8Btn = getLvlBtn("Level 8",253,214);
        level8Btn.setOnAction(actionEvent ->  {
            createLevel8();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 8:");
        });

        Button level9Btn = getLvlBtn("level9",331,214);
        level9Btn.setOnAction(actionEvent ->  {
            createLevel9();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 9:");
        });

        Button level10Btn = getLvlBtn("level10",401,214);
        level10Btn.setOnAction(actionEvent ->  {
            createLevel10();
            primaryStage.setScene(gameScene);
            scoreKeeper = new HighscoreManager("Level 10:");
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(14);
        backBtn.setLayoutY(361);
        backBtn.prefHeight(25.0);
        backBtn.prefWidth(57.0);
        backBtn.setOnAction(e -> primaryStage.setScene(menuScene));


        contents.getChildren().addAll(title, level1Btn,level2Btn,level3Btn,level4Btn,level5Btn,level6Btn,level7Btn,level8Btn,level9Btn,level10Btn,backBtn);
//        contents.getChildren().addAll(title, level1Btn,level2Btn,backBtn);
        levelChoiceScene = new Scene(contents,600,400);
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
    public void createHSPage(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        String scoreboard = scoreKeeper.getScoreBoard();
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
        text.setText(scoreboard);
        text.setFont(Font.font("Arial Black",12.0));


        contents.getChildren().addAll(title, text,backBtn);
        scoreboardScene = new Scene(contents);
    }

    public Button getLvlBtn(String name,double x, double y){
        Button button = new Button(name);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.prefHeight(401);
        button.prefWidth(214);
        button.setUnderline(true);
        button.setTextFill(Paint.valueOf("#62cd3f"));
        button.setFont(Font.font("Arial Rounded MT Bold", 12.0));
        return button;
    }

    // Initializing items in levels


//FIXME: 'Optimize the positions of all the obstacles'
    public void createLevel1(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);

        LevelMaker level1 = new LevelMaker(game);
        level1.addTruckSmall(3,1,1,'L');
        level1.addCar       (4,2,2,'R');
        level1.addTruckBig  (2,3,1,'L');
        level1.addCar       (4,4,2,'R');
        level1.addTruckSmall(3,5,1,'L');


        level1.addLogBig   (2,1);
        level1.addWetTurtle(3,2);
        level1.addLogSmall (4,3);
        level1.addLogBig   (3,4);
        level1.addDryTurtle(2,5);
        level1.addWetTurtle(1,5);

        addPlayer(game);
        addStatic(game);
        game.start();
    }
    public void createLevel2(){
//        level2Stage = new MyStage();
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);

        LevelMaker level2 = new LevelMaker(game);
        level2.addCar(3,5,2,'R');
        level2.addCar(2,4,3,'L');
        level2.addCar(3,3,2,'R');
        level2.addCar(4,2,3,'L');
        level2.addCar(4,1,2,'R');




        level2.addLogBig   (3,5);
        level2.addWetTurtle(4,4);
        level2.addLogBig   (1,3);
        level2.addLogSmall (2,2);
        level2.addWetTurtle(3,1);


        addPlayer(game);
        addStatic(game);
        game.start();

    }

    public void createLevel3(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);

        LevelMaker level3 = new LevelMaker(game);
        level3.addCar(3,5,2,'R');
        level3.addCar(2,4,1,'L');
        level3.addCar(5,3,2,'R');
        level3.addCar(4,2,2,'L');
        level3.addCar(4,1,2,'R');





        level3.addWetTurtle(3,1);
        level3.addLogSmall (3,2);
        level3.addLogLong  (1,3);
        level3.addDryTurtle(4,4);
        level3.addLogSmall (3,5);
        addPlayer(game);
        addStatic(game);
        game.start();
//        level3Stage.start();
    }
    public void createLevel4(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);
        LevelMaker level4 = new LevelMaker(game);
        level4.addCar(3,5,1,'R');
        level4.addCar(3,4,3,'L');
        level4.addCar(4,3,2,'R');
        level4.addCar(4,2,2,'L');
        level4.addCar(4,1,2,'R');





        level4.addWetTurtle(3,1);
        level4.addLogSmall (2,2);
        level4.addLogLong  (1,3);
        level4.addWetTurtle(3,4);
        level4.addLogBig   (2,5);
        addPlayer(game);
        addStatic(game);
        game.start();

//        level4Stage.start();
    }
    public void createLevel5(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);
        LevelMaker level5 = new LevelMaker(game);
        level5.addCar(3,5,2,'L');
        level5.addCar(4,4,1,'R');
        level5.addCar(5,3,2,'L');
        level5.addCar(4,2,2,'R');
        level5.addCar(5,1,2,'L');





        level5.addWetTurtle(2,1);
        level5.addLogSmall (2,2);
        level5.addLogLong  (1,3);
        level5.addWetTurtle(3,4);
        level5.addLogBig   (1,5);

        addPlayer(game);
        addStatic(game);
        game.start();
//        level5Stage.start();
    }
    public void createLevel6(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);

        LevelMaker level6 = new LevelMaker(game);
        level6.addCar(2,5,2,'L');
        level6.addCar(1,4,1,'R');
        level6.addCar(3,3,2,'L');
        level6.addCar(3,2,2,'R');
        level6.addCar(3,1,2,'L');


        level6.addWetTurtle(4,1);
        level6.addLogSmall (3,2);
        level6.addLogLong  (3,3);
        level6.addWetTurtle(4,4);
        level6.addLogBig   (2,5);


        addPlayer(game);
        addStatic(game);
        game.start();

    }
    public void createLevel7(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);

        LevelMaker level7 = new LevelMaker(game);
        level7.addCar(2,5,2,'L');
        level7.addCar(1,4,1,'R');
        level7.addCar(3,3,2,'L');
        level7.addCar(3,2,2,'R');
        level7.addCar(3,1,2,'L');


        level7.addWetTurtle(4,1);
        level7.addLogSmall (3,2);
        level7.addLogLong  (3,3);
        level7.addWetTurtle(4,4);
        level7.addLogBig   (2,5);


        addPlayer(game);
        addStatic(game);
        game.start();

    }
    public void createLevel8(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);

        LevelMaker level8 = new LevelMaker(game);
        level8.addCar(4,1,2,'L');
        level8.addCar(4,2,2,'R');
        level8.addCar(5,3,2,'L');
        level8.addCar(2,4,3,'R');
        level8.addCar(3,5,2,'L');



        level8.addDryTurtle(3,1);
        level8.addLogSmall (3,2);
        level8.addLogLong  (1,3);
        level8.addWetTurtle(4,4);
        level8.addLogBig   (1,5);

        addPlayer(game);
        addStatic(game);
        game.start();
    }
    public void createLevel9(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);

        LevelMaker level9 = new LevelMaker(game);
        level9.addCar(4,1,2,'L');
        level9.addCar(4,2,2,'R');
        level9.addCar(4,3,2,'L');
        level9.addCar(4,4,3,'R');
        level9.addCar(4,5,2,'L');



        level9.addWetTurtle(3,1);
        level9.addLogSmall (2,2);
        level9.addLogLong  (1,3);
        level9.addLogSmall (2,4);
        level9.addWetTurtle(2,5);


        addPlayer(game);
        addStatic(game);
        game.start();
//        level9Stage.start();
    }
    public void createLevel10(){
        game = new MyStage();
        gameScene = new Scene(game, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        game.add(backgroundImage);

        LevelMaker level10 = new LevelMaker(game);
        level10.addCar(5,1,2,'L');
        level10.addCar(4,2,2,'R');
        level10.addCar(5,3,2,'L');
        level10.addCar(4,4,1,'R');
        level10.addCar(4,5,2,'L');



        level10.addWetTurtle (2,1);
        level10.addLogSmall  (2,2);
        level10.addLogLong   (1,3);
        level10.addWetTurtle (4,4);
        level10.addWetTurtle (2,5);


        addPlayer(game);
        addStatic(game);
        game.start();
//        level10Stage.start();
    }




    public void addPlayer(MyStage stage) {
        ActorGroupToWindow grouper = new ActorGroupToWindow("PlayerFactory");
        grouper.setStartXPos(300);
        grouper.setYPos(706);
        grouper.setAmount(1);
        playerToWindow(grouper,stage);
    }

    public void addStatic(MyStage stage) {
        ActorGroupToWindow grouper = new ActorGroupToWindow("StaticActorFactory");
        grouper.setActorType("Digit");
        grouper.setAmount(5);
        grouper.setStartXPos(460);
        grouper.setYPos(25);
        digitToWindow(grouper,stage);
    }



    /* Adding to window */
    public void digitToWindow(ActorGroupToWindow grouper, MyStage stage) {
        grouper.setImageLink("file:src/main/resources/0.png");
        grouper.setSize(30);
        grouper.setShift(-30);
        score = grouper.AddToWindow(stage);
    }

    public void playerToWindow(ActorGroupToWindow grouper, MyStage stage) {
        grouper.setActorType("Animal");
        grouper.setImageLink("file:src/main/resources/froggerUp.png");
        grouper.setShift(160);
        grouper.setSize(40);
        players = grouper.AddToWindow(stage);
    }
}


