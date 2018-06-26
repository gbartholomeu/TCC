DELIMITER $$
DROP TRIGGER IF EXISTS dictionary_after_insert$$

CREATE TRIGGER dictionary_after_insert AFTER INSERT ON dictionary FOR EACH ROW 
BEGIN
  INSERT INTO dictionary_history(nr_seq_object, ds_name, ie_type, ds_content, dt_insertion, nm_user)
  SELECT nr_sequence nr_seq_object, ds_name, ie_type, ds_content, dt_insertion, nm_user 
  FROM dictionary
  WHERE nr_sequence = NEW.nr_sequence;
END$$
DELIMITER ;