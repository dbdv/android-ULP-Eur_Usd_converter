package com.ulp.currency_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button convertBtn;
    private TextView inputDolar, inputEuro, resultView;
    private RadioGroup options;
    private RadioButton optionEur, optionDolar;
    private MainActivityVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setEvents();
    }

    private void initialize(){
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityVM.class);
        convertBtn = findViewById(R.id.convertBtn);
        inputDolar = findViewById(R.id.dolarInput);
        inputEuro = findViewById(R.id.euroInput);
        resultView = findViewById(R.id.euroInput2);
        options = findViewById(R.id.radioGroup);
        optionDolar = findViewById(R.id.radioDolar);
        optionEur = findViewById(R.id.radioEuros);
    }

    private void setEvents(){

        optionDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("entro a", "click radio");
                onRadioButtonClicked(view);
            }
        });

        optionEur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("entro a", "click radio");
                onRadioButtonClicked(view);
            }
        });

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioDolar:
                Log.d("entro a", "dolar");
                if (checked) viewModel.setCurrency("USD");
                break;
            case R.id.radioEuros:
                Log.d("entro a", "euro");
                if (checked) viewModel.setCurrency("EUR");
                break;
        }
    }

    public void onButtonClicked(){

        if(viewModel.getCurrency() == "USD")
            resultView.setText(viewModel.getResult(Double.parseDouble(inputEuro.getText().toString())).toString());
        else
            resultView.setText(viewModel.getResult(Double.parseDouble(inputDolar.getText().toString())).toString());

    }

}