package io.github.rianjara.controls;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.github.rianjara.R;
import io.github.rianjara.interfaces.OnLoginLister;

/**
 * Created by richard.jara on 16/07/2016.
 */
public class ControlLogin extends LinearLayout {

    private EditText txtUsuario, txtPassword;
    private Button btnLogin;
    private TextView lblMensaje;
    private OnLoginLister listener;

    public void setMensaje(String mensaje) {
        this.lblMensaje.setText(mensaje);
    }

    public void setListener(OnLoginLister listener) {
        this.listener = listener;
    }

    public ControlLogin(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializar();

        TypedArray tArray = getContext().obtainStyledAttributes(attrs, R.styleable.ControlLogin);
        String btn_value = tArray.getString(R.styleable.ControlLogin_login_text);

        btnLogin.setText(btn_value);
        tArray.recycle();
    }

    private void inicializar() {
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.control_login,this, true);

        txtUsuario = (EditText)findViewById(R.id.txt_usuario);
        txtPassword = (EditText)findViewById(R.id.txt_password);
        btnLogin = (Button)findViewById(R.id.btn_login);
        lblMensaje = (TextView)findViewById(R.id.lbl_mensaje);

        asignarEventos();
    }

    private void asignarEventos() {
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLogin(txtUsuario.getText().toString(),txtPassword.getText().toString());
            }
        });
    }
}
