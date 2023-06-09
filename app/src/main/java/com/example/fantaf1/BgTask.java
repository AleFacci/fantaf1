package com.example.fantaf1;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.fantaf1.network.F1APIservice;

import org.json.JSONObject;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class BgTask {
    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());
    private String action = null;
    private JSONObject data = null;

    public BgTask(Gestore g, String... params){
        executor.execute(() -> {
            switch (params[0]) {
                case "client":
                    action = params[0];
                    //fetching data from api
                    F1APIservice f1APIservice = new F1APIservice();
                    data = f1APIservice.fetchData(params[1]+"/results.json");
                    //g.getContext().runOnUiThread(()-> Toast.makeText(g.getContext(),f1APIservice.fetchData() , Toast.LENGTH_SHORT).show());
                    break;
                default:
                    break;
            }

            handler.post(() ->{
                switch (action){
                    default:
                        break;
                }
            });
        });
    }
}
