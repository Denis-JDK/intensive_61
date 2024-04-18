package com.aston.develop.task_2;

/**
 * Напишите программу, определяющую является ли строка палиндромом.
 */
public class Palindrome {
    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int size = clean.length();
        int forward = 0;
        int back = size-1;
        while (back>forward) {
            char forwardChar=clean.charAt(forward++);
            char backChar=clean.charAt(back--);
            if (forwardChar!=backChar) {
                return false;
            }
        }
        System.out.println(clean);
        return true;
    }
    public static void main(java.lang.String[] args) {
        String isPalindrome = "A man, a plan, a canal: Panama";

        isPalindrome(isPalindrome);


    }
}
