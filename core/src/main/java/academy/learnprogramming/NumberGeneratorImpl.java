package academy.learnprogramming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    // == Fields ==
    private final Random random = new Random();

    @Getter
    private final int maxNumber;
    @Getter
    private final int minNumber;

    // == Constructors ==
    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber){
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    // == Public methods==
    @Override
    public int next() {
        // min=5 , max=20 -> max-min=15 -> max= 15 + min -> range(0,15) + min -> 0-15
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }
}
