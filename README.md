# GiraffePlayer
out of the box android video player base on [ijkplayer](https://github.com/Bilibili/ijkplayer)

# features
1.base on ijkplayer
2.gestures for volume control
3.gestures for brightness control
4.gestures for forward or backward
5.fullscreen by manual or sensor
6.try to replay when error(only for live video)

# How to use (![example code](https://github.com/tcking/GiraffePlayer/blob/master/app/src/main/java/tcking/github/com/giraffeplayer/example/MainActivity.java))
# case 1:only what to play a vedio fullscreen
just call`GiraffePlayerActivity.play(activity,url,title)`,all is done.

# case 2:embed a player in a layout
## step 1 include video layout in your layout xml file
``` xml

<include
        layout="@layout/giraffe_player"
        android:layout_width="match_parent"
        android:layout_height="210dp"/>

```
notice:the giraffe player is match_parent default,if you want to specify `height` or `width` you can overwrite `layout_width` and `layout_width` in `include` tag

## step 2 new player and call `play`
``` java

GiraffeVideoPlayer player = new GiraffeVideoPlayer(activity);
player.play(url);

```

![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-142934.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143207.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143304.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143343.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/ddevice-2015-10-28-143722.png)