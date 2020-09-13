package duke.ui.fxcomponents;

import duke.Duke;
import duke.ui.GuiHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * MainWindow component of the GUI. Contains additional logic to
 * format and display messages.
 */
public class MainWindow extends AnchorPane {
    // @@author se-edu-reused
    // Reused with modifications from the module's tutorial.
    @FXML
    private ScrollPane scrollArea;
    @FXML
    private VBox outputContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private GuiHelper guiHelper;
    private Duke duke;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private final Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/naturo.png"));

    @FXML
    public void initialize() {
        scrollArea.vvalueProperty().bind(outputContainer.heightProperty());
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        this.guiHelper.setUserInput(input);
        this.userMessage(input);
        this.duke.nextIteration();
        if (!this.guiHelper.isActive()) {
            this.closeWindow();
        }
        this.guiHelper.consumeCommandOutput().ifPresent((messages) -> {
            for (String message : messages) {
                this.dukeMessage(message);
            }
        });
        userInput.clear();
    }

    /**
     * 'constructor' for this component.
     * Initializes the component.
     */
    public void setup() {
        this.guiHelper = new GuiHelper();
        this.duke = new Duke(guiHelper);
        this.sendWelcomeMessage();
    }

    private void sendWelcomeMessage() {
        final String welcomeMessage = "hello sir\nits me your assistant sir\nhow may i be of service sir";
        this.dukeMessage(welcomeMessage);
    }

    private void closeWindow() {
        // Somehow this.getScene... doesn't work but sendButton.getScene... does
        Stage stage = (Stage) sendButton.getScene().getWindow();
        stage.close();
    }

    private void dukeMessage(String message) {
        outputContainer.getChildren().add(DialogBox.createDukeDialog(message, dukeImage));
    }

    private void userMessage(String message) {
        outputContainer.getChildren().add(DialogBox.createUserDialog(message, userImage));
    }
}
