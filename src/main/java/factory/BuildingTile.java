package factory;

public class BuildingTile implements Tile {
	private String type = "building";
	private char character = 'B';

	public char getCharacter() {
		return character;
	}

	public String getType() {
		return type;
	}
}
