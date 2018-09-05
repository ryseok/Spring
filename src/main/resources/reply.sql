--날짜	 : 180905
--작성자	 : rys
--제목	 : 댓글
--파일명	 : reply.sql

--VO,xml에서 사용할것
--rno
--bno
--replytext
--replyer
--regdate
--updatedate

drop table tbl_reply;
create table tbl_reply(
	rno			number,						--댓글번호(자동추가)
	bno			number,						--게시물번호
	replytext	varchar2(1000) not null,	--댓글내용
	replyer		varchar2(50) not null,		--댓글 작성자
	regdate		date default sysdate,		--댓글 등록일
	updatedate	date default sysdate		--댓글 수정일
);

alter table tbl_reply
add constraint tbl_reply_pk primary key(rno);

alter table tbl_reply
add constraint tbl_reply_fk foreign key(bno) 
 references tbl_board(bno);
 
drop sequence tbl_reply_seq;
create sequence tbl_reply_seq
          start with 1
          increment by 1
          nocycle
          nocache;

	