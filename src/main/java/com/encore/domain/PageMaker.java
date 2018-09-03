package com.encore.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


public class PageMaker {
	// 게시물 하단에 번호출력하기
	// 게시물 하단 번호 좌측에 '<<'(prev) 우측에 '>>'(next)출력
	// ===> 번호와 prev,next 정보를 담는 클래스
/*

                  totalRecord : 372



                prev                                   next              현재페이지
                        1  2  3  4  5  6  7  8  9 10   >>                   3


                  <<   11 12 13 14 15 16 17 18 19 20   >>                  17


                  <<   21 22 23 24 25 26 27 28 29 30   >>                  24


                  <<   31 32 33 34 35 36 37 38                             35


      endPage =    ceil(17/10) * 10
                        1.7        2*10 ----->   20
                        35/10      4*10 ----->   40

      startPage =    (20-10)+1     ----->   11



      tempEndPage =  ceil(372/10)
                           37.2   -----> 38

      if(40>38){
           endPage=38;
      }
	
 */

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPageNum = 10;// 한 화면에 출력될 레코드(행) 수
	private Criteria cri;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();//시작페이지 번호, 끝페이지 번호, prev와 next의 상태 저장
	}
	
	private void calcData() {
	   //마지막 페이지 번호 구하기
		endPage= (int)(Math.ceil(cri.getPage()/(double)displayPageNum)
				            *displayPageNum);
		//현재페이지 3 일때
		//endPage= (int)( ceil(3/10.0) * 10  )
		//                      0.3 --> 1  * 10  ---->10
		startPage = (endPage-displayPageNum) + 1; // (10-10)+1 -->1
		
		int tempEndPage= (int) (Math.ceil(totalCount/(double)cri.getPerPageNum()));
	    //총 행의 갯수가 372 일때                  ceil(372/10)  ----> 38
		
		//현재 페이지 35페이지 이면   startPage==> 31,  endPage ==> 40
		if(endPage>tempEndPage) {// 40> 38
			endPage = tempEndPage;//endPage = 38
		}
		
		
		prev = (startPage==1) ? false:true;
		//startPage가 1이면 [1 2 3 4 5 6 7 8 9 10] prev를 false로 JSP전달하여 '<<'를 비활성화,notVisible

		next = (endPage * cri.getPerPageNum() >= totalCount) ? false:true;
		//마지막 숫자 출력이면 next를 false하여  JSP페이지에서 '>>'를 비활성화, not Visiblue
	}//calcData()
	
	public String makeQuery(int page) {
	  /*
	   UriComponents uriComponents =
			  UriComponentsBuilder.newInstance()
			  .queryParam("username","gildong")
			  .queryParam("age",13)
			  .queryParam("job","stu").build();
	  ----> "username=gildong&age=13&job=stu"
	  */
	  /*
	          <form method=get>
	               <input name="username" value="gildong">
	               <input name="age" value="13">
	               <input name="job" value="stu">
		       </form>
		  ----> 폼 액션 발생시   "?username=gildong&age=13&job=stu" 생성
		  사용이유: 폼 엘리먼트 사용없이 URL 파라미터를 생성하겠다!!        
	   */
	  
		 UriComponents uriComponents =
				  UriComponentsBuilder.newInstance()
				  .queryParam("page", page)//현재페이지
				  .queryParam("perPageNum", cri.getPerPageNum())
				  //한 화면에 보여줄 레코드 행수
				  .build();
		 return uriComponents.toString();//"?page=3&perPageNum=10"
	}


	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}

}