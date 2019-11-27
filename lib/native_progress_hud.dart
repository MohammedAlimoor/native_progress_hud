import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class NativeProgressHud {
  static const MethodChannel _channel =
      const MethodChannel('native_progress_hud');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
  static Future<Null> showWaiting({String backgroundColor =  "#000000",String textColor = "#ffffff"}) async {
    await _channel.invokeMethod('showNativeViewProgress',{"backgroundColor":backgroundColor,"textColor":textColor});
  }


  static Future<Null> showWaitingWithText(String text, {String backgroundColor =  "#000000",String textColor = "#ffffff"}) async {
    await _channel.invokeMethod('showNativeViewProgressTxt',{"text":text,"backgroundColor":backgroundColor,"textColor":textColor});
  }

  static  Future<Null> hideWaiting() async {
    await _channel.invokeMethod('hideNativeViewProgress');
  }
}
