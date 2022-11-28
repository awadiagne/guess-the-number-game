package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{

    // == Constants ==
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    // == Init ==
    @PostConstruct
    @Override
    public void init(){
        log.info("Game autowired : " + game.getNumber());
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest()
                + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber();
        }
        if(game.isGameLost()){
            return "You lost... The number was " + game.getNumber();
        }
        if(!game.isValidNumberRange()){
            return "Invalid number range!";
        }
        if(game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        }
        String direction = "Lower";
        if(game.getGuess() < game.getNumber()){
            direction = "Higher";
        }
        direction += "! You have " + game.getRemainingGuesses() + " guess";
        if(game.getRemainingGuesses() >  1){
            direction += "es";
        }
        direction += " left";
        return direction;
    }
}
