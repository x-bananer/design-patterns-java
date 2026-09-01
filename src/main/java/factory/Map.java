package factory;

public abstract class Map {
    private Tile[][] tiles;

    public Map(int rows, int cols) {
		tiles = new Tile[rows][cols];
    }

	public abstract Tile createTile();

	protected void generate() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public void display() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                System.out.print(tiles[i][j].getCharacter());
            }
            System.out.println();
        }
    }
}
