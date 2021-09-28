package br.com.api.ibyte.infra.crosscutting.integration.route.routes;

import java.util.stream.Stream;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.base.HttpOperationFailedException;
import lombok.extern.slf4j.Slf4j;
/**
 *
 * @author marcos.oliveira
 */
@Slf4j
public abstract class RouteBase extends RouteBuilder  {
    protected static final AtomicBoolean readyToProcess = new AtomicBoolean(true);
    final long _DELAY = 5000L;

    public static boolean readyToProcess() {
        boolean readyToProcess = RouteBase.readyToProcess.get();
        if (readyToProcess) {
            RouteBase.readyToProcess.set(false);
        }
        log.info("Integration - readyToProcess: {}", readyToProcess);
        return readyToProcess;
    }

    @Override
    public void configure() throws Exception {
        onException(Throwable.class)
        .handled(true)
        // .retryAttemptedLogLevel(LoggingLevel.INFO)
        // .maximumRedeliveries(3)
        // .redeliveryDelay(_DELAY)
        .logExhaustedMessageHistory(false)
        .process(exchange -> tryException(exchange))
        .log(LoggingLevel.ERROR,"${body}")
        .process(exchange -> readyToProcess(exchange));


    }

    protected void readyToProcess(Exchange exchange){
        readyToProcess.set(true);
    }

    protected void tryException(Exchange exchange){
        Throwable exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
        Optional<Throwable> rootCause = Stream.iterate(exception, Throwable::getCause)
            .filter(element -> element.getCause() == null)
            .findFirst();
        exchange.getIn().setBody(exception.getMessage() + " ROOT_CAUSE: "+rootCause.get());
        workWithException(exception,exchange);
    }

    protected void workWithException(Throwable exception, Exchange exchange){
        if (exception.getClass().equals(HttpOperationFailedException.class)) { 
            HttpOperationFailedException httpOperationFailedException = (HttpOperationFailedException) exception;  
            String responseBody = httpOperationFailedException.getResponseBody();  
            int statusCode = httpOperationFailedException.getStatusCode();  
            exchange.getIn().setBody(exception.getMessage() + " ROOT_CAUSE: "+responseBody);
        }
    }
}