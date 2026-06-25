BEGIN
   FOR c IN (
      SELECT CustomerID, DOB
      FROM Customers
   )
   LOOP
      IF FLOOR(MONTHS_BETWEEN(SYSDATE,c.DOB)/12) > 60 THEN
         UPDATE Loans
         SET InterestRate = InterestRate - 1
         WHERE CustomerID = c.CustomerID;
      END IF;
   END LOOP;

   COMMIT;
END;
/