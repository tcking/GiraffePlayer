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
                    String url = "https://r3---sn-o097znes.googlevideo.com/videoplayback?nh=IgpwcjAxLnNqYzA3KgkxMjcuMC4wLjE&key=yt6&ratebypass=yes&source=youtube&dur=15892.363&lmt=1448977432536368&mime=video/mp4&pl=32&expire=1455621993&mm=31&mn=sn-o097znes&ip=2600:3c01::f03c:91ff:fe70:35ff&upn=tUX3VKaaIE8&sparams=dur,id,initcwndbps,ip,ipbits,itag,lmt,mime,mm,mn,ms,mv,nh,pl,ratebypass,requiressl,source,upn,expire&mt=1455600346&mv=m&initcwndbps=16662500&ms=au&itag=18&ipbits=0&requiressl=yes&signature=B90159512BE71340D1112585C6B5744BBBA21784.03AA682D30B23C444773CBDB46A4B5F3F30C61D8&fexp=9407169,9408207,9416126,9420452,9422596,9423660,9423662,9424771,9425737,9426687,9428034,9428064,9428246,9428649,9428941&id=o-AAqIBBudm5xSSzsgeY2Han3wIQ4j2TUH3dlhQxA3XN5A&sver=3";
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
                }
            }
        };
        findViewById(R.id.btn_play).setOnClickListener(clickListener);
        findViewById(R.id.btn_play_sample_1).setOnClickListener(clickListener);
        findViewById(R.id.btn_play_sample_2).setOnClickListener(clickListener);
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
}
