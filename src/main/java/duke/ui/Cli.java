package duke.ui;

import java.util.Scanner;

/**
 * Class implementing Ui as a command line interface (stdio).
 */
public class Cli implements Ui {
    private static final String logo =
        "               /,   ,|   ,|     \n"
            + "           /| /(  ,' / ,//      \n"
            + "        \\`( |/ /,'  (,/ |      \n"
            + "         \\ \\ ` `   `  /--,    \n"
            + "       _,_\\ `  ` `  ``  /__    \n"
            + "        '-.____________`  /     \n"
            + "          [  \\@,    :] `--,-..-\n"
            + "          [__________]__,'-._/  \n"
            + "           )'o\\ ' o) \\/ )       hello sir\n"
            + "           \\  /   __  ./        its me your assistant sir\n"
            + "            \\=`   ==,\\..        how may i be of service sir\n"
            + "             \\ -. `,' (        \n"
            + "             \\`--''    \\.     \n";
    private static final String horizontalRule =
        "    ____________________________________________________________\n";
    private final Scanner scanner;
    private boolean isActive;

    /**
     * Constructor for Ui object.
     */
    public Cli() {
        this.scanner = new Scanner(System.in);
        this.isActive = true;
    }

    public String nextLine() {
        return this.scanner.nextLine();
    }

    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Closes this Ui object, and sets isActive() to false.
     */
    public void close() {
        this.scanner.close();
        this.isActive = false;
    }

    public void start() {
        this.systemMessage(logo);
    }

    public void systemMessage(String input) {
        System.out.println(horizontalRule + indent(input) + "\n" + horizontalRule);
    }

    private String indent(String original) {
        return "     " + original.replace("\n", "\n     ");
    }
}
