package fr.ece.projetlogna.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ForumController {

    @FXML
    private TextArea txtMessage;

    @FXML
    private Button btnPost;

    @FXML
    private ListView<String> listPosts;

    @FXML
    private void handlePost() {
        String message = txtMessage.getText();
        if (!message.isEmpty()) {
            listPosts.getItems().add(message);
            txtMessage.clear();
        }
    }
}
