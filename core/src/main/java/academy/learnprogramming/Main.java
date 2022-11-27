package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // Create context container
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // Get numberGenerator bean from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        log.info("Max number : {}", numberGenerator.getMaxNumber());
        log.info("Next number : {}", numberGenerator.next());

        // Get game bean from context
        Game game = context.getBean(Game.class);
        //game.reset();

        // Close context container
        context.close();
    }
}
