package com.example.csc325_m5_lab;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TotalBillController {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal TipPercentage = new BigDecimal(0.15);
    @FXML
    private TextField TipPercentageValue;

    @FXML
    private Label TipPercentageLabel;

    @FXML
    private TextField BillAmountTextField;

    @FXML
    private TextField TotalTextField;

    @FXML
    private ScrollBar TipScrollBar;

    @FXML
    private Button CalculateButton;

    @FXML
    private TextField TipTextField;

    @FXML
    void CalculateTotal(ActionEvent event) {
        try {
            BigDecimal amount = new BigDecimal(BillAmountTextField.getText());
            BigDecimal tip = amount.multiply(TipPercentage);
            BigDecimal total = amount.add(tip);

            TipTextField.setText(currency.format(tip));
            TotalTextField.setText(currency.format(total));
        } catch (NumberFormatException ex) {
            BillAmountTextField.setText("Enter amount");
            BillAmountTextField.selectAll();
            BillAmountTextField.requestFocus();
        }
    }

    public void initialize() {
        currency.setRoundingMode(RoundingMode.HALF_UP);

        TipScrollBar.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                        double value = newValue.doubleValue();
                        TipPercentage = BigDecimal.valueOf(value / 100.0);
                        TipPercentageValue.setText(percent.format(TipPercentage));
                    }
                }
        );
    }
}
