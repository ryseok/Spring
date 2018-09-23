/* 멤버 */
select * from member;
CREATE TABLE member (
	member_email VARCHAR2(50) NOT NULL, /* 이메일 */
	member_pw VARCHAR2(20) NOT NULL, /* 회원PW */
	member_name VARCHAR2(30) NOT NULL, /* 이름 */
	member_addr VARCHAR2(200) NOT NULL, /* 주소 */
	member_tel VARCHAR2(13) NOT NULL, /* 연락처 */
	member_pref VARCHAR2(50), /* 선호지역 */
	member_intro VARCHAR2(300) /* 소개 */
);

CREATE UNIQUE INDEX PK_member
	ON member (
		member_email ASC
	);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			member_email
		);

/* 게시글 */
CREATE TABLE board (
	board_no NUMBER NOT NULL, /* 게시글번호 */
	board_type VARCHAR2(20) NOT NULL, /* 게시글유형 */
	board_title VARCHAR2(100) NOT NULL, /* 게시글제목 */
	board_cont VARCHAR2(1000), /* 게시글내용 */
	board_img VARCHAR2(150) NOT NULL, /* 게시글이미지 */
	board_view NUMBER DEFAULT 0 NOT NULL, /* 조회수 */
	board_like NUMBER DEFAULT 0 NOT NULL, /* 좋아요 */
	board_date DATE DEFAULT sysdate NOT NULL, /* 게시글작성일시 */
	board_alti NUMBER NOT NULL, /* 위도 */
	board_long NUMBER NOT NULL, /* 경도 */
	board_max NUMBER, /* 투어최대인원수 */
	board_rec VARCHAR2(150) DEFAULT null, /* 추천여부 */
	member_email VARCHAR2(50) /* 이메일 */
);

CREATE UNIQUE INDEX PK_board
	ON board (
		board_no ASC
	);

ALTER TABLE board
	ADD
		CONSTRAINT PK_board
		PRIMARY KEY (
			board_no
		);

/* 댓글 */
CREATE TABLE reply (
	reply_no NUMBER NOT NULL, /* 댓글번호 */
	reply_cont VARCHAR2(300) NOT NULL, /* 댓글내용 */
	reply_date DATE DEFAULT sysdate NOT NULL, /* 댓글작성일시 */
	reply_upno NUMBER, /* 상위댓글번호 */
	reply_star NUMBER NOT NULL, /* 평점 */
	board_no NUMBER NOT NULL, /* 게시글번호 */
	member_email VARCHAR2(50) /* 댓글작성자 */
);

CREATE UNIQUE INDEX PK_reply
	ON reply (
		reply_no ASC
	);

ALTER TABLE reply
	ADD
		CONSTRAINT PK_reply
		PRIMARY KEY (
			reply_no
		);

/* 투어 */
CREATE TABLE tour (
	tour_no NUMBER NOT NULL, /* 투어번호 */
	tour_title VARCHAR2(100) NOT NULL, /* 투어명 */
	tour_sdate DATE NOT NULL, /* 투어시작일시 */
	tour_edate DATE NOT NULL, /* 투어종료일시 */
	tour_pay NUMBER NOT NULL, /* 투어금액 */
	tour_cont VARCHAR2(500) NOT NULL, /* 투어내용 */
	tour_img VARCHAR2(150) NOT NULL, /* 투어이미지 */
	board_no NUMBER NOT NULL /* 게시글번호 */
);

CREATE UNIQUE INDEX PK_tour
	ON tour (
		tour_no ASC
	);

ALTER TABLE tour
	ADD
		CONSTRAINT PK_tour
		PRIMARY KEY (
			tour_no
		);

/* 결제내역 */
CREATE TABLE pay (
	pay_no NUMBER NOT NULL, /* 결제번호 */
	pay_pay NUMBER NOT NULL, /* 결제금액 */
	pay_num NUMBER NOT NULL, /* 결제인원 */
	pay_pdate DATE NOT NULL, /* 결제승인일시 */
	pay_cdate DATE, /* 결제취소일시 */
	pay_state VARCHAR2(20) NOT NULL, /* 결제상태 */
	pay_way VARCHAR2(20) NOT NULL, /* 결제수단 */
	board_no NUMBER NOT NULL, /* 게시글번호 */
	member_email VARCHAR2(50) /* 신청회원 */
);

CREATE UNIQUE INDEX PK_pay
	ON pay (
		pay_no ASC
	);

ALTER TABLE pay
	ADD
		CONSTRAINT PK_pay
		PRIMARY KEY (
			pay_no
		);

/* 채팅 */
CREATE TABLE chat (
	chat_no NUMBER NOT NULL, /* 채팅번호 */
	chat_cont VARCHAR2(300) NOT NULL, /* 채팅내용 */
	chat_date DATE NOT NULL, /* 채팅생성시간 */
	chat_check VARCHAR2(20) NOT NULL, /* 확인여부 */
	member_email_sender1 VARCHAR2(50), /* 보낸회원 */
	member_email_receiver1 VARCHAR2(50) /* 받는회원 */
);

CREATE UNIQUE INDEX PK_chat
	ON chat (
		chat_no ASC
	);

