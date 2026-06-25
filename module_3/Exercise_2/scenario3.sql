CREATE OR REPLACE PROCEDURE AddNewCustomer(
   p_id NUMBER,
   p_name VARCHAR2,
   p_dob DATE,
   p_bal NUMBER)
IS
BEGIN
   INSERT INTO Customers
   VALUES(p_id,p_name,p_dob,p_bal,SYSDATE);

   COMMIT;

EXCEPTION
   WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Customer ID Already Exists');
END;
/