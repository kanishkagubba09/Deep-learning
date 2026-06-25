CREATE OR REPLACE PROCEDURE TransferFunds(
   p_from NUMBER,
   p_to NUMBER,
   p_amt NUMBER)
IS
   bal NUMBER;
BEGIN
   SELECT Balance INTO bal
   FROM Accounts
   WHERE AccountID=p_from;

   IF bal>=p_amt THEN

      UPDATE Accounts
      SET Balance=Balance-p_amt
      WHERE AccountID=p_from;

      UPDATE Accounts
      SET Balance=Balance+p_amt
      WHERE AccountID=p_to;

      COMMIT;

   ELSE
      DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
   END IF;
END;
/