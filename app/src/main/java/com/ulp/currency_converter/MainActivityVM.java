package com.ulp.currency_converter;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class MainActivityVM extends AndroidViewModel {
    private MutableLiveData<Double> result;

    private MutableLiveData<String> currency;
    private final Double multiplyVal = 1.24;

    public MainActivityVM(@NonNull Application application) {
        super(application);
        result = new MutableLiveData<>();
        currency = new MutableLiveData<>();
    }

    public Double getResult(Double value){
        Log.d("lo que llega:", value.toString());
        if(currency.getValue() == "USD")
            return value * multiplyVal;
        else
            return value / multiplyVal;
    }

    public void setCurrency(String newCurrency){
        currency.setValue(newCurrency);
    }

    public String getCurrency() {
        return currency.getValue();
    }
}
