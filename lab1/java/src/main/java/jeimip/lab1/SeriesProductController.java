package jeimip.lab1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SeriesProductController {

    @FXML
    private TextField inputField;

    @FXML
    private TextFlow resultTextFlow;

    @FXML
    protected void onCalculate() {
        String input = inputField.getText();
        resultTextFlow.getChildren().clear();

        try {
            int terms = Integer.parseInt(input);

            if (terms <= 0) {
                resultTextFlow.getChildren().add(new Text("Enter a number greater than 0."));
                return;
            }

            String userInput = Integer.toString(terms);
            String resultStr = Integer.toString((int) MathService.CalculateSeriesProduct(terms));

            for (int i = 0; i < resultStr.length(); i++) {
                char resultDigit = resultStr.charAt(i);
                char inputDigit = i < userInput.length() ? userInput.charAt(i) : '\0';

                Text digitText = new Text(String.valueOf(resultDigit));

                if (i >= userInput.length() || resultDigit != inputDigit) {
                    digitText.setFill(Color.web("#B69DF8"));
                    digitText.setStyle("-fx-font-weight: bold");
                } else {
                    digitText.setFill(Color.BLACK);
                }

                resultTextFlow.getChildren().add(digitText);
            }

        } catch (NumberFormatException e) {
            resultTextFlow.getChildren().add(new Text("Please enter a valid number."));
        }
    }
}
