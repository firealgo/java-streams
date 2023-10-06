package collectorsDemo;

import collectorsDemo.EmpService;

public class EmpServiceDemo {
    private static final EmpService service = new EmpService();
    public static void main(String[] args) {
        // 01. print all empList
        System.out.println("\n -----  All Emp  -----");
        System.out.println(service.getAllEmp());

        //02. Group Emps By Dept
//        System.out.println("\n -----  Group Emps By Dept  -----");
//        System.out.println(service.groupEmpByDept());
        //03. Group Emps firstName by Dept
//        System.out.println("\n -----  Group Emps firstName by Dept  -----");
//        System.out.println(service.groupEmpFirstNameByDept());
        //04. Group Emps firstName by Dept
//        System.out.println("\n -----  Group Emps fullName by Dept  -----");
//        System.out.println(service.groupEmpFullNameByDept());

        //05. Total Salary By Dept
//        System.out.println("\n -----  Total Salary By Dept  -----");
//        System.out.println(service.totalSalaryByDept());

        //06. Total Salary By Dept
//        System.out.println("\n -----  Total Salary By Dept  -----");
//        System.out.println(service.empCountByDept());

        //07. Partition Emps By Salary
//        System.out.println("\n -----  Partition Emps By Salary  -----");
//        System.out.println(service.partitionEmpBySalary());

        //08. Find Highest Salaried Emp By Dept
//        System.out.println("\n -----  Find Highest Salaried Emp By Dept  -----");
//        System.out.println(service.highestSalariedEmpByDept());
        //09. Find Highest Salary By Dept
//        System.out.println("\n -----  Find Highest Salaried Emp By Dept  -----");
//        System.out.println(service.highestSalaryByDept());

        //10. Well Paid Emps by Dept. Ex:: sal > 7000  == wel paid
//        System.out.println("\n -----  Well Paid Emps by Dept. Ex:: sal > 7000  == wel paid  -----");
//        System.out.println(service.wellPaidEmpByDept());

        //11. Well Paid Emps Name by Dept. Ex:: sal > 7000  == wel paid
//        System.out.println("\n -----  Well Paid Emps by Dept. Ex:: sal > 7000  == wel paid  -----");
//        System.out.println(service.wellPaidEmpNameByDept());

        //12. Map EmpId to Emp FullName
        System.out.println("\n -----  Map EmpId to Emp FullName  -----");
        System.out.println(service.mapEmpIdToEmpFullName());

        //13. Map EmpId to Emp FullName - sorted TreeMap
        System.out.println("\n -----  Map EmpId to Emp FullName - sorted TreeMap  -----");
        System.out.println(service.mapEmpIdToEmpFullNameSorted());

    }


}
