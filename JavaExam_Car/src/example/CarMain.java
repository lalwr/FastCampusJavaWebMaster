package example;

import example.Car;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarMain {
    public static void main(String[] args){
        //Car car = new Car(); //추상메소드라 객체 생성 불가
        Car car = new Bus();
        car.run();
        //car.bangsong(); //사용불가. 래퍼런스 타입이 Car

        Bus bus = new Bus();
        bus.run();
        bus.bangsong();
        System.out.println("---------------");

        Car car2 = new SuperCar();
        car2.run(); //메소드가 오버라이딩 되면 자식의 메소드 실행
        System.out.println("---------------");

        Car[] cars = new Car[]{new Bus(), new Bus(), new SuperCar() };
        print(cars);
        for(Car c : cars){
            c.run();
        }

        //Calendar calendar = new Calendar();

        Calendar calendar = new GregorianCalendar(); // GregorianCalendar 캘린더만 사용 가능하므로 사용 자제


        //static 한 메소드를 지향하자
        //return 값이 static한 자식 메소드가 있는지 확인
        Calendar calendar1 = Calendar.getInstance(); // 사용자가 원하는 캘린더 사용 가능
        System.out.println(calendar1.getClass().getName());

    }

    //결과를 알수없는 메소드
    public static void print(Car[] cars){
        for(Car c : cars){
            c.run();
        }
    }
}
