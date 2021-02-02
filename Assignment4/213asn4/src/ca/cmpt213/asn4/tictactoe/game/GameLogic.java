package ca.cmpt213.asn4.tictactoe.game;

/**
 * This class is about game's logic
 * Used arraylist to store the girdpane's root
 * Used two-D array to memory
 * Also the logic about click the differnt box what will show
 */

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;


public class GameLogic {
    public GridPane root = new GridPane();
    public ArrayList<Button> listOfButton = new ArrayList<>();
    public int arr[][] = new int[4][4];
    private boolean gameDone = false;

    public GameLogic(GridPane root){
        this.root = root;
    }

    public void insert(){
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button butn = new Button(" ");
                butn.setPrefSize(100, 100);
                listOfButton.add(butn);
            }
        }
        int count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++)
            {
                root.add(listOfButton.get(count),j,i);
                arr[i][j]= -1;
                count++;
            }
        }
    }

    public void gameStart() {
        listOfButton.get(0).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(0));
            Button button1 = new Button();
            if (a % 2 == 0) {
                button1 = new Button("", new ImageView("file:img/x.png"));
                arr[0][0] = 1;
            } else {
                button1 = new Button("", new ImageView("file:img/O.png"));
                arr[0][0] = 0;

            }
            listOfButton.set(0, button1);
            root.add(listOfButton.get(0), 0, 0);
            checkWinner(arr, root, listOfButton);
        }
        });

        listOfButton.get(1).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(1));
            Button button2 = new Button();
            if (a % 2 == 0) {
                button2 = new Button("", new ImageView("file:img/x.png"));
                arr[1][0] = 1;
            } else {
                button2 = new Button("", new ImageView("file:img/O.png"));
                arr[1][0] = 0;

            }
            listOfButton.set(1, button2);
            root.add(listOfButton.get(1), 1, 0);
            checkWinner(arr, root, listOfButton);
        }

    });

        listOfButton.get(2).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(2));
            Button button3 = new Button();
            if (a % 2 == 0) {
                button3 = new Button("", new ImageView("file:img/x.png"));
                arr[2][0] = 1;
            } else {
                button3 = new Button("", new ImageView("file:img/O.png"));
                arr[2][0] = 0;

            }
            listOfButton.set(2, button3);
            root.add(listOfButton.get(2), 2, 0);
            checkWinner(arr, root, listOfButton);
        }
    });

        listOfButton.get(3).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(3));
            Button button4 = new Button();
            if (a % 2 == 0) {
                button4 = new Button("", new ImageView("file:img/x.png"));
                arr[3][0] = 1;
            } else {
                button4 = new Button("", new ImageView("file:img/O.png"));
                arr[3][0] = 0;

            }
            listOfButton.set(3, button4);
            root.add(listOfButton.get(3), 3, 0);
            int check = checkBingo(arr);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(4).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(4));
            Button button5 = new Button();
            if (a % 2 == 0) {
                button5 = new Button("", new ImageView("file:img/x.png"));
                arr[0][1] = 1;
            } else {
                button5 = new Button("", new ImageView("file:img/O.png"));
                arr[0][1] = 0;

            }
            listOfButton.set(4, button5);
            root.add(listOfButton.get(4), 0, 1);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(5).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(5));
            Button button6 = new Button();
            if (a % 2 == 0) {
                button6 = new Button("", new ImageView("file:img/x.png"));
                arr[1][1] = 1;
            } else {
                button6 = new Button("", new ImageView("file:img/O.png"));
                arr[1][1] = 0;

            }
            listOfButton.set(5, button6);
            root.add(listOfButton.get(5), 1, 1);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(6).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(6));
            Button button7 = new Button();
            if (a % 2 == 0) {
                button7 = new Button("", new ImageView("file:img/x.png"));
                arr[2][1] = 1;
            } else {
                button7 = new Button("", new ImageView("file:img/O.png"));
                arr[2][1] = 0;

            }
            listOfButton.set(6, button7);
            root.add(listOfButton.get(6), 2, 1);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(7).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(7));
            Button button8 = new Button();
            if (a % 2 == 0) {
                button8 = new Button("", new ImageView("file:img/x.png"));
                arr[3][1] = 1;
            } else {
                button8 = new Button("", new ImageView("file:img/O.png"));
                arr[3][1] = 0;

            }
            listOfButton.set(7, button8);
            root.add(listOfButton.get(7), 3, 1);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(8).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(8));
            Button button9 = new Button();
            if (a % 2 == 0) {
                button9 = new Button("", new ImageView("file:img/x.png"));
                arr[0][2] = 1;
            } else {
                button9 = new Button("", new ImageView("file:img/O.png"));
                arr[0][2] = 0;

            }
            listOfButton.set(8, button9);
            root.add(listOfButton.get(8), 0, 2);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(9).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(9));
            Button button10 = new Button();
            if (a % 2 == 0) {
                button10 = new Button("", new ImageView("file:img/x.png"));
                arr[1][2] = 1;
            } else {
                button10 = new Button("", new ImageView("file:img/O.png"));
                arr[1][2] = 0;

            }
            listOfButton.set(9, button10);
            root.add(listOfButton.get(9), 1, 2);
            checkWinner(arr, root, listOfButton);

        }
    });
        listOfButton.get(10).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(10));
            Button button11 = new Button();
            if (a % 2 == 0) {
                button11 = new Button("", new ImageView("file:img/x.png"));
                arr[2][2] = 1;
            } else {
                button11 = new Button("", new ImageView("file:img/O.png"));
                arr[2][2] = 0;

            }
            listOfButton.set(10, button11);
            root.add(listOfButton.get(10), 2, 2);
            checkWinner(arr, root, listOfButton);
        }

    });
        listOfButton.get(11).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(11));
            Button button12 = new Button();
            if (a % 2 == 0) {
                button12 = new Button("", new ImageView("file:img/x.png"));
                arr[3][2] = 1;
            } else {
                button12 = new Button("", new ImageView("file:img/O.png"));
                arr[3][2] = 0;

            }
            listOfButton.set(11, button12);
            root.add(listOfButton.get(11), 3, 2);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(12).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(12));
            Button button13 = new Button();
            if (a % 2 == 0) {
                button13 = new Button("", new ImageView("file:img/x.png"));
                arr[0][3] = 1;
            } else {
                button13 = new Button("", new ImageView("file:img/O.png"));
                arr[0][3] = 0;

            }
            listOfButton.set(12, button13);
            root.add(listOfButton.get(12), 0, 3);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(13).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(13));
            Button button14 = new Button();
            if (a % 2 == 0) {
                button14 = new Button("", new ImageView("file:img/x.png"));
                arr[1][3] = 1;
            } else {
                button14 = new Button("", new ImageView("file:img/O.png"));
                arr[1][3] = 0;

            }
            listOfButton.set(13, button14);
            root.add(listOfButton.get(13), 1, 3);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(14).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(14));
            Button button15 = new Button();
            if (a % 2 == 0) {
                button15 = new Button("", new ImageView("file:img/x.png"));
                arr[2][3] = 1;
            } else {
                button15 = new Button("", new ImageView("file:img/O.png"));
                arr[2][3] = 0;

            }
            listOfButton.set(14, button15);
            root.add(listOfButton.get(14), 2, 3);
            checkWinner(arr, root, listOfButton);

        }

    });
        listOfButton.get(15).setOnAction((event) -> {
        int a = checkNext(arr);
        if (!gameDone) {
            root.getChildren().remove(listOfButton.get(15));
            Button button16 = new Button();
            if (a % 2 == 0) {
                button16 = new Button("", new ImageView("file:img/x.png"));
                arr[3][3] = 1;
            } else {
                button16 = new Button("", new ImageView("file:img/O.png"));
                arr[3][3] = 0;

            }
            listOfButton.set(15, button16);
            root.add(listOfButton.get(15), 3, 3);
            checkWinner(arr, root, listOfButton);
        }
    });
    }

    public void checkWinner(int arr[][], GridPane root,ArrayList<Button> listOfButton ){
        int check = checkBingo(arr);
        if (check == 3) {
            Label labX = new Label("X WIN");
            labX.setFont(new Font("Arial", 50));
            labX.setTextFill(Color.web("ff0000"));
            root.add(labX, 6, 2);

        } else if(check == 4){
            Label labO = new Label("O win");
            labO.setFont(new Font("Arial", 50));
            labO.setTextFill(Color.web("ff0000"));
            root.add(labO, 6, 2);
        }
        int howManyInsert = checkNext(arr);
        if(howManyInsert == 16)
        {
            Label labDraw = new Label("Game ends with draw");
            labDraw.setTextFill(Color.web("ff0000"));
            root.add(labDraw, 5, 2);
            gameDone = true;
        }

        if(check == 3 || check ==4) {
            gameDone = true;
        }


    }

    public int checkNext(int arr[][]) {
        int count = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (arr[j][i] >= 0)
                    count++;
        return count;
    }

    public int checkBingo(int arr[][]) {

        for (int i = 0; i < 4; i++) {
            int countX = 0;
            int countO = 0;
            for (int j = 0; j < 4; j++) {
                if (arr[j][i] == 1)
                    countX++;
                else if (arr[j][i] == 0)
                    countO++;
            }
            if (countX == 4)
                return 3;
            else if (countO == 4)
                return 4;
        }

        for (int i = 0; i < 4; i++) {
            int countX = 0;
            int countO = 0;
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 1)
                    countX++;
                else if (arr[i][j] == 0)
                    countO++;
            }
            if (countX == 4)
                return 3;
            else if (countO == 4)
                return 4;
        }

        int x = 0;
        int o = 0;
        for(int i = 0; i < 4; i++) {
            if (arr[i][i] == 1)
                x++;
            else if (arr[i][i] == 0)
                o++;
        }
        if (x == 4)
            return 3;
        else if (o == 4)
            return 4;


        int countX = 0;
        int countO = 0;
        int j = 3;
        for (int i = 0; i < 4; i++) {
            if (arr[i][j] == 1)
                countX++;
            else if (arr[i][j] == 0)
                countO++;
            j--;
        }
        if (countX == 4)
            return 3;
        else if (countO == 4)
            return 4;

        return 0;
    }
}


