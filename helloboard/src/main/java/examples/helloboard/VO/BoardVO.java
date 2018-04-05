package examples.helloboard.VO;

public class BoardVO extends CommonVO{
    public String subject;
    public int no;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
