SELECT * FROM cardealership.sales_contracts;

SELECT vehicles.dealership_id, vehicles.VIN, COUNT(*)
FROM vehicles
GROUP BY vehicles.dealership_id, vehicles.VIN
HAVING COUNT(*) >1;

SHOW CREATE TABLE cardealership.inventory; 

INSERT INTO cardealership.sales_contracts(
	dealership_id, VIN, buyer_name)
SELECT vehicles.dealership_id, vehicles.VIN
FROM vehicles
JOIN dealerships  ON vehicles.dealership_id = dealerships.dealership_id;

INSERT INTO sales_contracts (
    buyer_name, buyer_phone, purchase_date, purchase_price,
    payment, warranty, warranty_expiration
) VALUES
('Alice Mendoza', '555-123-4567', '2024-09-01', 23999.99, 'Cash', 1, '2027-09-01'),
('Brian O''Connor', '555-234-5678', '2025-01-15', 18950.00, 'Financing', 0, NULL),
('Carla Nguyen', '555-345-6789', '2025-02-22', 21400.00, 'Lease', 1, '2028-02-22'),
('David Kim', '555-456-7890', '2025-05-10', 30100.00, 'Trade-in', 1, '2027-05-10'),
('Ellie Johnson', '555-567-8901', '2025-06-01', 17999.95, 'Cash', 0, NULL),
('Frank Rivera', '555-678-9012', '2025-04-12', 24999.00, 'Financing', 1, '2028-04-12'),
('Grace Lin', '555-789-0123', '2025-03-05', 27000.00, 'Lease', 0, NULL);

INSERT INTO cardealership.sales_contracts (
    dealership_id, VIN, buyer_name, buyer_phone, purchase_date,
    purchase_price, payment, warranty, warranty_expiration
)
SELECT 
    v.dealership_id,
    v.VIN,
    s.buyer_name,
    s.buyer_phone,
    s.purchase_date,
    s.purchase_price,
    s.payment,
    s.warranty,
    s.warranty_expiration
FROM vehicles v
JOIN dealerships d ON v.dealership_id = d.dealership_id
JOIN (
    SELECT 
        'Alice Mendoza' AS buyer_name,
        '555-123-4567' AS buyer_phone,
        '2024-09-01' AS purchase_date,
        23999.99 AS purchase_price,
        'Cash' AS payment,
        1 AS warranty,
        '2027-09-01' AS warranty_expiration
    UNION ALL
    SELECT 'Brian O''Connor', '555-234-5678', '2025-01-15', 18950.00, 'Financing', 0, NULL
    UNION ALL
    SELECT 'Carla Nguyen', '555-345-6789', '2025-02-22', 21400.00, 'Lease', 1, '2028-02-22'
    -- Add more UNION ALLs to match the number of vehicles you're pulling
) s ON v.VIN IS NOT NULL  -- this just ensures a join, tweak as needed
LIMIT 3; -- match number of rows in subquery

DELETE FROM sales_contracts
WHERE buyer_name LIKE '%ALICE%';
