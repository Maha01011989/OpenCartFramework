package com.qa.opencart.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class Practice {


    public static void main(String args[]) {
        System.out.println(countVowels("I am an Indian"));


        System.out.println(findCommonNumbersInArray(new int[]{1, 1, 3}, new int[]{1, 3, 5, 7, 3, 5, 1}));


        System.out.println(getIndexValue(1, 3, 4));


    }


    public static int countVowels(String s1) {

        int count = 0;
        s1 = s1.toLowerCase();

        char[] arr = s1.toCharArray();

        for (char s : arr) {

            if (Character.isLetter(s)) {
                if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
                    count++;
                }
            }
        }

        return count;

    }

    public static Set<Integer> findCommonNumbersInArray(int[] a, int[] b) {
        int arr1 = a.length;
        int arr2 = b.length;
        int k = 0;

        //int finalArray[] = new int[a.length];
        Set<Integer> set = new HashSet<>();

        if (arr2 < arr1) {
            for (int i = 0; i < arr2; i++)
                for (int j = 0; j < arr1; j++) {
                    if (b[i] == a[j]) {
                        set.add(b[i]);
                        k++;
                        break;
                    }
                }
        } else {
            for (int i = 0; i < arr1; i++)
                for (int j = 0; j < arr2; j++) {
                    if (a[i] == b[j]) {
                        set.add(a[i]);
                        k++;
                        break;
                    }
                }
        }
        return set;
    }

    public static List<Integer> getIndexValue(int... a) {
        int[] arrfinal = {1, 4, 5, 6, 7};
        List<Integer> list = new ArrayList();
        for (int i : a) {
            list.add(arrfinal[i]);
        }
        return list;
    }
}

