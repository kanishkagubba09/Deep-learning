CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
   p_loan NUMBER,
   p_rate NUMBER,
   p_year NUMBER)
RETURN NUMBER
IS
BEGIN
   RETURN (p_loan+(p_loan*p_rate*p_year/100))
          /(p_year*12);
END;
/