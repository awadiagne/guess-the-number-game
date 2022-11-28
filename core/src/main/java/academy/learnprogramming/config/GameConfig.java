package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    // == Fields ==
    private int maxNumber = 50;
    private int guessCount = 8;

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
