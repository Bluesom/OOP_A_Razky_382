public class User {
    private String name;
    private String studentID;

    public User(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public boolean login() {
        return false;
    }

    public void displayInfo() {
        System.out.println("User Info:");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
    }
}
