CREATE TABLE `dictionary_history` (
  `nr_sequence` int(255) NOT NULL AUTO_INCREMENT,
  `nr_seq_object` int(255) NOT NULL,
  `ds_name` varchar(255) DEFAULT NULL,
  `ie_type` varchar(255) DEFAULT NULL,
  `ds_content` mediumtext,
  `dt_insertion` date DEFAULT NULL,
  `nm_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nr_sequence`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
