package com.example.shopping_list.ui.composable.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import com.example.shopping_list.R
import com.example.shopping_list.ui.theme.AddToShoppingListCardColor
import com.example.shopping_list.ui.theme.addToShoppingListCardColumnPadding
import com.example.shopping_list.ui.theme.addToShoppingListCardElevation
import com.example.shopping_list.ui.theme.addToShoppingListCardPadding
import com.example.shopping_list.ui.theme.spacerHeight

@Composable
fun TotalPriceCard(totalPrice: Double) {
    Card(
        modifier = Modifier
            .padding(addToShoppingListCardPadding)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(addToShoppingListCardElevation),
        colors = CardDefaults.cardColors(containerColor = AddToShoppingListCardColor)
    ) {
        Column(
            modifier = Modifier.padding(addToShoppingListCardColumnPadding),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.total_price),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "$${"%.2f".format(totalPrice)}",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.height(spacerHeight))

        }
    }
}
