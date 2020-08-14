package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean validador = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        binding.boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validador) {
                    mostrarFragmento();
                } else {
                    cerrarFragmento(view);
                }
            }
        });
    }

    private void mostrarFragmento() {
        //Genero la instancia del fragmento gracias al factoory metod
        FirstFragment firstFragment = FirstFragment.newInstance("", "");
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