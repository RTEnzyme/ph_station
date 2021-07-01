// ;(function (root, factory) {
//     if (typeof exports === 'object') {
//         module.exports = factory()
//     } else if (typeof define === 'function' && define.amd) {
//         define(factory)
//     } else {
//         root['dashboard'] = factory()
//     }
// })(this, function () {
//   var version = "1.0.0"
//   var DEBUG = false
//   if(DEBUG){
//     console.group("Dashboard.js APIs:")
//     console.log("dashboard(id,duration):\r\n\tid: 需要绑定的<canvas>标签的id。\r\n\tduration: 进入动画的时长。")
//     console.log("width: 画板宽度。")
//     console.log("height: 画板高度。")
//     console.log("data-label: 需要绑定的<canvas>标签的属性，定义仪表盘的上标签。")
//     console.log("data-score: 需要绑定的<canvas>标签的属性，number，定义仪表盘的进度，范围在0-100之间。")
//     console.log("data-color: 需要绑定的<canvas>标签的属性，定义仪表盘进度条的前景颜色。")
//     console.log("data-background-color: 需要绑定的<canvas>标签的属性，定义仪表盘进度条的背景颜色。")
//     console.log("data-text-color: 需要绑定的<canvas>标签的属性，定义仪表盘字体颜色。")
//     console.log("data-pre-text: 需要绑定的<canvas>标签的属性，定义仪表盘的进度前面显示的文本。")
//     console.log("data-post-text: 需要绑定的<canvas>标签的属性，定义仪表盘的进度后面显示的文本。")
//     console.log("data-bar-width: 仪表盘的进度条的宽度，number。")
//     console.log("data-label-size: 仪表盘的标签文字的大小，number，单位px。")
//     console.log("data-score-size: 仪表盘的进度文字的大小，number，单位px。")
//     console.log("data-line-space: 仪表盘的标签文字与进度文字的宽度，number。")
//     console.log("font-family: 仪表盘的文字字体字体。")
//     console.log("")
//     console.log("原则上支持所有框架更新属性，但在部分框架绑定元素前绑定<canvas>标签可能会导致问题。")
//     console.log("更多信息，请参阅：https://github.com/zbLiuLiu/Dashboard.js/blob/master/README.md")
//     console.log("")
//     console.groupEnd("Dashboard.js详解")
//     console.log("Dashboard.js v"+version+" @zbLiuLiu zbliuliu.top 2020-现在")
//   }
//
//   function a (id, dur) {
//     window.requestAnimFrame = (function () {
//       return (
//         window.requestAnimationFrame ||
//         window.webkitRequestAnimationFrame ||
//         window.mozRequestAnimationFrame ||
//         function (callback) {
//           window.setTimeout(callback, 1000 / 60)
//         }
//       )
//     })()
//
//     var canvas = document.getElementById(id),
//       ctx = canvas.getContext('2d'),
//       deg0 = Math.PI / 9,
//       blocks = 14,
//       mum = 1,
//       /*
//                  * 要求：圆弧走完，数字得自加完，就得确定圆弧走的次数和数字走的次数相等！
//                  数字最大100，对应的度数是11*PI/9,那每个步长mum对应的度数如下：
//                  */
//       deg1 = (mum * Math.PI * blocks) / 9 / 100, // 每mum对应的度数
//       framesNumber = dur / (1000 / 60)
//
//       var angle = 0,
//       credit = 0,
//       lastCredit = 0,
//       lastScore = 0
//
//     var drawFrame = function () {
//       //width height data-label data-score data-color data-background-color data-text-color data-pre-text data-post-text data-bar-width data-label-size data-score-size data-line-space
//       var cWidth = Number(canvas.width),
//       cHeight = Number(canvas.height),
//       label = (canvas.attributes['data-label']||{"value":""}).value,
//       score = Number((canvas.attributes['data-score']||{"value":"0"}).value),
//       color = (canvas.attributes['data-color']||{"value":(ctx.canvas.style.color&&ctx.canvas.style.color.length>0)?ctx.canvas.style.color:"#000000"}).value,
//       backgroundColor = (canvas.attributes['data-background-color']||{"value":(ctx.canvas.style.backgroundColor&&ctx.canvas.style.backgroundColor.length>0)?ctx.canvas.style.backgroundColor:"#BFBFBF"}).value,
//       textColor = (canvas.attributes['data-text-color']||{"value":(ctx.canvas.style.color&&ctx.canvas.style.color.length>0)?ctx.canvas.style.color:"#000000"}).value,
//       pre_text=(canvas.attributes['data-pre-text']||{"value":""}).value,
//       post_text=(canvas.attributes['data-post-text']||{"value":""}).value,
//       barWidth = Number((canvas.attributes['data-bar-width']||{"value":10}).value),
//       font= ((ctx.canvas.style.fontFamily.length>0)?(ctx.canvas.style.fontFamily+","):"")+"\"Arial\",\"Microsoft YaHei\",\"黑体\",\"宋体\",sans-serif"
//
//       var radius = (((cWidth>cHeight)?cHeight:cWidth)/2)-barWidth, //圆的半径
//       labelSize = Number((canvas.attributes['data-label-size']||{"value":(label.length>0)?"25":"0"}).value),
//       scoreSize = Number((canvas.attributes['data-score-size']||{"value":"50"}).value),
//       mumsPerFrame = ((lastScore>score)?(lastScore-score):(score-lastScore)) / framesNumber
//
//       var lineSpace = Number((canvas.attributes['data-line-space']||{"value":(scoreSize+labelSize)/2*0.382}).value)
//
//
//       if (score < 0 || score > 100) {
//         console.log('"data-score"只能是0-100')
//         score = 100
//       }
//       ctx.save()
//       ctx.clearRect(0, 0, cWidth, cHeight)
//       ctx.translate(cWidth / 2, cHeight / 2)
//
//       if (lastCredit <= credit && credit < score) {
//         credit += mumsPerFrame
//         angle += deg1 * mumsPerFrame
//       }else if(score < credit && credit <= lastCredit){
//         credit -= mumsPerFrame
//         angle -= deg1 * mumsPerFrame
//       } else if (credit >= 100) {
//         credit = 100
//       }
//       if(lastCredit <= credit && credit > score) credit = score, lastScore=score
//       lastCredit=credit
//       ctx.save()
//       ctx.restore()
//       text(pre_text+Math.floor(credit) + post_text, scoreSize+'px '+font, scoreSize/4-(labelSize/4)-((label.length>0)?lineSpace/2:0), textColor)
//       text(label, labelSize+'px '+font, scoreSize/4+(labelSize/4)+lineSpace/2, textColor)
//
//       ctx.save()
//       ctx.beginPath()
//       ctx.strokeStyle = backgroundColor
//       ctx.lineWidth = barWidth
//       ctx.rotate(9 * deg0 - (blocks * deg0 - 9 * deg0) / 2)
//       ctx.arc(0, 0, radius, 0, blocks * deg0, false) //设置外圆环280度
//       ctx.stroke()
//       ctx.restore()
//       ctx.save()
//       ctx.restore()
//       ctx.beginPath()
//       ctx.lineWidth = barWidth
//       ctx.strokeStyle = color
//       ctx.rotate(9 * deg0 - (blocks * deg0 - 9 * deg0) / 2) //200度
//       ctx.arc(0, 0, radius, 0, angle, false) //动画圆环
//       ctx.stroke()
//       ctx.restore()
//
//       window.requestAnimFrame(drawFrame)
//     }
//
//     function text (process, font, y, textColor) {
//       ctx.save()
//       ctx.fillStyle = textColor
//       ctx.font = font
//       ctx.textAlign = 'center'
//       ctx.textBaseLine = 'middle'
//       ctx.fillText(process, 0, y)
//       ctx.restore()
//     }
//
//     setTimeout(function () {
//       drawFrame()
//     }, 10)
//   }
//   a.version=version
//   return a
// })