# native_progress_hud

Native hud loading dialogs. (show loading hud with text or without , you can customize colors and background)
without context flutter :)
## Getting Started

This project is a starting point for a Flutter
[plug-in package](https://flutter.dev/developing-packages/),
a specialized package that includes platform-specific implementation code for
Android and/or iOS.

For help getting started with Flutter, view our
[online documentation](https://flutter.dev/docs), which offers tutorials,
samples, guidance on mobile development, and a full API reference.

# native_progress_hud ![Pub](https://img.shields.io/pub/v/native_progress_hud.svg) [![Build Status](https://travis-ci.com/wouterhardeman/native_progress_hud.svg?branch=master)](https://travis-ci.com/wouterhardeman/native_progress_hud)

This plugin allows using native hud loading "or waiting" dialogs in Android and iOS. , you can customize colors and background) without context flutter :)
![2019-11-27 11_35_09](https://github.com/MohammedAlimoor/native_progress_hud/raw/master/screenshotwithottext.gif)
## Usage

To use this plugin, add `native_progress_hud` as a [dependency in your pubspec.yaml file](https://flutter.io/docs/development/packages-and-plugins/using-packages).

## Example

```dart
import 'package:native_progress_hud/native_progress_hud.dart';


    NativeProgressHud.showWaiting(); // show hud

    NativeProgressHud.showWaiting(backgroundColor: "#FF0000",textColor: "#FFFFFF"); // show hud with colors

    NativeProgressHud.showWaitingWithText("show some text"); // show hud with text  and you can change colors

    NativeProgressHud.hideWaiting(); // hide hud


```
