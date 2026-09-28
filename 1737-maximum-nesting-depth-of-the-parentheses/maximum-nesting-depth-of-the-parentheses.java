class Solution {
    public int maxDepth(String s) {
        int currentopen = 0;
        int maxopen = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                currentopen++;
            }else if(s.charAt(i)==')'){
                currentopen--;
            }
            maxopen = Math.max(maxopen,currentopen);
        }
        return maxopen;

    }
}