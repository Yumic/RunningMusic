package yumic.diverbob.love.runningmusicviewpager;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Oathkeeper on 2016/2/29.
 */
public class MusicService extends Service {

    private static final String ACTION_PLAY = "love.diverbob.action.PLAY";
    private static final String ACTION_PAUSE = "love.diverbob.action.PAUSE";
    private static final String ACTION_STOP = "love.diverbob.action.STOP";



    //为日志工具设置标签
    private static String TAG = "MusicService";
    //定义音乐播放器变量
    private MediaPlayer mediaPlayer;

    //其他对象通过bindService 方法通知该Service时该方法被调用
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "MusicSevice onBind()"
                , Toast.LENGTH_SHORT).show();
        Log.e(TAG, "MusicSerice onBind()");

        return null;
    }

    //其它对象通过unbindService方法通知该Service时该方法被调用
    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "MusicSevice onUnbind()"
                , Toast.LENGTH_SHORT).show();
        Log.e(TAG, "MusicSerice onUnbind()");

        mediaPlayer.stop();

        return super.onUnbind(intent);
    }



    //该服务不存在需要被创建时被调用，不管startService()还是bindService()都会启动时调用该方法
        @Override
        public void onCreate() {
            Toast.makeText(this, "MusicSevice onCreate()"
                    , Toast.LENGTH_SHORT).show();
            Log.e(TAG, "MusicSerice onCreate()");

//            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.coldplay);
//            //设置可以重复播放
//            mediaPlayer.setLooping(true);
            super.onCreate();
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {

            Log.e(TAG, "MusicSerice onStart()");

            if (intent.getAction().equals(ACTION_PLAY)) {

                mediaPlayer = MediaPlayer.create(this, R.raw.coldplay);

                // mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
                mediaPlayer.start();
                Log.d(TAG,"play");
            }
            if (intent.getAction().equals(ACTION_PAUSE)) {

                mediaPlayer.pause();
                Log.d(TAG, "pause");
            }
            if (intent.getAction().equals(ACTION_STOP)) {

                mediaPlayer.stop();
                Log.d(TAG, "stop");
            }

            return START_STICKY;
        }
        @Override
        public void onDestroy() {
            Toast.makeText(this, "MusicSevice onDestroy()"
                    , Toast.LENGTH_SHORT).show();
            Log.e(TAG, "MusicSerice onDestroy()");

            if (mediaPlayer != null) mediaPlayer.release();

            super.onDestroy();
        }


}
