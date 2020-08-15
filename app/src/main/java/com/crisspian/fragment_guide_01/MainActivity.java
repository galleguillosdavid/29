package com.crisspian.fragment_guide_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    private ActivityMainBinding binding;
    private boolean validador = false;
    public static final String KEY_ONE = "KEY_ONE";
    public static final String KEY_TWO = "KEY_TWO";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(KEY_ONE, validador);
        outState.putString(KEY_TWO, String.valueOf(validador));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState !=null) {
            validador = savedInstanceState.getBoolean(KEY_ONE,validador);
        } else {

        }




        binding.boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validador) {
                    mostrarFragmento("wenna loco");
                } else {
                    cerrarFragmento(view);
                }
            }
        });
    }

    private void mostrarFragmento(String saludo) {
        //Genero la instancia del fragmento gracias al factoory metod
        FirstFragment firstFragment = FirstFragment.newInstance(saludo);
        //obtener instancias del fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Obtener e instanciamos la una transaccion
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, firstFragment).addToBackStack(null).commit();
        binding.boton1.setText("desaparece Picachu");
        validador = true;
    }


    public void cerrarFragmento(View view) {
        this.onBackPressed();
        binding.boton1.setText("Aparece Picachu");
        validador = false;
    }
}