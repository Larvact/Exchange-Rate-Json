package org.toby.exchangerate.json.api.exchangerates;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.toby.exchangerate.json.JsonHandler.deserializeFromJson;

class TestLatestCurrencyExchangeRatesResponse
{
    private static final String API_STUBBED_RESPONSE = """
            {
                "success": true,
                "timestamp": 1519296206,
                "base": "USD",
                "date": "2021-03-17",
                "rates": {
                    "GBP": 0.72007,
                    "JPY": 107.346001,
                    "EUR": 0.813399    }
            }""";

    @Test
    void test_latest_currency_exchange_rates_response_json_deserialization() throws JsonProcessingException
    {
        final var response = deserializeFromJson(API_STUBBED_RESPONSE, LatestCurrencyExchangeRatesResponse.class);

        Assertions.assertThat(response)
                .has(new Condition<>(r -> r.getTimestamp() != null, "Response has a non null timestamp"))
                .has(new Condition<>(r -> r.getCurrencyExchangeRates().size() == 3, "Response has three currency rates"))
                .extracting(LatestCurrencyExchangeRatesResponse::getIsSuccess, LatestCurrencyExchangeRatesResponse::getBaseCurrency)
                .containsExactly(true, "USD");
    }
}