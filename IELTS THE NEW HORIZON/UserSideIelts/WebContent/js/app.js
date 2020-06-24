/* global OT API_KEY TOKEN SESSION_ID SAMPLE_SERVER_BASE_URL */

var apiKey;
var sessionId;
var token;

function handleError(error) {
  if (error) {
    console.error(error);
  }
}

function initializeSession() {
  var session = OT.initSession(apiKey, sessionId);

  // Subscribe to a newly created stream
  session.on('streamCreated', function streamCreated(event) {
    var subscriberOptions = {
      insertMode: 'append',
      width: '100%',
      height: '100%'
    };
    session.subscribe(event.stream, 'subscriber', subscriberOptions, handleError);
  });

  session.on('sessionDisconnected', function sessionDisconnected(event) {
    console.log('You were disconnected from the session.', event.reason);
  });

  // initialize the publisher
  var publisherOptions = {
    insertMode: 'append',
    width: '100%',
    height: '100%'
  };
  var publisher = OT.initPublisher('publisher', publisherOptions, handleError);

  // Connect to the session
  session.connect(token, function callback(error) {
    if (error) {
      handleError(error);
    } else {
      // If the connection is successful, publish the publisher to the session
      session.publish(publisher, handleError);
    }
  });
}

// See the config.js file.
if (API_KEY && TOKEN && SESSION_ID) {
  apiKey ="46295462";
  sessionId = "1_MX40NjI5NTQ2Mn5-MTU1MzY5MjY0OTIxN35TYTY2dllYMDVkcnQ1S2V2Y1I4dE9SRk5-fg";
  token="T1==cGFydG5lcl9pZD00NjI5NTQ2MiZzaWc9NjI2NmExNWUwNzdjYzA0ZDllNDExYTBmZTkwZGQ1NWZhMDdiZjQzYjpzZXNzaW9uX2lkPTFfTVg0ME5qSTVOVFEyTW41LU1UVTFNelk1TWpZME9USXhOMzVUWVRZMmRsbFlNRFZrY25RMVMyVjJZMUk0ZEU5U1JrNS1mZyZjcmVhdGVfdGltZT0xNTUzNjk1NTE0Jm5vbmNlPTAuOTMyNDU5MTcwMDA1Nzg4NSZyb2xlPXB1Ymxpc2hlciZleHBpcmVfdGltZT0xNTU2Mjg3NTEzJmluaXRpYWxfbGF5b3V0X2NsYXNzX2xpc3Q9";
  initializeSession();
} else if (SAMPLE_SERVER_BASE_URL) {
  // Make an Ajax request to get the OpenTok API key, session ID, and token from the server
  fetch(SAMPLE_SERVER_BASE_URL + '/session').then(function fetch(res) {
    return res.json();
  }).then(function fetchJson(json) {
    apiKey = json.apiKey;
    sessionId = json.sessionId;
    token = json.token;

    initializeSession();
  }).catch(function catchErr(error) {
    handleError(error);
    alert('Failed to get opentok sessionId and token. Make sure you have updated the config.js file.');
  });
}
