package com.company.util;

import java.util.Random;

public class RandomUtil {
    public static long randomNumber(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }
}
