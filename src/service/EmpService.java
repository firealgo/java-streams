package service;

import dao.EmpDao;
import entity.Emp;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class EmpService {
    private static final List<Emp> allEmp = EmpDao.allEmp();
    private static final List<Emp> allEmpWithDuplicates = EmpDao.allEmpWithDuplicates();

    //01. Get All Emps
    public List<Emp> getAllEmp() {
        return allEmp;
    }

    // Get all Emps with duplicates
    public List<Emp> getAllEmpWithDuplicates() {
        return allEmpWithDuplicates;
    }


    // ----------- filter and map ------------------------

    //02 well paid emps list
    public List<Emp> wellPaidEmpList() {
        return allEmp.stream()
                .filter(e -> e.getSalary() > 7000)
                .toList();
    }

    // well paid emps list - only firstName list
    public List<String> wellPaidEmpNameList() {
        return allEmp.stream()
                .filter(e -> e.getSalary() > 7000)
                .map(Emp::getFirstName)
                .toList();
    }

    // ------------------ Set , Distinct ,Unique --------------

    // Set of Depts - Explain Set uses hashing technique which usies hashCode and equeals method.

    public List<String> deptDistinctList() {
        return allEmp.stream()
                .map(Emp::getDept)
                .distinct()
                .toList();
    }

    // v2
    public Set<String> deptSet() {
        return allEmp.stream()
                .map(Emp::getDept)
                .collect(toSet());
    }

    // Get all Distinct Emps - No duplicates
    public List<Emp> getAllDistinctEmp() {
        return allEmpWithDuplicates.stream()
                .distinct()
                .toList();
    }

    // Get all Distinct Emps Using Set - No duplicates (v2)
    public Set<Emp> getAllEmpSet() {
        return allEmpWithDuplicates.stream().collect(toSet());
    }


    // ---------------------- distinct and sorted ----------------------------
    // All Emp's firstName List
    public List<String> empFirstNameList() {
        return allEmp.stream()
                .map(Emp::getFirstName)
                .toList();
    }

    // All Emp's firstName List in Sorted Order
    public List<String> empFirstNameSortedList() {
        return allEmp.stream()
                .map(Emp::getFirstName)
                .sorted()
                .toList();
    }

    // Distinct Emp's firstName List in Sorted Order (v1)
    public List<String> empFirstNameSortedAndDistinctList() {
        return allEmp.stream()
                .map(Emp::getFirstName)
                .distinct()
                .sorted()
                .toList();
    }

    // Distinct Emp's firstName List in Reverse Sorted Order
    public List<String> empFirstNameReverseSortedAndDistinctList() {
        return allEmp.stream()
                .map(Emp::getFirstName)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    // Distinct Emp's firstName Set in Sorted Order - Using TreeSet (v2)
    public Set<String> empFirstNameSortedAndDistinctSet() {
        return allEmp.stream()
                .map(Emp::getFirstName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    // All Emps in Sorted Order by ID - play with allEmpWithDuplicates
    public List<Emp> empSortedListById() {
        return allEmpWithDuplicates.stream()
                .sorted(Comparator.comparing(Emp::getId))
                .toList();
    }

    // All Emps in  Reverse Sorted Order by ID
    public List<Emp> empReverseSortedListById() {
        return allEmpWithDuplicates.stream()
                .sorted(Comparator.comparing(Emp::getId).reversed())
                .toList();
    }

    // All Emps in Sorted Order by fullName
    public List<Emp> empSortedListByFullName() {
        return allEmpWithDuplicates.stream()
                .sorted(Comparator.comparing(e -> e.getFirstName() + " " + e.getLastName()))
                .toList();
    }

    // Distinct Emps in Sorted Order By FullName - explain how distinct works - toEquals()
    public List<Emp> empSortedListByFullNameAndDistinct() {
        return allEmpWithDuplicates.stream()
                .distinct()
                .sorted(Comparator.comparing(e -> e.getFirstName() + " " + e.getLastName()))
                .toList();
    }


    // ---------------------- Collectors.joining --------------------
    // Get Comma Separated fullNames in String
    public String getCommaSeparatedEmpFullNames() {
        return allEmp.stream()
                .map(e -> e.getFirstName() + " " + e.getLastName())
                .collect(joining(", "));
    }

    // ----------------------- first or any, allMatch -------------------------
    // find first emp in the list whose dept is HR
    public Emp findFirstEmpInHrDept() {
        return allEmp.stream()
                .filter(e -> e.getDept().equals("HR"))
                .findFirst().orElse(null);
    }

    // Check Any Emp exist who is in IT dept and salary < 5000
    //output:  false
    public boolean checkAnyEmpInITDeptPassingGivenSalaryCondition() {
        return allEmp.stream()
                .anyMatch(e -> e.getDept().equals("IT") && e.getSalary() < 5000);
    }

    // check if all emps salary > 4500
    public boolean checkIfAllEmpPassesCondition() {
        return allEmp.stream()
                .allMatch(e -> e.getSalary() > 4500);
    }

    // ------------------ max or min or count-----------------
    // Find Highest Paid Employee
    public Emp findHighestPaidEmp() {
        return allEmp.stream()
                .max(Comparator.comparing(Emp::getSalary))
                .get();
    }

    // Find Lowest Paid Employee
    public Emp findLowestPaidEmp() {
        return allEmp.stream()
                .min(Comparator.comparing(Emp::getSalary))
                .get();
    }

    // Count Total number of emps in IT dept
    public long getEmpCountInITDept() {
        return allEmp.stream()
                .filter(e -> e.getDept().equals("IT"))
                .count();
        // 3
    }

    // ---------------------------- mapToInt : on salary: sum, average, summerizingInt ------------------------

    // Total Salary of Emps in IT Dept
    public long totalSalaryOfITDeptEmps() {
        return allEmp.stream()
                .filter(e -> e.getDept().equals("IT"))
                .mapToInt(Emp::getSalary)
                .reduce(0, (a, b) -> a + b);
    }

    public long totalSalaryOfITDeptEmpsV2() {
        return allEmp.stream()
                .filter(e -> e.getDept().equals("IT"))
                .mapToInt(Emp::getSalary)
                .sum();
    }

    // Average Salary of Emps
    public double averageSalaryOfEmps() {
        return allEmp.stream()
                .mapToInt(Emp::getSalary)
                .average().getAsDouble();
    }

    // Collectors.summarizingInt
    public IntSummaryStatistics summarizingSalaryOfAllEmps() {
        return allEmp.stream()
                .collect(Collectors.summarizingInt(Emp::getSalary));
    }


    // ------------------- GROUP BY ---------------------------------------
    // Group Emps By Dept
    public Map<String, List<Emp>> groupEmpByDept() {
        return allEmp.stream().collect(Collectors.groupingBy(Emp::getDept));
    }

    // Group Emps By Dept - Emps should be sorted as well as distinct
    public Map<String, List<Emp>> groupEmpByDeptWithSortedAndDistictEmps() {
        return allEmpWithDuplicates.stream()
                .distinct()
                .sorted(Comparator.comparing(Emp::getId))
                .collect(Collectors.groupingBy(Emp::getDept));
    }

    // https://stackoverflow.com/questions/47679265/java-8-lambda-sorting-within-grouped-lists-and-merging-all-groups-to-a-list
    public Map<String, List<Emp>> groupEmpByDeptWithSortedAndDistictEmpsV2() {
        return allEmpWithDuplicates.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        collectingAndThen(toList(),
                                e -> e.stream().distinct().sorted(Comparator.comparing(Emp::getId)).toList())));
    }

    // Group Emp's firstNames by Dept
    public Map<String, List<String>> groupEmpFirstNameByDept() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.mapping(Emp::getFirstName, toList())));
    }

