var boxArray = ['light1', 'light2', 'light3', 'light4', 'light5', 'light6', 'light7', 'light8', 'light9'];

// event not defined in mozilla firefox
window.addEventListener('mouseup', function(){
    for(var i=0; i<boxArray.length; i++) {
        var box = document.getElementById(boxArray[i]);
        var boverlay = document.getElementById('fade');
        if((event.target != box) && (event.target.parentNode != box)) {
            //box.style.display = 'none';
            $( '#' + boxArray[i] ).fadeOut(500);
            $( '#fade' ).fadeOut(500);
            //boverlay.style.display = 'none';
        }
    }

});

// elments not visible are considered hidden by jquery: ie display; none
$( '.here' ).click(function(e){
    e.stopPropagation()
    $( "#light:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here1' ).click(function(e){
    e.stopPropagation()
    $( "#light1:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here2' ).click(function(e){
    e.stopPropagation()
    $( "#light2:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here3' ).click(function(e){
    e.stopPropagation()
    $( "#light3:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here4' ).click(function(e){
    e.stopPropagation()
    $( "#light4:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here5' ).click(function(e){
    e.stopPropagation()
    $( "#light5:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here6' ).click(function(e){
    e.stopPropagation()
    $( "#light6:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here7' ).click(function(e){
    e.stopPropagation()
    $( "#light7:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here8' ).click(function(e){
    e.stopPropagation()
    $( "#light8:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});

$( '.here9' ).click(function(e){
    e.stopPropagation()
    $( "#light9:hidden" ).fadeIn(500);
    $( "#fade:hidden" ).fadeIn(500);
});




// find a way to disable scrolling while popUpBox is visible


// reference 
// http://www.developphp.com/video/JavaScript/Click-Outside-Close-Menu-Box-Tutorial
// http://stackoverflow.com/questions/21065636/how-do-i-fade-out-a-pop-up-box-when-the-body-behind-it-is-clicked