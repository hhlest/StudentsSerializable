import java.io.*;

public class Faculty implements Serializable, FilePathConstants {
    private Group [] groups = new Group[10];

    public Faculty(Group[] groups) {
        this.groups = groups;
    }

    public Faculty() {
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public void addGroup (Group g) {
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == null) {
                groups[i] = g;
                return;
            }
        }
    }

    public Group getGroup(String groupName) {
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != null && groups[i].getGroupName().equals(groupName)) {
                return groups[i];
            }
        }
        return null;
    }

    public static void saveToFileUsingSerialization(Faculty s1) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE_PATH))) {
            oos.writeObject(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Faculty readFromFileUsingSerialization() {
        Faculty result = new Faculty();
        try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream(OUTPUT_FILE_PATH))) {
            result = (Faculty) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Group getGroupFromFileUsingSerialization (String groupName) {
        Faculty f = readFromFileUsingSerialization();
        return f.getGroup(groupName);
    }

    public static Student getStudentFromFileUsingSerialization (String studentLastname) throws Exception {
        Student result;
        Faculty f = readFromFileUsingSerialization();

        for (int i = 0; i < f.getGroups().length; i++) {
            if (f.getGroups()[i].searchStudentByLastName(studentLastname) != null) {
                result = f.getGroups()[i].searchStudentByLastName(studentLastname);
                return result;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "Faculty: \n";
        for (Group it : groups) {
            if (it != null) {
                result += it + "\n";
            }
        }
        return result;
    }
}
