package notessystem.cl.sistemanotas.base;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by martin on 04-04-18.
 */

public class Score {
    private int index;
    private double score;
    private byte weighing;

    private static final NumberFormat nf = new DecimalFormat("#0.0");

    public Score(int index, double score, byte weighing) {
        this.index = index;
        this.score = score;
        this.weighing = weighing;
    }

    public double getScore() {
        return score;
    }

    public byte getWeighing() {
        return weighing;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append('N').append(index)
                .append("->").append(nf.format(score))
                .append("->(").append(weighing)
                .append("%)").toString();
    }

}
