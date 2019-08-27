package zama.training.springboot;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author zama
 *
 */
@Controller
public class DemoController {
	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private static final String template = "<EMP_ID>_<NAME> - Welcome to Training: %s!";
    
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greet")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Learner") String name) {
    	Greeting greeting = null;
    	logger.info("Processing request for /greet --> "+name);
        try {
        	greeting = new Greeting(counter.incrementAndGet(), String.format(template, name), InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			logger.error("Error occurred while starting spring boot app", e);
		}
        return greeting;
    }
}
