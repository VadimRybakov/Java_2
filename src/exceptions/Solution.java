package exceptions;

import java.util.Arrays;

public class Solution {
/*         1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
            10 3 1 2
            2 3 2 2
            5 6 7 1
            300 3 1 0
    Написать метод, на вход которого подаётся такая строка,
    метод должен преобразовать строку в двумерный массив типа String[][];*/
    static String[][] stringTo2DArray(String str) throws WrongArraySizeException {
        int countRaws = 0;
        String[][] newStr = new String[4][4];
        for(String s : str.split("[\n]+")){
            if(countRaws >= 4)
                throw new WrongArraySizeException("there are more than 4 raws in your array");
            int countColumns = 0;

            for(String s1 : s.split("[ ]+")){
                if(countColumns >= 4)
                    throw new WrongArraySizeException("there are more than 4 columns in your array");
                newStr[countRaws][countColumns] = s1;
                countColumns++;
            }
            if(countColumns < 4)
                throw new WrongArraySizeException("there are less than 4 columns in your array");
            countRaws++;
        }
        if(countRaws < 4)
            throw new WrongArraySizeException("there are less than 4 raws in your array");
        return newStr;
    }

/*     2. Преобразовать все элементы массива в числа типа int,
     просуммировать, поделить полученную сумму на 2, и вернуть результат*/
    static float halfSumOfArray(String[][] str) throws NotNumberException {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(str[i][j].toLowerCase().matches("[a-z]+"))
                    throw new NotNumberException("There is a symbol in your Array", str[i][j]);
                sum += Integer.parseInt(str[i][j]);
            }
        }
        return sum / 2;
    }

    static void printArr(String[][] str){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(str[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws WrongArraySizeException {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String test1 = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0\n300 3 1 0";
        String test2 = "10 3 1 2\n2     3 2 2\n5 6 7 15 1\n300 3 1 0";
        String test3 = "10 3 1 2\n2 3 2 14\n5 6 7 1";
        String test4 = "10 3 1 2\n2 2 2\n5 6 7 1\n300 3 1 0";
        String test5 = "10 3 1 2\n2 3 2 2\n5 NN 7 1\n300 3 1 0";
        try {
            // 1.
            String[][] newStr = stringTo2DArray(str);
            printArr(newStr);
            // 2.
            System.out.println(halfSumOfArray(newStr));
            // test raws >= 4
//            newStr = stringTo2DArray(test1);

            // test columns >= 4
//            newStr = stringTo2DArray(test2);

            // test raws < 3
//            newStr = stringTo2DArray(test3);

            // test columns < 3
//            newStr = stringTo2DArray(test4);

            // test symbol in array
/*            newStr = stringTo2DArray(test5);
            System.out.println(halfSumOfArray(newStr));*/
        }
        catch (WrongArraySizeException e){
            System.out.println(e.getMessage());
        }
        catch (NotNumberException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getSymbols());
        }
    }
}
