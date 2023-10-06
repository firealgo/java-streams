package dao;

import entity.Emp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpDao {
    public static List<Emp> allEmp() {
        List<Emp> allEmp = Stream.of(
                new Emp(1, "Deep", "Kumar", 8500, "IT"),
                new Emp(10, "Shiva", "Jain", 7500, "HR"),
                new Emp(5, "Krishna", "Gopal", 5500, "HR"),
                new Emp(35, "Raj", "Kumar", 9500, "IT"),
                new Emp(25, "Asha", "Singh", 5500, "IT"),
                new Emp(45, "Alia", "Gupta", 6500, "FINANCE")
                ).toList();
        return allEmp;
    }
}
