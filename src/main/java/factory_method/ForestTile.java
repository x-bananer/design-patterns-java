package factory_method;

public class ForestTile implements Tile {
	private String type = "forest";
	private char character = 'F';

	public char getCharacter() {
		return character;
	}

	public String getType() {
		return type;
	}
}