
http://localhost:8080
context root : /


path        view                jsp                           parameter
 /         redirect:/boards


/boards   boards_list         WEB-INF/views/board_list.jsp                   1page의 목록을 보여준다.
/boards   boards_list         WEB-INF/views/board_list.jsp    page=2         1page의 목록을 보여준다.
/boards   boards_list         WEB-INF/views/board_list.jsp    searchType=title&searchStr=apple         제목에서 apple로 검색한 1page의 목록을 보여준다.
/boards   boards_list         WEB-INF/views/board_list.jsp    page=3&searchType=title&searchStr=apple  제목에서 apple로 검색한      3page의 목록을 보여준다.

/boards/{boardId}   boards_read       WEB-INF/views/boards_read       page=3&searchType=title&searchStr=apple

/boards/writeform   boards_writeform   글쓰기폼이보여진다.         이름, 암호, 제목, 내용
/boards (POST)      boards 리다이렉트     글이 저장되고 리다이렉트된다.

/boards/deleteform/{boardId}  boards_deleteform  암호를 물어보는 폼이 보여진다.
/boards (DELETE)    boards 리다이렉트    글이 삭제되고 리다이렉트된다.             boardId=50&passwd=hello

/boards/updateform/{boardId}  boards_updateform
/boards (PUT)      boards/{boardId} 글이 수정되고 글상세보기로 리다이렉트한다.


게시판 목록보기


http://localhost:8080/boards         파라미터가 없을 경우엔 page=1
http://localhost:8080/boards?page=2
http://localhost:8080/boards?page=11
http://localhost:8080/boards?page=12 (?)
http://localhost:8080/boards?page=-1 (?)
예> 게시물이 101건이 있다. 한페이지에 10건의 게시물 제목을 보여준다면 전체 페이지수는? 11개
   101 / 10 = 10 (정수를 정수로 나누면 잘림)
   101 % 10 = 1 (나머지가 있을 경우 10 + 1)

   - 전체페이지수를 구하려면 전체 게시물의 수



http://www.inven.co.kr/board/powerbbs.php?come_idx=17

http://www.inven.co.kr/board/powerbbs.php?come_idx=1222


http://www.inven.co.kr/board/powerbbs.php?come_idx=17&p=5

http://www.inven.co.kr/board/powerbbs.php?name=subject&keyword=확장&come_idx=17



<a href=/boards>1</a> <a href=/boards?page=2>2</a> <a href=/boards?page=3>3</a>

http://www.inven.co.kr/board/wow/17/33462
