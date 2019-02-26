import * as firebase from 'firebase';

  var config = {
    apiKey: "AIzaSyCj2ezMhQqW2yvi8LQYGNhBAaOUyX6LJek",
    authDomain: "chat-4c760-76907.firebaseapp.com",
    databaseURL: "https://chat-4c760-76907.firebaseio.com",
    projectId: "chat-4c760-76907",
    storageBucket: "chat-4c760-76907.appspot.com",
    messagingSenderId: "341481735617"
  };

firebase.initializeApp(config);

const database = firebase.database();

export {
  database,
};