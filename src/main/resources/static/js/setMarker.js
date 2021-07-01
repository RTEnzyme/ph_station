function setMarker(AMap,map){
    markerLocation = [
         new AMap.LngLat(118.80053,32.093344),//
         new AMap.LngLat(118.80053,32.093344),
         new AMap.LngLat(118.800123,32.09298),
         new AMap.LngLat(118.800507,32.091797),
         new AMap.LngLat(118.800922,32.091647),
         new AMap.LngLat(118.802141,32.09157),
         new AMap.LngLat(118.80274,32.092457),
         new AMap.LngLat(118.803946,32.093363),
         new AMap.LngLat(118.805668,32.093238),
         new AMap.LngLat(118.804857,32.091113),
         new AMap.LngLat(118.803264,32.090516),
        new AMap.LngLat(118.804325,32.08869),
         new AMap.LngLat(118.805508,32.08906),
         new AMap.LngLat(118.801174,32.091259),
         new AMap.LngLat(118.803403,32.091478),
         new AMap.LngLat(118.802051,32.091094)
    ];
    markerContent = [
        "南京熊猫馆","科普廊","狐猴馆","热带鸟馆","宠物园","狮虎馆","狼谷","壮观阁","猞猁馆","大象馆","长颈鹿馆","猩猩馆","斑马馆","企鹅馆","猴山","细尾獴馆"
    ];
    infoList = [];
    for (item in markerContent){
        var title = markerContent[item]+'<span style="font-size:11px;color:#ff0000;">开放中</span>'
        var img = "<img src='/static/images/redmountain.png' style='height: 200px;width: 200px'>";
        if(markerContent[item]==="大象馆"){
            img = "<img src='/static/images/daxiang.png' style='height: 200px;width: 200px'>";
        }
        if(markerContent[item]==="猩猩馆"){
            img = "<img src='/static/images/xingxing.png' style='height: 200px;width: 200px'>";
        }
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
    for (let item in markerLocation) {
        marker = new AMap.Marker({
            position: markerLocation[item],
            icon: '//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png',
            anchor: 'bottom-center',
            offset: new AMap.Pixel(0, 0)
        });

        marker.setMap(map);

        // 设置鼠标划过点标记显示的文字提示
        marker.setTitle(markerContent[item]);
        markerList.push(marker);
        // 设置label标签
        // label默认蓝框白底左上角显示，样式className为：amap-marker-label
        //实例化信息窗体

    }
    for(let item in markerContent){
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