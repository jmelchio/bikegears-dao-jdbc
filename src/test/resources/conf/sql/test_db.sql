CREATE DATABASE IF NOT EXISTS test;
USE test;

--
-- Definition of table `test`.`bike`
--

DROP TABLE IF EXISTS `test`.`bike`;
CREATE TABLE  `test`.`bike` (
  `id` int(11) NOT NULL auto_increment,
  `brand` varchar(25) default NULL,
  `model` varchar(25) default NULL,
  `year` int(11) default NULL,
  `color` varchar(15) default NULL,
  `description` text,
  `type_id` int(11) default NULL,
  `bike_rider_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `test`.`bike_ride`
--

DROP TABLE IF EXISTS `test`.`bike_ride`;
CREATE TABLE  `test`.`bike_ride` (
  `id` int(11) NOT NULL auto_increment,
  `date` date default NULL,
  `start_location` varchar(25) default NULL,
  `finish_location` varchar(25) default NULL,
  `distance_km` decimal(4,2) default NULL,
  `ride_time_seconds` int(11) default NULL,
  `average_hr` int(11) default NULL,
  `maximum_hr` int(11) default NULL,
  `calories_burnt` int(11) default NULL,
  `journal` text,
  `bike_rider_id` int(11) default NULL,
  `type_id` int(11) default NULL,
  `bike_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `i_date` (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`.`bike_ride`
--

--
-- Definition of table `test`.`bike_ride_type`
--

DROP TABLE IF EXISTS `test`.`bike_ride_type`;
CREATE TABLE  `test`.`bike_ride_type` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(15) NOT NULL default '',
  `description` text,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `test`.`bike_rider`
--

DROP TABLE IF EXISTS `test`.`bike_rider`;
CREATE TABLE  `test`.`bike_rider` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(15) default NULL,
  `password` varchar(40) default NULL,
  `person_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `test`.`bike_type`
--

DROP TABLE IF EXISTS `test`.`bike_type`;
CREATE TABLE  `test`.`bike_type` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(15) NOT NULL default '',
  `description` text,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `test`.`person`
--

DROP TABLE IF EXISTS `test`.`person`;
CREATE TABLE  `test`.`person` (
  `id` int(11) NOT NULL auto_increment,
  `first_name` varchar(25) default NULL,
  `last_name` varchar(25) default NULL,
  `initials` varchar(6) default NULL,
  `birthdate` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

