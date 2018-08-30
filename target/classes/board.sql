--제목 		: 게시판 만들기 미션
--작성자 		: rys
--날짜 		: 2018.08.30
--파일명 		: board.sql
--생성할것들 	: bno, title, content, writer, regdate

--b_board 테이블 삭제
drop table b_board;

--b_board 테이블 생성
create table b_board(
	bno number, 
	title varchar2(50) not null, 
	content varchar2(100) not null, 
	writer varchar2(50) not null, 
	regdate date,
	constraint b_board_pk primary key(bno)
);

--b_board_seq 삭제
drop sequence board_seq;

--b_board_seq 생성
create sequence board_seq
   start with 1
   increment by 1
   nocache
   nocycle;

--b_board 전체 조회
select * from b_board;
--------------------------------board insert 및 selectAll 작업 끝