package com.revature.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    Map<Integer, Long> calculatedValues;

    public Fibonacci(){
        calculatedValues = new HashMap<>();
    }

    public long calculate(int n){
        if(calculatedValues.containsKey(n)) return calculatedValues.get(n);
        long value = n;
        if(n > 1){
            value = calculate(n-1) + calculate(n-2);
            calculatedValues.put(n, value);
        }
        return value;
    }
}
