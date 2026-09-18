SELECT
    info.ITEM_ID,
    info.ITEM_NAME,
    info.RARITY
FROM
    ITEM_INFO as info
WHERE
    info.ITEM_ID IN (
        SELECT
            tree.ITEM_ID
        FROM
            ITEM_TREE as tree
        WHERE
            tree.ITEM_ID IN (
                SELECT
                    tree.ITEM_ID
                FROM
                    ITEM_TREE as tree
                JOIN
                    ITEM_INFO as info
                WHERE
                    tree.PARENT_ITEM_ID = info.ITEM_ID AND
                    info.RARITY = "RARE"
            )
    )
ORDER BY
    ITEM_ID DESC