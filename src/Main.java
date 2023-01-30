public class Main {
    public static void main(String[] args) {

        Faculty faculty = new Faculty();

        Group g1 = new Group("G1");
        Student s1 = new Student("a", "a", Gender.F, 1, g1.getGroupName());
        Student s2 = new Student("b", "b", Gender.M, 2, g1.getGroupName());

        Group g2 = new Group("G2");
        Student s3 = new Student("c", "c", Gender.F, 3, g2.getGroupName());
        Student s4 = new Student("d", "d", Gender.M, 4, g2.getGroupName());

        Group g3 = new Group("G3");
        Student s5 = new Student("e", "e", Gender.F, 5, g3.getGroupName());
        Student s6 = new Student("f", "f", Gender.M, 6, g3.getGroupName());

        try {
            g1.addStudent(s1);
            g1.addStudent(s2);
            g2.addStudent(s3);
            g2.addStudent(s4);
            g3.addStudent(s5);
            g3.addStudent(s6);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }

        faculty.addGroup(g1);
        faculty.addGroup(g2);
        faculty.addGroup(g3);

        Faculty.saveToFileUsingSerialization(faculty);
        System.out.println(Faculty.readFromFileUsingSerialization());

        System.out.println(Faculty.getGroupFromFileUsingSerialization("G3"));

        try {
            System.out.println(Faculty.getStudentFromFileUsingSerialization("c"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
