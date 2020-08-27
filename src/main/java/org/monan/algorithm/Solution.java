package org.monan.algorithm;

import java.util.*;


public class Solution {

    public int reverse(int x) {
        int a = x % 10 ;
        int b = x / 10 ;
        int num = a ;
        while(b != 0){
            a = b % 10 ;
            b = b /10 ;
            num = num *10 + a;
        }
        return num ;
    }
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        boolean valid = true ;
        Stack<Character> stack = new Stack<>() ;
        for (int i = 0 ;i < s.length() ;i++){
            Character c = s.charAt(i) ;
            if (c == '(' || c =='[' || c == '{'){
                stack.push(c) ;
            } else{
                if (stack.size() == 0){
                    valid = false ;
                    break ;
                }
                if (c == ')'){
                    if (stack.size() > 0 && stack.pop() != '('){
                        valid = false ;
                        break ;
                    }
                }

                if (c == ']'){
                    if (stack.size()> 0 &&  stack.pop() != '['){
                        valid = false ;
                        break ;
                    }
                }

                if (c == '}'){
                    if (stack.size()> 0 && stack.pop() != '{'){
                        valid = false ;
                        break ;
                    }
                }
            }


        }

        if (stack.size() > 0){
            valid = false ;
        }

        return valid ;
    }

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false ;
        }

        int revertnum = 0 ;
        int a = x ;
        while (a != 0){
            revertnum = revertnum* 10 + a %10 ;
            a = a /10 ;
        }
        System.out.println(revertnum) ;

        return x == revertnum ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution() ;
        System.out.println(solution.isPalindrome(121)) ;
        System.out.println("abc".substring(0,3)) ;
    }
}
