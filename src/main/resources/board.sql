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
drop table tbl_board;
create table tbl_board(
	bno  number constraint tbl_board_pk primary key,--글번호
	title  varchar2(100) not null,					--글제목
	content varchar2(2000),							--내용
	writer varchar2(50) not null,					--작성자
	regdate date default sysdate,					--작성일
	viewcnt number default 0						--글 조회수

);


--글번호에 사용할 시퀀스
drop sequence tbl_board_seq;
create sequence tbl_board_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	
select * from TBL_BOARD;

--댓글 추가 카운트
alter table tbl_board
add replycnt number default 0;

--댓글 카운트 동기화
update TBL_BOARD
set replycnt=(select count(*)
              from TBL_REPLY
              where bno=TBL_BOARD.bno);
              
              
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');
insert into tbl_board (bno,title,content,writer) values (tbl_board_seq.nextval,'타이틀','내용','홍길동');