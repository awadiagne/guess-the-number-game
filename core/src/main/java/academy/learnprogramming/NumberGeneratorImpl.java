package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator{

    // == Fields ==
    private final Random random = new Random();
    @Autowired
    @MaxNumber
    private int maxNumber;
    @Autowired
    @MinNumber
    private int minNumber;

    // == Public methods==
    @Override
    public int next() {
        // min=5 , max=20 -> max-min=15 -> max= 15 + min -> range(0,15) + min -> 0-15
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
