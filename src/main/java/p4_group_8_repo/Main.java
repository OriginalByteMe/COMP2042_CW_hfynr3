package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;


// https://gamedevelopment.tutsplus.com/tutorials/introduction-to-javafx-for-game-development--cms-23835
public class Main extends Application {
    private AnimationTimer timer;
    private MyStage menu;
    private List<Actor> players;
    private List<Actor> score;
    private Scene menuScene, infoScene, levelChoiceScene;
    Scene level1Scene,level2Scene,level3Scene,level4Scene,level5Scene,level6Scene,level7Scene,level8Scene,level9Scene,level10Scene;
    private BackgroundImage backgroundImage;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        callLevels();
        createInfo(primaryStage);
        createMenu(primaryStage);
        createLvlChooser(primaryStage);



        primaryStage.setTitle("Frogger Game!");

        primaryStage.setScene(menuScene);
        primaryStage.show();
        start(menu);
    }
//TODO: 'Find way at end of game to go back to level select screen'
    public void createTimer(MyStage stage) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for(Actor Player: players) {
                    if (( (Animal) Player).changeScore()) {
                        setNumber(( (Animal) Player).getScore());
                    }
                    if (( (Animal) Player).getStop()) {
                        System.out.print("STOPP:");
                        stage.stopMusic();
                        stop();
                        stage.stop();
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

    public void start(MyStage stage) {
        stage.playMusic();
        createTimer(stage);
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


    public void callLevels(){
        createLevel1();
        createLevel2();
        createLevel3();
        createLevel4();
        createLevel5();
        createLevel6();
        createLevel7();
        createLevel8();
        createLevel9();
        createLevel10();
    }

    public void createMenu(Stage primaryStage){
        menu = new MyStage("src/main/resources/Frogger Main Song Theme (loop).mp3");
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
    //FIXME:'Fix organisation of buttons'
    public void createLvlChooser(Stage primaryStage){
        AnchorPane contents = new AnchorPane();
        Label title= new Label("Frogger");
        title.setLayoutX(204.0);
        title.setLayoutY(30);
        title.setTextFill(Paint.valueOf("#0edd34"));
        title.setFont(Font.font("Cambria Bold Italic",50.0));

        Button level1Btn = getLvlBtn("Level 1", 98,162);
        level1Btn.setOnAction(actionEvent ->  {
            createLevel1();
            primaryStage.setScene(level1Scene);
        });
        Button level2Btn = getLvlBtn("Level 2", 180,162);
        level2Btn.setOnAction(actionEvent ->  {
            createLevel2();
            primaryStage.setScene(level2Scene);
        });

        Button level3Btn = getLvlBtn("Level 3",253,162);
        level3Btn.setOnAction(actionEvent ->  {
            createLevel3();
            primaryStage.setScene(level3Scene);
        });

        Button level4Btn = getLvlBtn("Level 4",331,162);
        level4Btn.setOnAction(actionEvent ->  {
            createLevel4();
            primaryStage.setScene(level4Scene);
        });
        Button level5Btn = getLvlBtn("Level 5",404,162);
        level5Btn.setOnAction(actionEvent ->  {
            createLevel5();
            primaryStage.setScene(level5Scene);
        });

        Button level6Btn = getLvlBtn("Level 6", 98,214);
        level6Btn.setOnAction(actionEvent ->  {
            createLevel6();
            primaryStage.setScene(level6Scene);
        });

        Button level7Btn = getLvlBtn("Level 7",180,214);
        level7Btn.setOnAction(actionEvent ->  {
            createLevel7();
            primaryStage.setScene(level7Scene);
        });

        Button level8Btn = getLvlBtn("Level 8",253,214);
        level8Btn.setOnAction(actionEvent ->  {
            createLevel8();
            primaryStage.setScene(level8Scene);
        });

        Button level9Btn = getLvlBtn("level9",331,214);
        level9Btn.setOnAction(actionEvent ->  {
            createLevel9();
            primaryStage.setScene(level9Scene);
        });

        Button level10Btn = getLvlBtn("level10",14,214);
        level10Btn.setOnAction(actionEvent ->  {
            createLevel10();
            primaryStage.setScene(level10Scene);
        });

        Button backBtn = new Button("Back");
        backBtn.setLayoutX(14);
        backBtn.setLayoutY(361);
        backBtn.prefHeight(25.0);
        backBtn.prefWidth(57.0);
        backBtn.setOnAction(e -> primaryStage.setScene(menuScene));


        contents.getChildren().addAll(title, level1Btn,level2Btn,level3Btn,level4Btn,level5Btn,level6Btn,level7Btn,level8Btn,level9Btn,level10Btn,backBtn);
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
        MyStage level1Stage = new MyStage();
        level1Scene = new Scene(level1Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level1Stage.add(backgroundImage);

        LevelMaker level1 = new LevelMaker(level1Stage,score);
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

        addPlayer(level1Stage);
        addStatic(level1Stage);
        level1Stage.start();

    }
    public void createLevel2(){
        MyStage level2Stage = new MyStage();
        level2Scene = new Scene(level2Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level2Stage.add(backgroundImage);

        LevelMaker level2 = new LevelMaker(level2Stage,score);
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


        addPlayer(level2Stage);
        addStatic(level2Stage);
        level2Stage.start();
    }
    public void createLevel3(){
        MyStage level3Stage = new MyStage();
        level3Scene = new Scene(level3Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level3Stage.add(backgroundImage);

        LevelMaker level3 = new LevelMaker(level3Stage,score);
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
        addPlayer(level3Stage);
        addStatic(level3Stage);
        level3Stage.start();
    }
    //
    public void createLevel4(){
        MyStage level4Stage = new MyStage();
        level4Scene = new Scene(level4Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level4Stage.add(backgroundImage);
        LevelMaker level4 = new LevelMaker(level4Stage,score);
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
        addPlayer(level4Stage);
        addStatic(level4Stage);

        level4Stage.start();
    }
    public void createLevel5(){
        MyStage level5Stage = new MyStage();
        level5Scene = new Scene(level5Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level5Stage.add(backgroundImage);
        LevelMaker level5 = new LevelMaker(level5Stage,score);
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

        addPlayer(level5Stage);
        addStatic(level5Stage);
        level5Stage.start();
    }
    public void createLevel6(){
        MyStage level6Stage = new MyStage();
        level6Scene = new Scene(level6Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level6Stage.add(backgroundImage);

        LevelMaker level6 = new LevelMaker(level6Stage,score);
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


        addPlayer(level6Stage);
        addStatic(level6Stage);
        level6Stage.start();
    }
    public void createLevel7(){
        MyStage level7Stage = new MyStage();
        level7Scene = new Scene(level7Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level7Stage.add(backgroundImage);

        LevelMaker level7 = new LevelMaker(level7Stage,score);



        addPlayer(level7Stage);
        addStatic(level7Stage);
        level7Stage.start();
    }
    public void createLevel8(){
        MyStage level8Stage = new MyStage();
        level8Scene = new Scene(level8Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level8Stage.add(backgroundImage);

        LevelMaker level8 = new LevelMaker(level8Stage,score);
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

        addPlayer(level8Stage);
        addStatic(level8Stage);
        level8Stage.start();
    }
    public void createLevel9(){
        MyStage level9Stage = new MyStage();
        level9Scene = new Scene(level9Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level9Stage.add(backgroundImage);

        LevelMaker level9 = new LevelMaker(level9Stage,score);
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


        addPlayer(level9Stage);
        addStatic(level9Stage);
        level9Stage.start();
    }
    public void createLevel10(){
        MyStage level10Stage = new MyStage();
        level10Scene = new Scene(level10Stage, 590, 800);
        backgroundImage = new BackgroundImage("file:src/main/resources/FBackground1.jpg");
        level10Stage.add(backgroundImage);

        LevelMaker level10 = new LevelMaker(level10Stage,score);
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


        addPlayer(level10Stage);
        addStatic(level10Stage);
        level10Stage.start();
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
/*
    public void backgroundINIT() {
        BackgroundImage background = new BackgroundImage("file:E:\\Programming\\Intellij\\TryFrog1\\src\\p4_group_8_repo\\FBackground1.jpg");
        area.add(background);

        // Implementing log obstacles
        area.add(new Log("file:src/p4_group_8_repo/log_small.png", 120, 0, 166, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log_small.png", 120, 220, 166, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log_small.png", 120, 440, 166, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log_small.png", 120, 50, 329, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log_small.png", 120, 270, 329, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log_small.png", 120, 490, 329, 0.75));
        area.add(new Log("file:src/p4_group_8_repo/log_long.png", 300, 0, 276, -2));
        area.add(new Log("file:src/p4_group_8_repo/log_long.png", 300, 400, 276, -2));


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


