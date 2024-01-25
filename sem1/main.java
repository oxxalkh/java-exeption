package sem1;

// Задание №0
// Реализуйте метод, принимающий в качестве аргумента
// целочисленный массив.
// Если длина массива меньше некоторого заданного минимума,
// метод возвращает -1, в качестве кода ошибки, иначе - длину
// массива
// Задание №1
// Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое
// значение. Метод ищет в массиве заданное значение и возвращает его индекс. При этом,
// например:
// 1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в
// качестве кода ошибки.
// 2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
// 3. если вместо массива пришел null, метод вернет -3
// 4. придумайте свои варианты исключительных ситуаций и верните соответствующие
// коды ошибок.
// Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот
// метод запросит искомое число у пользователя, вызовет первый, обработает возвращенное
// значение и покажет читаемый результат пользователю. Например, если вернулся -2,
// пользователю выведется сообщение: “Искомый элемент не найден”.
// Задание №2
// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
// Необходимо посчитать и вернуть сумму элементов этого массива.
// При этом накладываем на метод 2 ограничения: метод может работать только с
// квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
// только значение 0 или 1.
// Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об
// ошибке.
// Задание №3
// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
// Необходимо посчитать и вернуть сумму элементов этого массива.
// При этом накладываем на метод 2 ограничения: метод может работать только с
// квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
// только значение 0 или 1.
// Если нарушается одно из условий, метод должен вернуть код ошибки.
// Программа должна корректно обработать код ошибки и вывести соответствующее
// сообщение пользователю.
// Сравнить такой вариант обработки исключений с предыдущим.
// Какое преимущество у исключений перед кодами ошибок вы можете назвать в данном
// случае?
// Задание №4
// Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента
// целочисленный одномерный массив.
// Метод должен пройтись по каждому элементу и проверить что он не равен null.
// А теперь реализуйте следующую логику:
// 1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом
// пользователя
// 2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их
// // “подсветить”
// Задание №7 (доп)
// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и
// возвращающий новый массив, каждый элемент которого равен сумме элементов двух
// входящих массивов в той же ячейке.
// Если длины массивов не равны, необходимо как-то оповестить пользователя.
// Задание №8 (доп)
//  Реализуйте метод, принимающий в качестве аргументов двумерный массив.
// Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
// детализировать какие строки со столбцами не требуется. 

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        System.out.println(task0(new int[]{0,1,2}));
        System.out.println(task0(new int[]{0,1}));
        System.out.println(task1(new int[]{0,1,6}, 5));
        System.out.println(task1(null, 5));

        int[][] ar ={
            {0, 1, 0},
            {0, 1, 1},
            {1, 0, 0}
        };
        System.out.println(task2(ar));
        checkArray(new Integer[]{1, 2, null, 5, null});
        // System.out.println(Arrays.toString(task7(new int[]{1,2,3,9}, new int[]{4,5,6})));
        System.out.println(task8(ar)?"Квадратный" : "Неквадратный");

    }
    public static int task0(int[] args) {  
        return args.length < 3 ? -1 : args.length;  
    }
    public static int task1(int[] args, int value){
        if (args == null) return -3;            
        if (task0(args) == -1)   return -1;
        for (int index = 0; index < args.length; index++) {
            if (args[index] == value ) {return index;}
        }
        return -2;
    }
    

    public static int task2(int[][] args){
        if (args.length != args[0].length) {
            throw new RuntimeException("Не является квадратом");            
        }
        int sum = 0;
        for (int index = 0; index < args.length; index++) {
            for (int index1 = 0; index1 < args[0].length; index1++) {
                if (args[index][index1] != 1 & args[index][index1] != 0) {
                    throw new RuntimeException("Не является двоичным");
                }
                sum += args[index][index1];
            }
        }
        return sum;
    }

    public static void checkArray(Integer[] args) {
        for (int index = 0; index < args.length; index++) {
            try  {
                int i = args[index];             
            } catch(NullPointerException e){System.out.println(index);}
        }        
    }

    public static int[] task7(int[] a, int[] b) {            
        int[] out = new int[a.length];
        try {
            for (int index = 0; index < out.length; index++) {
                out[index] = a[index] + b[index];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Массивы не равны. Размер массива а " + a.length + " , массива b " + b.length);
        }        
        return out;
    }

    public static boolean task8(int[][] args){        
        return args.length == args[0].length;
    }
    

}
