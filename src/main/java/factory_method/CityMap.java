package factory_method;

import java.util.Random;

public class CityMap extends Map {
	public CityMap(int rows, int cols) {
		super(rows, cols);
		generate();
	}

	@Override
	public Tile createTile() {
		int randomNum = new Random().nextInt(3);

		return switch (randomNum) {
			case 0 -> new RoadTile();
			case 1 -> new ForestTile();
			case 2 -> new BuildingTile();
			default -> throw new IllegalStateException();
		};
	}
}
