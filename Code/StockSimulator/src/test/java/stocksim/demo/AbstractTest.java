package stocksim.demo;

import javafx.application.Application;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
