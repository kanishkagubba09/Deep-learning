CREATE OR REPLACE PROCEDURE SafeTransferFunds(
   p_from NUMBER,
   p_to NUMBER,
   p_amt NUMBER)
IS
   bal NUMBER;
BEGIN
   SELECT Balance INTO bal
   FROM Accounts
   WHERE AccountID=p_from;

   IF bal<p_amt THEN
      RAISE_APPLICATION_ERROR(-20001,'Insufficient Balance');
   END IF;

   UPDATE Accounts
   SET Balance=Balance-p_amt
   WHERE AccountID=p_from;

   UPDATE Accounts
   SET Balance=Balance+p_amt
   WHERE AccountID=p_to;

   COMMIT;

EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/