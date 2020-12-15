package p4_group_8_repo;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
//http://forum.codecall.net/topic/50071-making-a-simple-high-score-system/
//TODO:'Find way to put all highscore into a scene view'
//TODO:'Order scores according to level'
public class HighscoreManager {
    // An arraylist of the type "score" we will use to work with the scores inside the class
    /**
     * ArrayList created to store score datatype
     * @param scores
     */

    private ArrayList<Score> scores;

    // The name of the file where the highscores will be saved
    /**
     * Location of score file
     * @param HIGHSCORE_FILE
     *
     */
    private static final String HIGHSCORE_FILE = "src/main/java/p4_group_8_repo/scores.txt";

    //Initialising an in and outputStream for working with the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    private String stageName;
    public HighscoreManager(String stageName) {
        //initialising the scores-arraylist
        scores = new ArrayList<Score>();

        this.stageName = stageName;
    }

    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    private void sort() {
        HighscoreComparator comparator = new HighscoreComparator();
        Collections.sort(scores, comparator);
    }

    public void addScore( int score) {
        loadScoreFile();
        scores.add(new Score(stageName, score));
        updateScoreFile();
    }


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
     * Adding score to file
     */
    public void updateScoreFile() {
//        try {
//            FileWriter myWriter = new FileWriter(HIGHSCORE_FILE);
//            myWriter.write(String.valueOf(scores));
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }



        try {
            //FIXME:'Change input method, current method causes file to be written in unreadable format'
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


    public String getHighscoreString() {
        String highscoreString = "";
        int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
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
