class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return checkSum(0, N, arr, 0, K);
    }

    public static boolean checkSum(int i, int n, int[] arr, int s, int sum) {
        // base case
        if (i == n) return s == sum;

        // prune when sum exceeds target (only for positive arrays)
        if (s > sum) return false;

        // include current element
        if (checkSum(i + 1, n, arr, s + arr[i], sum))
            return true;

        // exclude current element
        if (checkSum(i + 1, n, arr, s, sum))
            return true;

        return false;
    }
}
