
USE yumutech;

SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER $$

-- getOptionValue
DROP FUNCTION IF EXISTS getOptionValue $$
CREATE FUNCTION getOptionValue(product_code varchar(100),field_code varchar(100),option_code varchar(64) )
RETURNS varchar(100)
BEGIN
	DECLARE option_value varchar(100);

	SELECT base_system_option.name INTO option_value 
	
	FROM base_system_field
    LEFT JOIN base_system_option ON base_system_option.system_field_id = base_system_field.id
    WHERE base_system_field.system_product_code = product_code 
    AND base_system_field.code =field_code
    AND base_system_option.code = option_code limit 1;
	
	SET option_value = IFNULL(option_value,'');
	
  RETURN option_value;
END
$$