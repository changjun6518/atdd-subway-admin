export const makeColorLine = (option, index) => {
    return `
            <button class="${option.bgColor} ${option.hoverColor} w-6 h-6 rounded m-0.5" data-color="${option.bgColor}"></button>
    `;
};