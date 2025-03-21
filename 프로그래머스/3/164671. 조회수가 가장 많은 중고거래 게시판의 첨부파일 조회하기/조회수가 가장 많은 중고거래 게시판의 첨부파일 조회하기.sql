SELECT '/home/grep/src/' || UGF.BOARD_ID||'/'||UGF.FILE_ID||UGF.FILE_NAME||UGF.FILE_EXT AS FILE_PATH
FROM USED_GOODS_FILE UGF
JOIN (
    SELECT BOARD_ID, VIEWS
    FROM USED_GOODS_BOARD UGB
    ORDER BY VIEWS DESC
    FETCH FIRST 1 ROWS ONLY
) TMP
ON TMP.BOARD_ID = UGF.BOARD_ID
ORDER BY UGF.FILE_ID DESC

