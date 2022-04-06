import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Board {
    private int[][] tiles;
    private int[][] goal;
    private Board previous; // pai

    private int[][] deepCopy(int[][] matrix) {
        return Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }

    public Board(int[][] tiles) {
        this.tiles = deepCopy(tiles);
        // preencher a matrix goal (De 1 a 8, com o último campo 0)
        goal = deepCopy(tiles);
        int value = 1;
        for (int i = 0; i < goal.length; i++) {
            for (int j = 0; j < goal.length; j++) {
                goal[i][j] = value++;
            }
        }
        goal[goal.length-1][goal.length-1] = 0;
    }           // constrói um tabuleiro a partir de um array de quadros N-por-N
    // (onde tiles[i][j] = quadro na linha i, coluna j)
    public int tileAt(int i, int j) {
        return tiles[i][j];
    }       // retorna o quadro na linha i, coluna j (ou 0 se vazio)
    public int size() {
        return tiles.length;
    }                     // o tamanho N do tabuleiro
    public int hamming() {
        int hamming=0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if(tiles[i][j]!=goal[i][j]){
                    hamming++;
                }
            }
        }
        return hamming;
    }                  // número de quadros fora do lugar
    public int manhattan() {
        return 0;
    }                // soma das distâncias de Manhattan entre os quadros e o objetivo final
    public boolean isGoal() {
        return Arrays.deepEquals(tiles,goal);
    }               // este tabuleiro é o tabuleiro objetivo?
    public boolean isSolvable() {
        int inversao=0;
      int[] flat= Stream.of(tiles).flatMapToInt(IntStream::of).toArray();
        for (int i = 0; i < flat.length-1; i++) {
            if(flat[i]==0){
                continue;
            }
            for (int j = i+1; j < flat.length; j++) {
                if (flat[j]==0){
                    continue;
                }
                if (flat[i] > flat[j]){
                    inversao++;
                }
            }
        }
        return inversao%2==0;
    }           // este tabuleiro é resolvível?
    public boolean equals(Object y) {
        Board other = (Board) y;

        return Arrays.deepEquals(this.tiles, other.tiles);
    }       // este tabuleiro é igual ao tabuleiro y?

    public Iterable<Board> neighbors() {
        return neighbors();
    }    // todos os tabuleiros vizinhos não pode o pai

    public String toString()  {
        String representation = "";
        return representation;
    }             // representação em string deste tabuleiro (no formato especificado abaixo)

}


