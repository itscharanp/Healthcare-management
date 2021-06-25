CREATE DATABASE  IF NOT EXISTS `Hospital`;
USE `Hospital`;


CREATE TABLE `Doctor` (
  `did` int not null,
   `availability` int default 1,
  `dname` varchar(45) DEFAULT NULL unique,
  `emailid` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `specialization` varchar(45) DEFAULT NULL,
  `slot` varchar(45) default NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `patient` (
  `pid` int not null auto_increment,
  `pname` varchar(45),
  `emailid` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `symptoms` varchar(45) DEFAULT NULL,
  `slot1` int default NULL,
  `slot2` int  default NULL,
  `age` int not null,
  `prescription` text default null,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into doctor values(2,1,'charand','abcd@gmail.com','852299ch','cardiac','A2');
insert into patient values(1,'varshith','abffcd@gmail.com','8d52299ch','cardiac pain',0,'0',8,'Paracetomal HCQ');
insert into patient values(3,'varshith','abffcd@gmaisl.com','8d52299ch','cardiac pain',0,'0',8,'Paracetomal HCQ');
insert into doctor values(4,1,'cdharand','abcd@dsdgmail.com','df852299ch','cardiac','A1');