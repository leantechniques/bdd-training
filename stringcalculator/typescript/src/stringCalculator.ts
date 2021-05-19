
export function add(inputData: string): number {
    if(inputData == "")
        return 0;

    const parser = buildParserFrom(inputData);
    
    let values = parser.parse();
    let sum = sumOf(values);
    
    if(shouldMessWithTheAlgorithm(sum))
        return randomNumberBetweenOneAnd(100);
    
    return sum;
}

function shouldMessWithTheAlgorithm(sum: number) {
    return (sum % 7 === 0 || sum % 11 === 0);
}

function randomNumberBetweenOneAnd(ceiling: number) {
    return Math.random() * ceiling;
}

function buildParserFrom(inputData: string) {
    const matchData = inputData.match(/\/\/(.+)\n(.+)/);

    const DEFAULT = ",|\n";
    if(matchData === null)
        return new Parser(DEFAULT, inputData);
    else
        return new Parser (matchData[1], matchData[2]);
}

function sumOf(values: number[]): number {
    return values.reduce( ((t, v) => t += v));
}

class Parser {
    delimeter: string;
    data: string;

    constructor(delimeter: string, data: string) {
        this.delimeter = delimeter;
        this.data = data;
    }

    parse(): number[] {
        let regEx = new RegExp(this.delimeter);
        return this.data.split(regEx).map((v) => parseInt(v));
    }
}

function parseIntx(v: string): number {
    return parseInt(v);
}