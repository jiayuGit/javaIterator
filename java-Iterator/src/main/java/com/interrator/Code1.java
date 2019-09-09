package com.interrator;

public class Code1 {
    public static void main(String []ags){
        System.out.println(code("a b  c"));
    }

    /**
     * 空格中插入字符
     * 时间复杂度O(N)
     * @param s
     * @return
     */
    public static String code(String s){
        if(s==null){
            return null;
        }
        char[] cs = s.toCharArray();
        int m = 0;
        for(int i = 0;i<cs.length;i++){
            m+=1;
            if(cs[i]==' '){
                m+=2;
            }
        }
        char [] dp = new char[m];
        for (int i = dp.length-1,j=cs.length-1;i>=0;j--){//右侧向左扩,不会覆盖还未使用过的值,最多覆盖数组同一个位置的覆盖自己
            if(cs[j]==' '){
                dp[i--]='0';
                dp[i--]='2';
                dp[i--]='%';
            }else {
                dp[i--]=cs[j];
            }
        }
        return String.valueOf(dp);
    }

}
