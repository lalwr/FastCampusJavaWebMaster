package examples;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class BoardPaginTag extends TagSupport {

    private static final long serialVersionUID = 1L;
    private String linkFunction;
    private BoardPagingInfo pagingInfo;

    private final int PREVIOUS = -1;
    private final int INDEX = 0;
    private final int NEXT = 1;

    private int maxPage;
    private int pageIndex;
    private int lastPage;

    public void setLinkFunction(String linkFunction){
        this.linkFunction = linkFunction;
    }

    public void setPagingInfo(BoardPagingInfo pagingInfo){
        this.pagingInfo = pagingInfo;
    }

    @Override
    public int doEndTag() throws JspException {
        try{
            JspWriter out = pageContext.getOut();
            String contents = getContents();
            out.println(contents);
        }catch (IOException e){
            throw new JspException();
        }
        return EVAL_PAGE;
    }

    private String getContents() {
        StringBuffer html = new StringBuffer();
        if (this.pagingInfo.getTotCount() == 0) {
            return "";
        }
        this.maxPage = this.pagingInfo.getTotCount() / this.pagingInfo.getPageSize() + (this.pagingInfo.getTotCount() % this.pagingInfo.getPageSize() > 0 ? 1 : 0);
        this.pageIndex = (this.pagingInfo.getPage() - 1) / 5;
        this.lastPage = this.pageIndex * 5 + 5 >= this.maxPage ? this.maxPage : this.pageIndex * 5 + 5;


        html.append("총 " + this.pagingInfo.getTotCount() + " 건<br>");
        if (this.pageIndex != 0) {
            html.append("<a href='javascript:;' onclick='javascript:" + navFunction(this.PREVIOUS, -1) + ";'>");
        }
        for (int i = this.pageIndex * 5 + 1 ; i < this.lastPage + 1 ; i++) {
            if (i == this.pagingInfo.getPage()) {
                html.append("<b><a href='javascript:;' onclick='javascript:" + navFunction(this.INDEX, i) + ";'>" + i + "</a></b> ");
            }else{
                html.append("<a href='javascript:;' onclick='javascript:" + navFunction(this.INDEX, i) + ";'>" + i + "</a> ");
            }

        }
        if (this.lastPage + 1 <= this.maxPage) {
            html.append("<a href='javascript:;' onclick='javascript:" + navFunction(this.NEXT, -1) + ";'>></a>");
        }

        return html.toString();
    }

    private String navFunction(int type, int index) {
        String callFunction = "return false";
        switch(type){
            case PREVIOUS :
                if(this.pageIndex == 0){
                    break;
                }
                callFunction = this.linkFunction + "(" + this.pageIndex * 5 + ")";
                break;
            case INDEX :
                if(this.pagingInfo.getPage() == index){
                    break;
                }
                callFunction = this.linkFunction + "(" + index + ")";
                break;
            case NEXT :
                if(this.lastPage +1 > this.maxPage){
                    break;
                }
                callFunction = this.linkFunction + "(" + ((this.pageIndex + 1) * 5 + 1) + ")";
                break;
        }
        return callFunction;

    }
}
