package template_method;

import java.util.Random;
import java.util.Scanner;

public class PRSGame extends Game {
    private static final int NUMBER_OF_ROUNDS = 3;
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    private final int[] choices = new int[2];
    private final int[] scores = new int[2];

    private int round;
    private String playerName;

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers != 2) {
            throw new IllegalArgumentException("Rock Paper Scissors needs two players.");
        }

        round = 0;
        scores[0] = 0;
        scores[1] = 0;

        System.out.print("What is your name? ");

        playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Player";
        }

        System.out.println("[ ROCK PAPER SCISSORS ]");
        System.out.println("Let the battle begin! " + NUMBER_OF_ROUNDS + " rounds.");
        System.out.println("[ CHOOSE YOUR MOVE ]");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissors");
    }

    @Override
    public boolean endOfGame() {
        return round == NUMBER_OF_ROUNDS;
    }

    @Override
    public void playSingleTurn(int player) {
        if (player == 0) {
            choices[player] = readPlayerChoice();
        } else {
            choices[player] = random.nextInt(MOVES.length);
        }

        if (player == 1) {
            round++;
            System.out.println("[ ROUND " + round + " ]");
            System.out.println(playerName + " chooses " + MOVES[choices[0]] + ".");
            System.out.println("Computer chooses " + MOVES[choices[1]] + ".");
            System.out.println("[ RESULT ]");
            decideRoundWinner();
        }
    }

    @Override
    public void displayWinner() {
        if (scores[0] == scores[1]) {
            System.out.println("The game is a tie. Well played!");
        } else {
            if (scores[0] > scores[1]) {
                System.out.println(playerName + " wins the match. Nice job!");
            } else {
                System.out.println("Clanker wins the match.");
            }
        }
    }

    private void decideRoundWinner() {
        int result = (choices[0] - choices[1] + MOVES.length) % MOVES.length;

        if (result == 0) {
            System.out.println("It's a tie! Nobody gets a point.");
        } else if (result == 1) {
            scores[0]++;
            System.out.println(playerName + " takes the round!");
        } else {
            scores[1]++;
            System.out.println("The soulless machine takes the round!");
        }
    }

    private int readPlayerChoice() {
        while (true) {
            System.out.print("Your move: ");
            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                return Integer.parseInt(choice) - 1;
            }

            System.out.println("Please enter 1, 2, or 3.");
        }
    }
}
