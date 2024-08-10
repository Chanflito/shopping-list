package com.example.shopping_list.nav

enum class NavPath(private val path: String) {
    HOME("home"),
    CART("cart"),
    ORDER("order");

    override fun toString(): String {
        return path
    }
}