BEGIN
   FOR l IN (
      SELECT CustomerID,LoanID,EndDate
      FROM Loans
      WHERE EndDate BETWEEN SYSDATE AND SYSDATE+30
   )
   LOOP
      DBMS_OUTPUT.PUT_LINE(
      'Reminder: Customer '||l.CustomerID||
      ' Loan '||l.LoanID||
      ' Due on '||l.EndDate);
   END LOOP;
END;
/