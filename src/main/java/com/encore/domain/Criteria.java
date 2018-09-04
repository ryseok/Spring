package com.encore.domain;

public class Criteria {
	private int page; 		// 현재페이지
	private int perPageNum; // 한 화면에 출력할 행의수
	// ===> page와 perPageNum은 요청URL을 통해 초기화
	
	public Criteria() {
		// 기본값 설정(파라미터 정보가 없을시)
		page = 1;
		perPageNum = 10;
	}

	// IN <----- 사용자 요청 /board/listCri?page=3&perPageNum=10
	public void setPage(int page) {
		if(page <= 0) {
			page = 1; //고의로 잘못 파라미터 전달시 1페이지를 기본페이지 
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <=0 || perPageNum >100) {
			perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	// OUT -----> DAO ----> XML(sql)
	public int getPageStart() {
		//시작페이지 : (페이지번호 - 1) * 페이지 당 보여주는 개수
		return (page-1)*perPageNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

	public int getPage() {
		return page;
	}

}