//    public Map<String, TreeSet<Emp>> groupEmpByDeptWithSortedEmps() {
//        return allEmp.stream().collect(
//                Collectors.groupingBy(
//                        Emp::getDept,
//                        Collectors.toCollection(TreeSet::new)
//                ));
//    }


    // Group Emp's fullNames by Dept
    public Map<String, List<String>> groupEmpFullNameByDept() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.mapping(e -> e.getFirstName() + " " + e.getLastName(),
                                toList())
                ));
    }

    // Total Salary by Dept
    public Map<String, Integer> totalSalaryByDept() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.summingInt(Emp::getSalary)
                ));
    }

    public Map<String, Integer> totalSalaryByDeptV2UsingReducer() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        reducing(0, Emp::getSalary, (a, b) -> a + b)
                ));
    }

    // Emp's Count by Dept - using reducer
    public Map<String, Long> empCountByDept() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        reducing(0L, e -> 1L, (a, b) -> a + b)
                ));

    }

    // Emp's Count by Dept - using Counting
    public Map<String, Long> empCountByDeptV2UsingCounting() {
        return allEmp.stream()
                .collect(Collectors.groupingBy(
                        Emp::getDept,
                        Collectors.counting()
                ));

    }


    // Highest Salaried Emp By Dept
    public Map<String, Optional<Emp>> highestSalariedEmpByDept() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                reducing(BinaryOperator.maxBy(Comparator.comparing(Emp::getSalary))))
                );
    }

    // Highest Salaried Emp By Dept -V2
    public Map<String, Optional<Emp>> highestSalariedEmpByDeptV2UsingMaxBy() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                maxBy(Comparator.comparingInt(Emp::getSalary))
                        ));
    }


    // Highest Salary Amount By Dept
    public Map<String, Optional<Integer>> highestSalaryByDept() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                mapping(Emp::getSalary, maxBy(Comparator.comparingInt(e -> e))
                                )));
    }

    // Summery of  Salaries By Dept
    public Map<String, IntSummaryStatistics> summeryOfSalariesByDept() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                summarizingInt(Emp::getSalary)
                        ));
    }

    // Well Paid ( salary > 7000)  Emps  by Dept
    public Map<String, List<Emp>> wellPaidEmpByDept() {
        return allEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Emp::getDept,
                                filtering(e -> e.getSalary() > 7000, toList())
                        ));
    }

    //    Well Paid ( sal > 7000)  Emp's firstNames by Dept
    public Map<String, List<String>> wellPaidEmpFirstNameByDept() {
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

    // Partition Emps By Salary - (salary > 7000)
    public Map<Boolean, List<Emp>> partitionEmpBySalary() {
        return allEmp.stream()
                .collect(
                        Collectors.partitioningBy(e -> e.getSalary() > 7000)
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
