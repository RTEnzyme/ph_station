function pathOne(driving,AMap){
    driving.clear();
    path = [];
    path.push({lnglat:[118.799685,32.0949818]})
    path.push({lnglat:[118.801372,32.092888]})
    path.push({lnglat:[118.805747,32.091437]})
    opts = {
    // 途经点参数，最多支持传入16个途经点
    waypoints: [
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
         new AMap.LngLat(118.804325,32.08869)

    ]
  }
    driving.search(new AMap.LngLat(118.799685, 32.0949818), new AMap.LngLat(118.805508,32.08906),opts,function (status, result) {
               // result 即是对应的驾车导航信息，相关数据结构文档请参考  https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
               if (status === 'complete') {
                   log.success('绘制驾车路线完成')
               } else {
                   log.error('获取驾车数据失败：' + result)
               }
           });

}
function pathTwo(driving,AMap){
    driving.clear();

    opts2 = {
    // 途经点参数，最多支持传入16个途经点
    waypoints: [
            new AMap.LngLat(118.800123,32.09298),
            new AMap.LngLat(118.800507,32.091797),
            new AMap.LngLat(118.802155,32.091127),
            new AMap.LngLat(118.80123,32.091239),
            new AMap.LngLat(118.801434,32.092847),
            new AMap.LngLat(118.803946,32.093363),
            new AMap.LngLat(118.806247,32.093553),
            new AMap.LngLat(118.805668,32.093238),
            new AMap.LngLat(118.802141,32.09157),
            new AMap.LngLat(118.804325,32.08869)

    ]
  }
    driving.search(new AMap.LngLat(118.799685, 32.0949818), new AMap.LngLat(118.805508,32.08906),opts2,function (status, result) {
               // result 即是对应的驾车导航信息，相关数据结构文档请参考  https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
               if (status === 'complete') {
                   log.success('绘制驾车路线完成')
               } else {
                   log.error('获取驾车数据失败：' + result)
               }
           });

}
function pathThree(driving,AMap){
    driving.clear();
    opts1 = {
    // 途经点参数，最多支持传入16个途经点
    waypoints: [
            new AMap.LngLat(118.800123,32.09298),
            new AMap.LngLat(118.798308,32.09098),
            new AMap.LngLat(118.800507,32.091797),
            new AMap.LngLat(118.801434,32.092847),
            new AMap.LngLat(118.80274,32.092457),
            new AMap.LngLat(118.803946,32.093363),
            new AMap.LngLat(118.802141,32.09157),
            new AMap.LngLat(118.803421,32.091452),
            new AMap.LngLat(118.803264,32.090516),
            new AMap.LngLat(118.804857,32.091113)
    ]
  }
    driving.search(new AMap.LngLat(118.799685, 32.0949818), new AMap.LngLat(118.805557,32.091587),opts1,function (status, result) {
               // result 即是对应的驾车导航信息，相关数据结构文档请参考  https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
               if (status === 'complete') {
                   log.success('绘制驾车路线完成')
               } else {
                   log.error('获取驾车数据失败：' + result)
               }
           });

}
function genratePath(driving,AMap,locationList) {
    var loc2lnglat = {
        'xiongmao':new AMap.LngLat(118.80053,32.093344),//
        'kepu': new AMap.LngLat(118.80053,32.093344),
        'huhou': new AMap.LngLat(118.800123,32.09298),
        'redainiao': new AMap.LngLat(118.800507,32.091797),
        'chongwu': new AMap.LngLat(118.800922,32.091647),
        'shihu': new AMap.LngLat(118.802141,32.09157),
        'langgu': new AMap.LngLat(118.80274,32.092457),
        'zhuangguan': new AMap.LngLat(118.803946,32.093363),
        'sheli': new AMap.LngLat(118.805668,32.093238),
        'daxiang': new AMap.LngLat(118.804857,32.091113),
        'changjinglu': new AMap.LngLat(118.803264,32.090516),
        'xingxing': new AMap.LngLat(118.804325,32.08869),
        'banma': new AMap.LngLat(118.805508,32.08906),
        'qie': new AMap.LngLat(118.801174,32.091259),
        'houshan': new AMap.LngLat(118.803403,32.091478),
        'xiwei': new AMap.LngLat(118.802051,32.091094)
    }
    var wayLocation = [];
    for (var item of locationList){
        wayLocation.push(loc2lnglat[item]);
    }
    console.log(wayLocation);
     opts = {
    // 途经点参数，最多支持传入16个途经点
        waypoints: wayLocation
  }
    driving.search(new AMap.LngLat(118.799685, 32.0949818), new AMap.LngLat(118.805508,32.08906),opts,function (status, result) {
               // result 即是对应的驾车导航信息，相关数据结构文档请参考  https://lbs.amap.com/api/javascript-api/reference/route-search#m_DrivingResult
               if (status === 'complete') {
                   log.success('绘制驾车路线完成')
               } else {
                   log.error('获取驾车数据失败：' + result)
               }
           });
}