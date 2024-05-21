select category_name, 
    max(unit_price) as max_unit_price, 
    count(*) as product_count,
    avg(unit_price) avg_product_price
from PRODUCTS natural join CATEGORIES
group by category_name;

select category_name, 
    max(unit_price) as max_unit_price, 
    count(*) as product_count,
    avg(unit_price) avg_product_price
from PRODUCTS join CATEGORIES
on PRODUCTS.category_id=CATEGORIES.category_id
group by category_name;

select category_name, 
    max(unit_price) as max_unit_price, 
    count(*) as product_count,
    avg(unit_price) avg_product_price
from PRODUCTS join CATEGORIES
on PRODUCTS.category_id=CATEGORIES.category_id
group by category_name
having avg(unit_price) <= 30;


select category_name, 
    max(unit_price) as max_unit_price, 
    count(*) as product_count,
    avg(unit_price) avg_product_price
from PRODUCTS join CATEGORIES
on PRODUCTS.category_id=CATEGORIES.category_id
group by category_name
having count(*) <10;



select category_name
from PRODUCTS natural join CATEGORIES
group by category_name
having count(*) >= 10;


select category_name, 
    max(unit_price) as max_unit_price, 
    count(*) as product_count,
    avg(unit_price) avg_product_price
from PRODUCTS join CATEGORIES
on PRODUCTS.category_id=CATEGORIES.category_id
group by category_name
having product_count < 10
order by product_count desc;


select category_name, description,
    max(unit_price) as max_unit_price, 
    count(*) as product_count,
    avg(unit_price) avg_product_price
from PRODUCTS join CATEGORIES
on PRODUCTS.category_id=CATEGORIES.category_id
group by description, category_name;

-- list all category names along with the costliest product name in that category, along with the unit_price

-- SELECT CATEGORY_NAME, PRODUCT_NAME, UNIT_PRICE FROM PRODUCTS NATURAL JOIN CATEGORIES
-- WHERE UNIT_PRICE = (MAX UNIT PRICE FOR THE CATEGORY IN THE OUTER ROW)


SELECT CATEGORY_NAME, PRODUCT_NAME, UNIT_PRICE FROM PRODUCTS PRD NATURAL JOIN CATEGORIES CAT
WHERE UNIT_PRICE = (SELECT MAX(UNIT_PRICE) FROM PRODUCTS WHERE CATEGORY_ID = CAT.CATEGORY_ID);


-- GET THE LIST OF ALL PRODUCTS THAT ARE PRICED MORE THAN THE AVERAGE PRICE IN THEIR RESPECTIVE CATEGORY

SELECT C.CATEGORY_ID, CATEGORY_NAME, AVG(UNIT_PRICE)
    FROM CATEGORIES C NATURAL JOIN PRODUCTS
    GROUP BY C.CATEGORY_ID, CATEGORY_NAME;

SELECT * FROM PRODUCTS PRD
WHERE UNIT_PRICE > (SELECT AVG(UNIT_PRICE) FROM PRODUCTS WHERE CATEGORY_ID=PRD.CATEGORY_ID)
ORDER BY CATEGORY_ID, UNIT_PRICE;

SELECT P1.PRODUCT_ID, P1.PRODUCT_NAME, P1.UNIT_PRICE, P1.CATEGORY_ID, P2.* FROM PRODUCTS P1 
    JOIN (SELECT CATEGORY_ID, AVG(UNIT_PRICE) AVG_PRICE FROM PRODUCTS GROUP BY CATEGORY_ID) AS P2
    ON P1.CATEGORY_ID = P2.CATEGORY_ID
    WHERE P1.UNIT_PRICE > P2.AVG_PRICE;

SELECT P1.* FROM PRODUCTS P1 
    JOIN (SELECT CATEGORY_ID, AVG(UNIT_PRICE) AVG_PRICE FROM PRODUCTS GROUP BY CATEGORY_ID) AS P2
    ON P1.CATEGORY_ID = P2.CATEGORY_ID
    WHERE P1.UNIT_PRICE > P2.AVG_PRICE
    ORDER BY P1.CATEGORY_ID, P1.UNIT_PRICE;

SELECT P1.* FROM PRODUCTS P1,
    (SELECT CATEGORY_ID, AVG(UNIT_PRICE) AVG_PRICE FROM PRODUCTS GROUP BY CATEGORY_ID) AS P2
    WHERE P1.CATEGORY_ID = P2.CATEGORY_ID
    AND P1.UNIT_PRICE > P2.AVG_PRICE
    ORDER BY P1.CATEGORY_ID, P1.UNIT_PRICE;


SELECT * FROM ORDER_DETAILS WHERE ORDER_ID=10535;
SELECT *, UNIT_PRICE*QUANTITY*(1-DISCOUNT) AS NET_AMOUNT FROM ORDER_DETAILS WHERE ORDER_ID=10535;
SELECT SUM(UNIT_PRICE*QUANTITY*(1-DISCOUNT)) AS TOTAL_AMOUNT FROM ORDER_DETAILS WHERE ORDER_ID=10535;


CREATE VIEW CUSTOMER_ORDERS AS
SELECT 
    C.CUSTOMER_ID, C.COMPANY_NAME AS CUSTOMER_NAME, -- CUSTOMERS TABLE
    O.ORDER_ID, O.ORDER_DATE, O.REQUIRED_DATE, -- ORDERS TABLE
    CONCAT_WS(' ', E.FIRST_NAME, E.LAST_NAME) AS EMPLOYEE_NAME, -- EMPLOYEES TABLE
    S.COMPANY_NAME AS SHIPPED_BY, -- SHIPPERS TABLE
    SUM(OD.UNIT_PRICE*OD.QUANTITY*(1-OD.DISCOUNT)) AS ORDER_TOTAL -- ORDER_DETAILS TABLE
FROM CUSTOMERS C 
JOIN ORDERS O ON C.CUSTOMER_ID=O.CUSTOMER_ID
JOIN EMPLOYEES E ON O.EMPLOYEE_ID=E.EMPLOYEE_ID
JOIN SHIPPERS S ON O.SHIP_VIA=S.SHIPPER_ID
JOIN ORDER_DETAILS OD ON O.ORDER_ID=OD.ORDER_ID
GROUP BY CUSTOMER_NAME, O.ORDER_ID, O.ORDER_DATE, O.REQUIRED_DATE, EMPLOYEE_NAME, SHIPPED_BY;



