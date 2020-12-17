package p4_group_8_repo;

import java.util.Comparator;

public class HighscoreComparator implements Comparator<Score> {
    public int compare(Score score1, Score score2) {

        int sc1 = score1.getScore();
        int sc2 = score2.getScore();
        String n1 = score1.getName();
        String n2 = score2.getName();

        n1 = n1.replaceAll("\\D+","");
        n2 = n2.replaceAll("\\D+","");

        int L1 = Integer.parseInt(n1);
        int L2 = Integer.parseInt(n2);

        if (sc1 > sc2){
            if(L1 < L2){
                return -1;
            }else{
                return -1;
            }

        }else if (sc1 < sc2){
            if(L1 > L2){
                return +1;
            }else{
                return +1;
            }
        }else{
            return 0;
        }
    }
}
