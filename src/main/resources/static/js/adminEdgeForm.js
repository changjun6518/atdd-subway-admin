const $addEdgeButton = document.querySelector("#add-edge-button");
const $cancelButton = document.querySelector("#cancel-button");

function AdminEdgeForm() {

    const getLines = async () => {
        const $line = document.querySelector("#line");

        await fetch("/api/lines", {
            method: "GET",
            headers: {
                "content-type": "application/json"
            }
        }).then(res => res.json())
            .then(lines => {
                lines.map(line => {
                    $line.insertAdjacentHTML("beforeend", `
                        <option value="${line.name}">${line.name}</option> 
                    `) // TODO - 리팩토링을 한다.
                })
            });
    }

    const submitEdge = async (event) => {
        event.preventDefault();
        const request = createSubmitRequest();

        await fetch(`/api/edges`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(request)
        })

        window.location.href = '/admin-edge';
    }

    const createSubmitRequest = () => {
        const $line = document.querySelector("#line");
        const $targetStation = document.querySelector("#target-station");
        const $prevStation = document.querySelector("#prev-station");
        const $distance = document.querySelector("#distance");
        const $duration = document.querySelector("#duration");

        return {
            lineName: $line.value,
            station: $targetStation.value,
            prevStation: $prevStation.value,
            distance: $distance.value,
            duration: $duration.value
        };
    }

    const cancelHandler = (event) => {
        event.preventDefault();
        window.location.href = '/admin-edge';
    }

    const getStations = async () => {
        const $prevStation = document.querySelector('#prev-station');
        const $targetStation = document.querySelector('#target-station');

        await fetch(`/api/stations`, {
            method: 'GET',
            headers: {
                'content-type': 'application/json'
            }
        }).then(res => res.json())
            .then(stations => {
                stations.map(station => {
                    $prevStation.insertAdjacentHTML("beforeend", `
                        <option value="${station.stationName}">${station.stationName}</option> 
                    `);
                    $targetStation.insertAdjacentHTML("beforeend", `
                        <option value="${station.stationName}">${station.stationName}</option> 
                    `);
                })
            });
    }

    this.init = () => {
        getLines();
        getStations();
        $addEdgeButton.addEventListener("click", submitEdge);
        $cancelButton.addEventListener("click", cancelHandler);
    }

}

const adminEdgeForm = new AdminEdgeForm();
adminEdgeForm.init();