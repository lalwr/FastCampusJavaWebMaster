package examples;

import java.util.Arrays;
import java.util.Comparator;

public class exam {
    public static void main(String[] args){
        Student student[] = new Student[5];
        //순서대로 "이름", 학번, 학점
        student[0] = new Student("Dave", 20120001, 4.2);
        student[1] = new Student("Amie", 20150001, 4.5);
        student[2] = new Student("Emma", 20110001, 3.5);
        student[3] = new Student("Brad", 20130001, 2.8);
        student[4] = new Student("Cara", 20140001, 4.2);

        Arrays.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });


        Arrays.sort(student, new Comparable<Student>() {
            @Override
            public int compareTo(Student o) {
                return 0;
            }
        });
    }
}

class Student{
    String name; //이름
    int id; //학번
    double score; //학점
    public Student(String name, int id, double score){
        this.name = name;
        this.id = id;
        this.score = score;
    }
    public String toString(){ //출력용 toString오버라이드
        return "이름: "+name+", 학번: "+id+", 학점: "+score;
    }
}
