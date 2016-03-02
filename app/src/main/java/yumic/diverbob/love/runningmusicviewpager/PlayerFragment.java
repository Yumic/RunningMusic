package yumic.diverbob.love.runningmusicviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 音乐播放界面的Fragment
 * Created by Oathkeeper on 2016/2/29.
 */
public class PlayerFragment extends Fragment {

    ImageView imageViewAlbum;

    LinearLayout linearLayoutSongInfo;
    TextView textViewSong;
    TextView textViewArtist;
    TextView textViewAlbum;


    Context context;
    //定义手势检测器实例
    private GestureDetector detector;



    public static PlayerFragment newInstance() {
        return new PlayerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.framelayout_player, container, false);
        context  = getContext();
       // llPlayer = (LinearLayout) rootView.findViewById(R.id.linearLayoutPlayer);
      //  llPlayer.setOnTouchListener();
        detector = new GestureDetector(context, new MyGestureListener(context));

        return super.onCreateView(inflater, container, savedInstanceState);

    }


    private View.OnTouchListener viewTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            //短按 播放/暂停
            //event.getAction() = KeyEvent.
            //长按 查看歌曲详细信息
            //上滑 上一首
            //下滑 下一首
            //左划 后退
            //右划 前进
            return detector.onTouchEvent(event);
        }
    };


    class MyGestureListener implements GestureDetector.OnGestureListener {

        private Context context;
        private Bitmap tempBitmap;

        public MyGestureListener(Context context) {
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

            }else if(endX-beginX>minMove&&Math.abs(velocityX)>minVelocity){   //右滑

            }else if(beginY-endY>minMove&&Math.abs(velocityY)>minVelocity){   //上滑

            }else if(endY-beginY>minMove&&Math.abs(velocityY)>minVelocity){   //下滑

            }



            return false;
        }



        }
    }


