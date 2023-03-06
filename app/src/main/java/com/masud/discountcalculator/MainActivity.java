package com.masud.discountcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.masud.discountcalculator.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
            }
        });

    }

    private void checkValidation() {
        String percent = binding.percentET.getEditText().getText().toString().trim();
        String price = binding.priceET.getEditText().getText().toString().trim();

        if (TextUtils.isEmpty(percent)){
           binding.percentET.setError("Field can't be empty.");
           return;
        }
        if (TextUtils.isEmpty(price)){
            binding.priceET.setError("Field can't be empty.");
            return;
        }

        calculate(percent,price);
    }

    private void calculate(String myPercent, String myPrice) {
        binding.percentET.setError(null);
        binding.priceET.setError(null);

        double doublePercent = Double.parseDouble(myPercent);
        double hundred = 100.00;
        double doubleMyPrice = Double.parseDouble(myPrice);

        double dividedResult = doublePercent/hundred;

        double result = dividedResult*doubleMyPrice;

        int intResult = (int) result;


        binding.resultTV.setText("Reduce "+intResult+" from your original price.");




    }


}