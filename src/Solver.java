import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solver {
    public Solver(Board initial) {}          // encontra a solução para o tabuleiro inicial (usando o algoritmo A*)
    public int moves()  {return 0;}                   // min número de movimentos para resolver o tabuleiro inicial
    public Iterable<Board> solution() {return null;}      // sequência de tabuleiros na solução mais curta

    private static int[][] loadFileIntoArray(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        int n =in.nextInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = in.nextInt();
            }
        }
        return tiles;
    }

    public static void main(String[] args) {
        try {
            int[][] tiles = loadFileIntoArray(args[0]);
            Board initial = new Board(tiles);

            if (initial.isSolvable()) {
                Solver solver = new Solver(initial);
                System.out.println("Mínimo número de movimentos = " + solver.moves());
                for (Board board : solver.solution()) {
                    System.out.println(board);
                }
            } else {
                System.out.println("Puzzle irresolvível!");
                System.out.println(initial);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

