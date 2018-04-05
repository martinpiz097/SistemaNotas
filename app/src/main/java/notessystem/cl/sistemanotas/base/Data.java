package notessystem.cl.sistemanotas.base;

import java.text.NumberFormat;
import java.util.LinkedList;

/**
 * Created by martin on 04-04-18.
 */

public class Data {

    private LinkedList<Score> listScores;

    private static final String PASSW = "admin";
    private static final Data data = new Data();

    public static Data getInstance() {
        return data;
    }

    private Data() {
        listScores = new LinkedList<>();
    }

    public String getPassw() {
        return PASSW;
    }

    public byte getPondCount() {
        if (listScores.size() == 0)
            return 0;
        byte pondTotal = 0;
        for (Score s:
             listScores) {
            pondTotal+=s.getWeighing();
        }
        return pondTotal;
    }

    public boolean addScore(double score,  byte weighing) {
        boolean isValid = getPondCount()+weighing<=100;
        if (isValid)
            listScores.add(new Score(listScores.size()+1, score, weighing));
        return isValid;
    }

    public LinkedList<Score> getScores() {
        return listScores;
    }


}
