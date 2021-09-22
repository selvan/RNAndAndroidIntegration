import React, { useState, useEffect } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';


import { NativeModules, NativeEventEmitter, Button } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import NativeFragmentView from "./NativeAndroidFragmentView"
import { Dimensions } from "react-native";

var width = Dimensions.get('window').width; //full width
var height = Dimensions.get('window').height; //full height

function HomeScreen({ navigation }) {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Welcome</Text>
      <View style={styles.add_margin}>
        <Button 
          title="Android Activity"
          onPress={() => NativeModules.StartActivityModule.startFragmentActivity()}
        />
      </View>
      <View style={styles.add_margin}>
        <Button style={styles.add_margin}
          title="Android Fragment"
          onPress={() => navigation.push('AndroidFragmentScreen')}
        />
      </View>
    </View>
  );
}

function AndroidFragmentScreen({ navigation }) {
  const [showOverlay, setShowOverlay] = useState(false);

  useEffect(() => {
    const eventEmitter = new NativeEventEmitter();
    const eventListener = eventEmitter.addListener('showOverlay', (event) => {
      setShowOverlay(event.shouldShow);
    });    
    return () => {
      eventListener.remove();
    }
  }, []);

  return (
    <View style={styles.container} key={Date.now()}>
      <NativeFragmentView style={{ width: "100%", height: "100%" }}/>
      {showOverlay && <View style={[styles.overlay, { height: height/2}]} />}
    </View>
  );
}

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

const Stack = createNativeStackNavigator();


function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="HomeScreen" component={HomeScreen} />
        <Stack.Screen name="AndroidFragmentScreen" component={AndroidFragmentScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center'
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10
  },
  add_margin: {
    margin: 20
  },
  overlay: {
    flex: 1,
    position: 'absolute',
    left: 0,
    top: 0,
    width: width,
    opacity: 0.5,
    backgroundColor: 'black',
  }
});

AppRegistry.registerComponent(
  'MyReactNativeApp',
  () => App
);