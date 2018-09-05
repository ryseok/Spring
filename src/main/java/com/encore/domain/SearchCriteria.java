package com.encore.domain;

public class SearchCriteria extends Criteria {

	private String searchType;// 검색조건: 타이틀, 작성자, 내용
	private String keyword;// 검색어: "안녕" "홍길동" "화이팅"

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
		return super.toString() + "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}

}