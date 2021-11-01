const $lineAddButton = document.querySelector(".line-add-button")

function AdminLine() {
    const addButtonHandler = () => {
        window.location.href = "admin-line-form";
    };

    const getLines = async () => {
        const lines = await fetch("/api/lines", {
            method: "GET",
            headers: {
                "content-type": "application/json"
            }
        }).then(data => data.json())
            .then(data => console.log(data));
    }


    this.init = () => {
        getLines();
        $lineAddButton.addEventListener("click", addButtonHandler);
    };
}

const adminLine = new AdminLine();
adminLine.init();