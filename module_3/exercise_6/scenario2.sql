DECLARE
CURSOR c IS
SELECT AccountID
FROM Accounts;

fee NUMBER:=100;

BEGIN
FOR r IN c LOOP

UPDATE Accounts
SET Balance=Balance-fee
WHERE AccountID=r.AccountID;

END LOOP;

COMMIT;
END;
/