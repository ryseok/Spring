--날짜 	: 180831
--파일명 	: baoard.sql

--	사용할것들
--	bno
--	title
--	content
--	writer
--	regdate
--	viewcnt

--board 테이블 생성
create table tbl_board(
	bno  number constraint tbl_board_pk primary key,--글번호
	title  varchar2(100) not null,					--글제목
	content varchar2(2000),							--내용
	writer varchar2(50) not null,					--작성자
	regdate date default sysdate,					--작성일
	viewcnt number default 0						--글 조회수

);

--글번호에 사용할 시퀀스
create sequence tbl_board_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	
select * from tbl_board;
	