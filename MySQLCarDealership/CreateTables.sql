CREATE TABLE dealerships (
		dealership_id int NOT NULL auto_increment,
        name varchar(50) NOT NULL,
        address varchar(50) NOT NULL,
        phone varchar(12),
        PRIMARY KEY (dealership_id)
        );

CREATE TABLE vehicles (
	dealership_id int,
	VIN varchar(17),
    make varchar(50) ,
    model varchar(50) ,
    year int,
    color varchar (25),
    mileage int,
    price int, 
    transmission varchar(9),
    engine varchar(30),
    sold varchar (3),
    PRIMARY KEY (VIN)
    );
    
CREATE TABLE inventory ( -- track which dealership has the vehicle)
		dealership_id int NOT NULL,
        VIN varchar (17) NOT NULL
        );
        
CREATE TABLE sales_contracts (
	contract_id int auto_increment,
    dealership_id int,
    VIN varchar (17),
    buyer_name varchar(100) ,
    buyer_phone varchar(15),
    purchase_date date,
    purchase_price decimal(10,2),
    payment varchar(50),
    warranty BOOLEAN,
    warranty_expiration date,
	
    PRIMARY KEY(contract_id),
    FOREIGN KEY (VIN) references vehicles(VIN),
    FOREIGN KEY (dealership_id) references dealerships(dealership_id)
    );
    
    
			