package com.example.android.taller1_empresazxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Principal extends AppCompatActivity {
    private EditText cajaCantidad;
    private TextView cajaResultado, cajaVrUnitario;
    private Spinner comboGenero, comboTipoC, comboMarca;
    private String[] opc_gen, opc_tip, opc_mar;
    private ArrayAdapter adapter_gen, adapter_tip, adapter_mar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaCantidad = (EditText)findViewById(R.id.txtCantidad);
        cajaResultado = (TextView)findViewById(R.id.txtResultado);
        cajaVrUnitario = (TextView)findViewById(R.id.txtValorUnitario);
        comboGenero = (Spinner)findViewById(R.id.cmbSexo);
        comboTipoC = (Spinner)findViewById(R.id.cmbTipoZapato);
        comboMarca = (Spinner)findViewById(R.id.cmbMarca);

        opc_gen = this.getResources().getStringArray(R.array.opc_genero);
        opc_tip = this.getResources().getStringArray(R.array.opc_tipo);
        opc_mar = this.getResources().getStringArray(R.array.opc_marca);
        adapter_gen = new ArrayAdapter(this,android.R.layout.simple_list_item_1, opc_gen);
        adapter_tip = new ArrayAdapter(this,android.R.layout.simple_list_item_1, opc_tip);
        adapter_mar = new ArrayAdapter(this,android.R.layout.simple_list_item_1, opc_mar);

        comboGenero.setAdapter(adapter_gen);
        comboTipoC.setAdapter(adapter_tip);
        comboMarca.setAdapter(adapter_mar);
    }

    public void calcular (View v) {
        int op_g, op_t, op_m;
        double cant, res = 0;

        if (validar()) {
            cant = Double.parseDouble(cajaCantidad.getText().toString());
            op_g = comboGenero.getSelectedItemPosition();
            op_t = comboTipoC.getSelectedItemPosition();
            op_m = comboMarca.getSelectedItemPosition();

            switch (op_g) {
                case 0:
                    switch (op_t) {
                        case 0:
                            switch (op_m) {
                                case 0:
                                    res = 120000 * cant;
                                    break;
                                case 1:
                                    res = 140000 * cant;
                                    break;
                                case 2:
                                    res = 130000 * cant;
                                    break;
                            }
                            break;
                        case 1:
                            switch (op_m) {
                                case 0:
                                    res = 50000 * cant;
                                    break;
                                case 1:
                                    res = 80000 * cant;
                                    break;
                                case 2:
                                    res = 100000 * cant;
                                    break;
                            }
                            break;
                    }
                    break;
                case 1:
                    switch (op_t) {
                        case 0:
                            switch (op_m) {
                                case 0:
                                    res = 100000 * cant;
                                    break;
                                case 1:
                                    res = 130000 * cant;
                                    break;
                                case 2:
                                    res = 110000 * cant;
                                    break;
                            }
                            break;
                        case 1:
                            switch (op_m) {
                                case 0:
                                    res = 60000 * cant;
                                    break;
                                case 1:
                                    res = 70000 * cant;
                                    break;
                                case 2:
                                    res = 120000 * cant;
                                    break;
                            }
                            break;
                    }
                    break;
            }

            cajaVrUnitario.setText("$ " + res / cant + "0");
            cajaResultado.setText("$ " + res + "0");
        }
    }

    public void borrar(View v){
        cajaCantidad.setText("");
        cajaCantidad.requestFocus();
        cajaResultado.setText("");
        cajaVrUnitario.setText("");
    }

    public boolean validar(){
        if(cajaCantidad.getText().toString().isEmpty()){
            cajaCantidad.requestFocus();
            cajaCantidad.setError(this.getResources().getString(R.string.error_cant));
            return false;
        }
        if(Integer.parseInt(cajaCantidad.getText().toString())==0){
            cajaCantidad.requestFocus();
            cajaCantidad.setError(this.getResources().getString(R.string.error_cant_cero));
            return false;
        }
        return true;
    }

}
