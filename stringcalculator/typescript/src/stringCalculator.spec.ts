import { add } from "./stringCalculator"

it("should return 0 when empty string is passed", () => {
    const result = add("");
    expect(result).toEqual(0);
});

it("should return numeric value of when numeric string is passed", () => {
    const result1 = add("1");
    expect(result1).toEqual(1);

    const result2 = add("2");
    expect(result2).toEqual(2);
});

it("should return 3 when 1, 2 is given", () => {
    const result1 = add("1,2");
    expect(result1).toEqual(3);
});

