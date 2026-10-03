SELECT
    MCDP_CD as 진료과코드,
    count(*) as 5월예약건수
FROM
    APPOINTMENT
WHERE
    '2022-05-01' <= APNT_YMD AND
    APNT_YMD < '2022-06-01'
GROUP BY
    MCDP_CD
ORDER BY
    5월예약건수 ASC,
    진료과코드 ASC;