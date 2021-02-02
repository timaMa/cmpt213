package ca.cmpt213.assignment3.UI;
/**
 * Use "Recursive backtracker" algorithm
 */

import ca.cmpt213.assignment3.GameLogic.Fokimon;
import ca.cmpt213.assignment3.GameLogic.InsertGame;
import ca.cmpt213.assignment3.GameLogic.StartPlay;
import ca.cmpt213.assignment3.GameLogic.Tokimon;

import java.util.ArrayList;
import java.util.Scanner;

import static ca.cmpt213.assignment3.GameLogic.StartPlay.GameBegin;

public class TokimonFinder {

    public static void main(String[] args) {
        int tokimonNum = 10;
        int fokimonNum = 5;
        int toki = 0;
        int foki = 0;
        ArrayList<String> arrForArgu = new ArrayList<>();
        if(args.length == 1){
            String arg1=args[0];
            arrForArgu.add(arg1);
            if((arg1.length() == 11 || arg1.length() == 12) && arg1.substring(5,6).equals("T") ) {
                toki = Integer.parseInt(arg1.substring(10,arg1.length()));
                if (toki >= 5)
                    tokimonNum = toki;
            }
            else if((arg1.length() == 11 || arg1.length() == 12) && arg1.substring(5,6).equals("F"))
            {
                foki = Integer.parseInt(arg1.substring(10,arg1.length()));
                if (foki >= 5)
                    fokimonNum = foki;
            }


        }
        if(args.length == 2){
            String arg1=args[0];
            String arg2=args[1];
            arrForArgu.add(arg1);
            arrForArgu.add(arg2);

            if((arg1.length() == 11 || arg1.length() == 12) && arg1.substring(5,6).equals("T") ) {
                toki = Integer.parseInt(arg1.substring(10,arg1.length()));
                if (toki >= 5)
                    tokimonNum = toki;
            }
            else if((arg1.length() == 11 || arg1.length() == 12) && arg1.substring(5,6).equals("F"))
            {
                foki = Integer.parseInt(arg1.substring(10,arg1.length()));
                if (foki >= 5)
                    fokimonNum = foki;
            }

            if((arg2.length() == 11 || arg2.length() == 12) && arg2.substring(5,6).equals("T")){
                toki = Integer.parseInt(arg2.substring(10,arg2.length()));
                if (toki >= 5)
                    tokimonNum = toki;
            }
            else if((arg2.length() == 11 || arg2.length() == 12) && arg2.substring(5,6).equals("F")){
                foki = Integer.parseInt(arg2.substring(10,arg2.length()));
                if (foki >= 5)
                    fokimonNum = foki;

            }
        }

        if(args.length == 3){
            String arg1=args[0];
            String arg2=args[1];
            String arg3=args[2];
            arrForArgu.add(arg1);
            arrForArgu.add(arg2);
            arrForArgu.add(arg3);

            if((arg1.length() == 11 || arg1.length() == 12) && arg1.substring(5,6).equals("T") ) {
                toki = Integer.parseInt(arg1.substring(10,arg1.length()));
                if (toki >= 5)
                    tokimonNum = toki;
            }
            else if((arg1.length() == 11 || arg1.length() == 12) && arg1.substring(5,6).equals("F"))
            {
                foki = Integer.parseInt(arg1.substring(10,arg1.length()));
                if (foki >= 5)
                    fokimonNum = foki;
            }

            if((arg2.length() == 11 || arg2.length() == 12) && arg2.substring(5,6).equals("T")){
                toki = Integer.parseInt(arg2.substring(10,arg2.length()));
                if (toki >= 5)
                    tokimonNum = toki;
            }
            else if((arg2.length() == 11 || arg2.length() == 12) && arg2.substring(5,6).equals("F")){
                foki = Integer.parseInt(arg2.substring(10,arg2.length()));
                if (foki >= 5)
                    fokimonNum = foki;

            }

            if((arg3.length() == 11 || arg3.length() == 12) && arg3.substring(5,6).equals("T")){
                toki = Integer.parseInt(arg3.substring(10,arg3.length()));
                if (toki >= 5)
                    tokimonNum = toki;
            }
            else if((arg3.length() == 11 || arg3.length() == 12) && arg3.substring(5,6).equals("F")){
                foki = Integer.parseInt(arg3.substring(10,arg3.length()));
                if (foki >= 5)
                    fokimonNum = foki;

            }

        }

        InsertGame game1 = new InsertGame();
        for (int i = 0; i < tokimonNum; i++) {
            game1.tokimons.add(new Tokimon("$"));
        }
        for (int i = 0; i < fokimonNum; i++) {
            game1.fokimons.add(new Fokimon("X"));
        }
        game1.Input();
        for(int i = 0; i < arrForArgu.size(); i++){
            if(arrForArgu.get(i).length() == 7)
                game1.display();
        }





        StartPlay.GameBegin(game1);




    }
}