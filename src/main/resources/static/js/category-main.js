var _account_service = require('service/account-service.js');


var catalogMain = {

    init: function () {
        this.bindEvents();
        this.loadAccountInfo();
        this.show();
        return this;
    },
    bindEvents: function () {
    },
    loadAccountInfo: function () {
        //有时候会直接认为已经登录了，就很好笑，这个的原因是在关闭的时候没有登出，但是这是为啥呢，好好笑
        _account_service.checkLogin(
            function (res) {
                console.log(res);
                sessionStorage.setItem('userId',res.username)
                $('#WelcomeContent').text('欢迎您,' + res.username + '用户!');
            },
            function (errMsg) {
                $('#WelcomeContent').text('');
            }
        );
    },
    show: function () {
        var box = document.getElementsByClassName("box_big")[0];
        var spot = document.getElementsByClassName("spot_list");
        var block = document.getElementsByClassName("block")[0];
        var left_btn = document.getElementsByClassName("left_btn")[0];
        var right_btn = document.getElementsByClassName("right_btn")[0];
        var time = null;
        spot[0].style.background = "rgba(91,91,91,0.8)";
        var count = 0;
        showtime();
        //鼠标进入计时器停止
        block.onmouseenter = function () {
            clearInterval(time);
        };
        //鼠标出来计时器打开
        block.onmouseleave = function () {
            showtime();
        };
        //点的事件
        for (var i = 0; i < spot.length; i++) {
            console.log(spot.length);
            spot[i].index = i;
            spot[i].onmouseenter = function () {
                spot[count].style.background = "rgba(255, 255, 255, 0.3)";
                this.style.background = "rgba(91,91,91,0.8)";
                count = this.index;
                box.style.marginLeft = (count * -490) + "px";
            }

        }
        //图片右边划
        right_btn.onclick = function () {
            console.log(spot.length);
            mate();
        };
        //图片左边划
        left_btn.onclick = function () {
            console.log(count);
            spot[count].style.backgroundColor = "rgba(255,255,255,0.3)";
            count--;
            if (count < 0) {
                box.className = "box_big";
                count = box.children.length - 2;
                box.style.marginLeft = "-2450px";
            }
            setTimeout(function () {
                box.className = "box_big nav";
                box.style.marginLeft = (-490 * count) + "px";
                spot[count].style.backgroundColor = "rgba(91,91,91,0.8)";
            }, 1000);
        };
        //计时器
        function showtime() {
            time = setInterval(function () {
                mate();
            }, 1500);
        }
        //正常滚动
        function mate() {
            box.className = "box_big nav";
            spot[count].style.background = "rgba(255, 255, 255, 0.3)";
            count++;
            spot[count > box.children.length - 1 ? 0 : count].style.background = "rgba(91,91,91,0.8)";
            box.style.marginLeft = (count * -490) + "px";
            setTimeout(function () {
                if (count > box.children.length - 1) {
                    count = 0;
                    box.className = "box_big";
                    box.style.marginLeft = "0px"
                }
            }, 500)
        }
    }


};

module.exports = catalogMain.init();