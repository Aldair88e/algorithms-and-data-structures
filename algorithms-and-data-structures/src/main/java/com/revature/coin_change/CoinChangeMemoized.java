package com.revature.coin_change;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeMemoized implements CoinChangeI{
    @Override
    public int minCoins(int[] values, int amount) {
        return minCoins(values, amount, new HashMap<>());
    }

    private int minCoins(int [] values, int amount, Map<Integer, Integer> memo){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        int min = -1;
        for(int v: values){
            int coinsNeeded = minCoins(values, amount-v, memo);
            if(min == -1){
                min = coinsNeeded;
            }else {
                if(coinsNeeded != -1 && coinsNeeded < min){
                    min = coinsNeeded;
                }
            }
        }
        int returning = min < 0 ? min : min + 1;
        memo.put(amount, returning);
        return returning;
    }
}
