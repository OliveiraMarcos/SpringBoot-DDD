package br.com.api.ibyte.application.base.dtos;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import org.apache.camel.component.jackson.JacksonDataFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
/**
 *
 * @author marcos.oliveira
 */
public abstract class BaseDto implements Serializable {
    @JsonIgnore
    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    @JsonIgnore
    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(BaseDto.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    @JsonIgnore
    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    @JsonIgnore
    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(BaseDto.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    @JsonIgnore
    public static Object fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    @JsonIgnore
    public static String toJsonString(Object obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    @JsonIgnore
    public String toJsonString() throws JsonProcessingException{
        return BaseDto.toJsonString(this);
    }

    @JsonIgnore
    public JacksonDataFormat getDataFormat(){
        return new JacksonDataFormat(this.getClass());
    }

    @JsonIgnore
    public static JacksonDataFormat getDataFormat(Class<?> type){
        return new JacksonDataFormat(type);
    }

    @JsonIgnore
    private static ObjectReader reader;
    @JsonIgnore
    private static ObjectWriter writer;

    @JsonIgnore
    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return BaseDto.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(Object.class);
        writer = mapper.writerFor(Object.class);
    }

    @JsonIgnore
    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    @JsonIgnore
    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}
