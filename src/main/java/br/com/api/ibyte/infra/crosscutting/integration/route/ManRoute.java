package br.com.api.ibyte.infra.crosscutting.integration.route;

import org.springframework.stereotype.Component;

import br.com.api.ibyte.infra.crosscutting.integration.route.routes.RouteBase;

/**
 *
 * @author marcos.oliveira
 */
@Component
public class ManRoute extends RouteBase {
     
    @Override
    public void configure() throws Exception {
        
        // from("timer:rest?period=10s")
        //     .filter(method(ManRoute.class, "readyToProcess"))
        //     .to("direct:process-service").end();

    }
    
}