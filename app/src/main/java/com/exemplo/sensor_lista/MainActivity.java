package com.exemplo.sensor_lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Componentes a serem manipulados
    private Button buttonListar;
    private Button buttonFechar;
    private TextView textViewLista;

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associa os componentes da interface aos componentes da classe
        buttonListar = findViewById(R.id.buttonListar);
        textViewLista = findViewById(R.id.textViewLista);
        buttonFechar = findViewById(R.id.buttonFechar);

        //Recupera o gerenciador de sensores
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
    }

    public void onClickBotaoListar(View v) {
        // Retorna uma lista com os sensores
        List<Sensor> lista = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        // Cria o iterator para percorrer os sensores
        Iterator<Sensor> iterator = lista.iterator();
        String saida = "";
        // Percorre todos os sensores
        while (iterator.hasNext()) {
            // Recupera um sensor
            Sensor sensor = iterator.next();
            // Concatena o nome do sensor
            saida += " - " + sensor.getName() + "\n";
        }
        // Coloca a string com os nomes dos sensores no textview
        textViewLista.setText(saida);
    }

    public void onClickBotaoFechar(View v) {
        System.exit(0);
    }
}