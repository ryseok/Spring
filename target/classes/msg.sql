-- msg.sql

drop table tbl_msg;
drop table tbl_user;
drop sequence tbl_msg_seq; 

select * from tbl_user;
select * from tbl_msg;

create table tbl_user(
  userid     varchar2(30),
  userpw     varchar2(30) not null,
  username   varchar2(50) not null,
  userpoint  number default 0
);

create table tbl_msg(
  mno          number,
  senderid     varchar2(30),
  receiverid   varchar2(30),
  msg          varchar2(3000),
  senddate     date default sysdate,
  opendate     date
);

alter table tbl_user
add constraint tbl_user_pk primary key(userid);

alter table tbl_msg
add constraint tbl_msg_pk primary key(mno);

alter table tbl_msg 
add constraint tbl_msg_fk1 foreign key (senderid)  references tbl_user(userid);

alter table tbl_msg 
add constraint tbl_msg_fk2 foreign key (receiverid)  references tbl_user(userid);

create sequence tbl_msg_seq
       start with 1
       increment by 1
       nocycle
       nocache;
           
insert into tbl_user (userid, userpw, username) values ('gildong','1234','홍길동');
insert into tbl_user (userid, userpw, username) values ('lime','2222','길라임');
insert into tbl_user (userid, userpw, username) values ('juwon','3333','김주원');
