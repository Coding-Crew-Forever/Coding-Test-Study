-- 코드를 입력하세요
SELECT a.PRODUCT_CODE, SUM(b.SALES_AMOUNT * a.PRICE) as SALES FROM PRODUCT a JOIN OFFLINE_SALE b ON a.PRODUCT_ID = b.PRODUCT_ID GROUP BY a.PRODUCT_CODE ORDER BY SALES DESC, a.PRODUCT_CODE asc;
