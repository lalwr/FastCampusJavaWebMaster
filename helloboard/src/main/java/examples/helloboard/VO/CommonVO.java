package examples.helloboard.VO;

import java.io.Serializable;

public class CommonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int page = 1;
    private int pageVal = 0; //sql 에서 리스트 가져올떄 사용
    private int pageSize = 3;
    private int totCount;

    private String linkFunc;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        this.pageVal = (page - 1) * pageSize;
    }

    public int getPageVal() {
        return pageVal;
    }

    public void setPageVal(int pageVal) {
        this.pageVal = pageVal;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotCount() {
        return totCount;
    }

    public void setTotCount(int totCount) {
        this.totCount = totCount;
    }

    public String getLinkFunc() {
        return linkFunc;
    }

    public void setLinkFunc(String linkFunc) {
        this.linkFunc = linkFunc;
    }
}
