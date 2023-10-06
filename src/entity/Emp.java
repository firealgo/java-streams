package entity;

public class Emp {
    final private int id;
    final private String firstName;
    final private String lastName;
    private int salary;
    private String dept;

    public Emp(int id, String firstName, String lastName, int salary, String dept) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}' + "\n";
    }

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public int getSalary() {
        return salary;
    }



    public String getDept() {
        return dept;
    }


}
