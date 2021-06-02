create table Customer
(
  id integer not null,
  username  varchar(255),
  password varchar(255),
  Phone varchar2(10),
  Address varchar(255),
  created timestamp,
  primary key(id)
);