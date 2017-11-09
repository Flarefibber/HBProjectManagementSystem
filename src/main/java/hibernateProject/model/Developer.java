package hibernateProject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table (name = "developers")
public class Developer implements IModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "second_name")
    private String secondName;
    @Column (name = "salary")
    private double salary;
    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.EAGER)
    @JoinTable (name = "developer_skill", joinColumns = {@JoinColumn(name = "developer_id")},
            inverseJoinColumns = {@JoinColumn (name = "skill_id")})
    private Set<Skill> skills = new HashSet<Skill>();

    public Developer() {
    }

//    public Developer(String firstName, String secondName, double salary) {
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.salary = salary;
//    }

    public Developer(String firstName, String secondName, double salary, Set<Skill> skills) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (firstName != null ? !firstName.equals(developer.firstName) : developer.firstName != null) return false;
        return secondName != null ? secondName.equals(developer.secondName) : developer.secondName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}
