class Solution(object):
    def findTheDistanceValue(self, arr1, arr2, d):
        res=0

        for i in range(len(arr1)):
            check =0
            for j in range(len(arr2)):
                if abs(arr1[i]-arr2[j]) <=d :
                    check=1
            
            if check==0:
                res+=1
            check=0
        
        return res