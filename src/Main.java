import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int table[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        showTable(table);
        int rand, coloana;
        int marcheaza = 1;
        boolean joc = true;
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        while (joc) {

            System.out.println("Introduceti un rand si o coloana: ");
            rand = sc.nextInt();
            coloana = sc.nextInt();
            if (getValidare(rand, coloana)) {
                if (isEmptyCell(rand, coloana, table)) {
                    table[rand][coloana] = marcheaza;
                    if (marcheaza == 1) {
                        marcheaza = 2;
                    } else
                        marcheaza = 1;
                } else {
                    System.out.println(RED + "INTRODU O NOUA VALOARE!" + RESET);

                }
                if (gameOver(rand, coloana, table)) {
                    joc = false;
                    System.out.println(RED + "Jocul s-a terminat! Jucatorul " + marcheaza + " castiga!" + RESET);
                }
                showTable(table);
                if (isEqual(rand, coloana, table)) {
                    System.out.println(RED + "Este remiza!" + RESET);
                    break;
                }
            } else
                System.out.println("Introduceti o noua valoare!");
        }
    }

    public static boolean isEmptyCell(int i, int j, int[][] table) {
        if (table[i][j] == 1 || table[i][j] == 2)
            return false;
        else return true;
    }

    public static boolean getValidare(int a, int b) {
        if (a >= 0 && a <= 2 && b >= 0 && b <= 2)
            return true;
        else
            return false;
    }

    public static void showTable(int table[][]) {

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean isEqual(int i, int j, int[][] table) {
        for (i = 0; i < 3; ++i) {
            for (j = 0; j < 3; ++j) {
                if (table[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean gameOver(int rw, int cl, int[][] table) {
        if (table[0][cl] == table[1][cl] && table[0][cl] == table[2][cl])
            return true;
        if (table[rw][0] == table[rw][1] && table[rw][0] == table[rw][2])
            return true;
        if (table[0][0] == table[1][1] && table[0][0] == table[2][2] && table[1][1] != 0)
            return true;
        if (table[0][2] == table[1][1] && table[0][2] == table[2][0] && table[1][1] != 0)
            return true;
        return false;
    }

}











