CREATE OR REPLACE PACKAGE CustomerManagement AS

PROCEDURE AddCustomer(
id NUMBER,
name VARCHAR2,
dob DATE,
bal NUMBER);

PROCEDURE UpdateCustomer(
id NUMBER,
name VARCHAR2);

FUNCTION GetBalance(
id NUMBER)
RETURN NUMBER;

END CustomerManagement;
/