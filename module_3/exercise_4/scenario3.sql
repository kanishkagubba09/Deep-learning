CREATE OR REPLACE FUNCTION HasSufficientBalance(
   p_acc NUMBER,
   p_amt NUMBER)
RETURN BOOLEAN
IS
   bal NUMBER;
BEGIN
   SELECT Balance INTO bal
   FROM Accounts
   WHERE AccountID=p_acc;

   RETURN bal>=p_amt;
END;
/