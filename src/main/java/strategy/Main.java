package strategy;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SMALL_DATA_SET_SIZE = 30;
    private static final int LARGE_DATA_SET_SIZE = 100_000;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		SortingContext sortingHandler = new SortingContext();

		while (true) {
			System.out.println("Select sorting method: ");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("0. Exit");

			int choice = scanner.nextInt();
			if (choice == 0) {
				break;
			}

			switch (choice) {
            case 1:
                sortingHandler.setStrategy(new BubbleSort());
                break;
            case 2:
                sortingHandler.setStrategy(new MergeSort());
                break;
            case 3:
                sortingHandler.setStrategy(new QuickSort());
                break;
            default:
                System.out.println("Invalid choice!");
                continue;
        }

		int[] smallDataSet = createDataSet(SMALL_DATA_SET_SIZE);
		int[] largeDataSet = createDataSet(LARGE_DATA_SET_SIZE);

		long start = System.nanoTime();
		sortingHandler.sort(smallDataSet);
		long end = System.nanoTime();

		System.out.println("Strategy: " + sortingHandler.getStrategyName());

		System.out.println("Small data set: " + (end - start) / 1_000_000.0 + " ms");


		start = System.nanoTime();
		sortingHandler.sort(largeDataSet);
		end = System.nanoTime();

		System.out.println("Large data set: " + (end - start) / 1_000_000.0 + " ms");
		}
		scanner.close();
	}

	private static int[] createDataSet(int size) {
		// The same seed recreates the same data for each sorting strategy.
		Random random = new Random(42);

		int[] dataSet = new int[size];

		for (int i = 0; i < dataSet.length; i++) {
            dataSet[i] = random.nextInt(1000);
        }

		return dataSet;
	}
}
