/*
* @Author: Marte
* @Date:   2018-05-29 02:18:50
* @Last Modified by:   Marte
* @Last Modified time: 2018-05-29 08:17:47
*/

var i = 5;
var intervalid;
intervalid = setInterval("fun()", 1000);
function fun() {
if (i == 0) {
window.location.href = "../text.html";
clearInterval(intervalid);
}
document.getElementById("mes").innerHTML = i;
i--;
}