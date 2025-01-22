class Solution {
    public long gcd(long num1,long num2)
    {
        if(num1==0)return num2;
        if(num2==0)return num1;
        return gcd(num2,num1%num2);
    }
    public long lcm(long num1,long num2)
    {
        return (num1*num2)/gcd(num1,num2);
    }
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long low=1;
        long high=(long)Math.pow(10,10);
        long count1=0;
        long count2=0;
        long common=0;

        while(low<high)
        {
            long mid=(low+high)/2;
            count1=mid-(mid/divisor1);
            count2=mid-(mid/divisor2);
            common=mid-(mid/lcm(divisor1,divisor2));
            if(count1>=uniqueCnt1 && count2>=uniqueCnt2 && common>=uniqueCnt1+uniqueCnt2)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return (int)low;
    }

}
