CREATE OR REPLACE PROCEDURE UpdateSalary(
   p_empid NUMBER,
   p_percent NUMBER)
IS
BEGIN
   UPDATE Employees
   SET Salary=Salary+(Salary*p_percent/100)
   WHERE EmployeeID=p_empid;

   IF SQL%ROWCOUNT=0 THEN
      RAISE NO_DATA_FOUND;
   END IF;

   COMMIT;

EXCEPTION
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Employee Not Found');
END;
/