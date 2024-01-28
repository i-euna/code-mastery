package com.euna;

import java.util.Arrays;

public class TwoDArrays {
   public static void main(String args[]) {
       char[][] ticTacToeBoard = new char[3][3];

       Arrays.stream(ticTacToeBoard)
             .forEach(a -> Arrays.fill(a, '-'));
       System.out.println(Arrays.deepToString(ticTacToeBoard));
   }
}
