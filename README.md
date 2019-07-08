# React Native Toggle Immersive Mode

Light weight [React Native](http://facebook.github.io/react-native/) library to toggle the [Android Immersive Mode](https://developer.android.com/training/system-ui/immersive "immersive mode").

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

1. Open `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.jayli3n.ToggleImmersiveMode.ToggleImmersiveModePackage;` to the imports at the top of the file
  - Add `packages.add(new ToggleImmersiveModePackage());` to the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
    ```
    include ':react-native-android-immersive-mode'
    project(':react-native-android-immersive-mode').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-immersive-mode/android')
    ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
    ```
    compile project(':react-native-android-immersive-mode')
    ```


## Usage:
```javascript
import { immersiveModeOn, immersiveModeOff } from 'react-native-android-immersive-mode';
...
immersiveModeOn(); // Turn on immersive mode
immersiveModeOff(); // Turn off immersive mode
```
##### If immersive mode goes away after the app goes into background, use `AppState` to listen to when the app returns from background then run `immersiveModeOn()`.
```javascript
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