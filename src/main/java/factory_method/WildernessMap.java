package factory_method;

import java.util.Random;

public class WildernessMap extends Map {
	public WildernessMap(int rows, int cols) {
		super(rows, cols);
		generate();
	}

	@Override
	public Tile createTile() {
		int randomNum = new Random().nextInt(3);

		return switch(randomNum) {
			case 0 -> new SwampTile();
			case 1 -> new WaterTile();
			case 2 -> new ForestTile();
			default -> throw new IllegalStateException();
		};
	}
}
