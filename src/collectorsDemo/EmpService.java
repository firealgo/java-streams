package collectorsDemo;

import dao.EmpDao;
import entity.Emp;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class EmpService {
    private static final List<Emp> allEmp = EmpDao.allEmp();

    public List<Emp> getAllEmp() {
        return allEmp;
    }

    public Map<String, List<Emp>> groupEmpByDept() {
        return allEmp.stream().collect(Collectors.groupingBy(Emp::getDept));
    }

    public Map<String, TreeSet<Emp>> groupEmpByDeptWithSortedEmps() {
        return allEmp.stream().collect(
                Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.toCollection(TreeSet::new)
                        ));
    }

    public Map<String, List<String>> groupEmpFirstNameByDept() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.mapping(Emp::getFirstName, toList())));
    }

    public Map<String, List<String>> groupEmpFullNameByDept() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.mapping(e -> e.getFirstName() + " " + e.getLastName(),
                                toList())
                ));
    }

    public Map<String, Integer> totalSalaryByDept() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.summingInt(Emp::getSalary)
                ));
    }

    public Map<String, Long> empCountByDept() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.counting()
                ));

    }

    public Map<Boolean, List<Emp>> partitionEmpBySalary() {
        return allEmp.stream()
                .collect(
                        Collectors.partitioningBy(e -> e.getSalary() > 6000)
                );
    }

    public Map<String, Optional<Emp>> highestSalariedEmpByDept() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                maxBy(Comparator.comparingInt(Emp::getSalary))
                        ));
        // solution 02
//        return allEmp.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                Emp::getDept,
//                                reducing(BinaryOperator.maxBy(Comparator.comparing(Emp::getSalary))))
//                        );
    }

    public Map<String, Optional<Integer>> highestSalaryByDept() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                mapping(Emp::getSalary, maxBy(Comparator.comparingInt(e -> e))
                                )));
    }

    public Map<String, List<Emp>> wellPaidEmpByDept() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                filtering(e -> e.getSalary() > 7000, toList())
                        ));
    }

    public Map<String, List<String>> wellPaidEmpNameByDept() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                filtering(e -> e.getSalary() > 7000,
                                        mapping(Emp::getFirstName, toList())
                                )
                        )
                );
    }

    public Map<Integer, String> mapEmpIdToEmpFullName() {
        return allEmp.stream()
                .collect(
                        Collectors.toMap(Emp::getId, e -> e.getFirstName() + " " + e.getLastName())
                );
    }

    public Map<Integer, String> mapEmpIdToEmpFullNameSorted() {
        return allEmp.stream()
                .collect(
                        Collectors.toMap(Emp::getId,
                                e -> e.getFirstName() + " " + e.getLastName(),
                                (o, o2) -> o2,
                                TreeMap::new
                        )
                );
    }
}
