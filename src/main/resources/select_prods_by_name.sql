select product_name from ORDERS
                                        join CUSTOMERS cust on ORDERS.customer_id = cust.id
where lower(cust.name) = lower(:name)
order by 1;