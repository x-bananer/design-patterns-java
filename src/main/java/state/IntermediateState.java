package state;

public class IntermediateState extends State {
	
    public IntermediateState(Character character) {
        super(character);
        getCharacter().setLevel("Intermediate");
    }

    @Override
    public void action() {
        String[] options = {"Train", "Meditate"};

        switch (getCharacter().readUserChoice(options)) {
            case 1:
                getCharacter().addExperiencePoints(10);
                if (getCharacter().hasExperiencePoints(80)) {
                    getCharacter().setState(new ExpertState(getCharacter()));
                }
                break;
            case 2:
                getCharacter().addHealthPoints(10);
                break;
        }
    }
}
