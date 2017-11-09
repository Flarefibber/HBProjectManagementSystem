package hibernateProject.model;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill implements IModel{

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "skill_name")
    private String skill;

    public Skill() {
    }

    public Skill(String skill) {
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill1 = (Skill) o;

        return skill != null ? skill.equals(skill1.skill) : skill1.skill == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result = 31*result+ (skill != null ? skill.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                '}';
    }
}
