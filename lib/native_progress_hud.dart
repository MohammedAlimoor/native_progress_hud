import 'dart:async';

import 'package:flutter/services.dart';

class NativeProgressHud {
  static const MethodChannel _channel =
      const MethodChannel('native_progress_hud');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
  static Future<Null> showWaiting() async {
    await _channel.invokeMethod('showNativeViewProgress');
  }

  static Future<Null> showWaitingWithText(text) async {
    await _channel.invokeMethod('showNativeViewProgressTxt',{"text":text});
  }

  static  Future<Null> hideWaiting() async {
    await _channel.invokeMethod('hideNativeViewProgress');
  }
}
