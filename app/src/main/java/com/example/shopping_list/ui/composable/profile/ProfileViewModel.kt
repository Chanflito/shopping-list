package com.example.shopping_list.ui.composable.profile

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping_list.data.PreferencesKeys
import com.example.shopping_list.data.getFromDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    @ApplicationContext val context: Context,
) : ViewModel(){
    private var _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private var _lastName=MutableStateFlow("")
    val lastName = _lastName.asStateFlow()

    private var _age= MutableStateFlow("")
    val age= _age.asStateFlow()

    init {
        getNameFromDataStore()
        getLastNameFromDataStore()
        getAgeFromDataStore()
    }
    private fun getNameFromDataStore() {
        viewModelScope.launch {
            getFromDataStore(context, PreferencesKeys.NAME_KEY).collect {
                _name.value = it ?: ""
            }
        }
    }

    private fun getLastNameFromDataStore() {
        viewModelScope.launch {
            getFromDataStore(context, PreferencesKeys.LAST_NAME_KEY).collect {
                _lastName.value = it ?: ""
            }
        }
    }

    private fun getAgeFromDataStore() {
        viewModelScope.launch {
            getFromDataStore(context, PreferencesKeys.AGE_KEY).collect {
                _age.value = it ?: ""
            }
        }
    }

    fun saveNameToDataStore(name: String) {
        viewModelScope.launch {
            com.example.shopping_list.data.saveToDataStore(context, name, PreferencesKeys.NAME_KEY)
            _name.value = name
        }
    }

    fun saveLastNameToDataStore(lastName: String) {
        viewModelScope.launch {
            com.example.shopping_list.data.saveToDataStore(context, lastName, PreferencesKeys.LAST_NAME_KEY)
            _lastName.value = lastName
        }
    }

    fun saveAgeToDataStore(age: String) {
        viewModelScope.launch {
            com.example.shopping_list.data.saveToDataStore(context, age, PreferencesKeys.AGE_KEY)
            _age.value = age
        }
    }
}