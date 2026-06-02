import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    private double mark1;
    private double mark2;
    private double mark3;

    private int attendedClasses;
    private int totalClasses;

    public Student(int id, String name, int age, String course,
                   double mark1, double mark2, double mark3,
                   int attendedClasses, int totalClasses) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.attendedClasses = attendedClasses;
        this.totalClasses = totalClasses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return (mark1 + mark2 + mark3) / 3.0;
    }

    public String getGrade() {
        double per = getPercentage();

        if (per >= 90) return "A";
        else if (per >= 75) return "B";
        else if (per >= 60) return "C";
        else if (per >= 40) return "D";
        else return "F";
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0)
            return 0;

        return (attendedClasses * 100.0) / totalClasses;
    }

    public void update(String name, int age, String course,
                       double mark1, double mark2, double mark3,
                       int attendedClasses, int totalClasses) {

        this.name = name;
        this.age = age;
        this.course = course;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.attendedClasses = attendedClasses;
        this.totalClasses = totalClasses;
    }

    @Override
    public String toString() {
        return "\n----------------------------------" +
                "\nID            : " + id +
                "\nName          : " + name +
                "\nAge           : " + age +
                "\nCourse        : " + course +
                "\nMark 1        : " + mark1 +
                "\nMark 2        : " + mark2 +
                "\nMark 3        : " + mark3 +
                "\nPercentage    : " + String.format("%.2f", getPercentage()) +
                "\nGrade         : " + getGrade() +
                "\nAttendance %  : " + String.format("%.2f", getAttendancePercentage()) +
                "\n----------------------------------";
    }
}

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        if (!login()) {
            System.out.println("Invalid Credentials!");
            return;
        }

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort By Name");
            System.out.println("7. Sort By Percentage");
            System.out.println("8. Dashboard");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    sortByName();
                    break;
                case 7:
                    sortByPercentage();
                    break;
                case 8:
                    dashboard();
                    break;
                case 9:
                    System.out.println("Thank You!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static boolean login() {

        sc.nextLine();

        System.out.println("===== ADMIN LOGIN =====");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        return username.equals("admin")
                && password.equals("12345");
    }

    static boolean studentExists(int id) {
        for (Student s : students) {
            if (s.getId() == id)
                return true;
        }
        return false;
    }

    static void addStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        if (studentExists(id)) {
            System.out.println("Student ID Already Exists!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Mark 1: ");
        double m1 = sc.nextDouble();

        System.out.print("Enter Mark 2: ");
        double m2 = sc.nextDouble();

        System.out.print("Enter Mark 3: ");
        double m3 = sc.nextDouble();

        System.out.print("Attended Classes: ");
        int attended = sc.nextInt();

        System.out.print("Total Classes: ");
        int total = sc.nextInt();

        students.add(new Student(
                id, name, age, course,
                m1, m2, m3,
                attended, total));

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void updateStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {

                sc.nextLine();

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Mark 1: ");
                double m1 = sc.nextDouble();

                System.out.print("Enter Mark 2: ");
                double m2 = sc.nextDouble();

                System.out.print("Enter Mark 3: ");
                double m3 = sc.nextDouble();

                System.out.print("Attended Classes: ");
                int attended = sc.nextInt();

                System.out.print("Total Classes: ");
                int total = sc.nextInt();

                s.update(
                        name, age, course,
                        m1, m2, m3,
                        attended, total);

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {

                students.remove(s);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void sortByName() {

        students.sort(
                Comparator.comparing(
                        Student::getName,
                        String.CASE_INSENSITIVE_ORDER));

        System.out.println("Sorted By Name!");
    }

    static void sortByPercentage() {

        students.sort(
                Comparator.comparingDouble(
                        Student::getPercentage)
                        .reversed());

        System.out.println("Sorted By Percentage!");
    }

    static void dashboard() {

        System.out.println("\n===== DASHBOARD =====");

        System.out.println("Total Students: "
                + students.size());

        if (students.isEmpty())
            return;

        double totalPercentage = 0;

        Student topper = students.get(0);

        for (Student s : students) {

            totalPercentage += s.getPercentage();

            if (s.getPercentage() >
                    topper.getPercentage()) {

                topper = s;
            }
        }

        System.out.println("Average Percentage: "
                + String.format("%.2f",
                totalPercentage / students.size()));

        System.out.println("Topper: "
                + topper.getName());

        System.out.println("Topper Percentage: "
                + String.format("%.2f",
                topper.getPercentage()));
    }
}