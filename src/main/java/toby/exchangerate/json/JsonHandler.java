package toby.exchangerate.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonHandler
{
    private static final ObjectMapper objectMapper;

    static
    {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T deserializeFromJson(final String jsonString, Class<T> clz) throws JsonProcessingException
    {
        return objectMapper.readValue(jsonString, clz);
    }

    public static String writeToJson(final Object object) throws JsonProcessingException
    {
        return objectMapper.writeValueAsString(object);
    }
}
