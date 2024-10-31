package com.example.shopping_list.data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



val Context.dataStore by preferencesDataStore(name = "SHOPPING_LIST_DATA_STORE")

object PreferencesKeys {
    val NAME_KEY = stringPreferencesKey("user_name_key")
    val LAST_NAME_KEY = stringPreferencesKey("last_name_key")
    val AGE_KEY = stringPreferencesKey("age_key")
}
suspend fun <T> saveToDataStore(context: Context, value: T, key: Preferences.Key<T>) {
    context.dataStore.edit { preferences ->
        preferences[key] = value
    }
}
fun <T> getFromDataStore(context: Context, key: Preferences.Key<T>): Flow<T?> {
    return context.dataStore.data
        .map { preferences ->
            preferences[key]
        }
}