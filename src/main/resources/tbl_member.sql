--tbl_member.sql

--테이블 삭제
drop table tbl_member;

create table tbl_member(
	userid varchar2(50),
	userpw varchar2(50) not null,
	username varchar2(50) not null,
	email varchar2(100),
	regdate date default sysdate,
	updatedate date default sysdate,
	constraint tbl_member_pk primary key(userid) 
);

--전체 조회
select * from tbl_member;


