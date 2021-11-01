export const stationTemplate = (station) =>{
    return `<li class="station-item" data-station-id="${station.stationId}">
            <span class="station-name">${station.stationName}</span><button class="station-delete-button">삭제</button>
        </li>`;
}
