package factory;

public class SwampTile implements Tile {
	private String type = "swamp";
	private char character = 'S';

	public char getCharacter() {
		return character;
	}

	public String getType() {
		return type;
	}
}