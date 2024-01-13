package entity;

import java.util.Objects;

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
        return "\n{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return getId() == emp.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
