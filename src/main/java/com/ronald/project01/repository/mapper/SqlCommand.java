package com.ronald.project01.repository.mapper;

public final class SqlCommand {

//    Long customerId; String productName; Integer offset, Integer limit
    public static final String Get_DetailCartItem_By_ProductName_And_Offset_And_Limit = "SELECT product_name, quantity_wished, total_amount, date_added FROM \n" +
            "           customer\n" +
            "           INNER JOIN \n" +
            "           cart  ON  customer.cart_id = cart.cart_id\n" +
            "           INNER JOIN\n" +
            "           cart_item ON cart.cart_id = cart_item.cart_id\n" +
            "           INNER JOIN \n" +
            "           product ON cart_item.product_id = product.product_id \n" +
            "WHERE UPPER(product_name) like UPPER(#{productName}) AND customer.customer_id = #{customerId} \n" +
            "ORDER BY DATE_ADDED DESC \n" +
            "OFFSET #{offset} ROWS \n" +
            "FETCH NEXT #{limit} ROWS ONLY";
}
