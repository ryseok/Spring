package com.encore.domain;

public class SearchCriteria extends Criteria {

	private String searchType; // 검색조건: 타이틀, 작성자, 내용
	private String keyword; // 검색어: "안녕" "홍길동" "화이팅"
//===================================
//	private int page; // 0 현재페이지
//	private int perPageNum; // 0 한화면에 보여줄 레코드(행) 수
//
//	// IN <----- 사용자 요청 /board/listCri?page=3&perPageNum=10
//	public void setPage(int page) {
//		if (page <= 0) {
//			this.page = 1; // 고의로 잘못 파라미터 전달시 1페이지를 기본페이지
//			return;
//		}
//		this.page = page;
//	}
//	
//	public void setPerPageNum(int perPageNum) {
//		if(perPageNum <=0 || perPageNum >100) {
//			perPageNum = 10;
//			return;
//		}
//		this.perPageNum = perPageNum;
//	}
//
//	// OUT -----> DAO ----> XML(sql)
//	public int getPageStart() {
//		//시작페이지 : (페이지번호 - 1) * 페이지 당 보여주는 개수
//		return (page-1)*perPageNum;
//	}
//
//	public int getPerPageNum() {
//		return perPageNum;
//	}
//	
//	public int getPage() {
//		return page;
//	}
//===================================
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}


}