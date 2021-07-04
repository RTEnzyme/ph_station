function setMarker(AMap,map, uid){
    var locationList;
    $.ajax({
        type: 'get',
        url: '/locations/'+uid+'/list',
        contentType: "applicatoin/json; charset=utf-8",
        async: false,
        success: function (result){
            console.log(result);
            locationList = result.data;
        }
    })
    let markerLists = [], markerContents = [];
    console.log(locationList);
    for (item in locationList){
        let data = locationList[item];
        markerLists.push(new AMap.LngLat(data.longitude, data.latitude));
        markerContents.push(data.projName);
    }
    infoList = [];
    for (item in markerContents){
        var title = markerContents[item]+'<span style="font-size:11px;color:#ff0000;">运行中</span>'
        var img = "<img src='/images/光电站.png' style='height: 200px;width: 200px'>";
        content = [];
        content.push(img);
        content.push("电话：010-64733333");
        content.push("<a href='http://www.njhszoo.com/animal.aspx?cateid=88'>详细信息</a>");
        var infoWindow2 = new AMap.InfoWindow({
            isCustom: true,  //使用自定义窗体
            content: createInfoWindow(title, content.join("<br/>")),
            offset: new AMap.Pixel(16, -45)
        });
        infoList.push(infoWindow2);
    }
    let markerList = [];
    for (let item in markerLists) {
        marker = new AMap.Marker({
            position: markerLists[item],
            icon: '//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png',
            anchor: 'bottom-center',
            offset: new AMap.Pixel(0, 0)
        });

        marker.setMap(map);

        // 设置鼠标划过点标记显示的文字提示
        marker.setTitle(markerContents[item]);
        markerList.push(marker);
    }
    for(let item in markerContents){
        markerList[item].on('click', function () {
            infoList[item].open(map, markerList[item].getPosition());
        });
    }
}
function createInfoWindow(title, content) {
    var info = document.createElement("div");
    info.className = "custom-info input-card content-window-card";

    //可以通过下面的方式修改自定义窗体的宽高
    info.style.width = "400px";
    // 定义顶部标题
    var top = document.createElement("div");
    var titleD = document.createElement("div");
    var closeX = document.createElement("img");
    top.className = "info-top";
    titleD.innerHTML = title;
    closeX.src = "https://webapi.amap.com/images/close2.gif";
    closeX.onclick = closeInfoWindow;

    top.appendChild(titleD);
    top.appendChild(closeX);
    info.appendChild(top);

    // 定义中部内容
    var middle = document.createElement("div");
    middle.className = "info-middle";
    middle.style.backgroundColor = 'white';
    middle.innerHTML = content;
    info.appendChild(middle);

    // 定义底部内容
    var bottom = document.createElement("div");
    bottom.className = "info-bottom";
    bottom.style.position = 'relative';
    bottom.style.top = '0px';
    bottom.style.margin = '0 auto';
    var sharp = document.createElement("img");
    sharp.src = "https://webapi.amap.com/images/sharp.png";
    bottom.appendChild(sharp);
    info.appendChild(bottom);
    return info;
}

//关闭信息窗体
function closeInfoWindow() {
    map.clearInfoWindow();
}