package com.example.notebookdell.wifi;

import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button btnDt;
    WifiManager wifiManager;
    TextView txtStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnAtv);
        btnDt = (Button) findViewById(R.id.btnDt);
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);


    }
    public void ativar(View view){
        wifiManager.setWifiEnabled(true);
    }

    public void desativar (View view){
        wifiManager.setWifiEnabled(false);
    }

    public void status (View view){
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();
        String macAddress = wifiInfo.getMacAddress();
        String bssid = wifiInfo.getBSSID();
        int rssi = wifiInfo.getRssi();
        int linkspeed = wifiInfo.getLinkSpeed();
        String ssid = wifiInfo.getSSID();
        int networkId = wifiInfo.getNetworkId();
        String ipAddress = Formatter.formatIpAddress(ip);
        String info = "ipAddress:" + ipAddress +
                "\n" + "MacAddres:" + macAddress +
                "\n" + "BSSID:" + bssid +
                "\n" + "SSID:" + ssid +
                "\n" + "Networkid" + networkId +
                "\n" + "RSSI" + rssi +
                "\n" + "Linkspeed" + linkspeed;

        txtStatus.setText(info);

    }
}
