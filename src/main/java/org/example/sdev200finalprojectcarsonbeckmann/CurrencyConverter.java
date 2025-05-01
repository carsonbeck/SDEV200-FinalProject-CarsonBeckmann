package org.example.sdev200finalprojectcarsonbeckmann;

import java.time.LocalDate;
import java.util.List;

public class CurrencyConverter extends AbstractCurrencyConverter {
        // Additional fields (total fields: 10+)
        private LocalDate conversionDate;
        private boolean isHistoricalRate;
        private double feePercentage;
        private String transactionId;
        private String userEmail;

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public void setFromCurrency(String fromCurrency) throws InvalidDataException {
            if (!List.of("USD", "Euro", "Peso", "Yen", "Rupee").contains(fromCurrency)) {
                throw new InvalidDataException("Invalid source currency");
            }
            this.fromCurrency = fromCurrency;
        }

        public void setToCurrency(String toCurrency) throws InvalidDataException {
            if (!List.of("USD", "Euro", "Peso", "Yen", "Rupee").contains(toCurrency)) {
                throw new InvalidDataException("Invalid target currency");
            }
            this.toCurrency = toCurrency;
        }

        @Override
        public double convert() throws InvalidDataException {
        if (amount <= 0) throw new InvalidDataException("Amount must be positive");

        double usdAmount = switch (fromCurrency) {
        case "USD" -> amount;
        case "Euro" -> amount / USD_TO_EURO;
        case "Peso" -> amount / USD_TO_PESO;
        case "Yen" -> amount / USD_TO_YEN;
        case "Rupee" -> amount / USD_TO_RUPEE;
        default -> throw new InvalidDataException("Unsupported currency");
        };

        return switch (toCurrency) {
        case "USD" -> usdAmount;
        case "Euro" -> usdAmount * USD_TO_EURO;
        case "Peso" -> usdAmount * USD_TO_PESO;
        case "Yen" -> usdAmount * USD_TO_YEN;
        case "Rupee" -> usdAmount * USD_TO_RUPEE;
        default -> throw new InvalidDataException("Unsupported currency");
        };
        }
}