import {stationTemplate} from "../utils/StationTemplate.js";

const $submitButton = document.querySelector(".station-add-button");
const $stationName = document.querySelector("#station-name");
const $stationList = document.querySelector(".station-list");
const $deleteButton = document.querySelector(".station-delete-button");
function AdminStation() {
    const addStation = async () => {
        const request = {
            stationName: $stationName.value
        }
        await fetch("api/stations", {
            method: 'POST',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.stringify(request)
        })
        window.location.reload();
    };

    const getStations = async () => {
        const stations = await fetch("api/stations", {
            method: "GET",
            headers: {
                'content-type': 'application/json'
            }
        }).then(data => data.json())
            .then(data => {
            return data;
        });
        stations.map(station => {$stationList.insertAdjacentHTML("beforeend", stationTemplate(station))});
        console.log(stations);
    };

    const deleteStation = async (event) => {
        const $target = event.target;
        const id = $target.closest("LI").dataset.stationId;
        await fetch(`api/stations?id=${id}`, {
            method: "DELETE",
            headers: {
                'content-type': 'application/json'
            }
        })
        window.location.reload();
    }

    this.init = async () => {
        await getStations();
        $submitButton.addEventListener("click", addStation);
        $stationList.addEventListener("click", deleteStation);
    };
}

const adminStation = new AdminStation();
adminStation.init();