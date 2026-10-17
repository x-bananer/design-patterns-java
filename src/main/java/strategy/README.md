# Strategy

## Algorithm Performance Comparison

This example uses the Strategy pattern to compare three integer-sorting algorithms:

- Quick sort
- Merge sort
- Bubble sort

`SortingStrategy` is the strategy interface. Each algorithm implements it, while
`SortingContext` delegates sorting to whichever strategy is selected through
`setStrategy()`. `Main` creates random data sets of 30 and 100,000 integers,
sorts a separate copy with every strategy, checks the result, and prints the
elapsed time.

No built-in sorting method is used. Timing varies between runs and machines;
each algorithm receives the same input copy for a given data set. Bubble sort
has quadratic time complexity, so it will generally take noticeably longer on
the large data set.
