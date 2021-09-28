package br.com.api.ibyte.application.base.dtos;

import com.fasterxml.jackson.annotation.*;
import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author marcos.oliveira
 */
@Data
public abstract class IdentityDto<T, I extends Serializable> extends BaseDto {
    @Getter(onMethod_ = {@JsonProperty("id")})
    @Setter(onMethod_ = {@JsonProperty("id")})
    private I id;

    @JsonIgnore
    public T toJson(String json) throws IOException {
        return (T) BaseDto.fromJsonString(json);
    }
}