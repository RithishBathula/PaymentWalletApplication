create database wallet;

use wallet;

create table Customer(customerName varchar(30) not null,aadharNum bigint primary key,username varchar(10) unique,password varchar(8),gender varchar(8),age int,contact bigint,email varchar(30));


create table WalletApplication(accNum bigint,aod Date,balance double,branch varchar(20),accType varchar(20),aadharNo bigint,foreign key(aadharNo)references customer(aadharNum));

create table transactions(aadharNum bigint,trans_info blob);