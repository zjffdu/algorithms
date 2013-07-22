package com.zjffdu.algorithm.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingSubsequence {

	public int longestSub(int[] array) {

		// find its predecessors
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < array.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] < array[i]) {
					if (map.containsKey(i)) {
						map.get(i).add(j);
					} else {
						List<Integer> preds = new ArrayList<Integer>();
						preds.add(j);
						map.put(i, preds);
					}
				}
			}
		}

		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(i)) {
				result[i] = 1;
			} else {
				List<Integer> preds = map.get(i);
				int max = 0;
				for (int pred : preds) {
					if (result[pred] > max) {
						max = result[pred];
					}
				}
				result[i] = max + 1;
			}
		}
		
		return result[array.length-1];
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence s=new LongestIncreasingSubsequence();
		System.out.println(s.longestSub(new int[]{5,2,8,6,3,6,9,7,10,11,14}));
	}
}
