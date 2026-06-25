DECLARE
CURSOR c IS
SELECT LoanID,InterestRate
FROM Loans;

BEGIN
FOR r IN c LOOP

UPDATE Loans
SET InterestRate=r.InterestRate+0.5
WHERE LoanID=r.LoanID;

END LOOP;

COMMIT;
END;
/