CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT
ON Transactions
FOR EACH ROW
DECLARE
   bal NUMBER;
BEGIN
   SELECT Balance INTO bal
   FROM Accounts
   WHERE AccountID=:NEW.AccountID;

   IF :NEW.TransactionType='Withdrawal'
      AND :NEW.Amount>bal THEN
      RAISE_APPLICATION_ERROR(-20002,'Insufficient Balance');
   END IF;

   IF :NEW.TransactionType='Deposit'
      AND :NEW.Amount<=0 THEN
      RAISE_APPLICATION_ERROR(-20003,'Invalid Deposit');
   END IF;
END;
/