import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';


import { NativeModules, Button } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import NativeFragmentView from "./NativeAndroidFragmentView"

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
          onPress={() => navigation.navigate('AndroidFragmentScreen')}
        />
      </View>
    </View>
  );
}

function AndroidFragmentScreen({ navigation }) {
  return (
    <NativeFragmentView style={{ width: "100%", height: "100%" }}/>
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
  }
});

AppRegistry.registerComponent(
  'MyReactNativeApp',
  () => App
);