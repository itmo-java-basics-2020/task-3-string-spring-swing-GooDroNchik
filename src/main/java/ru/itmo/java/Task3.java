package ru.itmo.java;

import java.util.*;

class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[]{};
        } else {
            int[] updateArray = new int[inputArray.length];
            updateArray[0] = inputArray[inputArray.length - 1];
            System.arraycopy(inputArray, 0, updateArray, 1, inputArray.length - 1);
            return updateArray;
        }
    }


    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        } else if (inputArray.length == 1) {
            return inputArray[0];
        } else {
            int max1 = inputArray[0];
            int max2 = 0;
            for (int i = 1; i < inputArray.length; i++) {
                if (inputArray[i] > max1) {
                    max1 = inputArray[i];
                } else {
                    if (inputArray[i] > max2) {
                        max2 = inputArray[i];
                    }
                }
            }
            return (max1 * max2);
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.equals("")) {
            return 0;
        } else {
            String UpdateString = input.toLowerCase();
            int count = 0;
            for (int i = 0; i < UpdateString.length(); i++) {
                if (UpdateString.charAt(i) == 'a' | UpdateString.charAt(i) == 'b') count++;
            }
            return count * 100 / UpdateString.length();
        }
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {

        if (input == null) return false;
        else {
            StringBuilder buf = new StringBuilder();
            for (int i = input.length() - 1; i > -1; i--) {
                buf.append(input.charAt(i));
            }
            return input.equals(buf.toString());
        }
    }


    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.equals("")) {
            return "";
        } else {
            StringBuilder buf = new StringBuilder();
            int count = 1;
            char IamChar = input.charAt(0);
            for (int i = 1; i < input.length(); i++) {
                if (IamChar == input.charAt(i)) count++;
                else {
                    buf.append(IamChar);
                    buf.append(count);
                    IamChar = input.charAt(i);
                    count = 1;
                    if (i == input.length() - 1) {
                        buf.append(IamChar);
                        buf.append(count);
                    }
                }
            }
            if (buf.length() == 0) {
                buf.append(IamChar);
                buf.append(count);
            }
            return buf.toString();
        }
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.equals("") | two.equals("")) return false;
        else {
            one = one.toLowerCase();
            two = two.toLowerCase();
            if (one.equals(two)) return false;
            else {
                char[] a = one.toCharArray();
                char[] b = two.toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                return (Arrays.equals(a, b));
            }
        }
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.equals("")) return false;
        else {
            HashSet<Character> hs = new HashSet<>(s.length());
            for (int i = 0; i < s.length(); i++)
                if (!hs.add(s.charAt(i))) return false;
            return true;
        }
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m[0].length == 0) return new int[][]{{}, {}};
        else {

            int[][] newMatrix = new int[m.length][m.length];
            for (int i = 0; i < newMatrix.length; i++) {
                for (int j = 0; j < newMatrix.length; j++) {
                    newMatrix[i][j] = m[j][i];
                }
            }
            return newMatrix;
        }
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) return "";
        else {
            StringBuilder buf = new StringBuilder();
            if (separator == null) {
                for (String i : inputStrings) {
                    buf.append(i);
                    buf.append(" ");
                }
            } else {
                for (String i : inputStrings) {
                    buf.append(i);
                    buf.append(",");
                }
            }
            buf.deleteCharAt(buf.length() - 1); // удаляем последний символ
            return buf.toString();
        }
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || inputStrings.length == 0 || prefix == null) return 0;
        else {
            int count = 0;
            for (String i : inputStrings) {
                if (prefix.length() <= i.length()) {
                    if (i.startsWith(prefix)) count++;
                }
            }
            return count;
        }
    }
}
