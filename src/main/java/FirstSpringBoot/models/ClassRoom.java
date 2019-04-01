package FirstSpringBoot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="classrooms")
public class ClassRoom implements Serializable {
    @Id
    @Column(name="id", length=5)
    private String id;

    @Column(name="name", length=50)
    private String name;

    @Column(name="teacher", length=50)
    private String teacher;

    @Column(name="amount")
    private int amount;

    public ClassRoom(String id, String name, String teacher, int amount) {
        this.id=id;
        this.name=name;
        this.teacher=teacher;
        this.amount=amount;
    }

    public ClassRoom() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher=teacher;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount=amount;
    }
}
