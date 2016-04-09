create table userRegistration{
	studentId varchar2(20)primary key;
	emailId varchar2(20);
	name varchar2(50);
	phoneNumber integer;
	password varchar2(50);
	
};

create table bookRegistration{
	bookNumber varchar2(20)primary key;
	bookName varchar2(20);
	author varchar2(50);
	subject varchar2(50);
	bookType char(1);
	eBook BLOB;
	
};

commit;