package command;

import logic.FamilyLogic;
import logic.FlowerLogic;

public enum CommandType {

    SHOW_FAMILY_LIST(new ShowFamilyListCommand(new FamilyLogic())),
    DELETE_FAMILY(new DeleteFamilyCommand(new FamilyLogic())),
    ADD_FAMILY(new AddFamilyCommand(new FamilyLogic())),
    CHANGE_FAMILY(new ChangeFamilyCommand(new FamilyLogic())),
    SHOW_FLOWER_LIST(new ShowFlowerListCommand(new FlowerLogic())),
    DELETE_FLOWER(new DeleteFlowerCommand(new FlowerLogic())),
    ADD_FLOWER(new AddFlowerCommand(new FlowerLogic())),
    CHANGE_FLOWER(new ChangeFlowerCommand(new FlowerLogic()));

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
