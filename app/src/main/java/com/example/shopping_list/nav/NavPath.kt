package com.example.shopping_list.nav

enum class NavPath(private val path: String) {
    HOME("home"),
    CART("cart"),
    FAVORITE("favorite"),
    PRODUCT_DETAIL("productDetail"),
    PROFILE("profile");

    override fun toString(): String {
        return path
    }
}