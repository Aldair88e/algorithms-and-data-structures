package com.revature.subset_sum;

import java.util.List;

public class SubsetSumForceBrute implements SubsetSumI{
    public boolean isSubsetSumPossible(List<Integer> numbers, int target){
        if(target==0)return true;
        if(target<0) return false;

        for(int n:numbers){
            int subAmount = target - n;
            if(isSubsetSumPossible(numbers, subAmount)){
                return true;
            }
        }
        return false;
    }
}
