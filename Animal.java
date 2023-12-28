import java.util.ArrayList;
import java.util.List;

class Animal {
    private String name;
    private String birthday;
    private List<String> commands;

    public Animal(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getBirthday() {
        return birthday;
    }
}
