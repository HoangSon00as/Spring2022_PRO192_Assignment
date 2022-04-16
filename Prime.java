/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Prime {
    public int f1(String str) {
        int countPrime = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                int currentNumber = Integer.parseInt("" + currentChar);
                if (isPrime(currentNumber)) {
                    countPrime++;
                }
            }
        }
        return countPrime;
    }
    
    private boolean isPrime(int currentNumebr) {
        if (currentNumebr == 1) {
            return false;
        }
        if (currentNumebr == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(currentNumebr); i++) {
            if (currentNumebr % i == 0) {
                return false;
            }
        }
        return true;
    }
}
