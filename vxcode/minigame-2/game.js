console.log(wx)
const canvas = wx.createCanvas();
const image = wx.createImage()



const context = canvas.getContext('2d') // 创建一个 2d context

context.fillStyle = '#1aad19' // 矩形颜色


const { windowWidth, windowHeight } = wx.getSystemInfoSync()
function drawRect(x, y) {
  context.clearRect(0, 0, windowWidth, windowHeight)
  context.fillRect(x, y, 100, 100)
}



//drawRect(canvas.width / 2 - 50, 0)
const rectX = canvas.width / 2 - 50
let rectY = 0
setInterval(function () {
  drawRect(rectX, rectY++)
}, 16)

const imgX = canvas.width / 2 - 50
let imgY = 100
image.load = function () {
  console.log(111111111111)
  context.drawImage(image, imgX, imgY)
}
image.src = 'image/fj.png'

// 存储当前飞机左上角坐标
let touchX = imgX
let touchY = imgY

wx.onTouchMove(function (res) {
  context.clearRect(touchX, touchY, 100, 100); // 清除画布上原有的飞机
  touchX = res.changedTouches[0].clientX // 重新判断当前触摸点x坐标
  touchY = res.changedTouches[0].clientY // 重新判断当前触摸点x坐标
  context.drawImage(image, touchX, touchY);
  if (touchX >= rectX - 100 && touchX <= rectX + 100 && touchY >= rectY - 100 && touchY <= rectY + 100) { // 飞机与矩形发生碰撞
    wx.showModal({
      title: '提示',
      content: '发生碰撞，游戏结束！'
    })
  }
})
