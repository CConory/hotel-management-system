/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/12/21 16:35:12                          */
/*==============================================================*/


drop trigger Trigger_1;

drop procedure if exists Procedure_1;

drop procedure if exists Procedure_2;

drop table if exists Bill;

drop table if exists Book;

drop table if exists Client;

drop table if exists Department;

drop table if exists Description;

drop table if exists Employee;

drop table if exists Live;

drop table if exists Room;

/*==============================================================*/
/* Table: Bill                                                  */
/*==============================================================*/
create table Bill
(
   BillNo               int not null,
   EmployeeNo           int not null,
   ClientNo             int not null,
   RoomCost             int not null,
   OtherCost            int not null,
   primary key (BillNo)
);

/*==============================================================*/
/* Table: Book                                                  */
/*==============================================================*/
create table Book
(
   BookNo               int not null,
   ClientNo             int,
   CheckInDate          date not null,
   CheckOutDate         date not null,
   PayStatus            varchar(5) not null,
   Pay                  int not null,
   Remark               varchar(20) not null,
   primary key (BookNo)
);

/*==============================================================*/
/* Table: Client                                                */
/*==============================================================*/
create table Client
(
   ClientNo             int not null,
   ClientName           varchar(20) not null,
   Sex                  varchar(5) not null,
   Birth                date not null,
   ID                   varchar(20) not null,
   Tel                  varchar(20) not null,
   Remark               varchar(20),
   primary key (ClientNo)
);

/*==============================================================*/
/* Table: Department                                            */
/*==============================================================*/
create table Department
(
   DeptNo               int not null,
   DeptName             varchar(20) not null,
   Tel                  varchar(20) not null,
   Loc                  varchar(50) not null,
   ManagerNo            int not null,
   primary key (DeptNo)
);

/*==============================================================*/
/* Table: Description                                           */
/*==============================================================*/
create table Description
(
   TypeNo               int not null,
   TypeName             varchar(20) not null,
   Price                int not null,
   Gross                int not null,
   Surplus              int not null,
   primary key (TypeNo)
);

/*==============================================================*/
/* Table: Employee                                              */
/*==============================================================*/
create table Employee
(
   EmployeeNo           int not null,
   DeptNo               int not null,
   EmployeeName         varchar(20) not null,
   ID                   varchar(20) not null,
   Sex                  varchar(5) not null,
   Birth                date not null,
   Tel                  varchar(20) not null,
   Loc                  varchar(50) not null,
   Job                  varchar(10) not null,
   EmployeeDate         date not null,
   Sal                  int not null,
   Remark               varchar(20),
   PassWord             varchar(20) not null,
   primary key (EmployeeNo)
);

/*==============================================================*/
/* Table: Live                                                  */
/*==============================================================*/
create table Live
(
   RoomNo               int not null,
   ClientNo             int not null,
   primary key (RoomNo, ClientNo)
);

/*==============================================================*/
/* Table: Room                                                  */
/*==============================================================*/
create table Room
(
   RoomNo               int not null,
   TypeNo               int not null,
   BookNo               int,
   Status               varchar(5) not null,
   primary key (RoomNo)
);

alter table Bill add constraint FK_ClientBIll foreign key (ClientNo)
      references Client (ClientNo) on delete restrict on update restrict;

alter table Bill add constraint FK_EmployeeBil foreign key (EmployeeNo)
      references Employee (EmployeeNo) on delete restrict on update restrict;

alter table Book add constraint FK_ClientBook foreign key (ClientNo)
      references Client (ClientNo) on delete restrict on update restrict;

alter table Employee add constraint FK_EmpDepart foreign key (DeptNo)
      references Department (DeptNo) on delete restrict on update restrict;

alter table Live add constraint FK_Live foreign key (RoomNo)
      references Room (RoomNo) on delete restrict on update restrict;

alter table Live add constraint FK_Live2 foreign key (ClientNo)
      references Client (ClientNo) on delete restrict on update restrict;

alter table Room add constraint FK_RoomBook foreign key (BookNo)
      references Book (BookNo) on delete restrict on update restrict;

alter table Room add constraint FK_RoomDescr foreign key (TypeNo)
      references Description (TypeNo) on delete restrict on update restrict;


create procedure Procedure_1 
(IN p1 int ,in p2 int,in p3 int,in p4 int ,in p5 int)
insert into Bill values(p1,p2,p3,p4,p5);


create procedure Procedure_2 
(IN p1 int ,in p2 int,in p3 int,in p4 varchar(5))
insert into Room values(p1,p2,p3,p4);


create trigger Trigger_1 after insert
on Employee for each row
begin
end;

