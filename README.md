# native_progress_hud

A new flutter plugin project.

## Getting Started

This project is a starting point for a Flutter
[plug-in package](https://flutter.dev/developing-packages/),
a specialized package that includes platform-specific implementation code for
Android and/or iOS.

For help getting started with Flutter, view our 
[online documentation](https://flutter.dev/docs), which offers tutorials, 
samples, guidance on mobile development, and a full API reference.

# native_progress_hud ![Pub](https://img.shields.io/pub/v/native_progress_hud.svg) [![Build Status](https://travis-ci.com/wouterhardeman/native_progress_hud.svg?branch=master)](https://travis-ci.com/wouterhardeman/native_progress_hud)

This plugin allows using native hud loading dialogs in Android and iOS. It was made specifically for Add2App use cases when just a part of your UI is made in Flutter.


## Usage

To use this plugin, add `native_progress_hud` as a [dependency in your pubspec.yaml file](https://flutter.io/docs/development/packages-and-plugins/using-packages).

## Example

```dart
import 'package:native_progress_hud/native_progress_hud.dart';

    NativeProgressHud.showWaiting(); // show hud

    NativeProgressHud.showWaitingWithText("show some text"); // show hud with text
    NativeProgressHud.hideWaiting(); // hide hud


```
