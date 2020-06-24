var gumStream; //stream from getUserMedia()
var recorder; //WebAudioRecorder object
var input; //MediaStreamAudioSourceNode we'll be recording
var encodingType; //holds selected encoding for resulting audio (file)
var encodeAfterRecord = true; // when to encode
var audioContext = new AudioContext; //new audio context to help us record
 
var encodingTypeSelect = document.getElementById("encodingTypeSelect");
var recordButton = document.getElementById("recordButton");
var stopButton = document.getElementById("stopButton");
recordButton.addEventListener("click", startRecording);
 
stopButton.addEventListener("click", stopRecording);

 

function startRecording() {
    console.log("startRecording() called");
 
    /*
    Simple constraints object, for more advanced features see
    <div class="video-container"><blockquote class="wp-embedded-content" data-secret="DjfftgfxmA"><a href="https://addpipe.com/blog/audio-constraints-getusermedia/">Supported Audio Constraints in getUserMedia()</a></blockquote><iframe class="wp-embedded-content" sandbox="allow-scripts" security="restricted" style="position: absolute; clip: rect(1px, 1px, 1px, 1px);" src="https://addpipe.com/blog/audio-constraints-getusermedia/embed/#?secret=DjfftgfxmA" data-secret="DjfftgfxmA" width="600" height="338" title="“Supported Audio Constraints in getUserMedia()” — Pipe Blog" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe></div>
    */
 
    var constraints = { audio: true, video:false }
 
    /*
    We're using the standard promise based getUserMedia() 
    https://developer.mozilla.org/en-US/docs/Web/API/MediaDevices/getUserMedia
    */
 
    navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
    __log("getUserMedia() success, stream created, initializing WebAudioRecorder...");
 
    //assign to gumStream for later use
    gumStream = stream;
 
    /* use the stream */
    input = audioContext.createMediaStreamSource(stream);
 
    //stop the input from playing back through the speakers
    input.connect(audioContext.destination)
 
    //get the encoding 
    encodingType = encodingTypeSelect.options[encodingTypeSelect.selectedIndex].value;
 
    //disable the encoding selector
    encodingTypeSelect.disabled = true;
 
    recorder = new WebAudioRecorder(input, {
        workerDir: "js/",
        encoding: encodingType,
        onEncoderLoading: function(recorder, encoding) {
            // show "loading encoder..." display
            __log("Loading "+encoding+" encoder...");
        },
        onEncoderLoaded: function(recorder, encoding) {
            // hide "loading encoder..." display
            __log(encoding+" encoder loaded");
        }
    });
 
    recorder.onComplete = function(recorder, blob) { 
        __log("Encoding complete");
        createDownloadLink(blob,recorder.encoding);
        encodingTypeSelect.disabled = false;
    }
 
    recorder.setOptions({
        timeLimit:120,
        encodeAfterRecord:encodeAfterRecord,
        ogg: {quality: 0.5},
        mp3: {bitRate: 160}
    });
 
    //start the recording process
    recorder.startRecording();
 
    __log("Recording started");
 
    }).catch(function(err) {
        //enable the record button if getUSerMedia() fails
        recordButton.disabled = false;
        stopButton.disabled = true;
 
    });
 
    //disable the record button
    recordButton.disabled = true;
    stopButton.disabled = false;
}

function stopRecording() {
    console.log("stopRecording() called");
 
    //stop microphone access
    gumStream.getAudioTracks()[0].stop();
 
    //disable the stop button
    stopButton.disabled = true;
    recordButton.disabled = false;
 
    //tell the recorder to finish the recording (stop recording + encode the recorded audio)
    recorder.finishRecording();
 
    __log('Recording stopped');
    }