package toby.exchangerate.json.api.exchangerates.latest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Data
public class LatestCurrencyExchangeRatesResponse
{
    @JsonProperty("success")
    private Boolean isSuccess;

    @JsonProperty("timestamp")
    private Instant timestamp;

    @JsonProperty("base")
    private String baseCurrency;

    @JsonProperty("rates")
    private Map<String, BigDecimal> currencyExchangeRates = new HashMap<>();
}
