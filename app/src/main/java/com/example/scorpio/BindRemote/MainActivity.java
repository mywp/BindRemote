package com.example.scorpio.BindRemote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.scorpio.RemoteService.IMiddlePerson;


public class MainActivity extends AppCompatActivity {

    private MyConn conn;
    private IMiddlePerson iMp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bind(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.scorpio.RemoteService");
        conn = new MyConn();
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void unbind(View view) {
        unbindService(conn);
    }

    public void call(View view) {

        try{
            iMp.callMethodInService();
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
       unbindService(conn);
        super.onDestroy();
    }

    private class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMp=IMiddlePerson.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
