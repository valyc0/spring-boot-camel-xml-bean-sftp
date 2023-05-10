package io.bootify.my_app.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyRouteSftp extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        from("sftp:demo@test.rebex.net:22/pub/example?password=password&knownHostsUri=known_hosts&useUserKnownHostsFile=false")
//                .log("${file:name}");
        
//        from("sftp:administrator@172.30.51.54:22/tmp?password=admin&knownHostsUri=known_hosts&useUserKnownHostsFile=true&noop=true\"").to("file:C:\\tmp\\datafiles")
//        .log("${file:name}");
    	
//    	from("sftp://172.30.51.54:22/appo?username=prova1&password=prova1").log(LoggingLevel.INFO, log, "processing ${headers.CamelFileName}")
//    	 .to("sftp://{{sftp.username}}@{{sftp.host}}:{{sftp.port}}/{{sftp.virtualDirectory}}"
// 				+ "?privateKeyFile={{sftp.private-key-file}}"
// 				+ "&binary=true" 
//    			 );
    	
    	
    	from("sftp://{{sftp.username}}@{{sftp.host}}:{{sftp.port}}/{{sftp.virtualDirectory}}"
				+ "?privateKeyFile={{sftp.private-key-file}}"
				+ "&binary=true&move=.completed").log(LoggingLevel.INFO, log, "processing ${headers.CamelFileName}")
   	    .to("sftp://172.30.51.54:22/appo?username=prova1&password=prova1&binary=true"
   			 );
    	
    	
    	//.to("file:C:\\\\tmp\\\\datafiles");
    	
    	
        
//        from("sftp://{{sftp.username}}@{{sftp.host}}:{{sftp.port}}/{{sftp.virtualDirectory}}"
//    				+ "?privateKeyFile={{sftp.private-key-file}}"
//    				+ "&binary=true"
//                    // poll interval in ms
//                    + "&delay=1000"
//                    // the sub-folder to archive files processed successfully
//    				+ "&move=.done"
//                    // the sub-folder to archive files NOT processed succesfully
//                    + "&moveFailed=.error"
//                    // to avoid pulling files still in-progress or being written
//                    + "&readLock=changed"
//                ).log(LoggingLevel.INFO, log, "processing ${headers.CamelFileName}")
//                .to("file:{{sftp.localDirectory}}");
    }
    
    
//	 @Override
//	    public void configure() throws Exception {
//		 from("file:C://tmp//data//inputFolder?noop=true").to("file:C://tmp//data//outputFolder");
//	    }
}
