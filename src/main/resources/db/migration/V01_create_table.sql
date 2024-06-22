CREATE SEQUENCE product_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE product
(
    id    bigint PRIMARY KEY DEFAULT nextval(product_seq),
    name  varchar(100) NOT NULL ,
    price bigint NOT NULL
);

CREATE TABLE coupon
(
    code varchar(50) PRIMARY KEY NOT NULL,
    value bigint NOT NULL,
    type varchar(20) NOT NULL
);
