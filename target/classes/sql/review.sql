--날짜	: 180908
--작성자	: rys
--파일명	: review.sql

create table tbl_review(
	uesr_id varchar2(50) constraint tbl_review_pk primary key,
	uesr_pw varchar2(50),
	uesr_date date default sysdate
);

drop sequence tbl_review_seq;
create sequence tbl_review_seq
start with 1 		--시퀀스 번호의 시작을 지정
increment by 1 	--연속적인 시퀀스 번호의 증가치를 지정할 떄 사용
nocycle			--시퀀스 값이 최대값 까지 증가되면 다시 start로 시작(nocycle 했기 때문에 start로 안감)
nocache		--메모리상에서 시퀀스 사용 안함
;

insert into tbl_review(uesr_id,uesr_pw)  values('rys','123');

select * from tbl_review;
