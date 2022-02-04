create table CUSTOMERS
(
    id serial PRIMARY KEY,
    name varchar(30) NOT NULL,
    surname varchar(60) NOT NULL,
    age int NOT NULL,
    phone_number varchar(20)
);
create table ORDERS
(
    id serial PRIMARY KEY,
    date timestamp DEFAULT now(),
    customer_id int NOT NULL,
    product_name varchar(150) NOT NULL,
    amount int NOT NULL,
    CHECK ( amount > 0),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);
create index cust_id on ORDERS (customer_id);

insert into CUSTOMERS (name, surname, age, phone_number) values
                                                             ('Alexey', 'Alekseev', 20, '1111'),
                                                             ('ivan', 'Ivanov', 30, '2222'),
                                                             ('Petr', 'Petrov', 40, '3333'),
                                                             ('alexey', 'Ivanov', 50, '4444');

insert into ORDERS (customer_id, product_name, amount) values
                                                           (1, 'milk', 1),
                                                           (1, 'soap', 3),
                                                           (1, 'juice', 2),
                                                           (2, 'apples', 5),
                                                           (2, 'bananas', 7),
                                                           (3, 'pen', 10),
                                                           (4, 'ball', 1),
                                                           (4, 'tooth fresh', 2);