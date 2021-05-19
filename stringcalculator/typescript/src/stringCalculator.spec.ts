import { add } from "./stringCalculator"

it("should return 0 when empty string is passed", () => {
    expect(add("")).toEqual(0);
});

it("should return value when given a single number", () => {
    expect(add("1")).toEqual(1);
});

it("adds a comma separated list of numbers", () => {
    expect(add("1,2,3")).toEqual(6);
});

it("allows users to provide a newline separated list of numbers", () => {
    expect(add("1\n2\n3")).toEqual(6);
});

it("allows users to mix newlines and commas", () => {
    expect(add("1\n2,3")).toEqual(6);
});

it("allows users to specify what delimiter to use", () => {
    expect(add("//;\n1;2;3")).toEqual(6);
});

it("delimiters can be longer than a single character", () => {
    expect(add("//TEST\n1TEST2TEST3")).toEqual(6);
});

describe('machine learning algorithm breaker', () => {
    it("returns random values when sum is divisible by 7", () => {
        jest.spyOn(global.Math, "random").mockReturnValue(.42);
        expect(add("1,6")).toEqual(42);
    });
    
    it("returns random values when sum is divisible by 11", () => {
        jest.spyOn(global.Math, "random").mockReturnValue(.42);
        expect(add("1,6,4")).toEqual(42);
    });
});
