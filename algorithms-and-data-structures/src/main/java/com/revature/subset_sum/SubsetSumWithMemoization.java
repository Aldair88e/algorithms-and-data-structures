package com.revature.subset_sum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetSumWithMemoization implements SubsetSumI{
    @Override
    public boolean isSubsetSumPossible(List<Integer> numbers, int target) {
        return isSubsetSumPossible(numbers, target, new HashMap<>());
    }
    private boolean isSubsetSumPossible(List<Integer> numbers, int target, Map<Integer, Boolean> memo){
        if(target==0)return true;
        if(target<0) return false;
        if(memo.containsKey(target))return memo.get(target);
        for(int n:numbers){
            int subAmount = target - n;
            if(isSubsetSumPossible(numbers, subAmount, memo)){
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }
}
