create table board (
bno int primary key,
title varchar2(100),
content varchar2(1000),
visited int,
resdate date);
create sequence board_seq increment by 1 start with 3 nocache;

insert into board values(board_seq.nextval, '샘플제목1', '샘플글 1 입니다.', 0,'2022-08-12');
insert into board values(board_seq.nextval, '샘플제목2', '샘플글 2 입니다.',0, sysdate);
insert into board values(board_seq.nextval, '샘플제목3', '샘플글 3 입니다.',0, sysdate);
select * from user1;
select * from board;
commit;