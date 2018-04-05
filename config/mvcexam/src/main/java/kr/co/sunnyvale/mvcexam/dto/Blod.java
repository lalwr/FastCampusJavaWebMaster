package kr.co.sunnyvale.mvcexam.dto;

public class Blod {
    private String name;
    private String blod;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlod() {
        return blod;
    }

    public void setBlod(String blod) {
        this.blod = blod;
    }

    @Override
    public String toString() {
        return "Blod{" +
                "name='" + name + '\'' +
                ", blod='" + blod + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
