package io.github.rianjara.customcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.rianjara.R;
import io.github.rianjara.controls.ControlLogin;
import io.github.rianjara.interfaces.OnLoginLister;

public class MainActivity extends AppCompatActivity {

    private ControlLogin ctrl_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctrl_login = (ControlLogin)findViewById(R.id.ctrl_login);
        ctrl_login.setListener(new OnLoginLister() {
            @Override
            public void onLogin(String usuario, String password) {
                if( usuario.equals("demo") && password.equals("demo") ){
                    ctrl_login.setMensaje("Login Success!");
                }else{
                    ctrl_login.setMensaje("Error de usuario o password");
                }
            }
        });

    }
}
