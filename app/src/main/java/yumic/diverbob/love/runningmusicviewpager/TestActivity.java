package yumic.diverbob.love.runningmusicviewpager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import yumic.diverbob.love.runningmusicviewpager.utils.LogHelper;

public class TestActivity extends AppCompatActivity {

    private static final String ACTION_PLAY = "love.diverbob.action.PLAY";
    private static final String ACTION_PAUSE = "love.diverbob.action.PAUSE";
    private static final String ACTION_STOP = "love.diverbob.action.STOP";

    private static boolean isPlaying = false;

    private static final String TAG = LogHelper.makeLogTag(TestActivity.class);

    PlayerLayout playerLayout;
    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        detector = new GestureDetector(this, new PlayerGestureListener(this));
        playerLayout = (PlayerLayout) findViewById(R.id.playerLayout);
        playerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        playerLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }
        });



    }
    class PlayerGestureListener implements GestureDetector.OnGestureListener {

        private Context context;

        public PlayerGestureListener(Context context) {
            this.context=context;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {


            Intent intent = new Intent(TestActivity.this,MusicService.class);
            if(isPlaying){
                intent.setAction(ACTION_PAUSE);
                isPlaying = false;
            }else{
                intent.setAction(ACTION_PLAY);
                isPlaying = true;
            }

            startService(intent);
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            float minMove = 120;         //最小滑动距离
            float minVelocity = 0;      //最小滑动速度
            float beginX = e1.getX();
            float endX = e2.getX();
            float beginY = e1.getY();
            float endY = e2.getY();
            if(beginX-endX>minMove&&Math.abs(velocityX)>minVelocity){   //左滑
                //LogHelper.d(TAG, "左滑");
                Log.d(TAG, "左滑");
            }else if(endX-beginX>minMove&&Math.abs(velocityX)>minVelocity){   //右滑
                Log.d(TAG, "右滑");
            }else if(beginY-endY>minMove&&Math.abs(velocityY)>minVelocity){   //上滑
                Log.d(TAG, "上滑");
            }else if(endY-beginY>minMove&&Math.abs(velocityY)>minVelocity){   //下滑
                Log.d(TAG, "下滑");
            }
            return false;
        }



    }

}
