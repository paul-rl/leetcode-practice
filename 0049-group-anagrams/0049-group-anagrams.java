import java.util.HashMap;
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            int[] charCount = new int[26];
            int len = strs[i].length();
            for (int j = 0; j < len; j++) {
                charCount[strs[i].charAt(j) - 'a'] += 1;
            }

            String key = intArrToString(charCount);
            if (map.containsKey(key)) {
                ArrayList<String> val = map.get(key);
                val.add(strs[i]);
            } else {
                ArrayList<String> val = new ArrayList<String>();
                val.add(strs[i]);
                map.put(key, val);
            }
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    String intArrToString(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + "*";
        }

        return s;
    }
}