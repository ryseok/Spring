--tbl_member.sql
create table tbl_member(
	userid varchar2(50),
	userpw varchar2(50) not null,
	username varchar2(50) not null,
	email varchar2(100),
	regdate date default sysdate,
	updatedate date default sysdate,
	constraint tbl_member_pk primary key(userid) 
);

select * from tbl_member;