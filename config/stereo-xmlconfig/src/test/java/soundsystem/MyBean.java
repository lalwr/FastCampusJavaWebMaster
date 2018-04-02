package soundsystem;

public class MyBean {
    private String name;
    private int count;

    public MyBean(){
        System.out.println("MyBean 생성자 호출");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
