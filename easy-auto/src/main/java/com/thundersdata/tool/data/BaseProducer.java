package com.thundersdata.tool.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BaseProducer {

    @Autowired
    RandomGenerator randomGenerator;

    public boolean trueOrFalse(){
        return randomGenerator.nextBoolean();
    }

    private int randomBetween(int min, int max){
        return randomGenerator.nextInt(min, max);
    }

    public <T> T randomElement(List<T> elements){
        return elements.get(randomBetween(0,elements.size()));
    }

    public String randomElement(String... elements){
        return randomElement(Arrays.asList(elements));
    }

}
