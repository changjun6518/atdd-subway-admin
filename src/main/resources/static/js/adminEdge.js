import { edgeTemplate } from "../utils/StationTemplate.js";

const $edgeAddButton = document.querySelector(".edge-add-button");
const $lineList = document.querySelector(".line-list");
const $prevLine = document.querySelector("#prev-line");
const $nextLine = document.querySelector("#next-line");

function AdminEdge() {

    let savedLines = [];
    let savedLinesId = [];

    const getLineStations = async () => {
        const index = window.location.hash.substring(1)

        const edges = await fetch(`/api/edges/${savedLinesId[index]}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => res.json())
            .then(edges => { return edges; });

        const $insertLine = document.querySelector(".insert-line");
        const $lineList = document.querySelector(".line-list");

        await edges.map(edge => {
            console.log("edge", edge);
            $lineList.insertAdjacentHTML("afterbegin", edgeTemplate(edge));
        })

        console.log(edges);
        $insertLine.insertAdjacentHTML("afterbegin", `<div class="line ${edges[0].lineColor}">${savedLines[index]}</div>`)
    }

    const addEdgeButtonHandler = () => {
        window.location.href = "admin-edge-form";
    };

    const getLines = async () => {
        await fetch("/api/lines", {
            method: "GET",
            headers: {
                "content-type": "application/json"
            }
        }).then(res => res.json())
            .then(lines => {
                lines.map(line => {
                    savedLines.push(`${line.name}`);
                    savedLinesId.push(`${line.lineId}`);
                })
            });
    }

    const pageMoveHandler = (event) => {
        const $target = event.target;
        let index = window.location.hash.substring(1);
        let i = parseInt(index);

        if ($target.id === 'next-line') {
            i += 1;
            if (i > savedLines.length - 1) {
                alert('마지막 페이지 입니다.');
                return;
            }
        } else {
            i -= 1;
            if (i < 0) {
                alert('첫 페이지입니다.');
                return;
            }
        }

        window.location.href = '/admin-edge' + '#' + i;
        window.location.reload();
    }

    const deleteHandler = async (event) => {
        console.log(event);
        const $target = event.target;
        if ($target.id !== 'delete-btn') {
            return;
        }
        console.log($target);
        const id = $target.closest('LI').dataset.edgeId;
        console.log("id", id);
        await fetch(`/api/edges/${id}`, {
            method: 'DELETE'
        })
    }

    this.init = async () => {
        await getLines();
        getLineStations();
        $edgeAddButton.addEventListener("click", addEdgeButtonHandler);
        $lineList.addEventListener("click", deleteHandler)
        $prevLine.addEventListener("click", pageMoveHandler);
        $nextLine.addEventListener("click", pageMoveHandler);
    }
}

const adminEdge = new AdminEdge();
adminEdge.init();