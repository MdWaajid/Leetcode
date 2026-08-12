class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> count=new HashMap<>(nums.length);
        for(int num:nums)
        {
            count.put(num,count.getOrDefault(num,0)+1);
        }
        for(int num:count.keySet())
        {
            if(count.get(num)==1)
            {
                return num;
            }
        }
        return -1;
    }
}