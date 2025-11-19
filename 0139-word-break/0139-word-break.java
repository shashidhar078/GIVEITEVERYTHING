class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];   // memo array
        return findWord(s, hs, 0, memo);
    }

    public static boolean findWord(String s, HashSet<String> hs, int indx, Boolean[] memo) {
        
        if (indx == s.length()) {
            return true;
        }

        // If already computed, return memoized result
        if (memo[indx] != null) {
            return memo[indx];
        }

        for (int i = indx; i < s.length(); i++) {

            if (hs.contains(s.substring(indx, i + 1))) {

                if (findWord(s, hs, i + 1, memo)) {
                    return memo[indx] = true;
                }
            }
        }

        return memo[indx] = false;
    }
}
