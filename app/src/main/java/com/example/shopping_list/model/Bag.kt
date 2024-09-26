package com.example.shopping_list.model

import java.util.UUID

data class Bag(val id: UUID, val products: List<Product>)