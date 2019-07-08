import { NativeModules, Platform } from 'react-native';

const { ToggleImmersiveMode } = NativeModules;

const immersiveModeOn = () => {
  if(Platform.OS === 'android') {
    return ToggleImmersiveMode.immersiveModeOn();
  } else {
    return false;
  }
};

const immersiveModeOff = () => {
  if(Platform.OS === 'android') {
    return ToggleImmersiveMode.immersiveModeOff();
  } else {
    return false;
  }
};

export { immersiveModeOn, immersiveModeOff };
