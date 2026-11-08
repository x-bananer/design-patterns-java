# Adapter

## Calendar Adapter

The goal is to develop a Java adapter that interfaces the `java.util.Calendar` class with a new interface, `NewDateInterface`, which defines methods for setting and getting the day, month, and year. Additionally, the interface includes a method `advanceDays()` that advances the date by a given number of days.

The interface is the one that the client code uses. The adapter class implements it and makes use of the `Calendar` class internally.

Source assignment: [https://github.com/vesavvo/design_patterns/blob/master/markdown/assignments/adapter.md](https://github.com/vesavvo/design_patterns/blob/master/markdown/assignments/adapter.md)
