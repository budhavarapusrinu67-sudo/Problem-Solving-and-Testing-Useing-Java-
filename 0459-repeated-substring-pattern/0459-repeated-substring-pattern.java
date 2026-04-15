class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
    
        if(n < 2){
            return false;
        }

        int index = 0;

        String[] candid_repeated = new String[n];
        String repeated = "";
        for(int idx = n-1; idx >=n/2; idx--){
            char curr = s.charAt(idx);

            if(curr == s.charAt(0)){
                repeated = s.substring(idx);
                candid_repeated[index] = repeated;
                index++;
            }
        }

        if(candid_repeated.length == 0){
            return false;
        }

        StringBuilder res = new StringBuilder();

        for(String candid : candid_repeated){
            if(candid != null){
                for(int i=0; i<n/candid.length(); i++){
                    res.append(candid);
                }
            }
            if(res.toString().compareTo(s) == 0){
                return true;
            }
            res = new StringBuilder();
        }

        return false;
    }
}