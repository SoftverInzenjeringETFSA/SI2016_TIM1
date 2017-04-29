CREATE DATABASE IF NOT EXISTS `tim1`;
create user 'EtfSI2016'@'localhost' identified by '2016SIEtf';
grant all privileges on tim1.* to 'EtfSI2016'@'localhost' identified by '2016SIEtf';