import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';


import { NativeModules, Button } from 'react-native';
import NativeFragmentView from "./NativeAndroidFragmentView"

const HelloWorld = () => {
  return (
    <View style={styles.container}>
      <NativeFragmentView style={{ width: "100%", height: "100%" }}/>
      <Text style={styles.hello}>Hello, World</Text>
      <Button
                onPress={() => NativeModules.StartActivityModule.startFragmentActivity()}
                title='Start example activity'
            />
    </View>
  );
};
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center'
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10
  }
});

AppRegistry.registerComponent(
  'MyReactNativeApp',
  () => HelloWorld
);