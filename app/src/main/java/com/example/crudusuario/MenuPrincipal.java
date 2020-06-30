package com.example.crudusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {

    private Button btUsuarioMenu;
    private Button btSairMenu;
    private int contagem = 0;
    private TextView texto = new TextView(this);
    private Button contagemProgressiva = new Button(this);
    private TextView text;
    private TextView txtMonstrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        contagemProgressiva = findViewById(R.id.contagemProgressiva);
        btSairMenu = findViewById(R.id.btSairMenu);
        btUsuarioMenu = findViewById(R.id.btUsuarioMenu);
        text = findViewById(R.id.text);
        txtMonstrar = findViewById(R.id.txtMonstrar);

        contagemProgressiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),notificacaoB.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0, intent,0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                long tempo = System.currentTimeMillis();
                long tempoNotificacao = 1000*3600;
                //alarmManager.set(AlarmManager.RTC_WAKEUP,tempo,tempoNotificacao,PendingIntent);
                contagem++;
                text.setText("Contagem atual: " + contagem);
            }
        });

        notificacaoCanal();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            txtMonstrar.setText(bundle.getString("NomeUsuario"));
        }
        btUsuarioMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, MainActivity.class));
                finish();
            }
        });

        btSairMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, TelaAutenticacao.class));
                finish();
            }
        });

    }

    private void notificacaoCanal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Notificacao", "LAVE AS MÃOS",NotificationManager.IMPORTANCE_DEFAULT );
            channel.setDescription("CANAL TEXT");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
