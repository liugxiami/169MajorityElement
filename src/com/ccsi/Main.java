package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int[] a={1,2,3,4,3,4,3,2,3,3,3};
        System.out.println(majorityElement2(a));
    }
    //Given an array of size n,find the majority element.The majority element is the element that appears
    //more than [n/2] times.
    //You may assume that the array is non-empty and the majority element always exist in the array.
    //1.map Space O[n], ease to understand
    public static int majorityElement1(int[] nums){
        if(nums==null||nums.length==0)return -1;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(int i:map.keySet()){
            if(map.get(i)>nums.length/2) return i;
        }
        return -1;
    }
    //2.Space O[1]
    public static int majorityElement2(int[] nums){
        if(nums==null||nums.length==0)return -1;
        int target=nums[0];
        int counter=1;
        for (int i = 1; i < nums.length; i++) {
            if(counter==0){
                target=nums[i];
                counter=1;
            }else if(target==nums[i]){
                counter++;
            }else{
                counter--;
            }
        }
        return target;
    }
}
