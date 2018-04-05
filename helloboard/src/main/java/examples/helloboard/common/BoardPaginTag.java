package examples.helloboard.common;

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


        html.append("<div class='row'>");
        html.append("<div class='col-sm-4'>");
        html.append("<div class='dataTables_info' role='status' aria-live='polite'>총 " + this.pagingInfo.getTotCount() + " 건</div>");
        html.append("</div>");
        html.append("<div class='col-sm-8'>");
        html.append("<div class='dataTables_paginate paging_simple_numbers'>");
        html.append("<ul class='pagination'>");
        html.append("<li class='paginate_button previous ");
        if (this.pageIndex == 0) {
            html.append("disabled");
        }
        html.append("' aria-controls='dataTables-example' tabindex='0'><a href='javascript:;' onclick='javascript:" + navFunction(this.PREVIOUS, -1) + ";'><</a></li>");
        for (int i = this.pageIndex * 5 + 1 ; i < this.lastPage + 1 ; i++) {
            html.append("<li class='paginate_button ");
            if (i == this.pagingInfo.getPage()) {
                html.append("active");
            }
            html.append("' aria-controls='dataTables-example' tabindex='0'><a href='javascript:;' onclick='javascript:" + navFunction(this.INDEX, i) + ";'>" + i + "</a></li>");
        }
        html.append("<li class='paginate_button next ");
        if (this.lastPage + 1 > this.maxPage) {
            html.append("disabled");
        }
        html.append("' aria-controls='dataTables-example' tabindex='0'><a href='javascript:;' onclick='javascript:" + navFunction(this.NEXT, -1) + ";'>></a></li>");
        html.append("</ul>");
        html.append("</div>");
        html.append("</div>");
        html.append("</div>");

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
