package com.revature.coin_change;

public class CoinChangeSimpleRecursion implements CoinChangeI{
    @Override
    public int minCoins(int[] values, int amount) {
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int min = -1;
        for(int v: values){
            int coinsNeeded = minCoins(values, amount-v);
            if(min == -1){
                min = coinsNeeded;
            }else {
                if(coinsNeeded != -1 && coinsNeeded < min){
                    min = coinsNeeded;
                }
            }
        }
        int returning = min < 0 ? min : min + 1;
        return returning;
    }
}
