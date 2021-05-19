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

it("should return sum when comma delimitaed is given", () => {
    const result1 = add("1,2");
    expect(result1).toEqual(3);

    const result2 = add("1,2,3");
    expect(result2).toEqual(6);
});

it("should return sum when newline delimitaed is given", () => {
    const result1 = add("1\n2");
    expect(result1).toEqual(3);

    const result2 = add("1\n2\n3");
    expect(result2).toEqual(6);
});

it("should return sum when newline and comma delimitaed is given", () => {
    const result2 = add("1,2\n3");
    expect(result2).toEqual(6);
});

it("should return sum when newline and comma delimitaed is given", () => {
    const result2 = add("//;\n1;2;3;4;5;8");
    expect(result2).toEqual(23);
});

it("should mock", () => {
    jest.spyOn(global.Math, "random").mockReturnValue(0.42);
    const result = add('7');
    expect(result).toEqual(42);
});
