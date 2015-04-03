package com.damaja.cocktailmixxer;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.damaja.cocktailmixxer.Components.BluetoothSerialService;
import com.damaja.cocktailmixxer.Components.CM_Status;
import com.damaja.cocktailmixxer.Components.RowItem;
import com.damaja.cocktailmixxer.MainContent.PanelContent;
import com.damaja.cocktailmixxer.MainContent.PanelSlideUp;

import java.util.List;


public class MainActivity extends ActionBarActivity {


    /*OLD STUFF*/
    // Layout view
    private TextView mTitle;

    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;

    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothCommandService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    // Name of the connected device
    private String mConnectedDeviceName = null;
    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter = null;
    // Member object for Bluetooth Command Service
    private BluetoothSerialService mCommandService = null;



    @Override
    protected void onStart() {
        super.onStart();
        if (mCommandService==null)
            setupCommand();
    }

    CM_Status status;

    Spinner spinnerUser;
    List<RowItem> users;
    public final static String APP_PATH_SD_APPLICATION = "/cocktailmixxer/";
    static String fullPath = Environment.getExternalStorageDirectory()
            .getAbsolutePath() + APP_PATH_SD_APPLICATION;



    @Override
    protected void onStop() {
        status.saveAll();			// User, Status, Cocktails, Säfte(_intern) werden auf dem Speicher gesichert.
        super.onDestroy();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        status = (CM_Status) getApplicationContext();
        //setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content_main, PanelContent.newInstance(), PanelContent.getTAG()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content_slideup, PanelSlideUp.newInstance(), PanelSlideUp.getTAG()).commit();


    }



//    private final Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case MESSAGE_STATE_CHANGE:
//                    switch (msg.arg1) {
//                        case BluetoothSerialService.STATE_CONNECTED:
//                            mTitle.setText(R.string.title_connected_to);
//                            mTitle.append(mConnectedDeviceName);
//                            mTitle.setTextColor(Color.GREEN);
//                            break;
//                        case BluetoothSerialService.STATE_CONNECTING:
//                            mTitle.setText(R.string.title_connecting);
//                            mTitle.setTextColor(Color.YELLOW);
//                            break;
//                        case BluetoothSerialService.STATE_LISTEN:
//                        case BluetoothSerialService.STATE_NONE:
//                            mTitle.setText(R.string.title_not_connected);
//                            mTitle.setTextColor(Color.RED);
//                            break;
//                    }
//                    break;
//                case MESSAGE_DEVICE_NAME:
//                    // save the connected device's name
//                    mConnectedDeviceName = msg.getData().getString(DEVICE_NAME);
//                    Toast.makeText(getApplicationContext(), "Connected to "
//                            + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
//                    break;
//                case MESSAGE_TOAST:
//                    Toast.makeText(getApplicationContext(), msg.getData().getString(TOAST),
//                            Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//    };
//
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode) {
//            case REQUEST_CONNECT_DEVICE:
//                // When DeviceListActivity returns with a device to connect
//                if (resultCode == Activity.RESULT_OK) {
//                    // Get the device MAC address
//                    String address = data.getExtras()
//                            .getString(ActivityBluetooth.EXTRA_DEVICE_ADDRESS);
//                    // Get the BLuetoothDevice object
//                    BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
//                    // Attempt to connect to the device
//                    mCommandService.connect(device);
//                }
//                break;
//            case REQUEST_ENABLE_BT:
//                // When the request to enable Bluetooth returns
//                if (resultCode == Activity.RESULT_OK) {
//                    // Bluetooth is now enabled, so set up a chat session
//                    setupCommand();
//                } else {
//                    // User did not enable Bluetooth or an error occured
//                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//        }
//    }
private final Handler mHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MESSAGE_STATE_CHANGE:
//                switch (msg.arg1) {
//                    case BluetoothSerialService.STATE_CONNECTED:
//                        mTitle.setText(R.string.title_connected_to);
//                        mTitle.append(mConnectedDeviceName);
//                        mTitle.setTextColor(Color.GREEN);
//                        break;
//                    case BluetoothSerialService.STATE_CONNECTING:
//                        mTitle.setText(R.string.title_connecting);
//                        mTitle.setTextColor(Color.YELLOW);
//                        break;
//                    case BluetoothSerialService.STATE_LISTEN:
//                    case BluetoothSerialService.STATE_NONE:
//                        mTitle.setText(R.string.title_not_connected);
//                        mTitle.setTextColor(Color.RED);
//                        break;
//                }
//                break;
//            case MESSAGE_DEVICE_NAME:
//                // save the connected device's name
//                mConnectedDeviceName = msg.getData().getString(DEVICE_NAME);
//                Toast.makeText(getApplicationContext(), "Connected to "
//                        + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
//                break;
//            case MESSAGE_TOAST:
//                Toast.makeText(getApplicationContext(), msg.getData().getString(TOAST),
//                        Toast.LENGTH_SHORT).show();
//                break;
        }
    }
};
    private void setupCommand() {
        // Initialize the BluetoothChatService to perform bluetooth connections
        mCommandService = new BluetoothSerialService(this, mHandler);
        status.setBTservice(mCommandService);
    }

}
