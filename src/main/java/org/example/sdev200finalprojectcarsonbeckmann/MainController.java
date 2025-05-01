package org.example.sdev200finalprojectcarsonbeckmann;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController {
    // JavaFX UI Components
    @FXML private TextField amountInput;
    @FXML private ComboBox<String> fromCurrencyComboBox;
    @FXML private ComboBox<String> toCurrencyComboBox;
    @FXML private Label resultLabel;

    private final CurrencyConverter converter = new CurrencyConverter();

    // Initialize method called after FXML loading
    @FXML
    private void initialize() {
        // Populate currency selection boxes
        fromCurrencyComboBox.getItems().addAll(
                "USD", "Euro", "Peso", "Yen", "Rupee"
        );
        toCurrencyComboBox.getItems().addAll(
                "USD", "Euro", "Peso", "Yen", "Rupee"
        );

        // Set default selections
        fromCurrencyComboBox.setValue("USD");
        toCurrencyComboBox.setValue("Euro");
    }

    // Conversion handler
    @FXML
    private void handleConvert() {
        try {
            // Validate and parse input
            double amount = Double.parseDouble(amountInput.getText());
            String fromCurrency = fromCurrencyComboBox.getValue();
            String toCurrency = toCurrencyComboBox.getValue();

            // Validate selections
            if (fromCurrency == null || toCurrency == null) {
                throw new InvalidDataException("Please select both currencies");
            }

            // Set values in converter
            converter.setAmount(amount);
            converter.setFromCurrency(fromCurrency);
            converter.setToCurrency(toCurrency);

            // Perform conversion
            double result = converter.convert();

            // Display result
            resultLabel.setText(String.format(
                    "%.2f %s = %.2f %s",
                    amount, fromCurrency,
                    result, toCurrency
            ));

        } catch (NumberFormatException e) {
            showErrorAlert("Invalid Amount", "Please enter a valid number");
        } catch (InvalidDataException e) {
            showErrorAlert("Conversion Error", e.getMessage());
        } catch (NullPointerException e) {
            showErrorAlert("Selection Error", "Please select both currencies");
        }
    }

    // JavaFX Alert for errors
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}