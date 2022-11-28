package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game");

        // Create context container
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get numberGenerator bean from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        log.info("Max number : {}", numberGenerator.getMaxNumber());
        log.info("Next number : {}", numberGenerator.next());

        // Get game bean from context
        //Game game = context.getBean(Game.class);
        //game.reset();

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("Message Generator : {}", messageGenerator.getMainMessage());
        log.info("Result Generator : {}", messageGenerator.getResultMessage());

        // Close context container
        context.close();
    }
}
