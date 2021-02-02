package ca.cmpt213.assignment3.GameLogic;
/**
 * StartPlay class is for play
 * It is about game logic
 * enter the start position
 * Enter 1 if want to move up, down, left or right:
 * Enter 2 if want to use a spell:
 * show win or loose
 * and use the spell
 */

import java.util.Random;
import java.util.Scanner;

public class StartPlay {
    private static String up = "w";
    private static String down = "s";
    private static String left = "a";
    private static String right = "d";
    private static String currentPosition = "@";
    private static String foundTokimon = "$";
    private static String vistButEmpty = " ";
    private static int countFoundToki = 0;
    private static int countFoundFoki = 0;
    private static int countUseSpell1 = 10;
    private static int countUseSpell2 = 15;
    private static int countUseSpell3 = 3;
    private static int positionRow = 0;
    private static int positionColumn = 0;
    private static String[][] arr = new String[10][10];

    public static void GameBegin(InsertGame finalGame) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                arr[i][j] = "~";
        }

        display(arr);

        Scanner scan = new Scanner(System.in);
        System.out.println("Game start, Please enter the start position ");

        System.out.println("Please enter the start row and column. columns numbered 1,2,.... and row lettered A,B...");
        String enter = scan.nextLine();
        if(enter.length() == 3) {
            positionColumn = Integer.parseInt(enter.substring(0,2)) - 1;
        }
        else {
            positionColumn = Integer.parseInt(enter.substring(0, 1)) - 1;
        }
