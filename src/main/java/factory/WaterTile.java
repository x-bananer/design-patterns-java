package factory;

public class WaterTile implements Tile {
	private String type = "water";
	private char character = 'W';

	public char getCharacter() {
		return character;
	}

	public String getType() {
		return type;
	}
}