package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    // == Constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == Fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    // == Constructors ==
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == Events ==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Context refreshed , container ready!");

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();

            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());

                System.out.println("Play again? y/n");
                String playAgain = scanner.nextLine().trim();
                if(!playAgain.equalsIgnoreCase("y")){
                    System.out.println("See you soon!");
                    break;
                }
                game.reset();
            }

        }
    }
}
