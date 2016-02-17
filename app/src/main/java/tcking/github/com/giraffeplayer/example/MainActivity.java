package tcking.github.com.giraffeplayer.example;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tcking.github.com.giraffeplayer.GiraffePlayer;
import tcking.github.com.giraffeplayer.GiraffePlayerActivity;

public class MainActivity extends AppCompatActivity {
    GiraffePlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = new GiraffePlayer(this);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_play) {
                    String url = ((EditText) findViewById(R.id.et_url)).getText().toString();
                    player.play(url);
                    player.setTitle(url);
                } else if (v.getId() == R.id.btn_play_sample_1) {
                    String url = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";
                    ((EditText) findViewById(R.id.et_url)).setText(url);
                    player.play(url);
                    player.setTitle(url);
                } else if (v.getId() == R.id.btn_play_sample_2) {
                    String url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
                    ((EditText) findViewById(R.id.et_url)).setText(url);
                    player.play(url);
                    player.setTitle(url);
                    player.setShowNavIcon(false);
                }else if (v.getId() == R.id.btn_play_sample_3) {
                    String url = "https://r4---sn-ogueln7r.googlevideo.com/videoplayback?lmt=1448977432536368&signature=68DD73A2272E320D27CD7894F688D27AC0280AF6.37AC8C8A5DFEA4DDB19370F0BD63B8427EF22363&mime=video/mp4&key=cms1&itag=18&ipbits=0&pl=26&requiressl=yes&expire=1455701339&id=o-ALk1eZ8mUorQB1iSJV5tP0QSDNAWHgN9GeLw_Sqo3naK&sparams=dur,expire,id,initcwndbps,ip,ipbits,itag,lmt,mime,mm,mn,ms,mv,nh,pl,ratebypass,requiressl,source,upn&upn=cXAgK-3yk2A&dur=15892.363&ip=45.32.19.159&sver=3&fexp=9405824,9408211,9415030,9416126,9417380,9419451,9420452,9422596,9422778,9423661,9423662,9426401,9426976,9427126,9427317,9427860,9428350,9428421,9428709&source=youtube&ratebypass=yes&redirect_counter=1&req_id=9c2ec062eb3aa3ee&cms_redirect=yes&mm=30&mn=sn-ogueln7r&ms=nxu&mt=1455679313&mv=u&nh=IgpwcjAzLm5ydDE5KgkxMjcuMC4wLjE";
                    ((EditText) findViewById(R.id.et_url)).setText(url);
                    player.play(url);
                    player.setTitle(url);
                    player.setShowNavIcon(false);
                }else if (v.getId() == R.id.btn_open) {
                    String url = ((EditText) findViewById(R.id.et_url)).getText().toString();
                    GiraffePlayerActivity.configPlayer(MainActivity.this).setTitle(url).play(url);
//                    more configuration example:
//                    GiraffePlayerActivity.configPlayer(MainActivity.this)
//                            .setScaleType(GiraffePlayer.SCALETYPE_FITPARENT)
//                            .setDefaultRetryTime(5 * 1000)
//                            .setFullScreenOnly(false)
//                            .setTitle(url)
//                            .play(url);
                }else if (v.getId() == R.id.btn_start) {
                    player.start();
                }else if (v.getId() == R.id.btn_pause) {
                    player.pause();
                }else if (v.getId() == R.id.btn_toggle) {
                    player.toggleFullScreen();
                }
            }
        };
        findViewById(R.id.btn_play).setOnClickListener(clickListener);
        findViewById(R.id.btn_play_sample_1).setOnClickListener(clickListener);
        findViewById(R.id.btn_play_sample_2).setOnClickListener(clickListener);
        findViewById(R.id.btn_play_sample_3).setOnClickListener(clickListener);
        findViewById(R.id.btn_pause).setOnClickListener(clickListener);
        findViewById(R.id.btn_start).setOnClickListener(clickListener);
        findViewById(R.id.btn_toggle).setOnClickListener(clickListener);
        findViewById(R.id.btn_open).setOnClickListener(clickListener);
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

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
