class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> l=new ArrayList<>();
        if(s.length()<p.length()){
            return l;
        }
        int[] a=new int[26];
        for(int i=0;i<p.length();i++){
            a[p.charAt(i)-'a']++;
        }
        int q=0;
        for(int i=0;i<26;i++){
            if(a[i]!=0){
                q++;
            }
        }
        int i=0;
        int j=p.length()-1;
        int[] b=new int[26];
        for(int k=i;k<=j;k++){
            b[s.charAt(k)-'a']++;
        }
        int x=0;
        while(j<s.length()-1){
            x=0;
            for(int k=0;k<26;k++){
                if(a[k]!=0&&a[k]==b[k]){
                    x++;
                }
            }
            if(q==x){
                l.add(i);
            }
            i++;
            j++;
            b[s.charAt(j)-'a']++;
            b[s.charAt(i-1)-'a']--;
        }
        x=0;
        for(int k=0;k<26;k++){
            if(a[k]!=0&&a[k]==b[k]){
                x++;
            }
        }
        if(q==x){
            l.add(i);
        }
        return l;
    }
}