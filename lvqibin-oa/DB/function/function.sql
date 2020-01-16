
## 根据ID获取该数据ID和所以子数据ID 通过,进行分割
CREATE FUNCTION `getMenuChildList` (rootId varchar(100))
RETURNS TEXT
BEGIN
DECLARE str TEXT;  
DECLARE cid TEXT;   
SET str = '';   
SET cid = rootId;   
WHILE cid is not null DO   
    SET str = concat(str, ',', cid);   
    SELECT group_concat(id) INTO cid FROM sys_menu where FIND_IN_SET(parent, cid) > 0;   
END WHILE;   
RETURN str;   
RETURN 1;
END

## 根据ID获取该数据的ID和所以父数据ID 通过,进行分割
CREATE FUNCTION `getMenuParentList` (rootId varchar(100))
RETURNS TEXT
BEGIN
DECLARE fid TEXT default '';   
DECLARE str TEXT default rootId;   
  
WHILE rootId is not null  do   
    SET fid =(SELECT parent FROM sys_menu WHERE id = rootId);   
    IF fid is not null THEN   
        SET str = concat(str, ',', fid);   
        SET rootId = fid;   
    ELSE   
        SET rootId = fid;   
    END IF;   
END WHILE;   
return str;  
END

## 根据ID获取该数据组织机构ID和所以子数据ID 通过,进行分割  
CREATE  FUNCTION `getOrgChildList`(rootId varchar(100)) RETURNS text 
BEGIN
DECLARE str TEXT;  
DECLARE cid TEXT;   
SET str = '';   
SET cid = rootId;   
WHILE cid is not null DO   
    SET str = concat(str, ',', cid);   
    SELECT group_concat(id) INTO cid FROM sys_org where FIND_IN_SET(parent, cid) > 0;   
END WHILE;   
RETURN str;   
RETURN 1;
END

## 根据ID获取该组织机构数据的ID和所以父数据ID 通过,进行分割
CREATE FUNCTION `getOrgParentList` (rootId varchar(100))
RETURNS TEXT
BEGIN
DECLARE fid TEXT default '';   
DECLARE str TEXT default rootId;   
  
WHILE rootId is not null  do   
    SET fid =(SELECT parent FROM sys_org WHERE id = rootId);   
    IF fid is not null THEN   
        SET str = concat(str, ',', fid);   
        SET rootId = fid;   
    ELSE   
        SET rootId = fid;   
    END IF;   
END WHILE;   
return str;  
END
## 根据组织机构的列名name和code 获取 name或code 的全路径
CREATE FUNCTION `getByColumnName`(rootId varchar(100),columnName varchar(100)) RETURNS varchar(1000)
BEGIN
DECLARE fid TEXT default '';   
DECLARE str TEXT default ''; 
DECLARE columnValue TEXT default '';
DECLARE lastId TEXT default ''; 
DECLARE nowId TEXT default rootId;   
  
WHILE rootId is not null  do   
    SET fid =(SELECT parent FROM sys_org WHERE id = rootId); 
    SET lastId =(SELECT id FROM sys_org WHERE id = rootId);
    IF columnName ='name' THEN 
		SET columnValue =(SELECT name FROM sys_org WHERE id = rootId);
    ELSEIF columnName ='code' THEN 
        SET columnValue =(SELECT code FROM sys_org WHERE id = rootId);
	END IF;
    IF fid is not null THEN
		IF nowId <>  lastId THEN 
			SET str = concat(columnValue, '/', str); 
        ELSE 
			SET str = concat(columnValue, '', str); 
        END IF;
        SET rootId = fid;   
    ELSE   
        SET rootId = fid;
        SET str = concat('/root/' ,str);   
    END IF;   
END WHILE;
return str;
END
