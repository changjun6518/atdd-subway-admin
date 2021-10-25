const $edgeAddButton = document.querySelector(".edge-add-button");

function AdminEdge() {
    const addButtonHandler = () => {
        window.location.href = "admin-edge-form";
    };

    this.init = () => {
        $edgeAddButton.addEventListener("click", addButtonHandler)
    }
}

const adminEdge = new AdminEdge();
adminEdge.init();