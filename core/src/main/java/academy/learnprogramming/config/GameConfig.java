package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == Fields ==
    @Value("${game.maxNumber : 20}")
    private int maxNumber;
    @Value("${game.guessCount : 5}")
    private int guessCount;

    // == Bean methods ==
    @Bean
    @MaxNumber
    public int getMaxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int getGuessCount(){
        return guessCount;
    }
}
