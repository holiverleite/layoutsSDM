package br.edu.ifsp.scl.sdm.layoutssdm;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import static br.edu.ifsp.scl.sdm.layoutssdm.R.layout.frame_layout_activity_main;
import static br.edu.ifsp.scl.sdm.layoutssdm.R.layout.relative_layout_activity_main;

public class MainActivity extends AppCompatActivity {
    private final String ESTADO_NOTIFICACAO_CHECKBOX = "ESTADO_NOTIFICACAO_CHECKBOX";
    private final String NOTIFICACAO_RADIOBUTTON_SELECTED = "NOTIFICACAO_RADIOBUTTON_SELECTED";

    private CheckBox notificacoesCheckBox;
    private RadioGroup notificacoesRadioGroup;
    private EditText nomeEditText;
    private EditText emailEditText;
    private EditText telefoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(relative_layout_activity_main);

        // Referencia para view
        notificacoesCheckBox = findViewById(R.id.notificacoesCheckBox);
        notificacoesRadioGroup = findViewById(R.id.notificacoesRadioGoup);
        nomeEditText = findViewById(R.id.nomeEditText);
        telefoneEditText = findViewById(R.id.telefoneEditText);
        emailEditText = findViewById(R.id.emailEditText);

//         Tratando evento de checkbox
        notificacoesCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    notificacoesRadioGroup.setVisibility(View.VISIBLE);
                } else {
                    notificacoesRadioGroup.setVisibility(View.GONE);
                }
            }
        });
//
//        notificacoesCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    notificacoesRadioGroup.setVisibility(View.VISIBLE);
//                } else {
//                    notificacoesRadioGroup.setVisibility(View.GONE);
//                }
//            }
//        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putBoolean(ESTADO_NOTIFICACAO_CHECKBOX, notificacoesCheckBox.isChecked());
        outState.putInt(NOTIFICACAO_RADIOBUTTON_SELECTED,notificacoesRadioGroup.getCheckedRadioButtonId());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        notificacoesCheckBox.setChecked(savedInstanceState.getBoolean(ESTADO_NOTIFICACAO_CHECKBOX,false));
        int idRadioButtonSelecionado = savedInstanceState.getInt(NOTIFICACAO_RADIOBUTTON_SELECTED,-1);
        if (idRadioButtonSelecionado != -1) {
            notificacoesRadioGroup.check(idRadioButtonSelecionado);
        }
    }

    public void limparFormulario(View view) {
        nomeEditText.setText("");
        emailEditText.setText("");
        telefoneEditText.setText("");
        notificacoesRadioGroup.clearCheck();
        notificacoesCheckBox.setChecked(false);
        nomeEditText.requestFocus();
    }
}
