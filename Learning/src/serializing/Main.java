package serializing;

import java.io.*;
// Add Commit 

class Student implements Serializable{
    int id;
    String name;

    public Student(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Student{id=" + id + ",name=" + name + "}"; // Constructor
    }
}
public class Main {
    public static void main(String[] args) {
        Student s = new Student(1,"Shreyash");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\91997\\Desktop\\New Folder\\Student.ser")); // Chances of Error dur to FileOutputStream that's why we use Exception Handling try & catch
            oos.writeObject(s);
            System.out.println("SAVED");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\91997\\Desktop\\New Folder\\Student.ser"));) {
            Student s1 = (Student) ois.readObject(); // Chances of Error due to FileOutputStream that's why we use Exception Handling try & catch
            System.out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
