DROP DATABASE IF EXISTS OneMount;
CREATE DATABASE OneMount;
USE OneMount;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`(
	id 						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name_order				NVARCHAR(50) NOT NULL,
	number_of_item			SMALLINT NOT NULL,
    note					NVARCHAR(500),
    `date`					DATETIME DEFAULT NOW()
);


DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`(
	id 						SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name_item				NVARCHAR(50) NOT NULL,
    `type`					NVARCHAR(50) NOT NULL,
    price					DOUBLE UNSIGNED NOT NULL,
    `date`					DATETIME DEFAULT NOW(),
    note					NVARCHAR(500)
);



-- Create table: Course & Subject
DROP TABLE IF EXISTS order_item;
CREATE TABLE order_item(
	`id` 					SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    order_id				SMALLINT UNSIGNED NOT NULL,
	item_id 				SMALLINT UNSIGNED NOT NULL,	
    `date`					DATETIME DEFAULT NOW(),
    note					NVARCHAR(500),				
    
    FOREIGN KEY (order_id) REFERENCES `order` (id),
	FOREIGN KEY (item_id) REFERENCES item (id),
    UNIQUE KEY (order_id, item_id)
);

INSERT INTO `order` (name_order, number_of_item, note)
VALUES				('a'		,8				,NULL),		
					('b'		,3				,NULL);
                    
INSERT INTO	`item` 	(name_item	, `type`, price, `date`)
VALUES				('aa'		,	1	,500	,NOW()),	
					('ab'		,	1	,501	,NOW()),	
                    ('ac'		,	1	,502	,NOW()),	
                    ('ad'		,	1	,503	,NOW()),	
                    ('ae'		,	1	,504	,NOW()),	
                    ('af'		,	1	,505	,NOW()),	
                    ('ag'		,	1	,506	,NOW()),	
                    ('ah'		,	1	,507	,NOW()),	
                    ('ba'		,	2	,508	,NOW()),	
                    ('bb'		,	2	,509	,NOW());
                    
INSERT INTO order_item	(order_id	, item_id)
VALUES					(1			,		1),
						(1			,		2),
                        (1			,		3),
                        (1			,		4),
                        (1			,		5),
                        (1			,		6),
                        (1			,		7),
                        (1			,		8),
                        (2			,		9),
                        (2			,		10),
                        (2			,		1);