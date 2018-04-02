package soundsystem;

public class MyCD implements CompactDisc{
    private String title;

    public MyCD(String title){
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println(title + " play - MyCD");
    }
}
