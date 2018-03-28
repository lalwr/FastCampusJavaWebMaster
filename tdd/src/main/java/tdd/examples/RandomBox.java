package tdd.examples;

public class RandomBox {
    private String[] names = {"강사무엘", "권순규", "김병수", "김세화", "오세진", "최연정", "최준영"};

    public void mix(){
        int index0 = 0;
        int index1 = 0;
        for(int i=0; i<1000; i++){
            index0 = (int)(Math.random() * names.length);
            index1 = (int)(Math.random() * names.length);
            if(index0 != index0){
                String tmp = names[index0];
                names[index0] = names[index1];
                names[index1] = tmp;
            }
        }
    }

    public void print(int size){
        for(int i=0; i < size; i++){
            System.out.println(names[i]);
        }
    }

    public static void main(String[] args) {
        RandomBox randomBox = new RandomBox();
        randomBox.mix();
        randomBox.print(1);
    }
}
