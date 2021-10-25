export const makeColorLine = (option, index) => {
    return `
            <button class="${option.bgColor} ${option.hoverColor} w-8 h-8" data-color="${option.bgColor}"></button>
    `;
};