package yumic.diverbob.love.runningmusicviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

import yumic.diverbob.love.runningmusicviewpager.utils.LogHelper;

/**
 * Created by Oathkeeper on 2016/2/29.
 */
public class PlayerLayout extends FrameLayout {
    private static final String TAG = LogHelper.makeLogTag(PlayerLayout.class);

    ImageView imageViewAlbum;

    LinearLayout linearLayoutSongInfo;
    TextView textViewTitle;
    TextView textViewArtist;
    TextView textViewAlbum;

    Music music;
    private GestureDetector detector;
    View.OnTouchListener onTouchListener = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    };

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }


    public PlayerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.framelayout_player, this, true);
        linearLayoutSongInfo = (LinearLayout) findViewById(R.id.linearLayoutSongInfo);

        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewArtist = (TextView) findViewById(R.id.textViewArtist);
        textViewAlbum = (TextView) findViewById(R.id.textViewAlbum);

        //初始化
        if(null!=music){
            textViewTitle.setText(music.getTitle());
            textViewArtist.setText(music.getArtist());
            textViewAlbum.setText(music.getAlbum());

//            textViewTitle.setOnTouchListener(viewTouchListener);
//            textViewArtist.setOnTouchListener(viewTouchListener);
//            textViewAlbum.setOnTouchListener(viewTouchListener);
        }
        LogHelper.d(TAG, "SetTouchListener");
        //detector = new GestureDetector(context, new PlayerGestureListener(context));
    }










}
