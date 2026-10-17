package strategy;

public class SortingContext {
    private SortingStrategy sortingStrategy;

    public void setStrategy(SortingStrategy strategy) {
        this.sortingStrategy = strategy;
    }

	public String getStrategyName() {
        return sortingStrategy.getName();
    }

    public void sort(int[] numbers) {
        sortingStrategy.sort(numbers);
    }
}
