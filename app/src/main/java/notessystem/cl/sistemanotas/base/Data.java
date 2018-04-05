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

    /*Obtener promedio*/
    public double getPromedio(){
        double suma = 0;
        for (Score sc: listScores) {
            suma+=sc.getScore();
        }

        return suma/(listScores.size());
    }

    /*OBtener porcentaje de rojos*/
    public double getRojos(){
        double rojos = 0;
        for(Score sc : listScores){
            if(sc.getScore() < 4.0){
                rojos++;
            }
        }

        return rojos;
    }

    /*Obtener porcentaje de azules*/
    public double getAzules(){
        double azules = 0;
        for(Score sc : listScores){
            if(sc.getScore() >= 4.0){
                azules++;
            }
        }

        return azules;
    }


    /*Obtener nota mas alta*/
    public double getNotaMasAlta(){
        double alta = -1;
        for(Score sc: listScores){
            if(sc.getScore() > alta){
                alta = sc.getScore();
            }
        }

        return alta;
    }

    /*Obtener nota mas baja*/
    public double getNotaMasBaja(){
        double baja = 1000;
        for(Score sc: listScores){
            if(sc.getScore() < baja){
                baja = sc.getScore();
            }
        }

        return baja;
    }

    /*Obtener situacipóni*/
    public String getSituación(){
        String situacion = "[situacion]";

        if(getPondCount() < 100){
            situacion = "Falta %"
        }else if(getPromedio() >= 4.0){
            situacion = "Aprobado";
        }else if(getPromedio() < 4.0){
            situacion = "Reprobado";
        }else{
            situacion = "NN";
        }

        return situacion;
    }


}
