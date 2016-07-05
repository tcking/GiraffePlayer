# GiraffePlayer
out of the box android video player base on [ijkplayer](https://github.com/Bilibili/ijkplayer)

# features
1. base on ijkplayer,support RTMP , HLS (http & https) , MP4,M4A etc.
2. gestures for volume control
3. gestures for brightness control
4. gestures for forward or backward
5. fullscreen by manual or sensor
6. try to replay when error(only for live video)
7. set video scale type (double click video will switch the scale types in app,you can find the difference)
    1. fitParent:可能会剪裁,保持原视频的大小，显示在中心,当原视频的大小超过view的大小超过部分裁剪处理
    2. fillParent:可能会剪裁,等比例放大视频，直到填满View为止,超过View的部分作裁剪处理
    3. wrapContent:将视频的内容完整居中显示，如果视频大于view,则按比例缩视频直到完全显示在view中
    4. fitXY:不剪裁,非等比例拉伸画面填满整个View
    5. 16:9:不剪裁,非等比例拉伸画面到16:9,并完全显示在View中
    6. 4:3:不剪裁,非等比例拉伸画面到4:3,并完全显示在View中

# how to import library
 1. git clone https://github.com/tcking/GiraffePlayer.git
 2. android studio->file->New->Import module->select `giraffeplayer`
 
## notice:
 the player default support 6 CPU architecture:ARMv5, ARMv7, ARMv8,x86 and 86_64,if your project need't support all of the architectures,you can remove the folder in `ijkplayer-java/src/main/jniLibs` to generate a light APK.
 read this first:[How to use 32-bit native libaries on 64-bit Android device](http://stackoverflow.com/questions/30782848/how-to-use-32-bit-native-libaries-on-64-bit-android-device),[What you should know about .so files](http://ph0b.com/android-abis-and-so-files/),[关于Android的.so文件你所需要知道的](http://www.jianshu.com/p/cb05698a1968)

# How to use ([example code](https://github.com/tcking/GiraffePlayer/blob/master/app/src/main/java/tcking/github/com/giraffeplayer/example/MainActivity.java))
## case 1: only what to play a video fullscreen
just call`GiraffePlayerActivity.configPlayer(activity).play(url)`,all is done.

## case 2: embed a player in a layout
### step 1: include video layout in your layout xml file
``` xml

<include
        layout="@layout/giraffe_player"
        android:layout_width="match_parent"
        android:layout_height="210dp"/>

```
notice:the giraffe player is match_parent default,if you want to specify `height` or `width` you can overwrite `layout_width` and `layout_width` in `include` tag

### step 2: new player and call `play`
``` java

GiraffePlayer player = new GiraffePlayer(activity);
player.play(url);

```

# API:
* `play(url)` //play video
* `stop()` //stop play
* `pause()`
* `start()` 
* `forward()` // forward or back,example: forward(0.1f) forward(-0.1f)
* `getCurrentPosition()`
* `setScaleType()`
* `toggleAspectRatio()`
* `seekTo()` //seek to specify position
* `getDuration()` //get video duration
* `onInfo()` //callback when have some information
* `onError()` 
* `onComplete()`
* `onControlPanelVisibilityChange()` //callback when control panel visibility change
# screencap

![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-142934.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143207.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143304.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143343.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143722.png)
