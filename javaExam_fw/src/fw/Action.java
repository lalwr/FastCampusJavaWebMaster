package fw;

public abstract class Action {
    public final void exec(){ //오러바리이딩 금지
        init();
        run();
        destory();
    }
    protected void init(){ //상속, 같은 package접근
        System.out.println("init");
    }

    protected abstract void run();

    protected  void destory(){
        System.out.println("destory");
    }
}
