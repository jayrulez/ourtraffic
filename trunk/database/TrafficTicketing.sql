create table police_officer
{
	badge_num int not null,
	first_name varchar(50),
	middle_initial varchar(1),
	last_name varchar(50),
	dob datetime,
	address1 varchar(100),
	address2 varchar(100),
	constraint pk_police_officer foreign key(badge_num)
}
go;

create table police_division
{
	station_num int not null,
	station_address1 varchar(100),
	station_address2 varchar(100),
	station_tel varchar(14),
    constraint pk_police_division foreign key(station_num)
}
go;

create table offender
{
	trn_num varchar(11) not null,
	first_name varchar(50),
	middle_initial varchar(1),
	last_name varchar(50),
	dob datetime,
	address1 varchar(100),
	address2 varchar(100),
	license_type varchar(),
	points int,
	expiry_date datetime,
	constraint pk_offender primary key (trn_num)
}
go;

create table offenses
{
	offense_code int not null identity(101,1),
	offense_name varchar(50) not null,
	constraint pk_offenses primary key (offense_code)
}
go;

create table tickets
{
	ticket_num big int not null identity(1000001,1),
	offense_code int not null,
	offense_date datetime,
	offense_place varchar(100),
	description varchar(150),
	fine float,
	points int,
	payment_status int,
	constraint pk_tickets primary key (ticket_num),
	constraint fk_tickets_offense_code foreign key (offense_code) references offenses(offense_code) on delete do nothing on update cascade 
}
go;