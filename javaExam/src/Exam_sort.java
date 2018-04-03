import java.util.Arrays;

public class Exam_sort {
    public static void main(String[] args) {
        Student student[] = new Student[5];
        //순서대로 "이름", 입학년도
        student[0] = new Student("KIM", 2012);
        student[1] = new Student("LEE", 2011);
        student[2] = new Student("CHO", 2015);
        student[3] = new Student("BAK", 2009);
        student[4] = new Student("PANG", 2017);

        Arrays.sort(student); //내부적으로 오버라이딩을 구현한 메소드를 호출한다.
        for(int i=0;i<5;i++) //toString에 정의된 형식으로 출력
            System.out.println(student[i]);
    }
}
class Student implements Comparable<Student> {

    String name; //이름
    int year; //입학년도
    public Student(String name, int year){
        this.name = name;
        this.year = year;
    }

    public String toString(){
        return "이름: "+name+", 입학년도 : "+year;
    }

    /*@Override
    public int compareTo(Student student) {
        //return Integer.compare(year, student.year); //입학년도 기준으로 오름차순 정렬
        //return Integer.compare(student.year, year); //입학년도 기준으로 내림차순 정렬

    }*/

    @Override
    public int compareTo(Student student) {
        return name.compareTo(student.name); // 이름순으로 기준으로 오름차순 정렬
        //return student.getName().compareTo(name); // 이름순으로 기준으로 내림차순 정렬
    }
}