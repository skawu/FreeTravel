package cn.com.linuxc.freetravel;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

public class MasterActivity extends AppCompatActivity {

    private Switch ble_on_off;
    private ListView device_list;
    private BluetoothManager mBluetoothManager;
    private BluetoothAdapter mBluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        ble_on_off = (Switch) findViewById(R.id.ble_switch);
        device_list = (ListView) findViewById(R.id.listview_device);



        // 蓝牙开关监听
        ble_on_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isClicked) {
                if(isClicked) {             // 打开蓝牙
                    // 判断系统是否支持蓝牙BLE
                    if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
                        Log.e("FreeTravel","Device Not Support BLE");
                        finish();
                    }

                    // 获取蓝牙服务
                    mBluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
                    if(null == mBluetoothManager) {
                        Log.e("FreeTravel", "Unable to Initialize BluetoothManager");
                        return;
                    }

                    mBluetoothAdapter = mBluetoothManager.getAdapter();
                    if (mBluetoothAdapter == null) {
                        Log.e("FreeTravel", "Unable to obtain a BluetoothAdapter.");
                        return ;
                    }

                    if(!mBluetoothAdapter.isEnabled()) {
//                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                        startActivityForResult(enableBtIntent, 1);
                    }
                } else {                    // 关闭蓝牙

                }
            }
        });
    }
}
