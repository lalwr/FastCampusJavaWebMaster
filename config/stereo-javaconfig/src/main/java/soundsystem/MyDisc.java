package soundsystem;

public class MyDisc implements CompactDisc{

    public MyDisc(){
        System.out.println("MyDisc 호출!!!");
    }

    @Override
    public void play() {
        System.out.println("MyDisc!!!");
    }
}
