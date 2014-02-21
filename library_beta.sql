# SQL Manager 2010 Lite for MySQL 4.6.0.5
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : library_beta


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `library_beta`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `library_beta`;

#
# Structure for the `administrator_master` table : 
#

CREATE TABLE `administrator_master` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(30) NOT NULL,
  `admin_pass` varchar(20) NOT NULL,
  `admin_email` varchar(32) NOT NULL,
  `sec_ques` varchar(50) DEFAULT NULL,
  `sec_ans` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

#
# Structure for the `announcement` table : 
#

CREATE TABLE `announcement` (
  `ann_id` int(11) NOT NULL AUTO_INCREMENT,
  `announcement` varchar(100) NOT NULL,
  `ann_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ann_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Structure for the `author_master` table : 
#

CREATE TABLE `author_master` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(100) NOT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

#
# Structure for the `availability_flag_master` table : 
#

CREATE TABLE `availability_flag_master` (
  `flag_id` int(11) NOT NULL AUTO_INCREMENT,
  `flag` varchar(20) NOT NULL,
  PRIMARY KEY (`flag_id`),
  UNIQUE KEY `flag` (`flag`),
  UNIQUE KEY `flag_id` (`flag_id`),
  UNIQUE KEY `flag_2` (`flag`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Structure for the `branch_master` table : 
#

CREATE TABLE `branch_master` (
  `br_id` int(11) NOT NULL AUTO_INCREMENT,
  `br_name` varchar(50) NOT NULL,
  PRIMARY KEY (`br_id`),
  UNIQUE KEY `br_name` (`br_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

#
# Structure for the `publication_master` table : 
#

CREATE TABLE `publication_master` (
  `pub_id` int(11) NOT NULL AUTO_INCREMENT,
  `pub_name` varchar(50) NOT NULL,
  PRIMARY KEY (`pub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

#
# Structure for the `book_master` table : 
#

CREATE TABLE `book_master` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(50) NOT NULL,
  `book_author_id1` int(11) NOT NULL,
  `book_pub_id` int(11) NOT NULL,
  `book_price` int(11) DEFAULT NULL,
  `book_edition` int(11) DEFAULT NULL,
  `book_br_id` int(11) NOT NULL,
  `book_author_id2` int(11) NOT NULL,
  `book_author_id3` int(11) NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book_master_fk1` (`book_author_id1`),
  KEY `book_master_fk` (`book_author_id2`),
  KEY `book_master_fk2` (`book_author_id3`),
  KEY `book_master_fk3` (`book_pub_id`),
  KEY `book_master_fk4` (`book_br_id`),
  CONSTRAINT `book_master_fk` FOREIGN KEY (`book_author_id2`) REFERENCES `author_master` (`author_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_master_fk1` FOREIGN KEY (`book_author_id1`) REFERENCES `author_master` (`author_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_master_fk2` FOREIGN KEY (`book_author_id3`) REFERENCES `author_master` (`author_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_master_fk3` FOREIGN KEY (`book_pub_id`) REFERENCES `publication_master` (`pub_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_master_fk4` FOREIGN KEY (`book_br_id`) REFERENCES `branch_master` (`br_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

#
# Structure for the `book_individual` table : 
#

CREATE TABLE `book_individual` (
  `book_id` int(11) NOT NULL,
  `book_acc_no` varchar(20) NOT NULL,
  `rack_no` varchar(20) DEFAULT NULL,
  `avail_flag_id` int(11) NOT NULL,
  `holder_id` varchar(20) NOT NULL DEFAULT 'N',
  `holder_type` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`book_acc_no`),
  UNIQUE KEY `book_acc_no` (`book_acc_no`),
  KEY `book_individual_fk` (`book_id`),
  KEY `avail_flag_id` (`avail_flag_id`),
  CONSTRAINT `book_individual_fk` FOREIGN KEY (`book_id`) REFERENCES `book_master` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_individual_fk1` FOREIGN KEY (`avail_flag_id`) REFERENCES `availability_flag_master` (`flag_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `clerk_master` table : 
#

CREATE TABLE `clerk_master` (
  `clr_id` int(11) NOT NULL AUTO_INCREMENT,
  `clr_name` varchar(30) NOT NULL,
  `clr_join_yr` int(11) NOT NULL,
  `clr_email` varchar(100) NOT NULL,
  `clr_pass` varchar(100) NOT NULL,
  `sec_ques` varchar(50) DEFAULT NULL,
  `sec_ans` varchar(50) DEFAULT NULL,
  `clr_valid` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`clr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Structure for the `faculty_master` table : 
#

CREATE TABLE `faculty_master` (
  `fac_id` int(11) NOT NULL AUTO_INCREMENT,
  `fac_name` varchar(30) NOT NULL,
  `fac_password` varchar(20) NOT NULL,
  `fac_br_id` int(11) NOT NULL,
  `fac_designation` varchar(20) DEFAULT NULL,
  `fac_email` varchar(50) NOT NULL,
  `sec_ques` varchar(50) DEFAULT NULL,
  `sec_ans` varchar(50) DEFAULT NULL,
  `fac_valid` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`fac_id`),
  KEY `faculty_master_fk` (`fac_br_id`),
  CONSTRAINT `faculty_master_fk` FOREIGN KEY (`fac_br_id`) REFERENCES `branch_master` (`br_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Structure for the `research_sc_master` table : 
#

CREATE TABLE `research_sc_master` (
  `re_sc_id` int(11) NOT NULL AUTO_INCREMENT,
  `re_sc_password` varchar(20) NOT NULL,
  `re_sc_name` varchar(20) NOT NULL,
  `re_feild` varchar(20) NOT NULL,
  `re_sc_email` int(11) DEFAULT NULL,
  `re_sc_pass_yr` int(11) NOT NULL,
  PRIMARY KEY (`re_sc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `std_book_issued` table : 
#

CREATE TABLE `std_book_issued` (
  `std_id` int(11) NOT NULL,
  `book1_acc_no` varchar(20) DEFAULT 'null',
  `book2_acc_no` varchar(20) DEFAULT 'null',
  `book3_acc_no` varchar(20) DEFAULT 'null',
  `book4_acc_no` varchar(20) DEFAULT 'null',
  `book5_acc_no` varchar(20) DEFAULT 'null',
  PRIMARY KEY (`std_id`),
  UNIQUE KEY `book5_acc_no` (`book5_acc_no`),
  UNIQUE KEY `book5_acc_no_2` (`book5_acc_no`),
  UNIQUE KEY `book5_acc_no_3` (`book5_acc_no`),
  UNIQUE KEY `book4_acc_no` (`book4_acc_no`),
  UNIQUE KEY `book4_acc_no_2` (`book4_acc_no`),
  UNIQUE KEY `book3_acc_no` (`book3_acc_no`),
  UNIQUE KEY `book3_acc_no_2` (`book3_acc_no`),
  UNIQUE KEY `book2_acc_no` (`book2_acc_no`),
  UNIQUE KEY `book2_acc_no_2` (`book2_acc_no`),
  UNIQUE KEY `book1_acc_no` (`book1_acc_no`),
  UNIQUE KEY `book1_acc_no_3` (`book1_acc_no`),
  UNIQUE KEY `book1_acc_no_4` (`book1_acc_no`),
  UNIQUE KEY `book1_acc_no_5` (`book1_acc_no`),
  UNIQUE KEY `book1_acc_no_6` (`book1_acc_no`),
  UNIQUE KEY `book2_acc_no_3` (`book2_acc_no`),
  UNIQUE KEY `book3_acc_no_3` (`book3_acc_no`),
  UNIQUE KEY `book4_acc_no_3` (`book4_acc_no`),
  UNIQUE KEY `book5_acc_no_4` (`book5_acc_no`),
  KEY `book1_acc_no_2` (`book1_acc_no`,`book2_acc_no`,`book3_acc_no`,`book4_acc_no`,`book5_acc_no`),
  CONSTRAINT `std_book_issued_fk` FOREIGN KEY (`book1_acc_no`) REFERENCES `book_individual` (`book_acc_no`) ON UPDATE CASCADE,
  CONSTRAINT `std_book_issued_fk1` FOREIGN KEY (`book2_acc_no`) REFERENCES `book_individual` (`book_acc_no`) ON UPDATE CASCADE,
  CONSTRAINT `std_book_issued_fk2` FOREIGN KEY (`book3_acc_no`) REFERENCES `book_individual` (`book_acc_no`) ON UPDATE CASCADE,
  CONSTRAINT `std_book_issued_fk3` FOREIGN KEY (`book4_acc_no`) REFERENCES `book_individual` (`book_acc_no`) ON UPDATE CASCADE,
  CONSTRAINT `std_book_issued_fk4` FOREIGN KEY (`book5_acc_no`) REFERENCES `book_individual` (`book_acc_no`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `student_master` table : 
#

CREATE TABLE `student_master` (
  `st_id` int(11) NOT NULL AUTO_INCREMENT,
  `st_roll` varchar(20) NOT NULL,
  `st_name` varchar(50) NOT NULL,
  `st_branch_id` int(11) NOT NULL,
  `st_password` varchar(20) NOT NULL,
  `st_email` varchar(50) DEFAULT NULL,
  `st_pass_yr` int(4) NOT NULL,
  `sec_ques` varchar(50) DEFAULT NULL,
  `sec_ans` varchar(50) DEFAULT NULL,
  `st_valid` varchar(1) NOT NULL DEFAULT 'N',
  `st_cat` varchar(1) NOT NULL DEFAULT 'G',
  PRIMARY KEY (`st_id`),
  UNIQUE KEY `st_roll` (`st_roll`),
  UNIQUE KEY `st_roll_2` (`st_roll`),
  KEY `student_master_fk` (`st_branch_id`),
  CONSTRAINT `student_master_fk` FOREIGN KEY (`st_branch_id`) REFERENCES `branch_master` (`br_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Data for the `administrator_master` table  (LIMIT 0,500)
#

INSERT INTO `administrator_master` (`admin_id`, `admin_name`, `admin_pass`, `admin_email`, `sec_ques`, `sec_ans`) VALUES 
  (1,'ritika','123','qwert@gmail.com','what is your day','sunday'),
  (2,'RITIKA SAHAY','QWERTY','RITIKA.SAHAYY@GMAIL.COM','q','q'),
  (3,'admin1','qwerty','admin@nita.com','q','q'),
  (4,'Shobhraj','shobhraj123','sshakdupia@gmail.com','q','qq'),
  (5,'newone','ritika','newone@nita.com','q','qqq'),
  (6,'ajay','ritika','ritika@nita.com','what is you name??','ajay'),
  (7,'bhaskey','root','bhaskey@discipulo.com','my puppy','ritika'),
  (8,'a','asdfghjkl','qxqxq','qrqre','qxqsx'),
  (9,'a','asdfghjkl','qxqxq','qrqre','qxqsx');
COMMIT;

#
# Data for the `announcement` table  (LIMIT 0,500)
#

INSERT INTO `announcement` (`ann_id`, `announcement`, `ann_by`) VALUES 
  (1,'Currently the Library Management System is running in Beta version, it''s going to be Fully functione','admin1'),
  (2,'Today Library will be closed at 6PM.','admin1'),
  (3,'Library is going to fully WiFi. :)','admin1'),
  (4,'Issue schedule for CSE is changed to Friday.','admin1');
COMMIT;

#
# Data for the `author_master` table  (LIMIT 0,500)
#

INSERT INTO `author_master` (`author_id`, `author_name`) VALUES 
  (0,'None');
UPDATE `author_master` SET `author_id`=0 WHERE `author_id`=LAST_INSERT_ID();
INSERT INTO `author_master` (`author_id`, `author_name`) VALUES 
  (1,'Herbert Shield'),
  (2,'Galvin'),
  (3,'Astrachan'),
  (4,'Balagurusami'),
  (5,'Stallings'),
  (6,'Hearn'),
  (7,'Baker'),
  (8,'John Clark'),
  (9,'Mical Smith'),
  (10,'Johnson Mett'),
  (11,'R S Khurmi'),
  (12,'Silberschatz'),
  (13,'galvin'),
  (14,'Gagne'),
  (15,'Santosh Gupta'),
  (16,'A Gosh'),
  (17,'A K Mallik'),
  (18,'Anish Mishra');
COMMIT;

#
# Data for the `availability_flag_master` table  (LIMIT 0,500)
#

INSERT INTO `availability_flag_master` (`flag_id`, `flag`) VALUES 
  (1,'AVAILABLE'),
  (2,'UNAVAILABLE'),
  (3,'RESERVED');
COMMIT;

#
# Data for the `publication_master` table  (LIMIT 0,500)
#

INSERT INTO `publication_master` (`pub_id`, `pub_name`) VALUES 
  (1,'PHI'),
  (2,'TMH'),
  (3,'Wiley'),
  (4,'arihant'),
  (5,'IBM Publication'),
  (6,'S Chand'),
  (7,'TTH'),
  (8,'Mishra');
COMMIT;

#
# Data for the `branch_master` table  (LIMIT 0,500)
#

INSERT INTO `branch_master` (`br_id`, `br_name`) VALUES 
  (2,'Civil Engineering'),
  (3,'Electrical Engineering'),
  (4,'Mechanical Engg'),
  (5,'Production Engg'),
  (6,'Electronics & Comm Engg'),
  (7,'Electronics and Instrumentation Engg'),
  (9,'CSE');
COMMIT;

#
# Data for the `book_master` table  (LIMIT 0,500)
#

INSERT INTO `book_master` (`book_id`, `book_title`, `book_author_id1`, `book_pub_id`, `book_price`, `book_edition`, `book_br_id`, `book_author_id2`, `book_author_id3`) VALUES 
  (4,'Thermal Engineering',4,3,200,NULL,4,0,0),
  (6,'Manufacturing Science',16,3,150,NULL,4,17,0),
  (8,'Algorithms',5,4,400,3,9,12,0),
  (9,'Dynamic of Machine',11,6,500,4,4,15,0);
COMMIT;

#
# Data for the `book_individual` table  (LIMIT 0,500)
#

INSERT INTO `book_individual` (`book_id`, `book_acc_no`, `rack_no`, `avail_flag_id`, `holder_id`, `holder_type`) VALUES 
  (8,'CSE100','CSEA',2,'123456','S'),
  (8,'CSE101','CSEA',1,'N','N'),
  (8,'CSE102','CSEA',1,'N','N'),
  (8,'CSE104','CSEA',1,'N','N'),
  (8,'CSE105','CSEA',1,'N','N'),
  (8,'CSE106','CSEA',2,'faculty1','F'),
  (8,'CSE107','CSEA',1,'N','N'),
  (8,'CSE108','CSEA',3,'faculty1','F'),
  (8,'CSE109','CSEA',1,'N','N'),
  (8,'CSE111','CSEA',2,'N','N'),
  (8,'CSE112','CSEA',2,'123456','S'),
  (8,'CSE113','CSEA',1,'N','N'),
  (8,'CSE114','CSEA',1,'N','N'),
  (8,'CSE115','CSEA',1,'N','N'),
  (8,'CSE116','CSEA',1,'N','N'),
  (8,'CSE117','CSEA',1,'N','N'),
  (8,'CSE118','CSEA',1,'N','N'),
  (8,'CSE119','CSEA',1,'N','N'),
  (8,'CSE120','CSEA',1,'N','N'),
  (8,'CSE121','CSEA',1,'N','N'),
  (8,'CSE122','CSEA',1,'N','N'),
  (8,'CSE123','CSEA',1,'N','N'),
  (8,'CSE124','CSEA',1,'N','N'),
  (8,'CSE125','CSEA',1,'N','N'),
  (8,'CSE126','CSEA',1,'N','N'),
  (8,'CSE127','CSEA',1,'N','N'),
  (8,'CSE128','CSEA',1,'N','N'),
  (8,'CSE129','CSEA',1,'N','N'),
  (6,'me1','meb',1,'N','N'),
  (6,'me10','meb',1,'N','N'),
  (6,'me11','meb',1,'N','N'),
  (6,'me2','meb',1,'N','N'),
  (4,'ME201','MEC',2,'810425','S'),
  (4,'ME202','MEC',2,'810201','S'),
  (4,'ME203','MEC',2,'810204','S'),
  (6,'me3','meb',1,'N','N'),
  (6,'me4','meb',1,'N','N'),
  (6,'ME400','MEA',1,'N','N'),
  (6,'ME401','MEA',1,'N','N'),
  (6,'ME402','MEA',1,'N','N'),
  (6,'ME403','MEA',1,'N','N'),
  (6,'ME404','MEA',1,'N','N'),
  (6,'ME405','MEA',1,'N','N'),
  (6,'ME406','MEA',1,'N','N'),
  (6,'ME407','MEA',1,'N','N'),
  (6,'ME408','MEA',1,'N','N'),
  (6,'ME409','MEA',1,'N','N'),
  (6,'ME410','MEA',1,'N','N'),
  (6,'ME411','MEA',1,'N','N'),
  (6,'ME412','MEA',1,'N','N'),
  (6,'ME413','MEA',1,'N','N'),
  (6,'ME414','MEA',1,'N','N'),
  (6,'ME415','MEA',1,'N','N'),
  (6,'ME416','MEA',1,'N','N'),
  (6,'ME417','MEA',1,'N','N'),
  (6,'ME418','MEA',1,'N','N'),
  (6,'ME419','MEA',1,'N','N'),
  (6,'ME420','MEA',1,'N','N'),
  (6,'ME421','MEA',1,'N','N'),
  (6,'ME422','MEA',1,'N','N'),
  (6,'ME423','MEA',1,'N','N'),
  (6,'ME424','MEA',1,'N','N'),
  (6,'ME425','MEA',1,'N','N'),
  (6,'ME426','MEA',1,'N','N'),
  (6,'ME428','MEA',1,'N','N'),
  (6,'ME429','MEA',1,'N','N'),
  (6,'me430','MEA',1,'N','N'),
  (6,'me431','MEA',1,'N','N'),
  (6,'me432','MEA',1,'N','N'),
  (6,'me433','MEA',1,'N','N'),
  (6,'me434','MEA',1,'N','N'),
  (6,'me435','MEA',1,'N','N'),
  (6,'me436','MEA',1,'N','N'),
  (6,'me437','MEA',1,'N','N'),
  (6,'me438','MEA',1,'N','N'),
  (6,'me439','MEA',1,'N','N'),
  (6,'me440','MEa',1,'N','N'),
  (6,'me441','MEa',1,'N','N'),
  (6,'me442','MEa',1,'N','N'),
  (6,'me443','MEa',1,'N','N'),
  (6,'me444','MEa',1,'N','N'),
  (6,'me5','meb',1,'N','N'),
  (9,'ME500','MEA',1,'N','N'),
  (9,'ME501','MEA',1,'N','N'),
  (9,'ME502','MEA',2,'123456','S'),
  (9,'ME503','MEA',1,'N','N'),
  (9,'ME504','MEA',1,'N','N'),
  (9,'ME505','MEA',1,'N','N'),
  (9,'ME506','MEA',1,'N','N'),
  (9,'ME507','MEA',1,'N','N'),
  (9,'ME508','MEA',1,'N','N'),
  (9,'ME509','MEA',1,'N','N'),
  (9,'ME510','MEA',1,'N','N'),
  (9,'ME511','MEA',1,'N','N'),
  (9,'ME512','MEA',1,'N','N'),
  (9,'ME513','MEA',1,'N','N'),
  (9,'ME514','MEA',1,'N','N'),
  (9,'ME515','MEA',1,'N','N'),
  (9,'ME516','MEA',1,'N','N'),
  (9,'ME517','MEA',1,'N','N'),
  (9,'ME518','MEA',1,'N','N'),
  (9,'ME519','MEA',1,'N','N'),
  (9,'ME520','MEA',1,'N','N'),
  (9,'ME521','MEA',1,'N','N'),
  (9,'ME522','MEA',1,'N','N'),
  (9,'ME523','MEA',1,'N','N'),
  (9,'ME524','MEA',1,'N','N'),
  (9,'ME525','MEA',1,'N','N'),
  (9,'ME526','MEA',1,'N','N'),
  (9,'ME527','MEA',1,'N','N'),
  (9,'ME528','MEA',1,'N','N'),
  (9,'ME529','MEA',1,'N','N'),
  (9,'ME530','MEA',1,'N','N'),
  (9,'ME531','MEA',1,'N','N'),
  (9,'ME532','MEA',1,'N','N'),
  (9,'ME533','MEA',1,'N','N'),
  (9,'ME534','MEA',1,'N','N'),
  (9,'ME535','MEA',1,'N','N'),
  (9,'ME536','MEA',1,'N','N'),
  (9,'ME537','MEA',1,'N','N'),
  (9,'ME538','MEA',1,'N','N'),
  (9,'ME539','MEA',1,'N','N'),
  (9,'ME540','MEA',1,'N','N'),
  (9,'ME541','MEA',1,'N','N'),
  (9,'ME542','MEA',1,'N','N'),
  (9,'ME543','MEA',1,'N','N'),
  (9,'ME544','MEA',1,'N','N'),
  (9,'ME545','MEA',1,'N','N'),
  (9,'ME546','MEA',1,'N','N'),
  (9,'ME547','MEA',1,'N','N'),
  (9,'ME548','MEA',1,'N','N'),
  (9,'ME549','MEA',1,'N','N'),
  (9,'ME550','MEA',1,'N','N'),
  (9,'ME551','MEA',1,'N','N'),
  (9,'ME552','MEA',1,'N','N'),
  (9,'ME553','MEA',1,'N','N'),
  (9,'ME554','MEA',1,'N','N'),
  (9,'ME555','MEA',1,'N','N'),
  (9,'ME556','MEA',1,'N','N'),
  (9,'ME557','MEA',1,'N','N'),
  (9,'ME558','MEA',1,'N','N'),
  (9,'ME559','MEA',1,'N','N'),
  (9,'ME560','MEA',1,'N','N'),
  (9,'ME561','MEA',1,'N','N'),
  (9,'ME562','MEA',1,'N','N'),
  (9,'ME563','MEA',1,'N','N'),
  (9,'ME564','MEA',1,'N','N'),
  (9,'ME565','MEA',1,'N','N'),
  (9,'ME566','MEA',1,'N','N'),
  (9,'ME567','MEA',1,'N','N'),
  (9,'ME568','MEA',1,'N','N'),
  (9,'ME569','MEA',1,'N','N'),
  (9,'ME570','MEA',1,'N','N'),
  (9,'ME571','MEA',1,'N','N'),
  (9,'ME572','MEA',1,'N','N'),
  (9,'ME573','MEA',1,'N','N'),
  (9,'ME574','MEA',1,'N','N'),
  (9,'ME575','MEA',1,'N','N'),
  (9,'ME576','MEA',1,'N','N'),
  (9,'ME577','MEA',1,'N','N'),
  (9,'ME578','MEA',1,'N','N'),
  (9,'ME579','MEA',1,'N','N'),
  (9,'ME580','MEA',1,'N','N'),
  (9,'ME581','MEA',1,'N','N'),
  (9,'ME582','MEA',1,'N','N'),
  (9,'ME583','MEA',1,'N','N'),
  (9,'ME584','MEA',1,'N','N'),
  (9,'ME585','MEA',1,'N','N'),
  (9,'ME586','MEA',1,'N','N'),
  (9,'ME587','MEA',1,'N','N'),
  (9,'ME588','MEA',1,'N','N'),
  (9,'ME589','MEA',1,'N','N'),
  (9,'ME590','MEA',1,'N','N'),
  (9,'ME591','MEA',1,'N','N'),
  (9,'ME592','MEA',1,'N','N'),
  (9,'ME593','MEA',1,'N','N'),
  (9,'ME594','MEA',1,'N','N'),
  (9,'ME595','MEA',1,'N','N'),
  (9,'ME596','MEA',1,'N','N'),
  (9,'ME597','MEA',1,'N','N'),
  (9,'ME598','MEA',1,'N','N'),
  (9,'ME599','MEA',1,'N','N'),
  (6,'me6','meb',1,'N','N'),
  (9,'ME600','MEA',1,'N','N'),
  (9,'ME601','MEA',1,'N','N'),
  (9,'ME602','MEA',1,'N','N'),
  (9,'ME603','MEA',1,'N','N'),
  (9,'ME604','MEA',1,'N','N'),
  (9,'ME605','MEA',1,'N','N'),
  (9,'ME606','MEA',1,'N','N'),
  (9,'ME607','MEA',1,'N','N'),
  (9,'ME608','MEA',1,'N','N'),
  (9,'ME609','MEA',1,'N','N'),
  (9,'ME610','MEA',1,'N','N'),
  (9,'ME611','MEA',1,'N','N'),
  (9,'ME612','MEA',1,'N','N'),
  (9,'ME613','MEA',1,'N','N'),
  (9,'ME614','MEA',1,'N','N'),
  (9,'ME615','MEA',1,'N','N'),
  (9,'ME616','MEA',1,'N','N'),
  (9,'ME617','MEA',1,'N','N'),
  (9,'ME618','MEA',1,'N','N'),
  (9,'ME619','MEA',1,'N','N'),
  (9,'ME620','MEA',1,'N','N'),
  (9,'ME621','MEA',1,'N','N'),
  (9,'ME622','MEA',1,'N','N'),
  (9,'ME623','MEA',1,'N','N'),
  (9,'ME624','MEA',1,'N','N'),
  (9,'ME625','MEA',1,'N','N'),
  (9,'ME626','MEA',1,'N','N'),
  (9,'ME627','MEA',1,'N','N'),
  (9,'ME628','MEA',1,'N','N'),
  (9,'ME629','MEA',1,'N','N'),
  (9,'ME630','MEA',1,'N','N'),
  (9,'ME631','MEA',1,'N','N'),
  (9,'ME632','MEA',1,'N','N'),
  (9,'ME633','MEA',1,'N','N'),
  (9,'ME634','MEA',1,'N','N'),
  (9,'ME635','MEA',1,'N','N'),
  (9,'ME636','MEA',1,'N','N'),
  (9,'ME637','MEA',1,'N','N'),
  (9,'ME638','MEA',1,'N','N'),
  (9,'ME639','MEA',1,'N','N'),
  (9,'ME640','MEA',1,'N','N'),
  (9,'ME641','MEA',1,'N','N'),
  (9,'ME642','MEA',1,'N','N'),
  (9,'ME643','MEA',1,'N','N'),
  (9,'ME644','MEA',1,'N','N'),
  (9,'ME645','MEA',1,'N','N'),
  (9,'ME646','MEA',1,'N','N'),
  (9,'ME647','MEA',1,'N','N'),
  (9,'ME648','MEA',1,'N','N'),
  (9,'ME649','MEA',1,'N','N'),
  (9,'ME650','MEA',1,'N','N'),
  (9,'ME651','MEA',1,'N','N'),
  (9,'ME652','MEA',1,'N','N'),
  (9,'ME653','MEA',1,'N','N'),
  (9,'ME654','MEA',1,'N','N'),
  (9,'ME655','MEA',1,'N','N'),
  (9,'ME656','MEA',1,'N','N'),
  (9,'ME657','MEA',1,'N','N'),
  (9,'ME658','MEA',1,'N','N'),
  (9,'ME659','MEA',1,'N','N'),
  (9,'ME660','MEA',1,'N','N'),
  (9,'ME661','MEA',1,'N','N'),
  (9,'ME662','MEA',1,'N','N'),
  (9,'ME663','MEA',1,'N','N'),
  (9,'ME664','MEA',1,'N','N'),
  (9,'ME665','MEA',1,'N','N'),
  (9,'ME666','MEA',1,'N','N'),
  (9,'ME667','MEA',1,'N','N'),
  (9,'ME668','MEA',1,'N','N'),
  (9,'ME669','MEA',1,'N','N'),
  (9,'ME670','MEA',1,'N','N'),
  (9,'ME671','MEA',1,'N','N'),
  (9,'ME672','MEA',1,'N','N'),
  (9,'ME673','MEA',1,'N','N'),
  (9,'ME674','MEA',1,'N','N'),
  (9,'ME675','MEA',1,'N','N'),
  (9,'ME676','MEA',1,'N','N'),
  (9,'ME677','MEA',1,'N','N'),
  (9,'ME678','MEA',1,'N','N'),
  (9,'ME679','MEA',1,'N','N'),
  (9,'ME680','MEA',1,'N','N'),
  (9,'ME681','MEA',1,'N','N'),
  (9,'ME682','MEA',1,'N','N'),
  (9,'ME683','MEA',1,'N','N'),
  (9,'ME684','MEA',1,'N','N'),
  (9,'ME685','MEA',1,'N','N'),
  (9,'ME686','MEA',1,'N','N'),
  (9,'ME687','MEA',1,'N','N'),
  (9,'ME688','MEA',1,'N','N'),
  (9,'ME689','MEA',1,'N','N'),
  (9,'ME690','MEA',1,'N','N'),
  (9,'ME691','MEA',1,'N','N'),
  (9,'ME692','MEA',1,'N','N'),
  (9,'ME693','MEA',1,'N','N'),
  (9,'ME694','MEA',1,'N','N'),
  (9,'ME695','MEA',1,'N','N'),
  (9,'ME696','MEA',1,'N','N'),
  (9,'ME697','MEA',1,'N','N'),
  (9,'ME698','MEA',1,'N','N'),
  (9,'ME699','MEA',1,'N','N'),
  (6,'me7','meb',1,'N','N'),
  (9,'ME700','MEA',1,'N','N'),
  (9,'ME701','MEA',1,'N','N'),
  (9,'ME702','MEA',1,'N','N'),
  (9,'ME703','MEA',1,'N','N'),
  (9,'ME704','MEA',1,'N','N'),
  (9,'ME705','MEA',1,'N','N'),
  (9,'ME706','MEA',1,'N','N'),
  (9,'ME707','MEA',1,'N','N'),
  (9,'ME708','MEA',1,'N','N'),
  (9,'ME709','MEA',1,'N','N'),
  (9,'ME710','MEA',1,'N','N'),
  (9,'ME711','MEA',1,'N','N'),
  (9,'ME712','MEA',1,'N','N'),
  (9,'ME713','MEA',1,'N','N'),
  (9,'ME714','MEA',1,'N','N'),
  (9,'ME715','MEA',1,'N','N'),
  (9,'ME716','MEA',1,'N','N'),
  (9,'ME717','MEA',1,'N','N'),
  (9,'ME718','MEA',1,'N','N'),
  (9,'ME719','MEA',1,'N','N'),
  (9,'ME720','MEA',1,'N','N'),
  (9,'ME721','MEA',1,'N','N'),
  (9,'ME722','MEA',1,'N','N'),
  (9,'ME723','MEA',1,'N','N'),
  (9,'ME724','MEA',1,'N','N'),
  (9,'ME725','MEA',1,'N','N'),
  (9,'ME726','MEA',1,'N','N'),
  (9,'ME727','MEA',1,'N','N'),
  (9,'ME728','MEA',1,'N','N'),
  (9,'ME729','MEA',1,'N','N'),
  (9,'ME730','MEA',1,'N','N'),
  (9,'ME731','MEA',1,'N','N'),
  (9,'ME732','MEA',1,'N','N'),
  (9,'ME733','MEA',1,'N','N'),
  (9,'ME734','MEA',1,'N','N'),
  (9,'ME735','MEA',1,'N','N'),
  (9,'ME736','MEA',1,'N','N'),
  (9,'ME737','MEA',1,'N','N'),
  (9,'ME738','MEA',1,'N','N'),
  (9,'ME739','MEA',1,'N','N'),
  (9,'ME740','MEA',1,'N','N'),
  (9,'ME741','MEA',1,'N','N'),
  (9,'ME742','MEA',1,'N','N'),
  (9,'ME743','MEA',1,'N','N'),
  (9,'ME744','MEA',1,'N','N'),
  (9,'ME745','MEA',1,'N','N'),
  (9,'ME746','MEA',1,'N','N'),
  (9,'ME747','MEA',1,'N','N'),
  (9,'ME748','MEA',1,'N','N'),
  (9,'ME749','MEA',1,'N','N'),
  (9,'ME750','MEA',1,'N','N'),
  (9,'ME751','MEA',1,'N','N'),
  (9,'ME752','MEA',1,'N','N'),
  (9,'ME753','MEA',1,'N','N'),
  (9,'ME754','MEA',1,'N','N'),
  (9,'ME755','MEA',1,'N','N'),
  (9,'ME756','MEA',1,'N','N'),
  (9,'ME757','MEA',1,'N','N'),
  (9,'ME758','MEA',1,'N','N'),
  (9,'ME759','MEA',1,'N','N'),
  (9,'ME760','MEA',1,'N','N'),
  (9,'ME761','MEA',1,'N','N'),
  (9,'ME762','MEA',1,'N','N'),
  (9,'ME763','MEA',1,'N','N'),
  (9,'ME764','MEA',1,'N','N'),
  (9,'ME765','MEA',1,'N','N'),
  (9,'ME766','MEA',1,'N','N'),
  (9,'ME767','MEA',1,'N','N'),
  (9,'ME768','MEA',1,'N','N'),
  (9,'ME769','MEA',1,'N','N'),
  (9,'ME770','MEA',1,'N','N'),
  (9,'ME771','MEA',1,'N','N'),
  (9,'ME772','MEA',1,'N','N'),
  (9,'ME773','MEA',1,'N','N'),
  (9,'ME774','MEA',1,'N','N'),
  (9,'ME775','MEA',1,'N','N'),
  (9,'ME776','MEA',1,'N','N'),
  (9,'ME777','MEA',1,'N','N'),
  (9,'ME778','MEA',1,'N','N'),
  (9,'ME779','MEA',1,'N','N'),
  (9,'ME780','MEA',1,'N','N'),
  (9,'ME781','MEA',1,'N','N'),
  (9,'ME782','MEA',1,'N','N'),
  (9,'ME783','MEA',1,'N','N'),
  (9,'ME784','MEA',1,'N','N'),
  (9,'ME785','MEA',1,'N','N'),
  (9,'ME786','MEA',1,'N','N'),
  (9,'ME787','MEA',1,'N','N'),
  (9,'ME788','MEA',1,'N','N'),
  (9,'ME789','MEA',1,'N','N'),
  (9,'ME790','MEA',1,'N','N'),
  (9,'ME791','MEA',1,'N','N'),
  (9,'ME792','MEA',1,'N','N'),
  (9,'ME793','MEA',1,'N','N'),
  (9,'ME794','MEA',1,'N','N'),
  (9,'ME795','MEA',1,'N','N'),
  (9,'ME796','MEA',1,'N','N'),
  (9,'ME797','MEA',1,'N','N'),
  (9,'ME798','MEA',1,'N','N'),
  (9,'ME799','MEA',1,'N','N'),
  (6,'me8','meb',1,'N','N'),
  (9,'ME800','MEA',1,'N','N'),
  (9,'ME801','MEA',1,'N','N'),
  (9,'ME802','MEA',1,'N','N'),
  (9,'ME803','MEA',1,'N','N'),
  (9,'ME804','MEA',1,'N','N'),
  (9,'ME805','MEA',1,'N','N'),
  (9,'ME806','MEA',1,'N','N'),
  (9,'ME807','MEA',1,'N','N'),
  (9,'ME808','MEA',1,'N','N'),
  (9,'ME809','MEA',1,'N','N'),
  (9,'ME810','MEA',1,'N','N'),
  (9,'ME811','MEA',1,'N','N'),
  (9,'ME812','MEA',1,'N','N'),
  (9,'ME813','MEA',1,'N','N'),
  (9,'ME814','MEA',1,'N','N'),
  (9,'ME815','MEA',1,'N','N'),
  (9,'ME816','MEA',1,'N','N'),
  (9,'ME817','MEA',1,'N','N'),
  (9,'ME818','MEA',1,'N','N'),
  (9,'ME819','MEA',1,'N','N'),
  (9,'ME820','MEA',1,'N','N'),
  (9,'ME821','MEA',1,'N','N'),
  (9,'ME822','MEA',1,'N','N'),
  (9,'ME823','MEA',1,'N','N'),
  (9,'ME824','MEA',1,'N','N'),
  (9,'ME825','MEA',1,'N','N'),
  (9,'ME826','MEA',1,'N','N'),
  (9,'ME827','MEA',1,'N','N'),
  (9,'ME828','MEA',1,'N','N'),
  (9,'ME829','MEA',1,'N','N'),
  (9,'ME830','MEA',1,'N','N'),
  (9,'ME831','MEA',1,'N','N'),
  (9,'ME832','MEA',1,'N','N'),
  (9,'ME833','MEA',1,'N','N'),
  (9,'ME834','MEA',1,'N','N'),
  (9,'ME835','MEA',1,'N','N'),
  (9,'ME836','MEA',1,'N','N'),
  (9,'ME837','MEA',1,'N','N'),
  (9,'ME838','MEA',1,'N','N'),
  (9,'ME839','MEA',1,'N','N'),
  (9,'ME840','MEA',1,'N','N'),
  (9,'ME841','MEA',1,'N','N'),
  (9,'ME842','MEA',1,'N','N'),
  (9,'ME843','MEA',1,'N','N'),
  (9,'ME844','MEA',1,'N','N'),
  (9,'ME845','MEA',1,'N','N'),
  (9,'ME846','MEA',1,'N','N'),
  (9,'ME847','MEA',1,'N','N'),
  (9,'ME848','MEA',1,'N','N'),
  (9,'ME849','MEA',1,'N','N'),
  (9,'ME850','MEA',1,'N','N'),
  (9,'ME851','MEA',1,'N','N'),
  (9,'ME852','MEA',1,'N','N'),
  (9,'ME853','MEA',1,'N','N'),
  (9,'ME854','MEA',1,'N','N'),
  (9,'ME855','MEA',1,'N','N'),
  (9,'ME856','MEA',1,'N','N'),
  (9,'ME857','MEA',1,'N','N'),
  (9,'ME858','MEA',1,'N','N'),
  (9,'ME859','MEA',1,'N','N'),
  (9,'ME860','MEA',1,'N','N'),
  (9,'ME861','MEA',1,'N','N'),
  (9,'ME862','MEA',1,'N','N'),
  (9,'ME863','MEA',1,'N','N'),
  (9,'ME864','MEA',1,'N','N'),
  (9,'ME865','MEA',1,'N','N'),
  (9,'ME866','MEA',1,'N','N'),
  (9,'ME867','MEA',1,'N','N'),
  (9,'ME868','MEA',1,'N','N'),
  (9,'ME869','MEA',1,'N','N'),
  (9,'ME870','MEA',1,'N','N'),
  (9,'ME871','MEA',1,'N','N'),
  (9,'ME872','MEA',1,'N','N'),
  (9,'ME873','MEA',1,'N','N'),
  (9,'ME874','MEA',1,'N','N'),
  (9,'ME875','MEA',1,'N','N'),
  (9,'ME876','MEA',1,'N','N'),
  (9,'ME877','MEA',1,'N','N'),
  (9,'ME878','MEA',1,'N','N'),
  (9,'ME879','MEA',1,'N','N'),
  (9,'ME880','MEA',1,'N','N'),
  (9,'ME881','MEA',1,'N','N'),
  (9,'ME882','MEA',1,'N','N'),
  (9,'ME883','MEA',1,'N','N'),
  (9,'ME884','MEA',1,'N','N'),
  (9,'ME885','MEA',1,'N','N'),
  (9,'ME886','MEA',1,'N','N'),
  (9,'ME887','MEA',1,'N','N'),
  (9,'ME888','MEA',1,'N','N'),
  (9,'ME889','MEA',1,'N','N'),
  (9,'ME890','MEA',1,'N','N'),
  (9,'ME891','MEA',1,'N','N'),
  (9,'ME892','MEA',1,'N','N'),
  (9,'ME893','MEA',1,'N','N'),
  (9,'ME894','MEA',1,'N','N'),
  (9,'ME895','MEA',1,'N','N'),
  (9,'ME896','MEA',1,'N','N'),
  (9,'ME897','MEA',1,'N','N'),
  (9,'ME898','MEA',1,'N','N'),
  (9,'ME899','MEA',1,'N','N'),
  (6,'me9','meb',1,'N','N'),
  (9,'ME900','MEA',1,'N','N'),
  (9,'ME901','MEA',1,'N','N'),
  (9,'ME902','MEA',1,'N','N'),
  (9,'ME903','MEA',1,'N','N'),
  (9,'ME904','MEA',1,'N','N'),
  (9,'ME905','MEA',1,'N','N'),
  (9,'ME906','MEA',1,'N','N'),
  (9,'ME907','MEA',1,'N','N'),
  (9,'ME908','MEA',1,'N','N'),
  (9,'ME909','MEA',1,'N','N'),
  (9,'ME910','MEA',1,'N','N'),
  (9,'ME911','MEA',1,'N','N'),
  (9,'ME912','MEA',1,'N','N'),
  (9,'ME913','MEA',1,'N','N');
COMMIT;

#
# Data for the `book_individual` table  (LIMIT 500,500)
#

INSERT INTO `book_individual` (`book_id`, `book_acc_no`, `rack_no`, `avail_flag_id`, `holder_id`, `holder_type`) VALUES 
  (9,'ME914','MEA',1,'N','N'),
  (9,'ME915','MEA',1,'N','N'),
  (9,'ME916','MEA',1,'N','N'),
  (9,'ME917','MEA',1,'N','N'),
  (9,'ME918','MEA',1,'N','N'),
  (9,'ME919','MEA',1,'N','N'),
  (9,'ME920','MEA',1,'N','N'),
  (9,'ME921','MEA',1,'N','N'),
  (9,'ME922','MEA',1,'N','N'),
  (9,'ME923','MEA',1,'N','N'),
  (9,'ME924','MEA',1,'N','N'),
  (9,'ME925','MEA',1,'N','N'),
  (9,'ME926','MEA',1,'N','N'),
  (9,'ME927','MEA',1,'N','N'),
  (9,'ME928','MEA',1,'N','N'),
  (9,'ME929','MEA',1,'N','N'),
  (9,'ME930','MEA',1,'N','N'),
  (9,'ME931','MEA',1,'N','N'),
  (9,'ME932','MEA',1,'N','N'),
  (9,'ME933','MEA',1,'N','N'),
  (9,'ME934','MEA',1,'N','N'),
  (9,'ME935','MEA',1,'N','N'),
  (9,'ME936','MEA',1,'N','N'),
  (9,'ME937','MEA',1,'N','N'),
  (9,'ME938','MEA',1,'N','N'),
  (9,'ME939','MEA',1,'N','N'),
  (9,'ME940','MEA',1,'N','N'),
  (9,'ME941','MEA',1,'N','N'),
  (9,'ME942','MEA',1,'N','N'),
  (9,'ME943','MEA',1,'N','N'),
  (9,'ME944','MEA',1,'N','N'),
  (9,'ME945','MEA',1,'N','N'),
  (9,'ME946','MEA',1,'N','N'),
  (9,'ME947','MEA',1,'N','N'),
  (9,'ME948','MEA',1,'N','N'),
  (9,'ME949','MEA',1,'N','N'),
  (9,'ME950','MEA',1,'N','N'),
  (9,'ME951','MEA',1,'N','N'),
  (9,'ME952','MEA',1,'N','N'),
  (9,'ME953','MEA',1,'N','N'),
  (9,'ME954','MEA',1,'N','N'),
  (9,'ME955','MEA',1,'N','N'),
  (9,'ME956','MEA',1,'N','N'),
  (9,'ME957','MEA',1,'N','N'),
  (9,'ME958','MEA',1,'N','N'),
  (9,'ME959','MEA',1,'N','N'),
  (9,'ME960','MEA',1,'N','N'),
  (9,'ME961','MEA',1,'N','N'),
  (9,'ME962','MEA',1,'N','N'),
  (9,'ME963','MEA',1,'N','N'),
  (9,'ME964','MEA',1,'N','N'),
  (9,'ME965','MEA',1,'N','N'),
  (9,'ME966','MEA',1,'N','N'),
  (9,'ME967','MEA',1,'N','N'),
  (9,'ME968','MEA',1,'N','N'),
  (9,'ME969','MEA',1,'N','N'),
  (9,'ME970','MEA',1,'N','N'),
  (9,'ME971','MEA',1,'N','N'),
  (9,'ME972','MEA',1,'N','N'),
  (9,'ME973','MEA',1,'N','N'),
  (9,'ME974','MEA',1,'N','N'),
  (9,'ME975','MEA',1,'N','N'),
  (9,'ME976','MEA',1,'N','N'),
  (9,'ME977','MEA',1,'N','N'),
  (9,'ME978','MEA',1,'N','N'),
  (9,'ME979','MEA',1,'N','N'),
  (9,'ME980','MEA',1,'N','N'),
  (9,'ME981','MEA',1,'N','N'),
  (9,'ME982','MEA',1,'N','N'),
  (9,'ME983','MEA',1,'N','N'),
  (9,'ME984','MEA',1,'N','N'),
  (9,'ME985','MEA',1,'N','N'),
  (9,'ME986','MEA',1,'N','N'),
  (9,'ME987','MEA',1,'N','N'),
  (9,'ME988','MEA',1,'N','N'),
  (9,'ME989','MEA',1,'N','N'),
  (9,'ME990','MEA',1,'N','N'),
  (9,'ME991','MEA',1,'N','N'),
  (9,'ME992','MEA',1,'N','N'),
  (9,'ME993','MEA',1,'N','N'),
  (9,'ME994','MEA',1,'N','N'),
  (9,'ME995','MEA',1,'N','N'),
  (9,'ME996','MEA',1,'N','N'),
  (9,'ME997','MEA',1,'N','N'),
  (9,'ME998','MEA',1,'N','N'),
  (9,'ME999','MEA',1,'N','N');
COMMIT;

#
# Data for the `clerk_master` table  (LIMIT 0,500)
#

INSERT INTO `clerk_master` (`clr_id`, `clr_name`, `clr_join_yr`, `clr_email`, `clr_pass`, `sec_ques`, `sec_ans`, `clr_valid`) VALUES 
  (1,'clerk',2000,'clerk@nita.com','WER','who are you?','clerk','Y'),
  (2,'CLK',2012,'RITBFDB','CLK',NULL,NULL,'Y'),
  (3,'Anil Paul',2011,'anil@gmail.com','123','What is birth Month?','march','Y');
COMMIT;

#
# Data for the `faculty_master` table  (LIMIT 0,500)
#

INSERT INTO `faculty_master` (`fac_id`, `fac_name`, `fac_password`, `fac_br_id`, `fac_designation`, `fac_email`, `sec_ques`, `sec_ans`, `fac_valid`) VALUES 
  (1,'faculty1','qwerty',2,'Prof','fac1@nita.com','what is your name','fac','Y'),
  (2,'Ashim Saha','123',9,'Ass. Prof','ashimsaha@gmail.com','What is my birth place?','agartala','Y');
COMMIT;

#
# Data for the `student_master` table  (LIMIT 0,500)
#

INSERT INTO `student_master` (`st_id`, `st_roll`, `st_name`, `st_branch_id`, `st_password`, `st_email`, `st_pass_yr`, `sec_ques`, `sec_ans`, `st_valid`, `st_cat`) VALUES 
  (2,'123456','student',2,'qwerty','stu@nita.com',2012,'what is fav color?','red','Y','G'),
  (3,'810404','Anil Bhaskar',2,'anil','anilbhaskar.cse@gmail.com',2012,'What is my mobile number?','9862515673','N','O'),
  (4,'810405','Anish Mishra',9,'123','anish@gmail.com',2012,'What is birth Month?','august','Y','G');
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;