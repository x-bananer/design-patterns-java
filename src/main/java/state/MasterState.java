package state;

public class MasterState extends State {
    public MasterState(Character character) {
        super(character);
        getCharacter().setLevel("Master");
    }

    @Override
    public void action() {
    }
}
