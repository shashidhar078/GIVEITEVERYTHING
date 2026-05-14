class Solution {
    public List<Integer> maxMeetings(int[] s, int[] f) {

        ArrayList<Integer> arr = new ArrayList<>();

        int[][] act = new int[s.length][3];

        for(int i = 0; i < s.length; i++)
        {
            act[i][0] = i;
            act[i][1] = s[i];
            act[i][2] = f[i];
        }

        Arrays.sort(act, Comparator.comparingInt(o -> o[2]));

        int lastVal = act[0][2];

        arr.add(act[0][0] + 1);

        for(int i = 1; i < act.length; i++)
        {
            if(act[i][1] > lastVal)
            {
                arr.add(act[i][0] + 1);

                lastVal = act[i][2];
            }
        }

        Collections.sort(arr);
        return arr;
        
    }
}