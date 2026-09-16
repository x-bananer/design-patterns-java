package state;

import java.util.Scanner;

public class Character {
    private static final Scanner scanner = new Scanner(System.in);

    private String name;
    private String level;
    private State state;
    private int experiencePoints;
    private int healthPoints;

    public Character(String name, int experiencePoints, int healthPoints) {
        this.name = name;
        this.experiencePoints = experiencePoints;
        this.healthPoints = healthPoints;
        state = new NoviceState(this);
    }

    public void operate() {
        while (!isFinished()) {
            displayStatus();
            state.action();
        }
		
        displayStatus();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void addExperiencePoints(int points) {
        experiencePoints += points;
    }

    public void addHealthPoints(int points) {
        healthPoints += points;
    }

    public boolean hasExperiencePoints(int points) {
        return experiencePoints >= points;
    }

    public boolean isFinished() {
        return state instanceof MasterState;
    }

    public int readUserChoice(String[] options) {
		System.out.println("\nSelect an option:");

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        return scanner.nextInt();
    }

    public void displayStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experiencePoints);
        System.out.println("Health: " + healthPoints);
    }
}
