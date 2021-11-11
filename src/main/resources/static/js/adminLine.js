import { lineTemplate } from "../utils/StationTemplate.js";

const $lineAddButton = document.querySelector(".line-add-button")
const $lineList = document.querySelector(".line-list");

function AdminLine() {
    const addButtonHandler = () => {
        window.location.href = "admin-line-form";
    };

    const getLines = async () => {
        const $lineList = document.querySelector(".line-list");

        await fetch("/api/lines", {
            method: "GET",
            headers: {
                "content-type": "application/json"
            }
        }).then(data => data.json())
            .then(lines => {
                console.log(lines)
                lines.map(line => {
                    $lineList.insertAdjacentHTML("afterbegin", lineTemplate(line));
                })
            });
    }

    const deleteLine = async (id) => {
        await fetch(`/api/lines/${id}`, {
            method: 'DELETE'
        })
    }

    const itemClickHandler = (event) => {
        const $target = event.target;
        const id = $target.closest('LI').dataset.lineId;
        if ($target.id === 'line-delete') {
            deleteLine(id);
            return;
        }

        if ($target.id !== 'line-name') {
            return;
        }

        const $startTime = document.querySelector("#start-time");
        const $lastTime = document.querySelector("#last-time");
        const $interval = document.querySelector("#interval");

        fetch(`/api/lines/${id}`, {
            method: 'GET',
            headers: {
                'content-type': 'application/json'
            }
        }).then(res => res.json())
            .then(line => {
                $startTime.innerHTML = `${line.firstTime}`;
                $lastTime.innerHTML = `${line.lastTime}`;
                $interval.innerHTML = `${line.intervalTime}`;
            })
    }

    this.init = () => {
        getLines();
        $lineAddButton.addEventListener("click", addButtonHandler);
        $lineList.addEventListener("click", itemClickHandler)
    };
}

const adminLine = new AdminLine();
adminLine.init();