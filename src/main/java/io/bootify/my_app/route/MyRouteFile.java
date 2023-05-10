package io.bootify.my_app.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyRouteFile extends RouteBuilder {

//    @Override
//    public void configure() throws Exception {
////        from("sftp:demo@test.rebex.net:22/pub/example?password=password&knownHostsUri=known_hosts&useUserKnownHostsFile=false")
////                .log("${file:name}");
//        
//        from("sftp:administrator@192.168.92.85:22/tmp?password=admin&knownHostsUri=known_hosts&useUserKnownHostsFile=true&noop=true\"").to("file:C:\\datafiles\\output")
//        .log("${file:name}");
//    }
    
    
	 @Override
	    public void configure() throws Exception {
		 from("file:C://tmp//data//inputFolder?noop=true").to("file:C://tmp//data//outputFolder");
	    }
}
