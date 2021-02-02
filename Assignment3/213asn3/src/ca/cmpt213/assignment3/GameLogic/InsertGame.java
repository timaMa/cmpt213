package ca.cmpt213.assignment3.GameLogic;

/**
 * InsertGame class is for create a new game, which is 10*10 array, and insert the tokimons and fokimons
 * inside
 */

import java.util.ArrayList;
import java.util.Random;


public class InsertGame{
    public static ArrayList<Tokimon> tokimons = new ArrayList<>();
    public static ArrayList<Fokimon> fokimons = new ArrayList<>();
    static String[][] playArr = new String[10][10];
    public static void Input() {
        Random rand = new Random();
        int rand1 = 0;
        int rand2 = 0;
        for (int i = 0; i < tokimons.size(); i++) {
            rand1 = rand.nextInt(10);
            rand2 = rand.nextInt(10);
            if (playArr[rand1][rand2] == null) {
                playArr[rand1][rand2] = tokimons.get(i).getName();
            } else
                i--;
        }
        for (int i = 0; i < fokimons.size(); i++) {
            rand1 = rand.nextInt(10);
            rand2 = rand.nextInt(10);
            if (playArr[rand1][rand2] == null) {
                playArr[rand1][rand2] = fokimons.get(i).getName();
            } else
                i--;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (playArr[i][j] == null) {
                    playArr[i][j] = " ";
                }
            }
        }
    }

    public static void display() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(playArr[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }



    }



