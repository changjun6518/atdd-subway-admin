export const stationTemplate = (station) => {
    return `
        <li class="station-item" data-station-id="${station.stationId}">
            <span class="station-name">${station.stationName}</span>
            <button class="station-delete-button">삭제</button>
        </li>`;
}

export const lineTemplate = (line) => {
    return `
        <li class="line-item" data-line-id="${line.lineId}">
            <span class="line-color ${line.color}"></span>
            <button id="line-name" class="line-name">${line.name}</button>
            <button id="line-delete" class="line-delete-button">삭제</button>
        </li>`;
}

export const edgeTemplate = (edge) => {
    return `
        <li>
            <div class="edge-item" data-edge-id="${edge.edgeId}">
                <span>${edge.station}</span>
                <button id="delete-btn" class="edge-delete-button">삭제</button>
            </div>
        </li>
    `;
}
