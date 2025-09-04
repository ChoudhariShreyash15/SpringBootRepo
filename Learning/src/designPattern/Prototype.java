package designPattern;

//interface A extends Cloneable
//{
//   public abstract A clone();
//}

class Student implements Cloneable
{
    public Student(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
}
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student=new Student("Mahesh",21);
        System.out.println(student);
        Student student2 = student.clone();
        student2.setAge(23);
        student2.setName("Kishore");
        System.out.println(student2);
        System.out.println(student==student2);
        Student clone = student2.clone();
        clone.setName("Pulkesh");
        clone.setAge(24);
        System.out.println(clone);
    }
}
