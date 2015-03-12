
window.addEventListener('mouseup', function(){
    var box = document.getElementById('light');
    var boverlay = document.getElementById('fade');
    if((event.target != box) && (event.target.parentNode != box)) {
        //box.style.display = 'none';
        $( '#light' ).fadeOut(500);
        $( '#fade' ).fadeOut(500);
        //boverlay.style.display = 'none';
    }
});

// works by changing the display value only
//function displayPopup() {
//    document.getElementById('light').style.display = 'block';
//    //document.getElementById('fade').style.display = 'block';
//}

// elments not visible are considered hidden by jquery: ie display; none
$( '.here' ).click(function(e){
    e.stopPropagation()
    $( "#light:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});


// find a way to disable scrolling while popUpBox is visible


// reference 
// http://www.developphp.com/video/JavaScript/Click-Outside-Close-Menu-Box-Tutorial
// http://stackoverflow.com/questions/21065636/how-do-i-fade-out-a-pop-up-box-when-the-body-behind-it-is-clicked