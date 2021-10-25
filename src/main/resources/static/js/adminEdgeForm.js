const $addEdgeButton = document.querySelector("#add-edge-button");

function AdminEdgeForm() {

    const addEdgeHandler = async (event) => {
        event.preventDefault();
    }

    this.init = () => {
        $addEdgeButton.addEventListener("click", addEdgeHandler);
    }

}

const adminEdgeForm = new AdminEdgeForm();
adminEdgeForm.init();