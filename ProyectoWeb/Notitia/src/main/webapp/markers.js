/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var currentMarker = null;

var pinColor = "FF0000";

function handlePointClick(event) {
    console.log(event);
    var pinImage = new google.maps.MarkerImage("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|" + "FF0000",
        new google.maps.Size(21, 34),
        new google.maps.Point(0,0),
        new google.maps.Point(10, 34));
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
