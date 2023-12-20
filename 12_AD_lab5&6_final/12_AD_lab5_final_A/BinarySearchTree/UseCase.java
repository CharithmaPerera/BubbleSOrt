import java.util.Random;

public class UseCase {
    public static void main(String[] args) {
        int kMax = 13; // Maximum value of k
        int M = 20; // Number of BST samples

        int[] nValues = new int[kMax];
        double[] averageDepths = new double[kMax];
        double[] standardDeviations = new double[kMax];

        Random random = new Random();

        for (int k = 3; k <= kMax; k++) {
            int n = (int) Math.pow(2, k) - 1;
            nValues[k - 3] = n;

            int[] depths = new int[M];

            for (int i = 0; i < M; i++) {
                Double[] sequence = new Double[n];
                for (int j = 0; j < n; j++) {
                    sequence[j] = random.nextDouble();
                }

                BST<Double, Integer> bst = new BST<>();
                for (Double value : sequence) {
                    bst.put(value, 0);
                }

                depths[i] = bst.treeDepth();
            }

            averageDepths[k - 3] = calculateAverage(depths);
            standardDeviations[k - 3] = calculateStandardDeviation(depths);
        }

    
    }

    private static double calculateAverage(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }

    private static double calculateStandardDeviation(int[] array) {
        double mean = calculateAverage(array);
        double sum = 0.0;
        for (int value : array) {
            sum += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sum / array.length);
    }
}
