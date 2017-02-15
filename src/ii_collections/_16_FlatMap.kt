package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap(String::toList)

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products ordered by customer
    return orders.flatMap(Order::products).toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
    return customers.flatMap { it.orderedProducts }.toSet()
}
