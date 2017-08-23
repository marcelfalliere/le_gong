package fr.fmf.legong.legong;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Set;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    final String TAG = "LEGONG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothProfile.ServiceListener serviceListener = new BluetoothProfile.ServiceListener() {
            @Override
            public void onServiceConnected(int profile, BluetoothProfile bluetoothProfile) {
                Log.d(TAG,  String.format("Service connected %s", String.valueOf(profile)));
            }

            @Override
            public void onServiceDisconnected(int profile) {
                Log.d(TAG,  String.format("Service disconnected %s", String.valueOf(profile)));
            }
        };

        Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
        Log.d(TAG, String.format("Number of device paired : %s", String.valueOf(bondedDevices.size())));
        String ARDUINO_ADDRESS = " 00:14:03:06:2D:43";
        for (BluetoothDevice device : bondedDevices) {
            Log.d(TAG, String.format("Device address : %s And name : %s", device.getAddress(), device.getName()));
            if (device.getAddress().equals(ARDUINO_ADDRESS)) {
                Log.d(TAG, "Device found");
            }
        }
        

    }
}
