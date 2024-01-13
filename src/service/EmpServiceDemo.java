package service;

public class EmpServiceDemo {
    private static final EmpService service = new EmpService();

    public static void main(String[] args) {
        // --------------- AllEmps , AllDistinctEmps, SetOfEmps
        // 01. print all empList
//        System.out.println("\n -----  All Emp  -----");
//        System.out.println(service.getAllEmp());

        // 02 Get all Emps with duplicates
        System.out.println("\n -----  Get all Emps with duplicates  -----");
        System.out.println(service.getAllEmpWithDuplicates());

        //03. Get all Distinct Emps - No duplicates
        System.out.println("\n -----  Get all Distinct Emps - No duplicates -----");
        System.out.println(service.getAllDistinctEmp());

        //03. Get all Distinct Emps - No duplicates v2 Using Set
        System.out.println("\n -----  Get all Distinct Emps - No duplicates v2 Using Set -----");
        System.out.println(service.getAllEmpSet());

        // 02. Well Paid Emps List
//        System.out.println("\n -----  Well Paid Emps List  -----");
//        System.out.println(service.wellPaidEmpList());

        // 02. Well Paid Emps List - only firstName list
//        System.out.println("\n -----  Well Paid Emps List - only firstName list  -----");
//        System.out.println(service.wellPaidEmpNameList());

        // 02. Set of Depts
//        System.out.println("\n -----  Set of Depts  -----");
//        System.out.println(service.deptSet());

        // -------------------- Sorting & Distinct -------------------
        // All Emp's firstName List
//        System.out.println("\n -----  All Emp's firstName List  -----");
//        System.out.println(service.empFirstNameList());
//
//        // All Emp's firstName List in Sorted Order
//        System.out.println("\n -----  All Emp's firstName List in Sorted Order  -----");
//        System.out.println(service.empFirstNameSortedList());

        // Distinct Emp's firstName List in Sorted Order
//        System.out.println("\n -----  Distinct Emp's firstName List in Sorted Order  -----");
//        System.out.println(service.empFirstNameSortedAndDistinctList());
//
//        // Distinct Emp's firstName List in Reverse Sorted Order
//        System.out.println("\n -----  Distinct Emp's firstName List in Reverse Sorted Order  -----");
//        System.out.println(service.empFirstNameReverseSortedAndDistinctList());
//
//        // Distinct Emp's firstName Set in Sorted Order - Using TreeSet
//        System.out.println("\n -----  Distinct Emp's firstName Set in Sorted Order - Using TreeSet  -----");
//        System.out.println(service.empFirstNameSortedAndDistinctList());

        // All Emps in Sorted Order by ID
//        System.out.println("\n -----  All Emps in Sorted Order by ID  -----");
//        System.out.println(service.empSortedListById());
//
//        // All Emps in  Reverse Sorted Order by ID
//        System.out.println("\n -----  All Emps in  Reverse Sorted Order by ID  -----");
//        System.out.println(service.empReverseSortedListById());

        // All Emps in Sorted Order by fullName
//        System.out.println("\n -----  All Emps in Sorted Order by fullName  -----");
//        System.out.println(service.empSortedListByFullName());

        // Distinct Emps in Sorted Order By fullName - explain how distinct works - toEquals()
//        System.out.println("\n -----  Distinct Emps in Sorted Order By fullName - explain how distinct works - toEquals()  -----");
//        System.out.println(service.empSortedListByFullNameAndDistinct());

        // --------------------------------- joining ---------------------------

        // Get Comma Separated fullNames in String
//        System.out.println("\n -----  Get Comma Separated fullNames in String  -----");
//        System.out.println(service.getCommaSeparatedEmpFullNames());

        // ------ first and any -----------------------
//        find first emp in HR Dept
//        System.out.println("\n -----  find first emp in HR Dept  -----");
//        System.out.println(service.findFirstEmpInHrDept());

//        check Any Emp exist who is in HR dept and salary < 4500
//        System.out.println("\n -----  check Any Emp exist who is in HR dept and salary < 4500 -----");
//        System.out.println(service.checkAnyEmpInITDeptPassingGivenSalaryCondition());
//
//        //10. check if all emps salary > 4500
//        System.out.println("\n -----  check if all emps salary > 4500 -----");
//        System.out.println(service.checkIfAllEmpPassesCondition());

        // ------------------ max or min or count-----------------
        // Find Highest Paid Employee
//        System.out.println("\n -----  Find Highest Paid Employee -----");
//        System.out.println(service.findHighestPaidEmp());
//        System.out.println("\n -----  Find Lowest Paid Employee -----");
//        System.out.println(service.findLowestPaidEmp());

        // ---------------------------- mapToInt ------------------------

        // Total Salary of Emps in IT Dept
//        System.out.println("\n -----  Total Salary of Emps in IT Dept  -----");
//        System.out.println(service.totalSalaryOfITDeptEmps());
//        // // Average Salary of Emps
//        System.out.println("\n -----  // Average Salary of Emps  -----");
//        System.out.println(service.averageSalaryOfEmps());
//
//        // Collectors.summarizingInt
//        System.out.println("\n -----  // Collectors.summarizingInt  -----");
//        System.out.println(service.summarizingSalaryOfAllEmps());
//        System.out.println(service.summarizingSalaryOfAllEmps().getMax());

        // ------------------------------------ GroupBy  -------------------------

        //02. Group Emps By Dept
//        System.out.println("\n -----  Group Emps By Dept  -----");
//        System.out.println(service.groupEmpByDept());
        
         // Group Emps By Dept & Emps should be sorted as well as distinct
        System.out.println("\n -----  Group Emps By Dept & Emps should be sorted as well as distinct  -----");
        System.out.println(service.groupEmpByDeptWithSortedAndDistictEmpsV2());

        //03. Group Emp's firstNames by Dept
//        System.out.println("\n -----  Group Emps firstName by Dept  -----");
//        System.out.println(service.groupEmpFirstNameByDept());

        //04. Group Emps fullName by Dept
//        System.out.println("\n -----  Group Emps fullName by Dept  -----");
//        System.out.println(service.groupEmpFullNameByDept());

        //05. Total Salary By Dept
//        System.out.println("\n -----  Total Salary By Dept  -----");
//        System.out.println(service.totalSalaryByDept());

        //06. Emp Count By Dept
//        System.out.println("\n -----  06. Emp Count By Dept  -----");
//        System.out.println(service.empCountByDept());


        //08. Find Highest Salaried Emp By Dept
//        System.out.println("\n -----  Find Highest Salaried Emp By Dept  -----");
//        System.out.println(service.highestSalariedEmpByDept());
        //09. Find Highest Salary By Dept
//        System.out.println("\n -----  Find Highest Salaried Emp By Dept  -----");
//        System.out.println(service.highestSalaryByDept());

        // Summery of  Salaries By Dept
//        System.out.println("\n -----  Summery of  Salaries By Dept  -----");
//        System.out.println(service.summeryOfSalariesByDept());

        //10. Well Paid ( sal > 7000)  Emps  by Dept.
//        System.out.println("\n -----  Well Paid Emps by Dept. Ex:: sal > 7000  == wel paid  -----");
//        System.out.println(service.wellPaidEmpByDept());

        //11. Well Paid Emps Name by Dept. Ex:: sal > 7000  == wel paid
//        System.out.println("\n -----  Well Paid Emps by Dept. Ex:: sal > 7000  == wel paid  -----");
//        System.out.println(service.wellPaidEmpNameByDept());

        //07. Partition Emps By Salary - (salary > 7000)
//        System.out.println("\n -----  Partition Emps By Salary  -----");
//        System.out.println(service.partitionEmpBySalary());

        //12. Map EmpId to Emp FullName
//        System.out.println("\n -----  Map EmpId to Emp FullName  -----");
//        System.out.println(service.mapEmpIdToEmpFullName());

        //13. Map EmpId to Emp FullName - sorted TreeMap
//        System.out.println("\n -----  Map EmpId to Emp FullName - sorted TreeMap  -----");
//        System.out.println(service.mapEmpIdToEmpFullNameSorted());

    }


}
