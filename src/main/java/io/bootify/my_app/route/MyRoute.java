package io.bootify.my_app.route;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
 
//@Component
public class MyRoute extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
    	  from("timer://foo?period=1000")
        .setBody().constant("Hello World")
       .log(">>> ${body}");
    }
}
