DELIMITER $$
DROP TRIGGER IF EXISTS dictionary_after_update$$

CREATE TRIGGER dictionary_after_update AFTER UPDATE ON dictionary FOR EACH ROW 
BEGIN
  INSERT INTO dictionary_history(nr_seq_object, ds_name, ie_type, ds_content, dt_insertion, nm_user)
	values(new.nr_sequence, new.ds_name, new.ie_type, new.ds_content, sysdate(), new.nm_user);
END$$
DELIMITER ;