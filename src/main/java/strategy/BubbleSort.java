package strategy;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. This algorithm is not efficient for large data sets as its average and worst-case time complexity are quite high.
 *
 * Source: https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/
*/

public class BubbleSort extends SortingStrategy {
	public BubbleSort() {
        super("Bubble Sort");
    }

    @Override
	public int[] sort(int[] numbers) {
		int length = numbers.length;
        int i, j, temp;
        boolean swapped;

        for (i = 0; i < length - 1; i++) {
            swapped = false;

            for (j = 0; j < length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

		return numbers;
	}
}
