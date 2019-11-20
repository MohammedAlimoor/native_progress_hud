package com.nativee.progresshud.native_progress_hud

import android.app.Activity
import com.kaopiz.kprogresshud.KProgressHUD
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class NativeProgressHudPlugin (val activity: Activity): MethodCallHandler {
//  (val activity: Activity)
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "native_progress_hud")
//      channel.setMethodCallHandler(NativeProgressHudPlugin())
      channel.setMethodCallHandler(NativeProgressHudPlugin(registrar.activity()))

//       activity = registrar.activity()
    }
  }
  var hud: KProgressHUD? =null
//  var activity: Activity? =null

  override fun onMethodCall(call: MethodCall, result: Result) {

    if (call.method.equals("showNativeViewProgress",true)) {
      if (hud != null ){
        hud?.dismiss()
      }

      hud =    KProgressHUD.create(this@NativeProgressHudPlugin.activity)
              .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
              .setLabel("Please wait ...")
              .setCancellable(false)
              .setAnimationSpeed(2)
              .setDimAmount(0.5f)
              .show()
      result.success(0)

    }else if (call.method.equals("showNativeViewProgressTxt",true)) {
      if (hud != null ){
        hud?.dismiss()
      }


      hud =    KProgressHUD.create(this@NativeProgressHudPlugin.activity)
              .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
              .setLabel(call.argument<String>("text"))
              .setCancellable(false)
              .setAnimationSpeed(2)
              .setDimAmount(0.5f)
              .show()
      result.success(0)

    }
    else
      if (call.method.equals("hideNativeViewProgress",true)) {
//        Log.d("HUD ::","Hide")

        if (hud != null){
//          Log.d("HUD ::","Hide2")

          hud?.dismiss();
        }
        result.success(0)

      }

    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else {
      result.notImplemented()
    }
  }
}
