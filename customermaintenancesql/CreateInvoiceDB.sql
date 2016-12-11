DROP TABLE Invoices;
CREATE TABLE Invoices
(invoiceCode VARCHAR(10), customerID INTEGER, invoiceDate DATE, total DOUBLE);

insert into invoices (invoiceCode,customerID,invoiceDate,total) values ('10500M',2,'2004-10-25',495.0);
insert into invoices (invoiceCode,customerID,invoiceDate,total) values ('10501M',1,'2004-10-25',59.5);
insert into invoices (invoiceCode,customerID,invoiceDate,total) values ('10502M',3,'2004-10-25',99.0);
insert into invoices (invoiceCode,customerID,invoiceDate,total) values ('10503M',4,'2004-10-25',112.0);
insert into invoices (invoiceCode,customerID,invoiceDate,total) values ('10504M',1,'2004-11-18',99.0);
insert into invoices (invoiceCode,customerID,invoiceDate,total) values ('10505M',2,'2004-11-18',297.5);