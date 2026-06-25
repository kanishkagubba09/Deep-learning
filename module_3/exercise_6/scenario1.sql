DECLARE
CURSOR c IS
SELECT *
FROM Transactions
WHERE TO_CHAR(TransactionDate,'MMYYYY')
=TO_CHAR(SYSDATE,'MMYYYY');

r c%ROWTYPE;

BEGIN
OPEN c;

LOOP
FETCH c INTO r;
EXIT WHEN c%NOTFOUND;

DBMS_OUTPUT.PUT_LINE(
'Account='||r.AccountID||
' Amount='||r.Amount||
' Type='||r.TransactionType);

END LOOP;

CLOSE c;
END;
/