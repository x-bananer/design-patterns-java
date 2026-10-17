package strategy;

public abstract class SortingStrategy {
    private final String name;

    protected SortingStrategy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int[] sort(int[] numbers);
}
