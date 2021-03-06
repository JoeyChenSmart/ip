package duke.command;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import duke.exception.DukeException;

/**
 * Stores all the commands to be run.
 */
public enum Command {
    TODO("todo",
        CommandLibrary.TODO_COMMAND),
    DEADLINE("deadline",
        CommandLibrary.DEADLINE_COMMAND,
        Option.builder("by")
            .required(true)
            .hasArg()
            .build()),
    EVENT("event",
        CommandLibrary.EVENT_COMMAND,
        Option.builder("at")
            .required(true)
            .hasArg()
            .build()),
    LIST("list",
        CommandLibrary.LIST_COMMAND),
    BYE("bye",
        CommandLibrary.BYE_COMMAND),
    DONE("done",
        CommandLibrary.DONE_COMMAND),
    DELETE("delete",
        CommandLibrary.DELETE_COMMAND),
    FIND("find",
        CommandLibrary.FIND_COMMAND);
    private final CommandExecutable exec;
    private final Options options;
    private final String name;

    Command(String name, CommandExecutable exec, Option ... optionArray) {
        this.name = name;
        this.exec = exec;
        this.options = new Options();
        for (Option option : optionArray) {
            options.addOption(option);
        }
    }

    public CommandExecutable getExec() {
        return this.exec;
    }

    public Options getOptions() {
        return this.options;
    }

    public static Command getCommandByName(String name) throws DukeException {
        for (Command command : Command.values()) {
            if (command.name.equals(name)) {
                return command;
            }
        }
        throw DukeException.Errors.UNKNOWN_COMMAND.create();
    }

    /**
     * Checks if the queried command exists.
     * @param name checks if there exists a command with this name.
     * @return true if name is a registered command.
     */
    public static boolean hasCommand(String name) {
        for (Command command : Command.values()) {
            if (command.name.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
