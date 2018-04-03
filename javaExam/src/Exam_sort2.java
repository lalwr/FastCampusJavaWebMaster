import java.util.Arrays;
import java.util.Comparator;

public class Exam_sort2 {
    public static void main(String[] args) {
        Student2[] Student2 = new Student2[5];
        //순서대로 "이름", 입학년도
        Student2[0] = new Student2("KIM", 2012, 4.1);
        Student2[1] = new Student2("LEE", 2011, 2.7);
        Student2[2] = new Student2("CHO", 2017, 3.5);
        Student2[3] = new Student2("BAK", 2009, 2.5);
        Student2[4] = new Student2("PANG", 2011, 3.5);

        Arrays.sort(Student2, new Comparator<Student2>(){
            public int compare(Student2 s1, Student2 s2) {
                double s1Grade = s1.grade;
                double s2Grade = s2.grade;
                if(s1Grade == s2Grade){ //입학년도가 같으면
                    return Integer.compare(s1.year, s2.year); //입학년도 오름차순
                }
                return Double.compare(s2.grade, s1.grade); //성적 내림차순
            }
        });

        for(int i=0;i<5;i++)
            System.out.println(Student2[i]);
    }
}

class Student2 implements Comparable<Student> {

    String name; //이름
    int year; //입학년도
    double grade; //학점
    public Student2(String name, int year, double grade){
        this.name = name;
        this.year = year;
        this.grade = grade;
    }

    public String toString(){
        return "이름: "+name+", 입학년도 : "+year+", 학번 : "+grade;
    }

    @Override
    public int compareTo(Student student) {
        return Integer.compare(year, student.year); //입학년도 기준으로 오름차순 정렬
    }

}
