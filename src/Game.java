import java.util.Scanner;
public class Game {
    public static void main(String[] args) throws InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("type board size");
        int x = keyboard.nextInt();
        boolean[][] field = new boolean[x][x];
        boolean[][] nextField = new boolean[x][x];
        while (true){
            print(field);
            System.out.println("enter coords (1 1 for the first box etc.) and -1 to print");
            int xCoord = keyboard.nextInt()-1;
            int yCoord = keyboard.nextInt()-1;
            if (xCoord == -2 || yCoord == -2){
                break;
            }

            field[yCoord][xCoord] = !field[yCoord][xCoord];
        }
        print(field);
        for (int k=0; k<25; k++) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    // Look at the eight neighbors.
                    int count = 0;
                    if (isAlive(field, i - 1, j - 1)) {
                        ++count;
                    }
                    if (isAlive(field, i - 1, j)) {
                        ++count;
                    }
                    if (isAlive(field, i - 1, j + 1)) {
                        ++count;
                    }
                    if (isAlive(field, i, j - 1)) {
                        ++count;
                    }
                    if (isAlive(field, i, j + 1)) {
                        ++count;
                    }
                    if (isAlive(field, i + 1, j - 1)) {
                        ++count;
                    }
                    if (isAlive(field, i + 1, j)) {
                        ++count;
                    }
                    if (isAlive(field, i + 1, j + 1)) {
                        ++count;
                    }
                    nextField[i][j] = field[i][j];
                    if (count > 3 && field[i][j]) {
                        nextField[i][j] = false;
                    }
                    if (count < 2 && field[i][j]) {
                        nextField[i][j] = false;
                    }
                    if (count == 3 && !field[i][j]) {
                        nextField[i][j] = true;
                    }
                }


            }
            boolean[][] swapField = field;
            field = nextField;
            nextField = swapField;

            System.out.println();
            print(field);
            Thread.sleep(80);
        }
    }
    private static boolean isAlive(boolean[][] field, int row, int column){
        if (row < 0) {
            row = field.length - 1;
        } else if (row >= field.length) {
            row = 0;
        }
        if (column < 0) {
            column = field.length - 1;
        } else if (column >= field.length) {
            column = 0;
        }
        return field[row][column];
    }
    public static void print(boolean[][] field){
        for (int i=0; i < field.length; i++){
            for (int j=0; j < field[i].length;j++){
                if (field[i][j]){
                    System.out.print("⬜");

                }
                else System.out.print("⬛");
            }
            System.out.println();

        }
    }
}
