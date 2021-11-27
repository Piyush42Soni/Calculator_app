package com.example.calculator.body

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Math.exp
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException


class BodyViewModel:ViewModel() {
    private val _word=MutableLiveData<String>()
    val word:LiveData<String>
    get()=_word
    init{
        _word.value="0"
    }
    fun number(i:Int){
        _word.value=_word.value+i.toString()
    }
    fun other(i:Char){
        if (_word.value.isNullOrEmpty()) {
            _word.value="0"
        }
        if((_word.value?.get(_word.value!!.length-1)?.isDigit() == true)){
            _word.value=_word.value+i.toString()
        }
        else{
            _word.value="0"
        }
    }
    fun dot() {
        if (_word.value.isNullOrEmpty()) {
            _word.value="0"
        }
        if ((_word.value?.last()?.isDigit() == true) == true and (!_word.value?.toString()
                ?.contains('.')!!)
        ) {
            _word.value = _word.value + "."
        } else {
            _word.value = "0"
        }
    }
    fun CE(){
        _word.value="0"
    }
    fun equal(){
        if(_word.value.toString().isNotEmpty()){
            val engine = ScriptEngineManager().getEngineByName("rhino")
            val x=engine.eval(_word.value)
            _word.value=x.toString()
        }
        else{
            _word.value="0"
        }
    }
    fun Exp_(){
        val engine = ScriptEngineManager().getEngineByName("rhino")
        val x=exp((engine.eval(_word.value)).toString().toDouble())
        _word.value=x.toString()
    }
    override fun onCleared() {
        super.onCleared()
    }
}