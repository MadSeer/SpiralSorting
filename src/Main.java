import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Vvedite i");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Vvedite j");
        int j = Integer.parseInt(reader.readLine());
        int[][] mass = new int[i][j];
        boolean[][] map = new boolean[i][j];
        i = 0;
        j = 0;


        while (i < mass.length) {
            while (j < mass[0].length) {
                mass[i][j] = i + j + j * i;
                map[i][j] = true;
                System.out.print(mass[i][j] + " ");
                j++;
            }
            System.out.print("\n");
            j = 0;
            i++;
        }
        i = 0;
        j = 0;
        int cycles = 0;

        ArrayList<Integer> sorted = new ArrayList<Integer>();
        while (cycles < mass.length) {
            while (j < mass[0].length - cycles) {
                if (map[i][j]) {
                    sorted.add(mass[i][j]);
                    map[i][j] = false;
                }
                j++;
            }
            j--;
            System.out.println(sorted);

            while (i < mass.length - cycles) {
                if (map[i][j]) {
                    sorted.add(mass[i][j]);
                    map[i][j] = false;
                }
                i++;
            }
            i--;
            System.out.println(sorted);

            while (j > 0 + cycles) {
                if (map[i][j]) {
                    sorted.add(mass[i][j]);
                    map[i][j] = false;
                }
                j--;
            }
            System.out.println(sorted);

            while (i > 0 + cycles) {
                if (map[i][j]) {
                    sorted.add(mass[i][j]);
                    map[i][j] = false;
                }
                i--;
            }
            System.out.println(sorted);
            cycles++;
            j = cycles;
            i = cycles;
        }

    }
}