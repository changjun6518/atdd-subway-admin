const $submitButton = document.querySelector("#add-line-button")

function AdminLine() {
    this.addButtonHandler = () => {
        window.location.href = "admin-line-form";
    };

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
        }

       await fetch("api/lines",{
            method : "POST",
            headers : {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify(lineInfo)
        })
    };

    this.init = () => {
        $submitButton.addEventListener("click", submitLine);
    }
}

const adminLine = new AdminLine();
adminLine.init();
