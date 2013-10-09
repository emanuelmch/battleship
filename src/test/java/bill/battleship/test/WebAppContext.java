package bill.battleship.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("bill.battleship")
public class WebAppContext extends WebMvcConfigurerAdapter {

}
