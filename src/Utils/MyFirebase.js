import firebase from 'firebase'

  var config = {
    apiKey: "AIzaSyBNZVBieSTY8PaTtxevnJ6ICeiPowkDo-0",
    authDomain: "chatting-c3654.firebaseapp.com",
    databaseURL: "https://chatting-c3654.firebaseio.com",
    projectId: "chatting-c3654",
    storageBucket: "chatting-c3654.appspot.com",
    messagingSenderId: "600289605440"
  };
firebase.initializeApp(config)
firebase.firestore().settings({
  timestampsInSnapshots: true
})

export const myFirebase = firebase
export const myFirestore = firebase.firestore()
export const myStorage = firebase.storage()
