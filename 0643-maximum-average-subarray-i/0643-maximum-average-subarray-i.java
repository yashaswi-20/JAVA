class Solution {
    public double findMaxAverage(int[] arr, int k) {
     double sum=0;
     for(int i=0;i<k;i++){
        sum+=arr[i];
     }
     double avg=sum/k;
     double maxAvg=avg;
     for(int i=k;i<arr.length;i++){
        sum=sum+arr[i];
        sum=sum-arr[i-k];
        avg=sum/k;
        maxAvg=Math.max(maxAvg,avg);
     }
     return maxAvg;
    }
}