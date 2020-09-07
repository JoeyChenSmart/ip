package duke.exception;

/**
 * Custom exception class for Duke-related exceptions.
 */
public class DukeException extends Exception {
    /**
     * Enum containing each error type. A new DukeException can be created using
     * DukeException.Errors.EXCEPTION_NAME.create().
     */
    public enum Errors {
        UNKNOWN_COMMAND("sorry sir i dont understand your command sir\n"
                + "please enter again sir thank you sir"),
        DONE_OUT_OF_RANGE("sir that number is too many for the list sir please\n"
                + "choose a lower number for the list please sir"),
        DELETE_OUT_OF_RANGE("sir that number is too many for the list sir please\n"
                + "choose a lower number for the list please sir"),
        DATE_PARSE_ERROR("sir the date of format is wrong sir please try\n"
                + "\"yyyy-mm-dd\", eg \"2020-08-24\" sir"),
        FILE_READ_ERROR("sir there is some error in read file i make new list ok?"),
        FILE_WRITE_ERROR("sir there is some error in write file, oopsies!"),
        MACRO_ALREADY_DEFINED("sir that's name's been already taken! please try make new name"),
        MACRO_DEFINITION_ERROR("sir that is invalid macro definition format, oopsies!");

        private final String message;
        Errors(String message) {
            this.message = message;
        }
        @Override
        public String toString() {
            return message;
        }
        public DukeException create() {
            return new DukeException(this);
        }
    }
    public DukeException(Errors error) {
        super(error.toString());
    }
    protected DukeException(String customMessage) {
        super(customMessage);
    }
}
