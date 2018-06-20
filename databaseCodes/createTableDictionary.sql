CREATE TABLE `dictionary` (
  `nr_sequence` int(255) NOT NULL AUTO_INCREMENT,
  `ds_name` varchar(255) DEFAULT NULL,
  `ie_type` varchar(255) DEFAULT NULL,
  `ds_content` mediumtext,
  `dt_insertion` date DEFAULT NULL,
  `nm_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nr_sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;