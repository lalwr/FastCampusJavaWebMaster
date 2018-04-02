package soundsystem;

import java.util.Map;

public class MyBean {
    private String name;
    private int count;
    private Map<String, String> map;

    public MyBean(){
        System.out.println("MyBean 생성자 호출");
    }

    public MyBean(String name, int count){
        this.name = name;
        this.count = count;
    }

    public MyBean(Map<String, String> map){
        this.map = map;
    }

    public String getValue(String key){
        return map.get(key);
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
