package state;

public class NoviceState extends State {
    public NoviceState(Character character) {
        super(character);
        getCharacter().setLevel("Novice");
    }

    @Override
    public void action() {
        String[] options = {"Train"};

        switch (getCharacter().readUserChoice(options)) {
            case 1:
                getCharacter().addExperiencePoints(10);
                if (getCharacter().hasExperiencePoints(30)) {
                    getCharacter().setState(new IntermediateState(getCharacter()));
                }
                break;
        }
    }
}
