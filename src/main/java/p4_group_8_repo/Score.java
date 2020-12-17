package p4_group_8_repo;

import java.io.Serializable;

public class Score  implements Serializable {

    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    /**
     * <h1>Score object for scoreboard</h1>
     * @param name Name of current stage
     * @param score number of points to be added
     */
    public Score(String name, int score) {
        this.score = score;
        this.name = name;
    }
}
