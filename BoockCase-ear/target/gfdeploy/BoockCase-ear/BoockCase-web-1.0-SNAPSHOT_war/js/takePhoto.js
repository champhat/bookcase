(function() {

  var streaming = false,
      video        = document.querySelector('#video'),
      cover        = document.querySelector('#cover'),
      canvas       = document.querySelector('#canvas'),
      photo        = document.querySelector('#photo'),
      startbutton  = document.querySelector('#startbutton'),
      width = 200,
      height = 0;

  navigator.getMedia = ( navigator.getUserMedia || 
                         navigator.webkitGetUserMedia ||
                         navigator.mozGetUserMedia ||
                         navigator.msGetUserMedia);

  navigator.getMedia(
    { 
      video: true, 
      audio: false 
    },
    function(stream) {
      if (navigator.mozGetUserMedia) { 
        video.mozSrcObject = stream;
      } else {
        var vendorURL = window.URL || window.webkitURL;
        video.src = vendorURL ? vendorURL.createObjectURL(stream) : stream;
      }
      video.play();
    },
    function(err) {
      console.log("An error occured! " + err);
    }
  );

  video.addEventListener('canplay', function(ev){
    if (!streaming) {
      height = video.videoHeight / (video.videoWidth/width);
      video.setAttribute('width', width);
      video.setAttribute('height', height);
      canvas.setAttribute('width', width);
      canvas.setAttribute('height', height);
      streaming = true;
    }
  }, false);

  function takepicture() {
    canvas.width = width;
    canvas.height = height;
    canvas.getContext('2d').drawImage(video, 0, 0, width, height); 
 var data = canvas.toDataURL('image/png');
 document.write('<img src="'+data+'"/>');
   photo.setAttribute('src', data);
 
var pixels = photo.data; 
var numPixels = pixels.length;  

for (var i = 0; i < numPixels; i++) { 
        var average = (pixels[i*4]+pixels[i*4+1]+pixels[i*4+2])/3; 
        pixels[i*4] = average; // Red 
        pixels[i*4+1] = average; // Green 
        pixels[i*4+2] = average; // Blue 
}
  
  photo.putImageData(video, 0, 0, width, height);
$(photo).attr('src', canvas.toDataURL());
  
  }

  startbutton.addEventListener('click', function(ev){
      takepicture();
    ev.preventDefault();
  }, false);

})();