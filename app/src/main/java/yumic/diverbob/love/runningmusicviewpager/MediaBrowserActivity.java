package yumic.diverbob.love.runningmusicviewpager;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;

/**
 * Created by Oathkeeper on 2016/3/2.
 */
public class MediaBrowserActivity extends Activity{

    String[] projection= {MediaStore.Video.Media.TITLE,  //音乐名
            MediaStore.Audio.Media.DURATION,            //音乐的总时间
            MediaStore.Audio.Media.ARTIST,          //艺术家
            MediaStore.Audio.Media._ID,             //id号
            MediaStore.Audio.Media.DISPLAY_NAME,        //音乐文件名
            MediaStore.Audio.Media.DATA};//音乐文件的路径


    private int[] _ids;//存放音乐文件的id数组
    private String[] _titles;//存放音乐文件的标题数组
    private String[] _path;//存放音乐文件的路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Cursor cursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                null,//查询条件
                null,//查询条件中用到的数据
                null);// 查询结果的排序方式


        cursor.moveToFirst();
        _ids = new int[cursor.getCount()];
        _titles = new String[cursor.getCount()];
        _path = new String[cursor.getCount()];
        for(int i=0;i<cursor.getCount();i++) {
            _ids[i] = cursor.getInt(3);
            _titles[i] = cursor.getString(0);
            _path[i] = cursor.getString(5).substring(4);
            cursor.moveToNext();
        }


        //点击开始扫描，扫描所有音乐文件
        //扫描完成后显示在ListView中
        //右上角还有编辑播放列表，点击后进入编辑播放列表模式

    }
}
