--게시판 복습
drop table re_board;

create table re_board(
	bno number,
	title varchar2(50) not null,
	content varchar2(100) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	constraint re_board_pk primary key(bno)
	
);

drop sequence re_board_seq;

create sequence re_board_seq
	start with 1
	increment by 1
	nocache
	nocycle;
	
select *from re_board;