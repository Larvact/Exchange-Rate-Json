package toby.exchangerate.json.api.exchangerates.latest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class LatestCurrencyExchangeRatesRequest
{
    @JsonProperty("base_currency_symbol")
    private String baseCurrencySymbol;

    @JsonProperty("response_currency_symbols")
    private Set<String> responseCurrencySymbols;
}
