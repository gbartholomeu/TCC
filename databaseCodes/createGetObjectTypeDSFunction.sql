DROP FUNCTION IF EXISTS `getUserUsername`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` FUNCTION `getUserUsername`(NR_SEQUENCE_P INT) RETURNS varchar(255) CHARSET utf8
BEGIN
  DECLARE OBJECT_RETURN VARCHAR(255);
  
  SELECT USERNAME
  INTO OBJECT_RETURN
  FROM APPLICATION_USER
  WHERE NR_SEQUENCE = NR_SEQUENCE_P;
  
  RETURN OBJECT_RETURN;
END//
DELIMITER ;