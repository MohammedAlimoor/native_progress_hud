#import "NativeProgressHudPlugin.h"
#import <native_progress_hud/native_progress_hud-Swift.h>

@implementation NativeProgressHudPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftNativeProgressHudPlugin registerWithRegistrar:registrar];
}
@end
