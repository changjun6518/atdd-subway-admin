import {subwayLineColorOptions} from "../utils/subwayDefaultColor.js";
import {makeColorLine} from "../utils/templateColor.js";

const $submitButton = document.querySelector("#add-line-button")
const $colorList = document.querySelector(".color-list")
const $colorBox = document.querySelector("#color-box")

function AdminLineForm() {

    const submitLine = async () => {
        const $lineName = document.querySelector("#line-name");
        const $startTime = document.querySelector("#start-time");
        const $lastTime = document.querySelector("#last-time");
        const $interval = document.querySelector("#interval");

        const lineInfo = {
            name: $lineName.value,
            firstTime : $startTime.value,
            lastTime : $lastTime.value,
            intervalTime : $interval.value,
            color: $colorBox.value
        }

       await fetch("api/lines",{
            method : "POST",
            headers : {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify(lineInfo)
        }).then(res => {
           if (res.status === 200) {
               alert('성공적으로 추가되었습니다.');
           }
       })

    };

    const showColor = () => {
        const colorTemplate = subwayLineColorOptions.map(
            (option) => {
                $colorList.insertAdjacentHTML("beforeend",makeColorLine(option));
                // makeColorLine(option);
            }
        ).join("");

        console.log(colorTemplate);
        // $colorList.insertAdjacentHTML("beforeend", colorTemplate);
    };

    const selectColor = (event) => {
        event.preventDefault();
        const $target = event.target;
        $colorBox.value = $target.dataset.color;
    };

    this.init = () => {
        showColor()
        $submitButton.addEventListener("click", submitLine);
        $colorList.addEventListener("click", selectColor);
    }
}

const adminLine = new AdminLineForm();
adminLine.init();
