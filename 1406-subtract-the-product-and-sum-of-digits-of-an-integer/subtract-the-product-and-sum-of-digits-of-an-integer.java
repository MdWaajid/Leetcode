class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0 ;
        int prod = 1 ;
        int digit = 0 ;

        int x = n ;

        while( x > 0 )
        {
            digit = x % 10 ;

            sum = sum + digit ;
            prod = prod * digit ;
            x = x / 10 ;
        }
        return prod - sum ;        
    }
}