ALTER TABLE chat
	ADD
		CONSTRAINT PK_chat
		PRIMARY KEY (
			chat_no
		);

/* 구독 */
select * from sub;
drop table sub;
CREATE TABLE sub (
	--member_email_sub1 VARCHAR2(50) NOT NULL, /* 구독자ID */
	--member_email_guide1 VARCHAR2(50) NOT NULL, /* 가이드ID */
	--sub number default 0 null, /*구독자 수*/
	followers number default 0 null /*구독자 수*/
	--sub_date DATE DEFAULT sysdate NOT NULL /* 구독신청일시 */
);

CREATE UNIQUE INDEX PK_sub
	ON sub (
		member_email_sub1 ASC,
		member_email_guide1 ASC
	);

ALTER TABLE sub
	ADD
		CONSTRAINT PK_sub
		PRIMARY KEY (
			member_email_sub1,
			member_email_guide1
		);

/* 활동이력 */
CREATE TABLE acthis (
	member_email VARCHAR2(50) NOT NULL, /* 이메일 */
	acthis_date DATE NOT NULL, /* 경험치변동일시 */
	acthis_point NUMBER NOT NULL, /* 경험치 */
	acthis_act VARCHAR2(20) NOT NULL /* 활동내용 */
);

CREATE UNIQUE INDEX PK_acthis
	ON acthis (
		member_email ASC
	);

ALTER TABLE acthis
	ADD
		CONSTRAINT PK_acthis
		PRIMARY KEY (
			member_email
		);

/* 회원등급이력 */
CREATE TABLE levelhis (
	member_email VARCHAR2(50) NOT NULL, /* 이메일 */
	levelhis_date DATE NOT NULL, /* 부여년도 */
	levelhis_level NUMBER NOT NULL /* 회원레벨 */
);

CREATE UNIQUE INDEX PK_levelhis
	ON levelhis (
		member_email ASC
	);

ALTER TABLE levelhis
	ADD
		CONSTRAINT PK_levelhis
		PRIMARY KEY (
			member_email
		);

/* 회원등급 */
CREATE TABLE level (
	level_level NUMBER NOT NULL, /* 회원레벨 */
	level_name VARCHAR2(20) NOT NULL, /* 레벨명 */
	level_point NUMBER NOT NULL, /* 누적경험치 */
	level_like NUMBER NOT NULL, /* 좋아요기준 */
	level_board NUMBER NOT NULL /* 게시글 수 */
);

CREATE UNIQUE INDEX PK_level
	ON level (
		level_level ASC
	);

ALTER TABLE level
	ADD
		CONSTRAINT PK_level
		PRIMARY KEY (
			level_level
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_member_TO_board
		FOREIGN KEY (
			member_email
		)
		REFERENCES member (
			member_email
		);

ALTER TABLE reply
	ADD
		CONSTRAINT FK_member_TO_reply
		FOREIGN KEY (
			member_email
		)
		REFERENCES member (
			member_email
		);

ALTER TABLE reply
	ADD
		CONSTRAINT FK_board_TO_reply
		FOREIGN KEY (
			board_no
		)
		REFERENCES board (
			board_no
		);

ALTER TABLE tour
	ADD
		CONSTRAINT FK_board_TO_tour
		FOREIGN KEY (
			board_no
		)
		REFERENCES board (
			board_no
		);

ALTER TABLE pay
	ADD
		CONSTRAINT FK_member_TO_pay
		FOREIGN KEY (
			member_email
		)
		REFERENCES member (
			member_email
		);

ALTER TABLE pay
	ADD
		CONSTRAINT FK_board_TO_pay
		FOREIGN KEY (
			board_no
		)
		REFERENCES board (
			board_no
		);

ALTER TABLE chat
	ADD
		CONSTRAINT FK_member_TO_chat
		FOREIGN KEY (
			member_email_sender1
		)
		REFERENCES member (
			member_email
		);

ALTER TABLE chat
	ADD
		CONSTRAINT FK_member_TO_chat2
		FOREIGN KEY (
			member_email_receiver1
		)
		REFERENCES member (
			member_email
		);

ALTER TABLE sub
	ADD
		CONSTRAINT FK_member_TO_sub
		FOREIGN KEY (
			member_id_sub1
		)
		REFERENCES member (
			member_email
		);

ALTER TABLE sub
	ADD
		CONSTRAINT FK_member_TO_sub2
		FOREIGN KEY (
			member_id_guide1
		)
		REFERENCES member (
			member_email
		);

ALTER TABLE acthis
	ADD
		CONSTRAINT FK_member_TO_acthis
		FOREIGN KEY (
			member_email
		)
		REFERENCES member (
			member_email
		);

ALTER TABLE levelhis
	ADD
		CONSTRAINT FK_level_TO_levelhis
		FOREIGN KEY (
			levelhis_level
		)
		REFERENCES level (
			level_level
		);

ALTER TABLE levelhis
	ADD
		CONSTRAINT FK_member_TO_levelhis2
		FOREIGN KEY (
			member_email
		)
		REFERENCES member (
			member_email
		);