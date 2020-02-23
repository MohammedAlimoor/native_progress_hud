package com.nativee.progresshud.native_progress_hud

import android.app.Activity
import android.graphics.Color
import android.os.Handler
import com.kaopiz.kprogresshud.KProgressHUD
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class NativeProgressHudPlugin(val activity: Activity) : MethodCallHandler {
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

    var hud: KProgressHUD? = null

    var backgroundColor: String = "#000000"
    var textColor: String = "#ffffff"
//  var textColor:Int = Color.BLACK

    override fun onMethodCall(call: MethodCall, result: Result) {

        if (call.method.equals("showNativeViewProgress", true)) {
            if (hud != null) {
//                hud?.dismiss()
                Handler().post(Runnable {
                    // Code here will run in UI thread
                    hud?.dismiss();
                })
            }
            if (call.hasArgument("backgroundColor")) {
                backgroundColor = call.argument<String>("backgroundColor")!!;
            }
            if (call.hasArgument("textColor")) {
                textColor = call.argument<String>("textColor")!!;
            }
            hud = KProgressHUD.create(this@NativeProgressHudPlugin.activity)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//              .setLabel("Please wait ...",Color.parseColor(textColor) )
                    .setCancellable(false)
                    .setBackgroundColor(Color.parseColor(backgroundColor))
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)
            Handler().post(Runnable {
                // Code here will run in UI thread
                hud?.show()
            })

            result.success(0)

        } else if (call.method.equals("showNativeViewProgressTxt", true)) {
            if (hud != null) {
//                hud?.dismiss()
                Handler().post(Runnable {
                    // Code here will run in UI thread
                    hud?.dismiss();
                })
            }
            if (call.hasArgument("backgroundColor")) {
                backgroundColor = call.argument<String>("backgroundColor")!!;
            }
            if (call.hasArgument("textColor")) {
                textColor = call.argument<String>("textColor")!!;
            }

            hud = KProgressHUD.create(this@NativeProgressHudPlugin.activity)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel(call.argument<String>("text"), Color.parseColor(textColor))
                    .setBackgroundColor(Color.parseColor(backgroundColor))
                    .setCancellable(false)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)

            Handler().post(Runnable {
                // Code here will run in UI thread
                hud?.show()
            })

            result.success(0)

        } else
            if (call.method.equals("hideNativeViewProgress", true)) {
//        Log.d("HUD ::","Hide")

                if (hud != null) {
//          Log.d("HUD ::","Hide2")
                    Handler().post(Runnable {
                        // Code here will run in UI thread
                        hud?.dismiss();
                    })
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
