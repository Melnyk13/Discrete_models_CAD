
import java.util.stream.IntStream;

public class Solution {

    private int P[];
    private int N;
    private int[][] A;
    private int[][] B;

    public Solution() {
        initData();
    }

    private void initData() {
        A = readIntMatrix("/Lab5/l5_a.txt");
        B = readIntMatrix("/Lab5/l5_b.txt");
        N = A.length;
        P = IntStream.range(0, N).toArray();
    }

    public boolean match() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i][j] != B[P[i]][P[j]]) {
                    return false;
                }
        return true;
    }

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        do {
            if (match()) {
                for (int i = 0; i < N; i++)
                    System.out.print(String.format("{%d: %d}; ", i + 1, P[i] + 1));
                break;
            }
        } while (findNextPermutation(P));
    }
  private int[][] readIntMatrix(final String path) {
        String[] allLines = getResourceAsString(path).split("\n");
        int numberOfVertices = Integer.parseInt(allLines[0]);
        String[] matrixLines = new String[allLines.length - 1];
        System.arraycopy(allLines, 1, matrixLines, 0, matrixLines.length);
        int[][] matrix = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i) {
            String[] inputData = matrixLines[i].split(" ");
            for (int j = 0; j < numberOfVertices; ++j) {
                matrix[i][j] = Integer.parseInt(inputData[j]);
            }
        }
        return matrix;
    }

    private String getResourceAsString(String fileName) {
        try (InputStream is = Solution.class.getResourceAsStream(fileName)) {
            return IOUtils.toString(is);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}