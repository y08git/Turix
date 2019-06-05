/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var currentMarker = null;

function handlePointClick(event) {
    console.log(event);
    if (currentMarker === null) {
        document.getElementById('lat').value = event.latLng.lat();
        document.getElementById('lng').value = event.latLng.lng();
        currentMarker = new google.maps.Marker({
            position: new google.maps.LatLng(event.latLng.lat(), event.latLng.lng())
        });
        PF('map').addOverlay(currentMarker);
        PF('dialog').show();
    }
    
}

function markerAddComplete() {
    

    currentMarker = null;
    PF('dialog').hide();
}

function cancel() {
    PF('dialog').hide();
    currentMarker.setMap(null);
    currentMarker = null;

    return false;
}

function markerDelete(){
    currentMarker.setMap(null);
    currentMarker=null;
}
