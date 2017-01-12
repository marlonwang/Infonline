----------------------------
--info distribute square
--marlonwang@163.com
----------------------------

----step1  create database
use master 
go
if exists(select * from sysdatabases where name='info') --sys.databases
drop database info
go

create database info
on primary(	
	name='info',
	filename='d:\info\data\info_data.mdf',
	size=5MB,
	maxsize=unlimited, 
	filegrowth=5%
 )
 log on
 (
	name='info_log',
	filename='d:\info\data\info_log.ldf',
	size=5MB,
	maxsize=unlimited,
	filegrowth=4MB
 )
go  

--step2 create table b_user
use info
go
create table b_user
(
	u_id int not null primary key identity(1,1),
	u_name nvarchar(20),
	u_password nvarchar(20),
	u_date datetime default (getdate()),
	u_admin nchar(1) default (0),		--1  admin
	constraint u_admin check(u_admin in (0,1)),
	--constraint PK_USERNAME foreign key (u_name) references b_book(b_pusher),
	--constraint PK_USERNAME foreign key (u_name) references b_help(h_pusher),
	--constraint PK_USERNAME foreign key (u_name) references b_machine(m_pusher),
	--constraint PK_USERNAME foreign key (u_name) references b_service(s_pusher)
)
go

--step2 create table b_info
use info
go
create table b_book
(
	b_id int not null primary key identity(1,1),
	b_pusher nvarchar(20),
	b_name nvarchar(50),
	b_describe varchar(200),
        --b_pirod int,
	b_postime datetime default (getdate())
)
go

--step3 create table b_help
use info
go
create table b_help
(
	h_id int not null primary key identity(1,1),
	h_title nvarchar(50),
	h_pusher nvarchar(20),
	h_text varchar(200),
	h_postime datetime default (getdate())
)
go

--step4 create table b_machine
use info
go
create table b_machine
(
	m_id int not null primary key identity(1,1),
	m_title nvarchar(50),
	m_text varchar(200),
	m_pusher nvarchar(20),
	m_postime datetime default (getdate())
)
go

--step5 create table b_service
use info
go
create table b_service
(
	s_id int not null primary key identity(1,1),
	s_kind nvarchar(50),
	s_text nvarchar(200),
	s_pusher nvarchar(20),
	s_postime datetime default (getdate())
)
go

-------------------------------------------
----修改 各表描述类型大小
-------------------------------------------
use info
go
alter table b_book 
--ALTER COLUMN b_describe nvarchar(200)
alter column b_name nvarchar(50)
go

alter table b_help
alter column h_text nvarchar(200)
go

alter table b_machine 
alter column m_text nvarchar(200)
go

alter table b_service 
alter column s_text nvarchar(200)
go

use info
go
alter table b_book
drop column b_pirod
go

-----------------------------------
--添加user
use info
go
insert into b_user values ('way','123456',default,1)
go

--添加machine
use info
go
insert into b_machine values ('电脑出售','型号ASUS A450 $600 ','dema',default)
insert into b_machine values ('笔记本赠送','7成新 Acer 找有缘人','dema',default)
go

--添加help
use info
go 
insert into b_help values('考研租房','way','寻找考研房子，东校区',default)
go

--添加service
use info
go
insert into b_service values('找家教','高中毕业生，英语','way',default)
go

use info
go
delete from b_service where s_kind='风中劲草' 
select * from b_book
go