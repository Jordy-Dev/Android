package com.example.app2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputTemperature, inputCurrency, inputLength;
    private Spinner spinnerTemperatureFrom, spinnerTemperatureTo;
    private Spinner spinnerCurrencyFrom, spinnerCurrencyTo;
    private Spinner spinnerLengthFrom, spinnerLengthTo;
    private TextView resultTemperature, resultCurrency, resultLength;
    private Button btnConvertTemperature, btnConvertCurrency, btnConvertLength, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTemperature = findViewById(R.id.input_temperature);
        inputCurrency = findViewById(R.id.input_currency);
        inputLength = findViewById(R.id.input_length);

        spinnerTemperatureFrom = findViewById(R.id.spinner_temperature_from);
        spinnerTemperatureTo = findViewById(R.id.spinner_temperature_to);
        spinnerCurrencyFrom = findViewById(R.id.spinner_currency_from);
        spinnerCurrencyTo = findViewById(R.id.spinner_currency_to);
        spinnerLengthFrom = findViewById(R.id.spinner_length_from);
        spinnerLengthTo = findViewById(R.id.spinner_length_to);

        resultTemperature = findViewById(R.id.result_temperature);
        resultCurrency = findViewById(R.id.result_currency);
        resultLength = findViewById(R.id.result_length);

        btnConvertTemperature = findViewById(R.id.btn_convert_temperature);
        btnConvertCurrency = findViewById(R.id.btn_convert_currency);
        btnConvertLength = findViewById(R.id.btn_convert_length);
        btnClear = findViewById(R.id.btn_clear);

        // Configurar los Spinners
        setupTemperatureSpinners();
        setupCurrencySpinners();
        setupLengthSpinners();

        // Configurar botones de conversión
        btnConvertTemperature.setOnClickListener(view -> convertTemperature());
        btnConvertCurrency.setOnClickListener(view -> convertCurrency());
        btnConvertLength.setOnClickListener(view -> convertLength());

        // Configurar botón limpiar
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Limpiar solo los resultados (TextViews)
                resultTemperature.setText("Resultado:");
                resultCurrency.setText("Resultado:");
                resultLength.setText("Resultado:");
            }
        });
    }

    private void setupTemperatureSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemperatureFrom.setAdapter(adapter);
        spinnerTemperatureTo.setAdapter(adapter);
    }

    private void setupCurrencySpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrencyFrom.setAdapter(adapter);
        spinnerCurrencyTo.setAdapter(adapter);
    }

    private void setupLengthSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.length_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLengthFrom.setAdapter(adapter);
        spinnerLengthTo.setAdapter(adapter);
    }

    private void convertTemperature() {
        String input = inputTemperature.getText().toString();
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            String fromUnit = spinnerTemperatureFrom.getSelectedItem().toString();
            String toUnit = spinnerTemperatureTo.getSelectedItem().toString();

            // Conversión de temperatura (puedes añadir más lógicas de conversión según sea necesario)
            if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
                resultTemperature.setText(String.format("Resultado: %.2f °F", value * 9 / 5 + 32));
            } else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
                resultTemperature.setText(String.format("Resultado: %.2f °K", value + 273.15));
            }
            // Aquí agregas las demás conversiones necesarias
        } else {
            Toast.makeText(this, "Por favor ingrese un valor", Toast.LENGTH_SHORT).show();
        }
    }

    private void convertCurrency() {
        String input = inputCurrency.getText().toString();
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            String fromCurrency = spinnerCurrencyFrom.getSelectedItem().toString();
            String toCurrency = spinnerCurrencyTo.getSelectedItem().toString();

            // Conversión de moneda (puedes añadir más lógicas de conversión según sea necesario)
            if (fromCurrency.equals("Soles") && toCurrency.equals("Dólares")) {
                resultCurrency.setText(String.format("Resultado: %.2f USD", value / 3.8));
            }
            // Aquí agregas las demás conversiones necesarias
        } else {
            Toast.makeText(this, "Por favor ingrese un monto", Toast.LENGTH_SHORT).show();
        }
    }

    private void convertLength() {
        String input = inputLength.getText().toString();
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            String fromLength = spinnerLengthFrom.getSelectedItem().toString();
            String toLength = spinnerLengthTo.getSelectedItem().toString();

            // Conversión de longitud (puedes añadir más lógicas de conversión según sea necesario)
            if (fromLength.equals("Centímetros") && toLength.equals("Metros")) {
                resultLength.setText(String.format("Resultado: %.2f Metros", value / 100));
            }
            // Aquí agregas las demás conversiones necesarias
        } else {
            Toast.makeText(this, "Por favor ingrese un valor", Toast.LENGTH_SHORT).show();
        }
    }
}
