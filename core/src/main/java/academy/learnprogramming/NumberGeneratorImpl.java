package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator{

    // == Fields ==
    private final Random random = new Random();
    @Autowired
    @MaxNumber
    private int maxNumber;

    // == Public methods==
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
