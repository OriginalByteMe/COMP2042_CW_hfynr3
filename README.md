# Screenshot of Game
![alt text](https://raw.githubusercontent.com/hirish99/Frogger-Arcade-Game/master/arcade.png)
## Install instructions for maven wrapper
1. Use IDE terminal and run the command 'mvn clean install'
2. If you receive an error saying that you need JDK instead of JRE check your maven runtime settings and also
   ensure that your JAVA_HOME is set to JDK instead of JRE
3. If maven wrapper still does not work for you, you can add javafx11 to the modules manually.
## Abstract Factory design pattern
Began refactoring first by implementing the abstract factory design pattern,
- Added new classes
    - Added the <b>AbstractFactory.java</b> abstract class for the factory producer to inherit
    - Added <b>FactoryProducer</b> to create obstacles of different factories
    - Added different actor-type factories to easily create objects of actors:
        - PlayerFactory
        - StaticFactory
        - ObstacleFactory
2. Created abstract classes to separate the moving objects from the static ones

## Adding Actors to the scene
- Created the LevelMaker class to insert actors at pre-determined X and Y positions more easily
    - LevelMaker object is created in main() where all 10 of the levels are created
    - LevelMaker class has predetermined lanes for both the water and the road, 5 for road and 5 for water
    - To insert an obstacle you simply need to call the LevelMaker object .addX(int amount, int lane, char direction,int speed),
      where X is the obstacle type.
    - LevelMaker also automates the shift between obstacles if they are on the same lane
    - It also changes direction image of the obstacle depending on input

## Added animation machine
1. Using the Transition class I was able to create an animation sequence out of a list of images
    - I used this for each actor that had an animation to reduce the amount of clutter that the previous method had used
    - Also allows me to edit the animation timings for an actor a lot easier.
    - I implemented the animation machine first in the Actor abstract class so that all actors would inherit it
    - Then within the Animal class I added 2 separate animation machines to handle both the movement animation and the death animation
    - I also used an animation machine for both the WetTurtle and Turtle
    
## Added scoreboard in file
- Added 3 classes:
    - Score: An object to store both the name of the level and the score that the player achieved on that level
    - HigscoreComparator: implements a comparator<Score>, is used to compare to Scores so to sort it
    - HighscoreManager: This is responsible for writing to the file and loading data from the file, also take out highscore and scoreboard
- File is written as a binary file so that you can't cheat and add your own scores
- Additionally it uses ObjectInputStream and ObjectOutputStream to store the data in the file as we are passing Score object in
- HighscoreManger object created in main
       
