package state;

public class ExpertState extends State {
    public ExpertState(Character character) {
        super(character);
        getCharacter().setLevel("Expert");
    }

    @Override
    public void action() {
        String[] options = {"Train", "Meditate", "Fight"};

        switch (getCharacter().readUserChoice(options)) {
            case 1:
                getCharacter().addExperiencePoints(10);
                checkMasterLevel();
                break;
            case 2:
                getCharacter().addHealthPoints(10);
                break;
            case 3:
                getCharacter().addHealthPoints(-10);
                getCharacter().addExperiencePoints(20);
                checkMasterLevel();
                break;
        }
    }

    private void checkMasterLevel() {
        if (getCharacter().hasExperiencePoints(150)) {
            getCharacter().setState(new MasterState(getCharacter()));
        }
    }
}