//        System.out.println(enter.length());
//        System.out.println(positionColumn);


        char ca = enter.charAt(enter.length()-1);
        positionRow = ca - 65;

        while (positionColumn < 0 || positionColumn >= 10 || positionRow < 0 || positionRow >= 10) {
            System.out.println("The start position is not avaiable, Please enter again: ");
            enter = scan.nextLine();
            if(enter.length() == 3) {
                positionColumn = Integer.parseInt(enter.substring(0,2)) - 1;
            }
            else {
                positionColumn = Integer.parseInt(enter.substring(0, 1)) - 1;
            }

            ca = enter.charAt(enter.length()-1);
            positionRow = ca - 65;
        }

        while (!finalGame.playArr[positionRow][positionColumn].equals("X") && countFoundToki < finalGame.tokimons.size()) {
            if (finalGame.playArr[positionRow][positionColumn].equals(" ")) {
                arr[positionRow][positionColumn] = vistButEmpty + currentPosition;
            } else if (finalGame.playArr[positionRow][positionColumn].equals(foundTokimon)) {
                arr[positionRow][positionColumn] = foundTokimon + currentPosition;
                countFoundToki++;
            }
            display(arr);
            StringBuilder temp = new StringBuilder(arr[positionRow][positionColumn]);
            temp.setCharAt(1, ' ');
            arr[positionRow][positionColumn] = temp.toString();
            System.out.println("Enter 1 if want to move up, down, left or right: ");
            System.out.println("Enter 2 if want to use a spell: ");
            int option = scan.nextInt();
            if (option == 1)
                movePosition();
            else if (option == 2)
                useSpell(finalGame);
        }


        /*if (finalGame.playArr[positionRow][positionColumn].equals(" "))
            finalGame.playArr[positionRow][positionColumn] = vistButEmpty;*/

        if (countFoundToki == finalGame.tokimons.size()) {
            System.out.println("You Win");
            finalGame.playArr[positionRow][positionColumn] += currentPosition;
            finalGame.display();
        } else {
            System.out.println("You loose");
            finalGame.playArr[positionRow][positionColumn] += currentPosition;
            finalGame.display();
        }
    }

    public static void movePosition() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the next move: w: up  s: down  a: left  d: right  ");
        String move = scan.nextLine();
        if (move.equalsIgnoreCase(up))
            positionRow--;
        else if (move.equalsIgnoreCase(down))
            positionRow++;
        else if (move.equalsIgnoreCase(left))
            positionColumn--;
        else if (move.equalsIgnoreCase(right))
            positionColumn++;

        if (positionColumn < 0 || positionColumn > 9 || positionRow < 0 || positionRow > 9) {
            System.out.println("The move is not allowed, please enter again");
            if (move.equalsIgnoreCase(up))
                positionRow++;
            else if (move.equalsIgnoreCase(down))
                positionRow--;
            else if (move.equalsIgnoreCase(left))
                positionColumn++;
            else if (move.equalsIgnoreCase(right))
                positionColumn--;
            movePosition();
        }

    }

    public static void useSpell(InsertGame finalGame) {
        System.out.println("Choose which spell want to use: ");
        System.out.println(" 1: Jump the player to another grid location (spell1 left time: " + countUseSpell1 + ")");
        System.out.println("2: Randomly reveal the location of one of the Tokimons (spell2 left time: " + countUseSpell2 + ")");
        System.out.println("3: Randomly kill off the Fokimons (spell3 left time: " + countUseSpell3 + ")");
        Scanner sca = new Scanner(System.in);
        int choose = sca.nextInt();

        if (choose == 1) {
            Scanner scan = new Scanner(System.in);

            if(countUseSpell1 > 0) {
                System.out.println("Please enter the location which you want to go ");

                String enter = scan.nextLine();
                if(enter.length() == 3) {
                    positionColumn = Integer.parseInt(enter.substring(0,2)) - 1;
                }
                else {
                    positionColumn = Integer.parseInt(enter.substring(0, 1)) - 1;
                }

                char ca = enter.charAt(enter.length()-1);
                positionRow = ca - 65;
                while (positionColumn < 0 || positionColumn >= 10 || positionRow < 0 || positionRow >= 10) {
                    System.out.println("The start position is not avaiable, Please enter again: ");
                    enter = scan.nextLine();
                    if(enter.length() == 3) {
                        positionColumn = Integer.parseInt(enter.substring(0,2)) - 1;
                    }
                    else {
                        positionColumn = Integer.parseInt(enter.substring(0, 1)) - 1;
                    }

                    ca = enter.charAt(enter.length()-1);
                    positionRow = ca - 65;
                }
                countUseSpell1--;
            }
            else
                System.out.println("Spell 1 used up, please do another action!");
        }

        else if (choose == 2) {
            if (countUseSpell2 > 0) {
                Random rand = new Random();
                int rand2 = 0;
                int rand1 = 0;
                do {
                    rand1 = rand.nextInt(10);
                    rand2 = rand.nextInt(10);
                } while (!finalGame.playArr[rand1][rand2].equals(foundTokimon) || arr[rand1][rand2].equals(foundTokimon) || (rand1 == positionRow && rand2 == positionColumn));

                arr[rand1][rand2] = foundTokimon;
                if (!finalGame.playArr[positionRow][positionColumn].equals(foundTokimon) || countFoundToki == finalGame.tokimons.size() - 1)
                    countFoundToki++;
                countUseSpell2--;
            }
            else
                System.out.println("Spell 2 used up, please do another action!");

        }

        else if (choose == 3) {
            if (countFoundFoki < finalGame.fokimons.size() && countUseSpell3 > 0) {
                Random rand = new Random();
                int rand1 = 0;
                int rand2 = 0;
                do {
                    rand1 = rand.nextInt(10);
                    rand2 = rand.nextInt(10);
                } while (finalGame.playArr[rand1][rand2].equals("X") || arr[rand1][rand2] .equals("X"));

                arr[rand1][rand2] = "X";
                countFoundFoki++;
                if (finalGame.playArr[positionRow][positionColumn].equals(foundTokimon))
                    countFoundToki--;

                countUseSpell3--;
            }
            else
                System.out.println("All the fokimons found already! or Spell 3 used up, please do another action!");

        }
    }

    public static void display(String[][] arr) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(arr[i][j]);
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
