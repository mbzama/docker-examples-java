package zama.training.springboot;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private static final String template = "919_Zama - Welcome to Training: %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greet")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Learner") String name) {
    	logger.info("Processing request for /greet --> "+name);
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
