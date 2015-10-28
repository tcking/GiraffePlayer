package tcking.github.com.giraffeplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by tcking on 15/10/27.
 */
public class GiraffePlayerActivity extends Activity {

    GiraffeVideoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giraffe_player);
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        if (TextUtils.isEmpty(url)) {
            Toast.makeText(this, "请指定播放视频的地址", Toast.LENGTH_SHORT).show();
        } else {
            player = new GiraffeVideoPlayer(this);
            player.setFullScreenOnly(true);
            player.play(url);
            player.setTitle(TextUtils.isEmpty(title)?"":title);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    /**
     *  play video
     * @param context
     * @param url url,title
     */
    public static void play(Activity context,String... url) {
        Intent intent = new Intent(context, GiraffePlayerActivity.class);
        intent.putExtra("url", url[0]);
        if (url.length>1) {
            intent.putExtra("title", url[1]);
        }
        context.startActivity(intent);
    }
}
