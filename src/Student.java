import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student extends Human implements Serializable {


    private int id;
    private String groupName;

    public Student(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Student(String name, String lastName, Enum gender, int id, String groupName) {
        super(name, lastName, gender);
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + getName() +
                ", lastName=" + getLastName() +
                ", gender=" + getGender() +
                ", id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
