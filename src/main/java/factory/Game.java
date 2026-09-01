package factory;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Map map = createMap();
		map.display();
    }

	public static Map createMap() {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Choose map: 1 for City, 2 for Wilderness");
        int choice = scanner.nextInt();

        if (choice == 1) {
            return new CityMap(5, 5);
        } else {
            return new WildernessMap(5, 5);
        }
	}
}