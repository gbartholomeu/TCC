CREATE TABLE `application_user` (
  `username` varchar(255) NOT NULL,
  `saltpass` varbinary(255) NOT NULL,
  `interations` decimal(10,0) NOT NULL,
  `keylength` decimal(10,0) NOT NULL,
  `userpassword` varbinary(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
