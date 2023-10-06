package streamDemo;

import collectorsDemo.EmpService;
import dao.EmpDao;
import entity.Emp;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    private static final List<Emp> allEmp = EmpDao.allEmp();
    private static final List<String> colorList =
            Stream.of("red", "green", "blue", "orange", "black", "white").toList();
    private static final List<String> colorListWithDuplicates =
            Stream.of("red", "green", "blue", "orange", "black", "white", "red", "blue", "red").toList();

    private static final List<Integer> numbersWithDuplicates =
            Stream.of(3, 4, 5, 6, 6, 2, 1, 3, 1, 1).toList();

    public static void main(String[] args) {

        //01. IntStream - Print 1 to 10
//        _01_printNumberFromOneToTen();

        //02. find color name which starts with b
//        _02_findColorWhichStartsWithB();
        // 03 find frequency of numbers
//        _03_findFrequencyOfNumbers();
        _03_findFrequencyOfColors();


    }

    private static void _03_findFrequencyOfColors() {
        System.out.println("\n -----  03 find frequency of colors  -----");
        var result = colorListWithDuplicates.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );
        System.out.println(result);
    }

    private static void _03_findFrequencyOfNumbers() {
        System.out.println("\n -----  03 find frequency of numbers  -----");
        var result = numbersWithDuplicates.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );
        System.out.println(result);
    }

    private static void _02_findColorWhichStartsWithB() {
        System.out.println("\n -----  02. find color name which starts with b  -----");
        List<String> colors = colorList.stream().filter(c -> c.startsWith("b")).toList();
        System.out.println(colors);
    }

    private static void _01_printNumberFromOneToTen() {
        System.out.println("\n -----  01. IntStream - Print 1 to 10  -----");
        IntStream.range(1, 10).forEach(i -> System.out.print(i + ", "));
    }
}
