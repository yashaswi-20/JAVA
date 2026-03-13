class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int buy=-1;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                 buy=prices[i];
            }
            if(buy!=-1){
                profit+=prices[i+1]-buy;
                buy=-1;
            }
        }
        return profit;
    }
}