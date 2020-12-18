package p4_group_8_repo;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class HighscoreManager {

    /**
     * ArrayList created to store score objects containing both name of level and score
     */

    private ArrayList<Score> scores;
    private String stageName;

    /**
     * Location of score file saved as a binary format so it cannot be manually edited
     * <p><b>Location:</b> {@value HIGHSCORE_FILE}</p>
     */
    private static final String HIGHSCORE_FILE = "src/main/java/p4_group_8_repo/scores.dat";

    //Initialising an in and outputStream for working with the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;


    /**
     * Highscore constructor
     * @param stageName Name of current stage
     */
    public HighscoreManager(String stageName) {
        //initialising the scores-arraylist
        scores = new ArrayList<Score>();

        this.stageName = stageName;
    }

    /**
     *  <h1>Get Scores</h1>
     *  Used to retrieve and sort all of the scores from file
     * @return ArrayList of Score objects
     */
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    private void sort() {
        HighscoreComparator comparator = new HighscoreComparator();
        Collections.sort(scores, comparator);
    }

    /**
     * <h1>Adding Score</h1>
     * <p>Creates Score object to add to Array.</p>
     * <p>Then adds Score to file using <b>updateScoreFile();</b></p>
     * @param score Object containing points and name of stage
     */
    public void addScore( int score) {
        loadScoreFile();
        scores.add(new Score(stageName, score));
        updateScoreFile();
    }


    /**
     * <h1>Loading Score File</h1>
     * <h2>Reading from file</h2>
     * <p>Uses ObjectInputStream to read Score objects from file.</p>
     * <p>File itself is not legible can only really be read with inputStream.</p>
     * @see ObjectInputStream
     */
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Load] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Load] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Load] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Load] IO Error: " + e.getMessage());
            }
        }
    }

    /**
     * <h1>Adding to file</h1>
     * <p>Using ObjectOutputStream to be able to write the object to file</p>
     *
     * @see ObjectOutputStream
     */
    public void updateScoreFile() {


        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }


    }

    /**
     * <h1>Get Highscore</h1>
     * <h2>Finding the highest score</h2>
     * <p>Retrieves all the scores from file and stores into new ArrayList</p>
     * <p>Goes through Arraylist running basic search to find the largest element then returns that element</p>
     * @return <b>highscoreString</b>
     */
    public String getHighscoreString() {
        String highscoreString = "";
        ArrayList<Score> scores;
        scores = getScores();
        int biggestScore = 0;
        int i = 0;
        int x = scores.size();


        for(i = 0; i<x;i++){
            int score = scores.get(i).getScore();
            if(score > biggestScore){
                biggestScore = score;
            }
        }

        for(int j = 0; j<x; j++){
            if(scores.get(j).getScore() == biggestScore){
                highscoreString += (j + 1) + ".\t" + scores.get(j).getName() + "\t\t" + scores.get(j).getScore() + "\n";
            }
        }

        return highscoreString;
    }

    public String getScoreBoard(){
        String scoreBoardString = "";
        int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            scoreBoardString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return scoreBoardString;
    }

    public void printScore() {

        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You Have Won The Game!");

            alert.setHeaderText(getHighscoreString());

            alert.setContentText("Highest Possible Score: 800");
            alert.show();
        } catch(Exception e) {

            e.printStackTrace();
        }

    }
}
