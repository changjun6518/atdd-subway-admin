const $edgeAddButton = document.querySelector(".edge-add-button");

function AdminEdge() {

    const getLineStations = async () => {
        let edges = await fetch(`/api/edges`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(res => res.json())
            .then(edges => {
                return edges;
            });

        // TODO - 응답받은 json을 가지고 브라우저에 그린다.
    }

    const addEdgeButtonHandler = () => {
        window.location.href = "admin-edge-form";
    };

    this.init = () => {
        getLineStations();
        $edgeAddButton.addEventListener("click", addEdgeButtonHandler)
    }
}

const adminEdge = new AdminEdge();
adminEdge.init();