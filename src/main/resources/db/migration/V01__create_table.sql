CREATE TABLE product
(
    id    serial PRIMARY KEY NOT NULL ,
    name  varchar(100) NOT NULL ,
    price bigint NOT NULL
);

CREATE TABLE coupon
(
    code varchar(50) PRIMARY KEY NOT NULL,
    value bigint NOT NULL,
    type varchar(20) NOT NULL
);
