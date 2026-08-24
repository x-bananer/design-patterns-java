package factory_method;

public class RoadTile implements Tile {
	private String type = "road";
	private char character = 'R';

	public char getCharacter() {
		return character;
	}

	public String getType() {
		return type;
	}
}
