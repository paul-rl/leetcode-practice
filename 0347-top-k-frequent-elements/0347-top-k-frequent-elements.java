class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer freq = map.get(nums[i]);
                map.put(nums[i], freq + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = getMaxFreq(map);
            map.remove(ans[i]);
        }

        return ans;
    }

    int getMaxFreq(HashMap<Integer, Integer> map) {
        int maxFreq = Integer.MIN_VALUE;
        int maxNum = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxNum = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        return maxNum;
    }
}