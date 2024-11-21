package toby.exchangerate.json.api.exchangerates.latest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LatestCurrencyExchangeRatesRequest
{
    @JsonProperty("base_currency_symbol")
    private String baseCurrencySymbol;

    @JsonProperty("response_currency_symbols")
    private Set<String> responseCurrencySymbols;
}
