package br.com.api.ibyte.service.api.base.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.http.HttpStatus;

public class Result<T extends Object> {
    private HttpStatus code;
    private String message;
    private T objectResponse;
    private List<String> errors;

    /**
     * @return the code
     */
    @JsonProperty(defaultValue = "code")
    public HttpStatus getCode() {
        return code;
    }

    /**
     * @param code the code to set
     * @return 
     */
    @JsonProperty(defaultValue = "code")
    public Result setCode(HttpStatus code) {
        this.code = code;
        return this;
    }

    /**
     * @return the message
     */
    @JsonProperty(defaultValue = "message")
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    @JsonProperty(defaultValue = "message")
    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * @return the objectResponse
     */
    @JsonProperty(defaultValue = "objectResponse")
    public T getObjectResponse() {
        return objectResponse;
    }

    /**
     * @param objectResponse the objectResponse to set
     */
    @JsonProperty(defaultValue = "objectResponse")
    public Result setObjectResponse(T objectResponse) {
        this.objectResponse = objectResponse;
        return this;
    }

    /**
     * @return the errors
     */
    @JsonProperty(defaultValue = "errors")
    public List<String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    @JsonProperty(defaultValue = "errors")
    public Result setErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }
    
    public Result addError(String error){
        if(this.errors == null){
            this.errors = new ArrayList();
        }
        this.errors.add(error);
        return this;
    }
}