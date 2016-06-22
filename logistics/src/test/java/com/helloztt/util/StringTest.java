package com.helloztt.util;

/**
 * Created by helloztt on 2016/6/22.
 */
public class StringTest {
    public static void main(String[] args) throws Exception{
        StringTest test = new StringTest();
        System.out.println(test.chinaToUnicode("密码不能为空"));
    }

    public String chinaToUnicode(String str){
        String result="";
        for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
                result+="\\u" + Integer.toHexString(chr1);
            }else{
                result+=str.charAt(i);
            }
        }
        return result;
    }
}
