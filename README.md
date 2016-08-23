# GiraffePlayer
out of the box android video player base on [ijkplayer](https://github.com/Bilibili/ijkplayer)

**note:** if the player can't play your video,try download **[full-featured so](https://pan.baidu.com/s/1gfO9MnT)** which support more codec/format (bigger binary size) to replace `ijkplayer-java/src/main/jniLibs ` (I have try to push a new branch to github but failed)

# features
1. base on ijkplayer,support RTMP , HLS (http & https) , MP4,M4A etc.
2. gestures for volume control
3. gestures for brightness control
4. gestures for forward or backward
5. fullscreen by manual or sensor
6. try to replay when error(only for live video)
7. set video scale type (double click video will switch the scale types in app,you can find the difference)
    1. fitParent:scale the video uniformly (maintain the video's aspect ratio) so that both dimensions (width and height) of the video will be equal to or **less** than the corresponding dimension of the view. like ImageView's `CENTER_INSIDE`.等比缩放,画面填满view。
    2. fillParent:scale the video uniformly (maintain the video's aspect ratio) so that both dimensions (width and height) of the video will be equal to or **larger** than the corresponding dimension of the view .like ImageView's `CENTER_CROP`.等比缩放,直到画面宽高都等于或小于view的宽高。
    3. wrapContent:center the video in the view,if the video is less than view perform no scaling,if video is larger than view then scale the video uniformly so that both dimensions (width and height) of the video will be equal to or **less** than the corresponding dimension of the view. 将视频的内容完整居中显示，如果视频大于view,则按比例缩视频直到完全显示在view中。
    4. fitXY:scale in X and Y independently, so that video matches view exactly.不剪裁,非等比例拉伸画面填满整个View
    5. 16:9:scale x and y with aspect ratio 16:9 until both dimensions (width and height) of the video will be equal to or **less** than the corresponding dimension of the view.不剪裁,非等比例拉伸画面到16:9,并完全显示在View中。
    6. 4:3:scale x and y with aspect ratio 4:3 until both dimensions (width and height) of the video will be equal to or **less** than the corresponding dimension of the view.不剪裁,非等比例拉伸画面到4:3,并完全显示在View中。

# how to import library
 1. git clone https://github.com/tcking/GiraffePlayer.git
 2. android studio->file->New->Import module->select `giraffeplayer`
 
## notice:
 the player default support 6 CPU architecture:ARMv5, ARMv7, ARMv8,x86 and 86_64,if your project need't support all of the architectures,you can remove the folder in `ijkplayer-java/src/main/jniLibs` to generate a light APK.
 read this first:[How to use 32-bit native libaries on 64-bit Android device](http://stackoverflow.com/questions/30782848/how-to-use-32-bit-native-libaries-on-64-bit-android-device),[What you should know about .so files](http://ph0b.com/android-abis-and-so-files/),[关于Android的.so文件你所需要知道的](http://www.jianshu.com/p/cb05698a1968)

# How to use ([example code](https://github.com/tcking/GiraffePlayer/blob/master/app/src/main/java/tcking/github/com/giraffeplayer/example/MainActivity.java))
## case 1: only want to play a video fullscreen
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
* `setScaleType(GiraffePlayer.SCALETYPE_FITPARENT)` //set video scale type
* `toggleAspectRatio()` // toggle video scale type
* `seekTo(...)` //seek to specify position
* `getDuration()` //get video duration
* `onInfo(...)` //callback when have some information
* `onError(...)`  //callback when an error occurred
* `onComplete(...)` //callback when the play is over
* `onControlPanelVisibilityChange(...)` //callback when control panel visibility change
# screencap

![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-142934.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143207.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143304.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143343.png)
![](https://github.com/tcking/GiraffePlayer/blob/master/screencap/device-2015-10-28-143722.png)
