import Flutter
import UIKit

public class SwiftNativeProgressHudPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "native_progress_hud", binaryMessenger: registrar.messenger())
    let instance = SwiftNativeProgressHudPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
//    result("iOS " + UIDevice.current.systemVersion)
    buildAlert(method: call.method,call:call, result: result)

  }
    
    func hexStringToUIColor (hex:String) -> UIColor {
        var cString:String = hex.trimmingCharacters(in: .whitespacesAndNewlines).uppercased()

        if (cString.hasPrefix("#")) {
            cString.remove(at: cString.startIndex)
        }

        if ((cString.count) != 6) {
            return UIColor.gray
        }

        var rgbValue:UInt64 = 0
        Scanner(string: cString).scanHexInt64(&rgbValue)

        return UIColor(
            red: CGFloat((rgbValue & 0xFF0000) >> 16) / 255.0,
            green: CGFloat((rgbValue & 0x00FF00) >> 8) / 255.0,
            blue: CGFloat(rgbValue & 0x0000FF) / 255.0,
            alpha: CGFloat(1.0)
        )
    }
    private func buildAlert(method: String,call: FlutterMethodCall, result: @escaping FlutterResult) {
         switch method {
            
         case "showNativeViewProgress":
            SwiftOverlays.showBlockingWaitOverlay()

            _ =  (call.arguments as! Dictionary<String, Any>)["textColor"];
            let backgroundColor =  (call.arguments as! Dictionary<String, Any>)["backgroundColor"]
            
            SwiftOverlays.backgroundColor3 = hexStringToUIColor(hex: backgroundColor as! String)

             showHUD(result: result)
         case "showNativeViewProgressTxt":
           let text =  (call.arguments as! Dictionary<String, Any>)["text"];
           let textColor =  (call.arguments as! Dictionary<String, Any>)["textColor"];
           let backgroundColor =  (call.arguments as! Dictionary<String, Any>)["backgroundColor"]
           SwiftOverlays.backgroundColor3 = hexStringToUIColor(hex: backgroundColor as! String)
           SwiftOverlays.textColor = hexStringToUIColor(hex: textColor as! String)

           showHUDtext(result: result,text:text as! String)
        case "hideNativeViewProgress":
             hideHUD(result: result)
//             return buildConfirmDialog(alertData: alertData, result: result)
         default: break
//             return buildAlertDialog(alertData: alertData, result: result)
         }
     }
    
    

        private func showHUD(result: FlutterResult) {
        
            print("Swift :: Show ")
    //        HUD.show(.progress)
            
            SwiftOverlays.showBlockingWaitOverlay()

            result(Int(0))

          }
    private func showHUDtext(result: FlutterResult,text: String) {
         
             print("Swift :: Show ")
     //        HUD.show(.progress)
        SwiftOverlays.showBlockingWaitOverlayWithText(text)

             result(Int(0))

           }
        private func hideHUD(result: FlutterResult) {
        
            print("Swift :: Show ")

            // Now some long running task starts...
            DispatchQueue.main.asyncAfter(deadline: .now() + 1) {
                // ...and once it finishes we flash the HUD for a second.
    //           HUD.flash(.success, delay: 1.0)
    //            HUD.show(.progress)
                SwiftOverlays.removeAllBlockingOverlays()


            }
            result(Int(0))

          }
}
