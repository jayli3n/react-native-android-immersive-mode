# React Native Toggle Immersive Mode

[![npm version](https://badge.fury.io/js/react-native-android-immersive-mode.svg)](https://badge.fury.io/js/react-native-android-immersive-mode)

Light weight [React Native](http://facebook.github.io/react-native/) library to toggle the [Android Immersive Mode](https://developer.android.com/training/system-ui/immersive "immersive mode").

**Note**: this package is for Android only and will do nothing for IOS. Immersive Full-Screen Mode is first introduced since [Android 4.4 (API Level 19)](https://developer.android.com/training/system-ui/immersive "immersive mode").

### Android Only

<div>
<img src="https://github.com/jayli3n/react-native-android-immersive-mode/blob/master/screenshots/Immersive_Mode_On.png?raw=true" height="600">
<img src="https://github.com/jayli3n/react-native-android-immersive-mode/blob/master/screenshots/Immersive_Mode_Off.png?raw=true" height="600">
</div>

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Installation:

`$ npm install react-native-android-immersive-mode --save`

### Automatic Configuration

`$ react-native link react-native-android-immersive-mode`

### Manual Configuration

#### **Android**

Edit `android/settings.gradle`:

```diff
+ include ':react-native-android-immersive-mode'
+ project(':react-native-android-immersive-mode').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-immersive-mode/android')
```
Edit `android/app/build.gradle`: (for versions before `v2.0.0`, use `compile` instead of `implementation` for `gradle@<=2`)

```diff
dependencies {
  implementation fileTree(dir: "libs", include: ["*.jar"])
  implementation "com.android.support:appcompat-v7:${rootProject.ext.supportLibVersion}"
  implementation "com.facebook.react:react-native:+"  // From node_modules
+ implementation project(':react-native-android-immersive-mode')
}
```
Edit `android/app/src/main/java/.../MainApplication.java`:

```diff
+ import com.jayli3n.ToggleImmersiveMode.ToggleImmersiveModePackage;

...

  @Override
  protected List<ReactPackage> getPackages() {
    @SuppressWarnings("UnnecessaryLocalVariable")
    List<ReactPackage> packages = new PackageList(this).getPackages();
+   packages.add(new ToggleImmersiveModePackage());
    // Packages that cannot be autolinked yet can be added manually here, for example:
    // packages.add(new MyReactNativePackage());
    return packages;
  }
```

## Usage:
```javascript
import { immersiveModeOn, immersiveModeOff } from 'react-native-android-immersive-mode';
...
immersiveModeOn(); // Turn on immersive mode
immersiveModeOff(); // Turn off immersive mode
```
##### If immersive mode goes away after the app goes into background, use `AppState` to listen to when the app returns back to foreground from background, then run `immersiveModeOn()`.
```javascript
import { AppState } from 'react-native';

class App extends Component {
  componentDidMount() {
    AppState.addEventListener('change', this.handleAppStateChange);
  }

  handleAppStateChange = (nextAppState) => {
    if (nextAppState === 'active') {
      immersiveModeOn();
    }
  };

  render() {
    immersiveModeOn();
    return (
      <View />
    );
  }
}
```

## License

MIT
